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
package edu.utah.further.profiledb.service;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;

import edu.utah.further.core.api.context.Implementation;
import edu.utah.further.core.api.data.Dao;
import edu.utah.further.profiledb.domain.Profiles;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfilesDaoImpl.
 */
@Implementation
@Repository( "profilesdbDao" )
public class ProfilesDaoImpl
    implements ProfilesDao
{

    /** The dao. */
    @Autowired
    @Qualifier( "profilesDao" )
    private Dao dao;

    /*
     * (non-Javadoc)
     * @see edu.utah.further.profiledb.service.ProfilesDao#getResourceProfile(long, int, edu.utah.further.profiledb.service.FileandMarker)
     */
    @Override
    @Transactional
    public void getResourceProfile( long id, int status, FileandMarker fm )
    {

        boolean finish = false;
        Profiles p = null;
        // FileandMarker fm = new FileandMarker();

        while ( !finish )
        {
            final Map<String, Object> properties = new HashMap<String, Object>();
            properties.put( "id", new Long( id ) );
            properties.put( "status", new Integer( status ) );
            final List l = dao.findByProperties( Profiles.class, properties );
            id++;
            fm.setMarker( (int) id );
            if ( l.size() != 0 )
            {

                p = (Profiles) l.get( 0 );
                finish = true;
            }
        }

        try
        {
            final Blob b = p.getContent();
            final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware( true );
            final DocumentBuilder db = dbf.newDocumentBuilder();
            final Document doc = db.parse( b.getBinaryStream() );
            fm.setBlobFile( doc );
            // A temporary file is created here
            // fm.setBlobFile(new File("fetch.xml")) ;
            //
            // InputStream in = b.getBinaryStream();
            // BufferedInputStream bufferedInputStream = new BufferedInputStream( in);
            // FileOutputStream outStream = new FileOutputStream(fm.getBlobFile());
            // int data = -1;
            // while ( (data = bufferedInputStream.read( )) != -1 )
            // {
            // outStream.write( data);
            // }
        }
        catch ( final Exception e )
        {
            e.printStackTrace();
        }
        // return fm;
    }

    /*
     * (non-Javadoc)
     * @see edu.utah.further.profiledb.service.ProfilesDao#count(int)
     */
    @Override
    @Transactional
    public long count( int status )
    {
        // Get the number of the profiles of the required status
        long count = 0;
        final long i = 1;
        final Integer temp = new Integer( status );
        final List no = dao.findByProperty( Profiles.class, "status", temp );
        count = no.size();
        return count;
    }

}
