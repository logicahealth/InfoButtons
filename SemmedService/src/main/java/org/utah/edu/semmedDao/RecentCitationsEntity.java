package org.utah.edu.semmedDao;

import javax.persistence.*;

/**
 * Created by JoeNarus on 6/2/16.
 */
@Entity
@Table(name = "RECENT_CITATIONS", schema = "SemanticMedline", catalog = "")
public class RecentCitationsEntity {
    private String pmid;
    private String issn;
    private String da;
    private String dcom;
    private String dp;
    private Integer pYear;
    private Integer quality;
    private Double probability;
    private String journalId;
    private String journalAbbreviation;
    private Integer numComments;
    private String ctGovId;
    private String pmcId;
    private String doi;
    private Byte comparativeStudy;
    private String authors;
    private String fundingSource;
    private Integer actualSample;
    private String ctGovFundingSource;
    private String ctGovFundingSourceType;
    private Boolean processed;
    private String summarySentence;
    private String citationjson;

    @Id
    @Column(name = "PMID")
    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    @Basic
    @Column(name = "ISSN")
    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    @Basic
    @Column(name = "DA")
    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    @Basic
    @Column(name = "DCOM")
    public String getDcom() {
        return dcom;
    }

    public void setDcom(String dcom) {
        this.dcom = dcom;
    }

    @Basic
    @Column(name = "DP")
    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    @Basic
    @Column(name = "PYear")
    public Integer getpYear() {
        return pYear;
    }

    public void setpYear(Integer pYear) {
        this.pYear = pYear;
    }

    @Basic
    @Column(name = "Quality")
    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    @Basic
    @Column(name = "Probability")
    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    @Basic
    @Column(name = "JournalID")
    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    @Basic
    @Column(name = "journal_abbreviation")
    public String getJournalAbbreviation() {
        return journalAbbreviation;
    }

    public void setJournalAbbreviation(String journalAbbreviation) {
        this.journalAbbreviation = journalAbbreviation;
    }

    @Basic
    @Column(name = "num_comments")
    public Integer getNumComments() {
        return numComments;
    }

    public void setNumComments(Integer numComments) {
        this.numComments = numComments;
    }

    @Basic
    @Column(name = "CT_GOV_ID")
    public String getCtGovId() {
        return ctGovId;
    }

    public void setCtGovId(String ctGovId) {
        this.ctGovId = ctGovId;
    }

    @Basic
    @Column(name = "PMC_ID")
    public String getPmcId() {
        return pmcId;
    }

    public void setPmcId(String pmcId) {
        this.pmcId = pmcId;
    }

    @Basic
    @Column(name = "DOI")
    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    @Basic
    @Column(name = "comparative_study")
    public Byte getComparativeStudy() {
        return comparativeStudy;
    }

    public void setComparativeStudy(Byte comparativeStudy) {
        this.comparativeStudy = comparativeStudy;
    }

    @Basic
    @Column(name = "authors")
    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Basic
    @Column(name = "funding_source")
    public String getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(String fundingSource) {
        this.fundingSource = fundingSource;
    }

    @Basic
    @Column(name = "actual_sample")
    public Integer getActualSample() {
        return actualSample;
    }

    public void setActualSample(Integer actualSample) {
        this.actualSample = actualSample;
    }

    @Basic
    @Column(name = "ct_gov_funding_source")
    public String getCtGovFundingSource() {
        return ctGovFundingSource;
    }

    public void setCtGovFundingSource(String ctGovFundingSource) {
        this.ctGovFundingSource = ctGovFundingSource;
    }

    @Basic
    @Column(name = "ct_gov_funding_source_type")
    public String getCtGovFundingSourceType() {
        return ctGovFundingSourceType;
    }

    public void setCtGovFundingSourceType(String ctGovFundingSourceType) {
        this.ctGovFundingSourceType = ctGovFundingSourceType;
    }

    @Basic
    @Column(name = "processed")
    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    @Basic
    @Column(name = "summary_sentence")
    public String getSummarySentence() {
        return summarySentence;
    }

    public void setSummarySentence(String summarySentence) {
        this.summarySentence = summarySentence;
    }

    @Basic
    @Column(name = "Citationjson")
    public String getCitationjson() {
        return citationjson;
    }

