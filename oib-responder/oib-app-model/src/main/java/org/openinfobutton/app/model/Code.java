package org.openinfobutton.app.model;

/**
 *
 * @author rick
 */
public class Code {

    private String code;
    private String displayName;
    private String codeSystemOid;
    private String codeSystemDisplayName;
    
    public Code() {}
    
    public Code(String codeSystemOid, String code) {
        this.code = code;
        this.codeSystemOid = codeSystemOid;
    }

    public String getCode() {
        return code;
    }

    public String getCodeSystemOid() {
        return codeSystemOid;
    }

    public void setCodeSystemOid(String codeSystemOid) {
        this.codeSystemOid = codeSystemOid;
    }

    public String getCodeSystemDisplayName() {
        return codeSystemDisplayName;
    }

    public void setCodeSystemDisplayName(String codeSystemDisplayName) {
        this.codeSystemDisplayName = codeSystemDisplayName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    @Override
    public int hashCode() {
        
        if ( code != null && codeSystemOid != null) {
        return code.hashCode() + codeSystemOid.hashCode();
        }
        else if ( code!= null && codeSystemOid == null ) {
            return code.hashCode();
        }
        return this.hashCode();
    }
    
    @Override
    public boolean equals( Object obj ) {
                
        if ( code != null && codeSystemOid != null) {
            return this.hashCode() == obj.hashCode();
        }
        else if ( code != null && codeSystemOid == null ) {
            return code.hashCode() == obj.hashCode();
        }
        
        return false;
        
    }
    
}
