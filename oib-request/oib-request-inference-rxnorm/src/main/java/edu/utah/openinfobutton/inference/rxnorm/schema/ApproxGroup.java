/**
 * ...
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2010-2014 OpenInfobutton Project, Biomedical Informatics, University of Utah<br>
 * Contact: {@code <andrew.iskander@utah.edu>}<br>
 * Biomedical Informatics<br>
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version May 5, 2014
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

/**
 * ...
 * <p>
 * -----------------------------------------------------------------------------------<br>
 * (c) 2008-2012 FURTHeR Project, Health Sciences IT, University of Utah<br>
 * Contact: {@code <further@utah.edu>}<br>
 * Biomedical Informatics, 26 South 2000 East<br>
 * Room 5775 HSEB, Salt Lake City, UT 84112<br>
 * Day Phone: 1-801-581-4080<br>
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version Aug 13, 2012
 */
@XmlRootElement(namespace="", name = "approxGroup")
@XmlType(name="", propOrder = 
{"inputTerm", "candidate"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ApproxGroup
{
	@XmlElement(name="inputTerm", required=true)
	private String inputTerm;
	
	@XmlElementRef(name="candidate")
	private List<Candidate> candidate = new ArrayList<Candidate>();
	
	/**
	 * Return the inputTerm property
	 * 
	 * @return
	 */
	public String getInputTerm()
	{
		return this.inputTerm;
	}
	
	/**
	 * Sets a new value for the inputTerm property
	 * 
	 * @param inputTerm
	 */
	public void setInputTerm(String inputTerm)
	{
		this.inputTerm = inputTerm;
	}
	
	/**
	 * Returns the candidates property
	 * 
	 * @return
	 */
	public List<Candidate> getCandidates()
	{
		return this.candidate;
	}
	
	/**
	 * Sets a new value for the candidates property
	 * 
	 * @param candidates
	 */
	public void setCandidates(List<Candidate> candidate)
	{
		this.candidate = candidate;
	}
	
	@XmlRootElement(namespace="", name ="candidate")
	@XmlType(name="", propOrder =
	{"rxcui", "rxaui", "score", "rank"})
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Candidate
	{
		@XmlElement(name="rxcui", required=true)
		private String rxcui;
		
		@XmlElement(name="rxaui", required=true)
		private String rxaui;
		
		@XmlElement(name="score", required=true)
		private String score;
		
		@XmlElement(name="rank", required=true)
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
		public void setRxcui(String rxcui)
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
		public void setRxaui(String rxaui)
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
		public void setRank(String rank)
		{
			this.rank = rank;
		}
	
	}
	
}
