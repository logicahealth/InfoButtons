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
import gov.nih.nlm.uts.webservice.content.AtomClusterRelationDTO;
import gov.nih.nlm.uts.webservice.content.Psf;
import gov.nih.nlm.uts.webservice.content.SourceAtomClusterDTO;
import gov.nih.nlm.uts.webservice.content.UtsFault_Exception;
import gov.nih.nlm.uts.webservice.content.UtsWsContentController;
import gov.nih.nlm.uts.webservice.content.UtsWsContentControllerImplService;
import gov.nih.nlm.uts.webservice.metadata.UtsWsMetadataController;
import gov.nih.nlm.uts.webservice.metadata.UtsWsMetadataControllerImplService;
import gov.nih.nlm.uts.webservice.security.UtsWsSecurityController;
import gov.nih.nlm.uts.webservice.security.UtsWsSecurityControllerImplService;
import java.util.ArrayList;
import java.util.List;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.openinfobutton.app.model.Code;
import org.openinfobutton.service.dao.CodeExpanderDao;

/**
 * The Class CodeExpanderUtsHelper.
 *
 * @author rick
 */
public class CodeExpanderUtsHelper {

    /**
     * The uts properties.
     */
    private Properties utsProperties;

    /**
     * The expansion codes.
     */
    private Set<Code> expansionCodes;

    /**
     *
     * The release
     */
    private String currentRelease;

    /**
     * Instantiates a new code expander uts helper.
     */
    public CodeExpanderUtsHelper() {
    }

