package org.openinfobutton.app.model;

/*
 * #%L
 * Project:  oib-app-model
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

/**
 * The Class Code.
 *
 * @author rick
 */
public class Code {

    /**
     * The code.
     */
    private String code;

    /**
     * The display name.
     */
    private String displayName;

    /**
     * The code system oid.
     */
    private String codeSystemOid;

    /**
     * The code system display name.
     */
    private String codeSystemDisplayName;

    /**
     * Instantiates a new code.
     */
    public Code() {
    }

    /**
     * Instantiates a new code.
     *
     * @param codeSystemOid the code system oid
     * @param code the code
     */
    public Code(String codeSystemOid, String code) {
        this.code = code;
        this.codeSystemOid = codeSystemOid;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the code system oid.
     *
     * @return the code system oid
     */
    public String getCodeSystemOid() {
        return codeSystemOid;
    }

    /**
     * Sets the code system oid.
     *
     * @param codeSystemOid the new code system oid
     */
    public void setCodeSystemOid(String codeSystemOid) {
        this.codeSystemOid = codeSystemOid;
    }

    /**
     * Gets the code system display name.
     *
     * @return the code system display name
     */
    public String getCodeSystemDisplayName() {
        return codeSystemDisplayName;
    }

    /**
     * Sets the code system display name.
     *
     * @param codeSystemDisplayName the new code system display name
     */
    public void setCodeSystemDisplayName(String codeSystemDisplayName) {
        this.codeSystemDisplayName = codeSystemDisplayName;
    }

    /**
     * Sets the code.
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the display name.
     *
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name.
     *
     * @param displayName the new display name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        if (code != null && codeSystemOid != null) {
            return code.hashCode() + codeSystemOid.hashCode();
        } else if (code != null && codeSystemOid == null) {
            return code.hashCode();
        }
        return 0;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (code != null && codeSystemOid != null) {
            return this.hashCode() == obj.hashCode();
        } else if (code != null && codeSystemOid == null) {
            return code.hashCode() == obj.hashCode();
        }

        return false;

    }

}
