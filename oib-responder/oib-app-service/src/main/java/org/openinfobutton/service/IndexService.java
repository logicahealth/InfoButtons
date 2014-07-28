package org.openinfobutton.service;

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
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.openinfobutton.app.model.Code;
import org.openinfobutton.app.model.ValueSetCode;

/**
 * The Interface IndexService.
 *
 * @author rick
 */
public interface IndexService {

    /**
     * The Constant GENERATED_BY_ONTOLOGY_RELATIONSHIP.
     */
    public static final String GENERATED_BY_ONTOLOGY_RELATIONSHIP = "GENERATED_BY_ONTOLOGY_RELATIONSHIP";

    /**
     * The Constant RXNORM_CODE_SYSTEM_OID.
     */
    public static final String RXNORM_CODE_SYSTEM_OID = "2.16.840.1.113883.6.88";

    /**
     * The Constant SNOMED_CODE_SYSTEM_OID.
     */
    public static final String SNOMED_CODE_SYSTEM_OID = "2.16.840.1.113883.6.96";

    /**
     * The Constant ICD9_CODE_SYSTEM_OID.
     */
    public static final String ICD9_CODE_SYSTEM_OID = "2.16.840.1.113883.6.103";

    // B-logic for indexing
    /**
     * Gets the expansion codes.
     *
     * @param codeSystem the code system
     * @param code the code
     * @return the expansion codes
     */
    Set<Code> getExpansionCodes(String codeSystem, String code);

    /**
     * Gets the supported code expansion code systems.
     *
     * @return the supported code expansion code systems
     */
    public List<ValueSetCode> getSupportedCodeExpansionCodeSystems();

    /**
     * Refresh asset index.
     *
     * @param assetId the asset id
     * @return the int
     */
    public int refreshAssetIndex(BigDecimal assetId);

    /**
     * Refresh asset index.
     *
     * @param assetId the asset id
     * @param codeSystem the code system
     * @return the int
     */
    public int refreshAssetIndex(BigDecimal assetId, String codeSystem);

    /**
     * Refresh all asset indexes.
     *
     * @return the int
     */
    public int refreshAllAssetIndexes();

    /**
     * Refresh all asset indexes.
     *
     * @param codeSystem the code system
     * @return the int
     */
    public int refreshAllAssetIndexes(String codeSystem);

}
