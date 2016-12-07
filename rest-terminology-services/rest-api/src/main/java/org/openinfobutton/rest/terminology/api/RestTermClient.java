package org.openinfobutton.rest.terminology.api;

/**
 *
 * The Rest Terminology client calls an external web service using a search term
 * and returns a JSON string as a result.
 *
 * -----------------------------------------------------------------------------------
 * (c) 2010-2016 OpenInfobutton Project, Biomedical Informatics, University of Utah
 * Contact: {@code <andrew.iskander@utah.edu>}
 * Biomedical Informatics
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514
 * Day Phone: 1-801-581-4080
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version March 13, 2016
 */
public interface RestTermClient {

    /**
     *
     * Returns a JSON result from a web service
     * in response to a search string.
     *
     * @param search Search term
     * @return JSON search result from web service
     *
     */
    String getTerms(String search);

    /**
     *
     * Returns a JSON result from a web service
     * in response to a search string and code system.
     *
     * @param search Search term
     * @param codeSystem Code System
     * @return JSON search result from web service
     */
    String getTerms (String search, String codeSystem);

    String getCodes (String code, String codeSystem);
    String getCodes (String CUI, String targetCS, String search);
}
