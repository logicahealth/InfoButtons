/**
 * -----------------------------------------------------------------------------------
 * (c) 2010-2014 OpenInfobutton Project, Biomedical Informatics, University of Utah
 * Contact: {@code <andrew.iskander@utah.edu>}
 * Biomedical Informatics
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514
 * Day Phone: 1-801-581-4080
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version Jul 15, 2014
 */
package edu.utah.openinfobutton.inference.rxnorm.schema;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// TODO: Auto-generated Javadoc
/**
 * The Class ApproxGroup.
 */
@XmlRootElement( namespace = "", name = "approxGroup" )
@XmlType( name = "", propOrder = { "inputTerm", "candidate" } )
@XmlAccessorType( XmlAccessType.FIELD )
public class ApproxGroup
{
    
    /** The input term. */
    @XmlElement( name = "inputTerm", required = true )
    private String inputTerm;

    /** The candidate. */
    @XmlElementRef( name = "candidate" )
    private List<Candidate> candidate = new ArrayList<Candidate>();

    /**
     * Return the inputTerm property.
     *
     * @return the input term
     */
    public String getInputTerm()
    {
        return this.inputTerm;
    }

    /**
     * Sets a new value for the inputTerm property.
     *
     * @param inputTerm the new input term
     */
    public void setInputTerm( String inputTerm )
    {
        this.inputTerm = inputTerm;
    }

    /**
     * Returns the candidates property.
     *
     * @return the candidates
     */
    public List<Candidate> getCandidates()
    {
        return this.candidate;
    }

    /**
     * Sets a new value for the candidates property.
     *
     * @param candidate the new candidates
     */
    public void setCandidates( List<Candidate> candidate )
    {
        this.candidate = candidate;
    }

    /**
     * The Class Candidate.
     */
    @XmlRootElement( namespace = "", name = "candidate" )
    @XmlType( name = "", propOrder = { "rxcui", "rxaui", "score", "rank" } )
    @XmlAccessorType( XmlAccessType.FIELD )
    public static class Candidate
    {
        
        /** The rxcui. */
        @XmlElement( name = "rxcui", required = true )
        private String rxcui;

        /** The rxaui. */
        @XmlElement( name = "rxaui", required = true )
        private String rxaui;

        /** The score. */
        @XmlElement( name = "score", required = true )
        private String score;

        /** The rank. */
        @XmlElement( name = "rank", required = true )
        private String rank;

        /**
         * Return the rxcui property.
         * 
         * @return the rxcui
         */
        public String getRxcui()
        {
            return rxcui;
        }

        /**
         * Set a new value for the rxcui property.
         * 
         * @param rxcui the rxcui to set
         */
        public void setRxcui( String rxcui )
        {
            this.rxcui = rxcui;
        }

        /**
         * Return the rxaui property.
         * 
         * @return the rxaui
         */
        public String getRxaui()
        {
            return rxaui;
        }

        /**
         * Set a new value for the rxaui property.
         * 
         * @param rxaui the rxaui to set
         */
        public void setRxaui( String rxaui )
        {
            this.rxaui = rxaui;
        }

        /**
         * Return the rank property.
         * 
         * @return the rank
         */
        public String getRank()
        {
            return rank;
        }

        /**
         * Set a new value for the rank property.
         * 
         * @param rank the rank to set
         */
        public void setRank( String rank )
        {
            this.rank = rank;
        }

    }

}
