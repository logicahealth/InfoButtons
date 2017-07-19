package org.openinfobutton.valuset.matcher.model;

import java.util.List;

/**
 * Created by andrew on 4/26/17.
 */
public class ValueSets {

    private ValueSet valueSet;

    public ValueSet getValueSet() {
        return valueSet;
    }

    public void setValueSet(ValueSet valueSet) {
        this.valueSet = valueSet;
    }


    public static class ValueSet {

        private String name;

        private String description;

        private List<CodeSystem> codeSystems;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<CodeSystem> getCodeSystems() {
            return codeSystems;
        }

        public void setCodeSystems(List<CodeSystem> codeSystems) {
            this.codeSystems = codeSystems;
        }

    }

    public static class CodeSystem {

        private String codeSystem;

        private List<Code> codes;

        public String getCodeSystem() {
            return codeSystem;
        }

        public void setCodeSystem(String codeSystem) {
            this.codeSystem = codeSystem;
        }

        public List<Code> getCodes() {
            return codes;
        }

        public void setCodes(List<Code> codes) {
            this.codes = codes;
        }
    }

    public static class Code {

        private String code;

        private String displayName;

        public String getCode () {

            return code;
        }

        public String getDisplayName() {

            return displayName;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }


}
