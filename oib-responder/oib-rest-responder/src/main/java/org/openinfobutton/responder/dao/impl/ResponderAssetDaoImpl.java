package org.openinfobutton.responder.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Query;
import org.openinfobutton.app.dao.DaoBase;
import org.openinfobutton.app.helper.AgeToAgeGroupConversionHelper;
import org.openinfobutton.app.model.Asset;
import org.openinfobutton.app.model.Code;
import org.openinfobutton.responder.dao.ResponderAssetDao;
import org.openinfobutton.service.dao.CodeExpanderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rick
 */
@Repository
public class ResponderAssetDaoImpl extends DaoBase<Asset> implements ResponderAssetDao {

    private int maxSupportedQueryCriteria = 950;

    @Autowired
    private CodeExpanderDao codeExpanderDao;

    @Override
    public Collection<Asset> findByInfobuttonRequest(Map<String, String> requestParameters) {

        Query hqlQuery = getHqlQueryFromOpenInfobuttonButtonRequest(requestParameters);

        return hqlQuery.list();
    }

    public void setMaxSupportedQueryCriteria(int maxSupportedQueryCriteria) {
        this.maxSupportedQueryCriteria = maxSupportedQueryCriteria;
    }

    /**
     * Builds the HQL search query. Assumes valid request parameters - no direct
     * error handling/checking.
     *
     * @param requestParameters the infobutton standard parameters and values
     * @return the Hibernate Query to the caller
     */
    private Query getHqlQueryFromOpenInfobuttonButtonRequest(Map<String, String> requestParameters) {

        StringBuilder mainSearchAdditionalPhrases = new StringBuilder();
        Map<String, String> hqlParameters = new HashMap<String, String>();
        Map<String, Set<String>> hqlParamatersForInPhrases = new HashMap<String, Set<String>>();
        int aliasIndex = 5; // for alias count to ensure they are unique in the subqueries

        StringBuilder subTopicPhrase = getHqlCriterionForParameterWithOptionalIndex(
                requestParameters,
                hqlParameters,
                "subTopic.v.c",
                "subTopic.v",
                "subTopicCode", aliasIndex++);

        StringBuilder agePhrase = getHqlCriterionForAge(
                requestParameters,
                hqlParamatersForInPhrases,
                "age.v.v",
                "age.v.u",
                "ageGroup.v",
                "convertedAgeGroups",
                aliasIndex++);

        StringBuilder ageGroupPhrase = getHqlCriterionForParameterWithOptionalIndex(
                requestParameters,
                hqlParameters,
                "ageGroup.v.c",
                "ageGroup.v",
                "ageGroupCode", aliasIndex++);

        StringBuilder administrativeGenderCodePhrase = getHqlCriterionForParameterWithOptionalIndex(
                requestParameters,
                hqlParameters,
                "patientPerson.administrativeGenderCode.c",
                "patientPerson.administrativeGenderCode",
                "genderCode", aliasIndex++);

        StringBuilder informationRecipientPhrase = getHqlCriterionForParameterWithOptionalIndex(
                requestParameters,
                hqlParameters,
                "informationRecipient",
                "informationRecipient",
                "informationRecipientCode", aliasIndex++);

        StringBuilder performerPhrase = getHqlCriterionForParameterWithOptionalIndex(
                requestParameters,
                hqlParameters,
                "performer",
                "performer",
                "performerCode", aliasIndex++);

        StringBuilder encounterPhrase = getHqlCriterionForParameterWithOptionalIndex(
                requestParameters,
                hqlParameters,
                "encounter.c.c",
                "encounter.c",
                "encounterCode", aliasIndex++);

        StringBuilder mainSearchCriterion
                = getHqlMainSerchCriteria(requestParameters, hqlParameters, hqlParamatersForInPhrases, aliasIndex++);

        String taskContext = requestParameters.get("taskContext.c.c");

        StringBuilder hsql = new StringBuilder();
        hsql.append("select a from Asset a \n");
        hsql.append("where 1 = 1 \n");
        hsql.append(mainSearchCriterion.toString());
        hsql.append(mainSearchAdditionalPhrases.toString());
        hsql.append("and a in (select p1.asset from AssetProperty p1 where p1.propertyName = 'taskContext.c' and p1.code = :taskContext ) \n");
        hsql.append(subTopicPhrase.toString());
        hsql.append(administrativeGenderCodePhrase.toString());
        hsql.append(agePhrase.toString());
        hsql.append(ageGroupPhrase.toString());
        hsql.append(informationRecipientPhrase.toString());
        hsql.append(performerPhrase.toString());
        hsql.append(encounterPhrase.toString());

        System.out.println(hsql.toString());

        Query query = getSessionFactory().getCurrentSession().createQuery(hsql.toString());
        query.setParameter("taskContext", taskContext);

        for (String parameterName : hqlParameters.keySet()) {
            query.setParameter(parameterName, hqlParameters.get(parameterName));
        }

        for (String parameterName : hqlParamatersForInPhrases.keySet()) {
            query.setParameterList(parameterName, hqlParamatersForInPhrases.get(parameterName));
        }

        return query;

    }

    private StringBuilder getHqlCriterionForParameterWithOptionalIndex(
            Map<String, String> requestParameters,
            Map<String, String> hqlParameters,
            String codeParameterName,
            String dbPropertyName,
            String hqlParameterName,
            int aliasIndex) {

        StringBuilder queryPhrase = new StringBuilder();
        String aliasIndex2 = aliasIndex + "" + aliasIndex;

        if (requestParameters.get(codeParameterName) != null) {

            queryPhrase
                    .append(" and ( a in ( \n")
                    .append("         select p").append(aliasIndex).append(".asset from AssetProperty p").append(aliasIndex).append(" \n")
                    .append("         where p").append(aliasIndex).append(".propertyName = '").append(dbPropertyName).append("' \n")
                    .append("           and p").append(aliasIndex).append(".code = :").append(hqlParameterName).append(") \n")
                    .append("     or a not in ( \n")
                    .append("         select p").append(aliasIndex2).append(".asset from AssetProperty p").append(aliasIndex2).append(" \n")
                    .append("         where p").append(aliasIndex2).append(".propertyName = '").append(dbPropertyName).append("') \n")
                    .append(" ) \n");

            hqlParameters.put(hqlParameterName, requestParameters.get(codeParameterName));
        }

        return queryPhrase;
    }

