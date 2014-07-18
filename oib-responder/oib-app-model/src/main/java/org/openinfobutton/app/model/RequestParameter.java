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
package org.openinfobutton.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestParameter.
 *
 * @author rick
 */
@Entity
@Table( name = "OIB_REQUEST_PARAMETER" )
@XmlRootElement
@NamedQueries( {
    @NamedQuery( name = "RequestParameter.findAll", query = "SELECT o FROM RequestParameter o" ),
    @NamedQuery( name = "RequestParameter.findByRequestParameterId", 
                query = "SELECT o FROM RequestParameter o WHERE o.requestParameterId = :requestParameterId" ),
    @NamedQuery( name = "RequestParameter.findByParameterName", 
                query = "SELECT o FROM RequestParameter o WHERE o.parameterName = :parameterName" ),
    @NamedQuery( name = "RequestParameter.findByParameterDescription", 
                query = "SELECT o FROM RequestParameter o WHERE o.parameterDescription = :parameterDescription" ),
    @NamedQuery( name = "RequestParameter.findByCardinalityMin", 
                query = "SELECT o FROM RequestParameter o WHERE o.cardinalityMin = :cardinalityMin" ),
    @NamedQuery( name = "RequestParameter.findByCardinalityMax", 
                query = "SELECT o FROM RequestParameter o WHERE o.cardinalityMax = :cardinalityMax" ) } )
public class RequestParameter
    implements Serializable
{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce
    // field validation
    /** The request parameter id. */
    @Id
    @Basic( optional = false )
    @Column( name = "REQUEST_PARAMETER_ID" )
    private BigDecimal requestParameterId;

    /** The parameter name. */
    @Column( name = "PARAMETER_NAME" )
    private String parameterName;

    /** The parameter root. */
    @Column( name = "PARAMETER_ROOT" )
    private String parameterRoot;

    /** The type code. */
    @Column( name = "TYPE_CD" )
    private String typeCode;

    /** The parameter description. */
    @Column( name = "PARAMETER_DSC" )
    private String parameterDescription;

    /** The cardinality min. */
    @Column( name = "CARDINALITY_MIN" )
    private Long cardinalityMin;

    /** The cardinality max. */
    @Column( name = "CARDINALITY_MAX" )
    private BigInteger cardinalityMax;

    /**
     * Instantiates a new request parameter.
     */
    public RequestParameter()
    {
    }

    /**
     * Instantiates a new request parameter.
     *
     * @param requestParameterId the request parameter id
     */
    public RequestParameter( BigDecimal requestParameterId )
    {
        this.requestParameterId = requestParameterId;
    }

    /**
     * Gets the request parameter id.
     *
     * @return the request parameter id
     */
    public BigDecimal getRequestParameterId()
    {
        return requestParameterId;
    }

    /**
     * Sets the request parameter id.
     *
     * @param requestParameterId the new request parameter id
     */
    public void setRequestParameterId( BigDecimal requestParameterId )
    {
        this.requestParameterId = requestParameterId;
    }

    /**
     * Gets the parameter name.
     *
     * @return the parameter name
     */
    public String getParameterName()
    {
        return parameterName;
    }

    /**
     * Sets the parameter name.
     *
     * @param parameterName the new parameter name
     */
    public void setParameterName( String parameterName )
    {
        this.parameterName = parameterName;
    }

    /**
     * Gets the parameter root.
     *
     * @return the parameter root
     */
    public String getParameterRoot()
    {
        return parameterRoot;
    }

    /**
     * Sets the parameter root.
     *
     * @param parameterRoot the new parameter root
     */
    public void setParameterRoot( String parameterRoot )
    {
        this.parameterRoot = parameterRoot;
    }

    /**
     * Gets the type code.
     *
     * @return the type code
     */
    public String getTypeCode()
    {
        return typeCode;
    }

    /**
     * Sets the type code.
     *
     * @param typeCode the new type code
     */
    public void setTypeCode( String typeCode )
    {
        this.typeCode = typeCode;
    }

    /**
     * Gets the parameter description.
     *
     * @return the parameter description
     */
    public String getParameterDescription()
    {
        return parameterDescription;
    }

    /**
     * Sets the parameter description.
     *
     * @param parameterDescription the new parameter description
     */
    public void setParameterDescription( String parameterDescription )
    {
        this.parameterDescription = parameterDescription;
    }

    /**
     * Gets the cardinality min.
     *
     * @return the cardinality min
     */
    public Long getCardinalityMin()
    {
        return cardinalityMin;
    }

    /**
     * Sets the cardinality min.
     *
     * @param cardinalityMin the new cardinality min
     */
    public void setCardinalityMin( Long cardinalityMin )
    {
        this.cardinalityMin = cardinalityMin;
    }

    /**
     * Gets the cardinality max.
     *
     * @return the cardinality max
     */
    public BigInteger getCardinalityMax()
    {
        return cardinalityMax;
    }

    /**
     * Sets the cardinality max.
     *
     * @param cardinalityMax the new cardinality max
     */
    public void setCardinalityMax( BigInteger cardinalityMax )
    {
        this.cardinalityMax = cardinalityMax;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( requestParameterId != null ? requestParameterId.hashCode() : 0 );
        return hash;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if ( !( object instanceof RequestParameter ) )
        {
            return false;
        }
        final RequestParameter other = (RequestParameter) object;
        if ( ( this.requestParameterId == null && other.requestParameterId != null )
            || ( this.requestParameterId != null && !this.requestParameterId.equals( other.requestParameterId ) ) )
        {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "org.openinfobutton.request.model.RequestParameter[ requestParameterId=" + requestParameterId + " ]";
    }

}
