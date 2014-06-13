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
 * @version Jun 13, 2014
 */
package edu.utah.further.subsetdb.domain;

import static edu.utah.further.core.api.text.ToStringCustomStyles.SHORT_WITH_SPACES_STYLE;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import edu.utah.further.core.api.data.PersistentEntity;
import edu.utah.further.core.api.lang.Final;

@Entity
@Table(name = "concept")
public class Concept implements PersistentEntity<Long> {
	// ========================= CONSTANTS =================================

	/**
	 * @serial Serializable version identifier.
	 */
	private static final long serialVersionUID = 1L;

	// ========================= FIELDS ====================================

	/**
	 * The unique identifier of this entity.
	 */
	@Id
	@Final
	public Long conceptId;

	/**
	 * Code of concept.
	 */
	@Column(name = "code", nullable = true)
	private String code;

	/**
	 * Display name of concept
	 */
	@Column(name = "displayname", nullable = true)
	private String displayName;
	
	/**
	 * Code system of concept
	 */
	@Column(name = "codesystem", nullable = true)
	private String codeSystem;
	
	/**
	 * Code system display name of concept
	 */
	@Column(name = "codesystemname", nullable = true)
	private String codeSystemName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "subsetmember", joinColumns = { @JoinColumn (name = 
		"conceptid") }, inverseJoinColumns = { @JoinColumn(name = "subsetid")})
	private Set<Subset> subsets = new HashSet<Subset>(0);
	

	// ========================= CONSTRUCTORS ==============================

	// ========================= IMPLEMENTATION: Object ====================

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public final boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Concept that = (Concept) obj;
		return new EqualsBuilder().append(this.conceptId,
				that.conceptId).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public final int hashCode() {
		return new HashCodeBuilder().append(conceptId).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this, SHORT_WITH_SPACES_STYLE)
				.append("conceptId", conceptId).append("code", code)
				.append("displayName", displayName).append("codeSystem", codeSystem)
				.append("codeSystemName", codeSystemName).toString();
	}

	// ========================= IMPLEMENTATION: PersistentEntity ==========

	/**
	 * @return
	 * @see edu.utah.further.core.util.data.PersistentEntity#getId()
	 */

	public Long getId() {
		return conceptId;
	}

	public void setConceptId(Long conceptId) {
		this.conceptId = conceptId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getCodeSystem() {
		return codeSystem;
	}

	public void setCodeSystem(String codeSystem) {
		this.codeSystem = codeSystem;
	}

	public String getCodeSystemName() {
		return codeSystemName;
	}

	public void setCodeSystemName(String codeSystemName) {
		this.codeSystemName = codeSystemName;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	public Set<Subset> getSubsets() {
		return subsets;
	}

	public void setSubsets(Set<Subset> subsets) {
		this.subsets = subsets;
	}

	// ========================= IMPLEMENTATION: Person ====================

}
