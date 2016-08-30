package org.openinfobutton.service.dao.impl;

/*
 * #%L
 * Project:  oib-app-service
 * Director: Guilherme Del Fiol, MD, PhD
 *           University of Utah
 *           Biomedical Informatics
 *           421 Wakara Way, Suite 140
 *           Salt Lake City, UT 84108-3514
 * Phone:    801-581-4080
 * %%
 * Copyright (C) 2010 - 2014 University of Utah
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import gov.nih.nlm.rxnav.rest.model.AllRelatedGroup;
import gov.nih.nlm.rxnav.rest.model.ConceptGroup;
import gov.nih.nlm.rxnav.rest.model.ConceptProperties;
import gov.nih.nlm.rxnav.rest.model.Name;
import gov.nih.nlm.rxnav.rest.model.Rxcui;
import gov.nih.nlm.rxnav.rest.model.Rxnormdata;
import gov.nih.nlm.rxnav.rest.model.Tty;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.openinfobutton.app.model.Code;
import org.openinfobutton.service.dao.CodeExpanderDao;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * The Class CodeExpanderDaoImpl.
 *
 * @author rick
 */
@Repository
public class CodeExpanderDaoImpl
        implements CodeExpanderDao {

    /**
     * The uts properties.
     */
    private Properties utsProperties;

    /**
     * The rx norm expansion term types.
     */
    private Set<String> rxNormExpansionTermTypes;

    /**
     * Instantiates a new code expander dao impl.
     */
    public CodeExpanderDaoImpl() {
    }

    /**
     * Instantiates a new code expander dao impl.
     *
     * @param utsProperties the uts properties
     */
    public CodeExpanderDaoImpl(Properties utsProperties) {
        this.utsProperties = utsProperties;
    }

    /**
     * Sets the uts properties.
     *
     * @param utsProperties the new uts properties
     */
    @Override
    public void setUtsProperties(Properties utsProperties) {
        this.utsProperties = utsProperties;
    }

    /**
     * Sets the rx norm expansion term types.
     *
     * @param rxNormExpansionTermTypes the new rx norm expansion term types
     */
    public void setRxNormExpansionTermTypes(Set<String> rxNormExpansionTermTypes) {
        this.rxNormExpansionTermTypes = rxNormExpansionTermTypes;
    }

    /**
     * Sets the default rx norm term types.
     */
    private void setDefaultRxNormTermTypes() {
        rxNormExpansionTermTypes = new HashSet();
        rxNormExpansionTermTypes.add("CDFG");
        rxNormExpansionTermTypes.add("CDC");
        rxNormExpansionTermTypes.add("IN");
        rxNormExpansionTermTypes.add("PIN");
        rxNormExpansionTermTypes.add("BN");
        rxNormExpansionTermTypes.add("BDC");
        rxNormExpansionTermTypes.add("BDP");
        rxNormExpansionTermTypes.add("BDFG");
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.dao.CodeExpanderDao#getExpansionCodes(java.lang.String, java.lang.String)
     */
    @Override
    public Set<Code> getExpansionCodes(String codeSystem, String code) {

        final Code code_ = new Code();
        code_.setCode(code);
        code_.setCodeSystemOid(codeSystem);

        if (RXNORM_CODE_SYSTEM_OID.equals(codeSystem)) {
            return getExpansionRxNormCodes(code);
        } else if (SNOMED_CODE_SYSTEM_OID.equals(codeSystem)) {
            return getExpansionSnomedCodes(code);
        } else if (ICD9_CODE_SYSTEM_OID.equals(codeSystem)) {
            return getExpansionIcd9Codes(code);
        } else {
            throw new UnsupportedOperationException("Code system " + codeSystem + " not supported yet."); // To change
            // body of
            // generated
            // methods,
            // choose
            // Tools |
            // Templates.
        }

    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.dao.CodeExpanderDao#getExpansionRxNormCodes(java.lang.String)
     */
    @Override
    public Set<Code> getExpansionRxNormCodes(String code) {

        if (rxNormExpansionTermTypes == null) {
            setDefaultRxNormTermTypes();
        }

        final Set<Code> rxNormExpansionCuis = new HashSet<Code>();

        final Map<String, String> vars = new HashMap<String, String>();
        vars.put("rxcui", code);

        final RestTemplate restTemplate = new RestTemplate();
        final Rxnormdata rxNormResponse
                = restTemplate.getForObject("https://rxnav.nlm.nih.gov/REST/rxcui/{rxcui}/allrelated", Rxnormdata.class, vars);
        final AllRelatedGroup allRelatedGroup = rxNormResponse.getAllRelatedGroup();

        for (final ConceptGroup conceptGroup : allRelatedGroup.getConceptGroup()) {

            final Tty termType = conceptGroup.getTty();

            if (rxNormExpansionTermTypes.contains(termType.getContent())) {

                for (final ConceptProperties conceptProperties : conceptGroup.getConceptProperties()) {
                    final Rxcui rxcui = conceptProperties.getRxcui();
                    final Name name = conceptProperties.getName();
                    if (rxcui != null) {
                        final String rxcuiCode = rxcui.getContent();
                        if (rxcuiCode != null) {
                            final Code code_ = new Code();
                            code_.setCode(rxcui.getContent());
                            code_.setDisplayName(name.getContent());
                            code_.setCodeSystemOid(RXNORM_CODE_SYSTEM_OID);
                            code_.setDisplayName("RxNorm");
                            rxNormExpansionCuis.add(code_);
                        }
                    }
                }
            }
        }

        return rxNormExpansionCuis;
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.dao.CodeExpanderDao#getExpansionIcd9Codes(java.lang.String)
     */
    @Override
    public Set<Code> getExpansionIcd9Codes(String code) {

        final CodeExpanderUtsHelper codeExpanderUtsHelper = new CodeExpanderUtsHelper(utsProperties);
        final Set<Code> codes = codeExpanderUtsHelper.getExpansionCodes(CodeExpanderDao.ICD9_CODE_SYSTEM_OID, code);

        return codes;
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.dao.CodeExpanderDao#getExpansionSnomedCodes(java.lang.String)
     */
    @Override
    public Set<Code> getExpansionSnomedCodes(String code) {

        final CodeExpanderUtsHelper codeExpanderUtsHelper = new CodeExpanderUtsHelper(utsProperties);
        final Set<Code> codes = codeExpanderUtsHelper.getExpansionCodes(CodeExpanderDao.SNOMED_CODE_SYSTEM_OID, code);

        return codes;

    }

}