    /**
     * Instantiates a new code expander uts helper.
     *
     * @param properties the properties
     */
    public CodeExpanderUtsHelper(Properties properties) {

        this.utsProperties = properties;
        final UtsWsMetadataController utsMetadataService = (new UtsWsMetadataControllerImplService()).getUtsWsMetadataControllerImplPort();
        try {
            currentRelease = utsMetadataService.getCurrentUMLSVersion(getSecurityTicket());
        } catch (gov.nih.nlm.uts.webservice.metadata.UtsFault_Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the uts properties.
     *
     * @param utsProperties the new uts properties
     */
    public void setUtsProperties(Properties utsProperties) {

        this.utsProperties = utsProperties;
        final UtsWsMetadataController utsMetadataService = (new UtsWsMetadataControllerImplService()).getUtsWsMetadataControllerImplPort();
        try {
            currentRelease = utsMetadataService.getCurrentUMLSVersion(getSecurityTicket());
        } catch (gov.nih.nlm.uts.webservice.metadata.UtsFault_Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the expansion codes.
     *
     * @param codeSystem the code system
     * @param code the code
     * @return the expansion codes
     */
    public Set<Code> getExpansionCodes(String codeSystem, String code) {

        expansionCodes = new HashSet<Code>();

        if (CodeExpanderDao.SNOMED_CODE_SYSTEM_OID.equals(codeSystem)) {
            getSnomedChildren(1, code);
        } else if (CodeExpanderDao.ICD9_CODE_SYSTEM_OID.equals(codeSystem)) {
            getIcd9Children(1, code);
        } else if (CodeExpanderDao.ICD10_CODE_SYSTEM_OID.equals(codeSystem)) {
            getIcd10Children(1, code);
        } else if (CodeExpanderDao.ICD10CM_CODE_SYSTEM_OID.equals(codeSystem)) {
            getIcd10CMChildren(1, code);
        } else {
            throw new UnsupportedOperationException("Code system " + codeSystem
                    + " is not supported by the current UTS implementation."); // To change body of generated methods,
            // choose Tools | Templates.
        }

        return expansionCodes;
    }

    /**
     * Gets the icd9 children.
     *
     * @param level the level
     * @param code the code
     * @return the icd9 children
     */
    private void getIcd9Children(int level, String code) {

        final UtsWsContentController utsContentService
                = (new UtsWsContentControllerImplService()).getUtsWsContentControllerImplPort();

        List<AtomClusterRelationDTO> myAtomClusterRelations = new ArrayList<AtomClusterRelationDTO>();
        final Psf myPsf = new Psf();
        myPsf.getIncludedRelationLabels().add("PAR");

        try {
            myAtomClusterRelations
                    = utsContentService.getSourceDescriptorSourceDescriptorRelations(getSecurityTicket(),
                    currentRelease,
                            code, "ICD9CM", myPsf);
        } catch (final UtsFault_Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < myAtomClusterRelations.size(); i++) {

            final AtomClusterRelationDTO myAtomClusterRelationDTO = myAtomClusterRelations.get(i);
            final String cuiCode = myAtomClusterRelationDTO.getRelatedAtomCluster().getUi();
            final String cuiPreferredName = myAtomClusterRelationDTO.getRelatedAtomCluster().getDefaultPreferredName();

            final Code code_ = new Code();
            code_.setCode(cuiCode);
            code_.setDisplayName(cuiPreferredName);
            code_.setCodeSystemOid(CodeExpanderDao.ICD9_CODE_SYSTEM_OID);
            code_.setCodeSystemDisplayName("ICD-9 CM");

            expansionCodes.add(code_);
            getIcd9Children(level + 1, cuiCode);

        }

    }

    /**
     * Gets the icd10 children.
     *
     * @param level the level
     * @param code the code
     * @return the icd10 children
     */
    private void getIcd10Children(int level, String code) {

        final UtsWsContentController utsContentService
                = (new UtsWsContentControllerImplService()).getUtsWsContentControllerImplPort();

        List<AtomClusterRelationDTO> myAtomClusterRelations = new ArrayList<AtomClusterRelationDTO>();
        final Psf myPsf = new Psf();
        myPsf.getIncludedRelationLabels().add("PAR");

        try {
            myAtomClusterRelations
                    = utsContentService.getSourceDescriptorSourceDescriptorRelations(getSecurityTicket(),
                    currentRelease,
                    code, "ICD10", myPsf);
        } catch (final UtsFault_Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < myAtomClusterRelations.size(); i++) {

            final AtomClusterRelationDTO myAtomClusterRelationDTO = myAtomClusterRelations.get(i);
            final String cuiCode = myAtomClusterRelationDTO.getRelatedAtomCluster().getUi();
            final String cuiPreferredName = myAtomClusterRelationDTO.getRelatedAtomCluster().getDefaultPreferredName();

            final Code code_ = new Code();
            code_.setCode(cuiCode);
            code_.setDisplayName(cuiPreferredName);
            code_.setCodeSystemOid(CodeExpanderDao.ICD10_CODE_SYSTEM_OID);
            code_.setCodeSystemDisplayName("ICD-10");

            expansionCodes.add(code_);
            getIcd10Children(level + 1, cuiCode);

        }

    }

    /**
     * Gets the icd10CM children.
     *
     * @param level the level
     * @param code the code
     * @return the icd10 children
     */
    private void getIcd10CMChildren(int level, String code) {

        final UtsWsContentController utsContentService
                = (new UtsWsContentControllerImplService()).getUtsWsContentControllerImplPort();

        List<AtomClusterRelationDTO> myAtomClusterRelations = new ArrayList<AtomClusterRelationDTO>();
        final Psf myPsf = new Psf();
        myPsf.getIncludedRelationLabels().add("PAR");

        try {
            myAtomClusterRelations
                    = utsContentService.getSourceDescriptorSourceDescriptorRelations(getSecurityTicket(),
                    currentRelease,
                    code, "ICD10CM", myPsf);
        } catch (final UtsFault_Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < myAtomClusterRelations.size(); i++) {

            final AtomClusterRelationDTO myAtomClusterRelationDTO = myAtomClusterRelations.get(i);
            final String cuiCode = myAtomClusterRelationDTO.getRelatedAtomCluster().getUi();
            final String cuiPreferredName = myAtomClusterRelationDTO.getRelatedAtomCluster().getDefaultPreferredName();

            final Code code_ = new Code();
            code_.setCode(cuiCode);
            code_.setDisplayName(cuiPreferredName);
            code_.setCodeSystemOid(CodeExpanderDao.ICD10CM_CODE_SYSTEM_OID);
            code_.setCodeSystemDisplayName("ICD-10 CM");

            expansionCodes.add(code_);
            getIcd10CMChildren(level + 1, cuiCode);

        }

    }

    /**
     * Gets the snomed children.
     *
     * @param level the level
     * @param code the code
     * @return the snomed children
     */
    private void getSnomedChildren(int level, String code) {

        final UtsWsContentController utsContentService
                = (new UtsWsContentControllerImplService()).getUtsWsContentControllerImplPort();
        SourceAtomClusterDTO conceptAtomCluster = null;
        List<AtomClusterRelationDTO> myRelations = null;
        final Psf myPsf = new Psf();
        myPsf.getIncludedRelationLabels().add("PAR");

        try {

            conceptAtomCluster
                    = utsContentService.getCode(getSecurityTicket(), currentRelease, code,
                            "SNOMEDCT_US");

            myRelations
                    = utsContentService.getSourceConceptSourceConceptRelations(getSecurityTicket(),
                    currentRelease,
                            code, "SNOMEDCT_US", myPsf);

        } catch (final UtsFault_Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < myRelations.size(); i++) {

            final AtomClusterRelationDTO myRelation = myRelations.get(i);
            final String cuiCode = myRelation.getRelatedAtomCluster().getUi();
            final String cuiPreferredName = myRelation.getRelatedAtomCluster().getDefaultPreferredName();

            final Code code_ = new Code();
            code_.setCode(cuiCode);
            code_.setDisplayName(cuiPreferredName);
            code_.setCodeSystemOid(CodeExpanderDao.SNOMED_CODE_SYSTEM_OID);
            code_.setCodeSystemDisplayName("SNOMED CT");

            expansionCodes.add(code_);
            getSnomedChildren(level + 1, cuiCode);
        }

    }

    /**
     * Gets the security ticket.
     *
     * @return the security ticket
     */
    private String getSecurityTicket() {

        String singleUseTicket = null;
        final UtsWsSecurityController securityService
                = (new UtsWsSecurityControllerImplService()).getUtsWsSecurityControllerImplPort();

        try {
            final String ticketGrantingTicket
                    = securityService.getProxyGrantTicket(utsProperties.getProperty("uts.username"),
                            utsProperties.getProperty("uts.password"));
            singleUseTicket
                    = securityService.getProxyTicket(ticketGrantingTicket, utsProperties.getProperty("uts.serviceName"));
        } catch (final Exception e) {
            e.printStackTrace();
        }

        return singleUseTicket;
    }
}
