package org.utah.edu.semmedDao;


import javax.persistence.*;

/**
 * Created by JoeNarus on 6/9/16.
 */
@Entity
@Table(name = "CONCEPT_FREQUENCY_SEMMED")
public class ConceptFrequencySemmedEntity {
    private String pmid;
    private String cui;
    private String preferredName;
    private String semGroup;
    private Byte conceptCount;


    @Column(name = "PMID")
    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

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

    @Column(name = "concept_count")
    public Byte getConceptCount() {
        return conceptCount;
    }

    public void setConceptCount(Byte conceptCount) {
        this.conceptCount = conceptCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConceptFrequencySemmedEntity that = (ConceptFrequencySemmedEntity) o;

        if (pmid != null ? !pmid.equals(that.pmid) : that.pmid != null) return false;
        if (cui != null ? !cui.equals(that.cui) : that.cui != null) return false;
        if (preferredName != null ? !preferredName.equals(that.preferredName) : that.preferredName != null)
            return false;
        if (semGroup != null ? !semGroup.equals(that.semGroup) : that.semGroup != null) return false;
        if (conceptCount != null ? !conceptCount.equals(that.conceptCount) : that.conceptCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pmid != null ? pmid.hashCode() : 0;
        result = 31 * result + (cui != null ? cui.hashCode() : 0);
        result = 31 * result + (preferredName != null ? preferredName.hashCode() : 0);
        result = 31 * result + (semGroup != null ? semGroup.hashCode() : 0);
        result = 31 * result + (conceptCount != null ? conceptCount.hashCode() : 0);
        return result;
    }

}
