/*******************************************************************************
 * Source File: RelatedGroup.java
 ******************************************************************************/
package edu.utah.openinfobutton.inference.rxnorm.schema;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
@XmlRootElement(namespace="", name="relatedGroup")
@XmlType(name="", propOrder=
{"rxcui", "termType", "rela", "conceptGroup"})
@XmlAccessorType(XmlAccessType.FIELD)
public class RelatedGroup
{
	@XmlElement(name="rxcui", required=true)
	private String rxcui;
	
	@XmlElement(name="termType", required=false)
	private List<String> termType;
	
	@XmlElement(name="rela", required=false)
	private List<String> rela;
	
	@XmlElement(name="conceptGroup", required=false)
	private List<ConceptGroup> conceptGroup;

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
	 * Return the termType property.
	 *
	 * @return the termType
	 */
	public List<String> getTermType()
	{
		return termType;
	}

	/**
	 * Set a new value for the termType property.
	 *
	 * @param termType the termType to set
	 */
	public void setTermType(List<String> termType)
	{
		this.termType = termType;
	}

	/**
	 * Return the rela property.
	 *
	 * @return the rela
	 */
	public List<String> getRela()
	{
		return rela;
	}

	/**
	 * Set a new value for the rela property.
	 *
	 * @param rela the rela to set
	 */
	public void setRela(List<String> rela)
	{
		this.rela = rela;
	}

	/**
	 * Return the conceptGroup property.
	 *
	 * @return the conceptGroup
	 */
	public List<ConceptGroup> getConceptGroup()
	{
		return conceptGroup;
	}

	/**
	 * Set a new value for the conceptGroup property.
	 *
	 * @param conceptGroup the conceptGroup to set
	 */
	public void setConceptGroup(List<ConceptGroup> conceptGroup)
	{
		this.conceptGroup = conceptGroup;
	}
	
	@XmlRootElement(namespace="", name="conceptGroup")
	@XmlType(name="", propOrder=
	{"tty", "conceptProperties"})
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class ConceptGroup
	{
		@XmlElement(name="tty", required=true)
		private String tty;
		
		@XmlElement(name="conceptProperties", required=false)
		private List<ConceptProperties> conceptProperties;

		/**
		 * Return the tty property.
		 *
		 * @return the tty
		 */
		public String getTty()
		{
			return tty;
		}

		/**
		 * Set a new value for the tty property.
		 *
		 * @param tty the tty to set
		 */
		public void setTty(String tty)
		{
			this.tty = tty;
		}

		/**
		 * Return the conceptProperties property.
		 *
		 * @return the conceptProperties
		 */
		public List<ConceptProperties> getConceptProperties()
		{
			return conceptProperties;
		}

		/**
		 * Set a new value for the conceptProperties property.
		 *
		 * @param conceptProperties the conceptProperties to set
		 */
		public void setConceptProperties(List<ConceptProperties> conceptProperties)
		{
			this.conceptProperties = conceptProperties;
		}
		
		@XmlRootElement(namespace="", name="conceptProperties")
		@XmlType(name="", propOrder=
		{"rxcui","name","synonym","tty","language","suppress","umlscui"})
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class ConceptProperties
		{
			@XmlElement(name="rxcui", required=true)
			private String rxcui;
			
			@XmlElement(name="name", required=true)
			private String name;
			
			@XmlElement(name="synonym", required=true)
			private String synonym;
			
			@XmlElement(name="tty", required=true)
			private String tty;
			
			@XmlElement(name="language", required=true)
			private String language;
			
			@XmlElement(name="suppress", required=true)
			private String suppress;
			
			@XmlElement(name="umlscui", required=true)
			private String umlscui;

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
			 * Return the name property.
			 *
			 * @return the name
			 */
			public String getName()
			{
				return name;
			}

			/**
			 * Set a new value for the name property.
			 *
			 * @param name the name to set
			 */
			public void setName(String name)
			{
				this.name = name;
			}

			/**
			 * Return the synonym property.
			 *
			 * @return the synonym
			 */
			public String getSynonym()
			{
				return synonym;
			}

			/**
			 * Set a new value for the synonym property.
			 *
			 * @param synonym the synonym to set
			 */
			public void setSynonym(String synonym)
			{
				this.synonym = synonym;
			}

			/**
			 * Return the tty property.
			 *
			 * @return the tty
			 */
			public String getTty()
			{
				return tty;
			}

			/**
			 * Set a new value for the tty property.
			 *
			 * @param tty the tty to set
			 */
			public void setTty(String tty)
			{
				this.tty = tty;
			}

			/**
			 * Return the language property.
			 *
			 * @return the language
			 */
			public String getLanguage()
			{
				return language;
			}

			/**
			 * Set a new value for the language property.
			 *
			 * @param language the language to set
			 */
			public void setLanguage(String language)
			{
				this.language = language;
			}

			/**
			 * Return the suppress property.
			 *
			 * @return the suppress
			 */
			public String getSuppress()
			{
				return suppress;
			}

			/**
			 * Set a new value for the suppress property.
			 *
			 * @param suppress the suppress to set
			 */
			public void setSuppress(String suppress)
			{
				this.suppress = suppress;
			}

			/**
			 * Return the umlscui property.
			 *
			 * @return the umlscui
			 */
			public String getUmlscui()
			{
				return umlscui;
			}

			/**
			 * Set a new value for the umlscui property.
			 *
			 * @param umlscui the umlscui to set
			 */
			public void setUmlscui(String umlscui)
			{
				this.umlscui = umlscui;
			}
		}
	}
}
