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
package org.openinfobutton.responder.dao.impl;

import java.util.Collection;
import java.util.List;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openinfobutton.app.dao.DaoBase;
import org.openinfobutton.app.model.RequestParameter;
import org.openinfobutton.responder.dao.ResponderRequestParameterDao;
import org.springframework.stereotype.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class ResponderRequestParameterDaoImpl.
 *
 * @author rick
 */
@Repository
public class ResponderRequestParameterDaoImpl
    extends DaoBase<RequestParameter>
    implements ResponderRequestParameterDao
{

    /** The supported open infobutton request parameters. */
    List<RequestParameter> supportedOpenInfobuttonRequestParameters = null;

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.responder.dao.ResponderRequestParameterDao#getRequiredOpenInfobuttonRequestParameters()
     */
    @Override
    public Collection<RequestParameter> getRequiredOpenInfobuttonRequestParameters()
    {
        return this.getOpenInfobuttonRequestParametersByMinCardinality( 1 );
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.responder.dao.ResponderRequestParameterDao#setAllOpenInfobuttonRequestParameters(java.util.List)
     */
    @Override
    public void setAllOpenInfobuttonRequestParameters( List<RequestParameter> supportedOpenInfobuttonRequestParameters )
    {
        this.supportedOpenInfobuttonRequestParameters = supportedOpenInfobuttonRequestParameters;
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.responder.dao.ResponderRequestParameterDao#getSupportedOpenInfobuttonRequestParametersOrdered()
     */
    @Override
    public List<RequestParameter> getSupportedOpenInfobuttonRequestParametersOrdered()
    {

        if ( supportedOpenInfobuttonRequestParameters == null )
        {
            supportedOpenInfobuttonRequestParameters =
                getSessionFactory().getCurrentSession().createCriteria( RequestParameter.class ).
                add( Restrictions.isNotNull( "parameterRoot" ) ).add( Restrictions.isNotNull( "parameterName" ) ).
                add( Restrictions.isNotNull( "typeCode" ) ).addOrder( Order.asc( "parameterName" ) ).list();
        }

        return supportedOpenInfobuttonRequestParameters;
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.responder.dao.ResponderRequestParameterDao#getOpenInfobuttonRequestParametersByMinCardinality(int)
     */
    @Override
    public Collection<RequestParameter> getOpenInfobuttonRequestParametersByMinCardinality( int minCardinality )
    {
        return getSessionFactory().getCurrentSession().createCriteria( RequestParameter.class ).
                        add( Restrictions.eq( "cardinalityMin", new Long( minCardinality ) ) ).list();
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.responder.dao.ResponderRequestParameterDao#getOpenInfobuttonRequestParameterByName(java.lang.String)
     */
    @Override
    public RequestParameter getOpenInfobuttonRequestParameterByName( String paramaterName )
    {

        final RequestParameter requestParameterExample = new RequestParameter();
        requestParameterExample.setParameterName( paramaterName );

        return (RequestParameter) getSessionFactory().getCurrentSession().createCriteria( RequestParameter.class ).
                        add( Example.create( requestParameterExample ) ).list().get( 0 );

    }

}
