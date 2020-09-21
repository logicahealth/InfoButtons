package org.openinfobutton.service.dao;

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
import java.util.Properties;
import java.util.Set;
import org.openinfobutton.app.model.Code;

/**
 * The Interface CodeExpanderDao.
 *
 * @author rick
 */
public interface CodeExpanderDao {

    /**
     * The Constant RXNORM_CODE_SYSTEM_OID.
     */
    public static final String RXNORM_CODE_SYSTEM_OID = "2.16.840.1.113883.6.88";

    /**
     * The Constant SNOMED_CODE_SYSTEM_OID.
     */
    public static final String SNOMED_CODE_SYSTEM_OID = "2.16.840.1.113883.6.90";

    /**
     * The Constant ICD9_CODE_SYSTEM_OID.
     */
    public static final String ICD9_CODE_SYSTEM_OID = "2.16.840.1.113883.6.103";

    /**
     * The Constant ICD10CM_CODE_SYSTEM_OID.
     */
    public static final String ICD10CM_CODE_SYSTEM_OID = "2.16.840.1.113883.6.103";

    /**
     * The Constant ICD10_CODE_SYSTEM_OID.
     */
    public static final String ICD10_CODE_SYSTEM_OID = "2.16.840.1.113883.6.3";

    /**
     * Sets the UTS Properties
     *
     * @param utsProperties
     */
    public void setUtsProperties(Properties utsProperties);

    /**
     * Gets the expansion codes.
     *
     * @param codeSystem the code system
     * @param code the code
     * @return the expansion codes
     */
    public Set<Code> getExpansionCodes(String codeSystem, String code);

    /**
     * Gets the expansion rx norm codes.
     *
     * @param code the code
     * @return the expansion rx norm codes
     */
    public Set<Code> getExpansionRxNormCodes(String code);

    /**
     * Gets the expansion icd9 codes.
     *
     * @param code the code
     * @return the expansion icd9 codes
     */
    public Set<Code> getExpansionIcd9Codes(String code);

    /**
     * Gets the expansion icd10 codes.
     *
     * @param code the code
     * @return the expansion icd9 codes
     */
    public Set<Code> getExpansionIcd10Codes(String code);

    /**
     * Gets the expansion icd10CM codes.
     *
     * @param code the code
     * @return the expansion icd9 codes
     */
    public Set<Code> getExpansionIcd10CMCodes(String code);

    /**
     * Gets the expansion snomed codes.
     *
     * @param code the code
     * @return the expansion snomed codes
     */
    public Set<Code> getExpansionSnomedCodes(String code);

}