    private StringBuilder getHqlMainSerchCriteria(
            Map<String, String> requestParameters,
            Map<String, String> hqlParameters,
            Map<String, Set<String>> hqlInPhraseParameters,
            int aliasIndex) {

        StringBuilder queryPhrase = new StringBuilder();
        String mainSearchCriteriaCode = null;
        String mainSearchCriteriaCodeSystem = null;
        int criteriaIndex = 0;
        boolean moreCriteria = true;

        // and ((m) or (m1) or (m2) ... )
        while (moreCriteria && criteriaIndex <= maxSupportedQueryCriteria) {

            if (criteriaIndex == 0) {
                queryPhrase.append(" and ( \n");
                mainSearchCriteriaCode = requestParameters.get("mainSearchCriteria.v.c");
                mainSearchCriteriaCodeSystem = requestParameters.get("mainSearchCriteria.v.cs");
            } else {
                mainSearchCriteriaCode = requestParameters.get("mainSearchCriteria.v.c" + criteriaIndex);
                mainSearchCriteriaCodeSystem = requestParameters.get("mainSearchCriteria.v.cs" + criteriaIndex);
            }

            if (mainSearchCriteriaCode != null) {

                if (criteriaIndex > 0) {
                    queryPhrase.append(" or \n");
                }
                queryPhrase
                        .append("(a.assetId in \n")
                        .append("(select p").append(aliasIndex).append(".asset from AssetProperty p").append(aliasIndex).append(" \n")
                        .append(" where (p").append(aliasIndex).append(".propertyName = 'mainSearchCriteria.v' \n")
                        .append("   and p").append(aliasIndex).append(".codeSystem = :mainSearchCriteriaCodeSystem \n");

                hqlParameters.put("mainSearchCriteriaCodeSystem", mainSearchCriteriaCodeSystem);

                if (CodeExpanderDao.RXNORM_CODE_SYSTEM_OID.equals(mainSearchCriteriaCodeSystem)) {

                    String hqlParameterName = "mainSearchCriteriaCodeList" + criteriaIndex;
                    queryPhrase.append("   and p").append(aliasIndex).append(".code in (:").append(hqlParameterName).append("))) \n ) \n");
                    Set<Code> expansionCodes = codeExpanderDao.getExpansionCodes(CodeExpanderDao.RXNORM_CODE_SYSTEM_OID, mainSearchCriteriaCode);
                    Set<String> codes = getCodesOnly(expansionCodes);
                    hqlInPhraseParameters.put(hqlParameterName, codes);

                } else {
                    String hqlParameterName = "mainSearchCriteriaCode" + criteriaIndex;
                    queryPhrase.append("   and p").append(aliasIndex).append(".code = :").append(hqlParameterName).append(")) \n ) \n");
                    hqlParameters.put(hqlParameterName, mainSearchCriteriaCode);
                }

            } else {
                moreCriteria = false;
            }

            criteriaIndex++;
        }

        queryPhrase.append(" ) \n");

        return queryPhrase;
    }

    private StringBuilder getHqlCriterionForAge(
            Map<String, String> requestParameters,
            Map<String, Set<String>> hqlInPhraseParameters,
            String ageParameterName,
            String ageUnitsParameterName,
            String dbPropertyName,
            String hqlParameterName,
            int aliasIndex) {

        StringBuilder queryPhrase = new StringBuilder();
        String aliasIndex2 = aliasIndex + "" + aliasIndex;
        String ageValue = requestParameters.get(ageParameterName);
        String ageUnitsCode = requestParameters.get(ageUnitsParameterName);

        if (ageValue != null && ageUnitsCode != null) {

            List<Code> hqlAgeGroupCodes = AgeToAgeGroupConversionHelper.ageToAgeGroup(Integer.parseInt(ageValue), ageUnitsCode);

            Set<String> hqlAgeGroupCodesSet = new HashSet<String>();
            for (Code ageGroupCode : hqlAgeGroupCodes) {
                hqlAgeGroupCodesSet.add(ageGroupCode.getCode());
            }

            queryPhrase
                    .append(" and ( a in ( \n")
                    .append("         select p").append(aliasIndex).append(".asset from AssetProperty p").append(aliasIndex).append(" \n")
                    .append("         where p").append(aliasIndex).append(".propertyName = '").append(dbPropertyName).append("' \n")
                    .append("           and p").append(aliasIndex).append(".code in (:").append(hqlParameterName).append(")) \n")
                    .append("     or a not in ( \n")
                    .append("         select p").append(aliasIndex2).append(".asset from AssetProperty p").append(aliasIndex2).append(" \n")
                    .append("         where p").append(aliasIndex2).append(".propertyName = '").append(dbPropertyName).append("') \n")
                    .append(" ) \n");

            hqlInPhraseParameters.put(hqlParameterName, hqlAgeGroupCodesSet);
        }

        return queryPhrase;
    }

    private Set<String> getCodesOnly(Set<Code> codes) {

        Set<String> codesOnly = new HashSet<String>();

        for (Code code_ : codes) {
            codesOnly.add(code_.getCode());
        }

        return codesOnly;
    }

}
