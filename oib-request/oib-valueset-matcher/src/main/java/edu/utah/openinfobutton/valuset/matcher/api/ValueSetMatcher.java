package edu.utah.openinfobutton.valuset.matcher.api;

/**
 * Created by andrew on 4/26/17.
 */
public interface ValueSetMatcher {

    /**
     * Checks if is concept in subset.
     *
     * @param code the code
     * @param codeSystem the code system
     * @param subsetName the subset name
     * @return the boolean
     */
    public Boolean isConceptInSubset( String code, String codeSystem, String subsetName );
}
