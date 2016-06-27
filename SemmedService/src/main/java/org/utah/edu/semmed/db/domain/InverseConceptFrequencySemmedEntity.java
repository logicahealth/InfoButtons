package org.utah.edu.semmed.db.domain;

/**
 * Created by JoeNarus on 6/9/16.
 */

import javax.persistence.*;

@Entity
@Table(name = "INVERSE_CONCEPT_FREQUENCY_SEMMED")
public class InverseConceptFrequencySemmedEntity {
    private String cui;
    private String preferredName;
    private String semGroup;
    private long conceptCount;

    @Id
    @Column(name = "CUI")
    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    @Column(name = "PREFERRED_NAME")
    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    @Column(name = "SEM_GROUP")
    public String getSemGroup() {
        return semGroup;
    }

    public void setSemGroup(String semGroup) {
        this.semGroup = semGroup;
    }

    @Column(name = "CONCEPT_COUNT")
    public long getConceptCount() {
        return conceptCount;
    }

    public void setConceptCount(long conceptCount) {
        this.conceptCount = conceptCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InverseConceptFrequencySemmedEntity that = (InverseConceptFrequencySemmedEntity) o;

        if (conceptCount != that.conceptCount) return false;
        if (cui != null ? !cui.equals(that.cui) : that.cui != null) return false;
        if (preferredName != null ? !preferredName.equals(that.preferredName) : that.preferredName != null)
            return false;
        if (semGroup != null ? !semGroup.equals(that.semGroup) : that.semGroup != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cui != null ? cui.hashCode() : 0;
        result = 31 * result + (preferredName != null ? preferredName.hashCode() : 0);
        result = 31 * result + (semGroup != null ? semGroup.hashCode() : 0);
        result = 31 * result + (int) (conceptCount ^ (conceptCount >>> 32));
        return result;
    }
}
