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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import edu.utah.further.core.api.data.PersistentEntity;
import edu.utah.further.core.api.lang.Final;

@Entity
@Table(name = "subset")
public class Subset implements PersistentEntity<Long> {
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
	public Long subsetId;

	/**
	 * Name of subset.
	 */
	@Column(name = "name", nullable = true)
	private String name;

	/**
	 * Description of subset
	 */
	@Column(name = "description", nullable = true)
	private String description;
	
	/**
	 * Internal concept id
	 */
	@Column(name = "internalconceptid", nullable = true)
	private Integer internalConceptId;
	
	/**
	 * Methodology concept id
	 */
	@Column(name = "methodologyconceptid", nullable = true)
	private String methodologyConceptId;

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
		final Subset that = (Subset) obj;
		return new EqualsBuilder().append(this.subsetId,
				that.subsetId).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public final int hashCode() {
		return new HashCodeBuilder().append(subsetId).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this, SHORT_WITH_SPACES_STYLE)
				.append("subsetId", subsetId).append("name", name)
				.append("description", description).append("internalconceptid", internalConceptId)
				.append("methodologyconceptid", methodologyConceptId).toString();
	}

	// ========================= IMPLEMENTATION: PersistentEntity ==========

	/**
	 * @return
	 * @see edu.utah.further.core.util.data.PersistentEntity#getId()
	 */

	public Long getId() {
		return subsetId;
	}

	public void setSubsetId(Long subsetId) {
		this.subsetId = subsetId;
	}

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

	public Integer getInternalConceptId() {
		return internalConceptId;
	}

	public void setInternalConceptId(Integer internalConceptId) {
		this.internalConceptId = internalConceptId;
	}

	public String getMethodologyConceptId() {
		return methodologyConceptId;
	}

	public void setMethodologyConceptId(String methodologyConceptId) {
		this.methodologyConceptId = methodologyConceptId;
	}

	// ========================= IMPLEMENTATION: Person ====================

}