    public void setCitationjson(String citationjson) {
        this.citationjson = citationjson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecentCitationsEntity that = (RecentCitationsEntity) o;

        if (pmid != null ? !pmid.equals(that.pmid) : that.pmid != null) return false;
        if (issn != null ? !issn.equals(that.issn) : that.issn != null) return false;
        if (da != null ? !da.equals(that.da) : that.da != null) return false;
        if (dcom != null ? !dcom.equals(that.dcom) : that.dcom != null) return false;
        if (dp != null ? !dp.equals(that.dp) : that.dp != null) return false;
        if (pYear != null ? !pYear.equals(that.pYear) : that.pYear != null) return false;
        if (quality != null ? !quality.equals(that.quality) : that.quality != null) return false;
        if (probability != null ? !probability.equals(that.probability) : that.probability != null) return false;
        if (journalId != null ? !journalId.equals(that.journalId) : that.journalId != null) return false;
        if (journalAbbreviation != null ? !journalAbbreviation.equals(that.journalAbbreviation) : that.journalAbbreviation != null)
            return false;
        if (numComments != null ? !numComments.equals(that.numComments) : that.numComments != null) return false;
        if (ctGovId != null ? !ctGovId.equals(that.ctGovId) : that.ctGovId != null) return false;
        if (pmcId != null ? !pmcId.equals(that.pmcId) : that.pmcId != null) return false;
        if (doi != null ? !doi.equals(that.doi) : that.doi != null) return false;
        if (comparativeStudy != null ? !comparativeStudy.equals(that.comparativeStudy) : that.comparativeStudy != null)
            return false;
        if (authors != null ? !authors.equals(that.authors) : that.authors != null) return false;
        if (fundingSource != null ? !fundingSource.equals(that.fundingSource) : that.fundingSource != null)
            return false;
        if (actualSample != null ? !actualSample.equals(that.actualSample) : that.actualSample != null) return false;
        if (ctGovFundingSource != null ? !ctGovFundingSource.equals(that.ctGovFundingSource) : that.ctGovFundingSource != null)
            return false;
        if (ctGovFundingSourceType != null ? !ctGovFundingSourceType.equals(that.ctGovFundingSourceType) : that.ctGovFundingSourceType != null)
            return false;
        if (processed != null ? !processed.equals(that.processed) : that.processed != null) return false;
        if (summarySentence != null ? !summarySentence.equals(that.summarySentence) : that.summarySentence != null)
            return false;
        if (citationjson != null ? !citationjson.equals(that.citationjson) : that.citationjson != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pmid != null ? pmid.hashCode() : 0;
        result = 31 * result + (issn != null ? issn.hashCode() : 0);
        result = 31 * result + (da != null ? da.hashCode() : 0);
        result = 31 * result + (dcom != null ? dcom.hashCode() : 0);
        result = 31 * result + (dp != null ? dp.hashCode() : 0);
        result = 31 * result + (pYear != null ? pYear.hashCode() : 0);
        result = 31 * result + (quality != null ? quality.hashCode() : 0);
        result = 31 * result + (probability != null ? probability.hashCode() : 0);
        result = 31 * result + (journalId != null ? journalId.hashCode() : 0);
        result = 31 * result + (journalAbbreviation != null ? journalAbbreviation.hashCode() : 0);
        result = 31 * result + (numComments != null ? numComments.hashCode() : 0);
        result = 31 * result + (ctGovId != null ? ctGovId.hashCode() : 0);
        result = 31 * result + (pmcId != null ? pmcId.hashCode() : 0);
        result = 31 * result + (doi != null ? doi.hashCode() : 0);
        result = 31 * result + (comparativeStudy != null ? comparativeStudy.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + (fundingSource != null ? fundingSource.hashCode() : 0);
        result = 31 * result + (actualSample != null ? actualSample.hashCode() : 0);
        result = 31 * result + (ctGovFundingSource != null ? ctGovFundingSource.hashCode() : 0);
        result = 31 * result + (ctGovFundingSourceType != null ? ctGovFundingSourceType.hashCode() : 0);
        result = 31 * result + (processed != null ? processed.hashCode() : 0);
        result = 31 * result + (summarySentence != null ? summarySentence.hashCode() : 0);
        result = 31 * result + (citationjson != null ? citationjson.hashCode() : 0);
        return result;
    }
}
