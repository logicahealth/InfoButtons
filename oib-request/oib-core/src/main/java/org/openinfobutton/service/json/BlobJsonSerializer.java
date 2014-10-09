/*******************************************************************************
 * Source File: BlobJsonSerializer.java
 ******************************************************************************/
package org.openinfobutton.service.json;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

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
 * @version May 5, 2014
 */
public class BlobJsonSerializer extends JsonSerializer<Blob>
{

    /*
     * (non-Javadoc)
     * @see org.codehaus.jackson.map.JsonSerializer#serialize(java.lang.Object, org.codehaus.jackson.JsonGenerator, org.codehaus.jackson.map.SerializerProvider)
     */
    @Override
    public void serialize( Blob blob, JsonGenerator gen, SerializerProvider prov )
        throws IOException, JsonProcessingException
    {
        byte[] bdata = null;
        try
        {
            bdata = blob.getBytes(1, (int) blob.length());
        }
        catch ( SQLException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String s = new String(bdata);
        gen.writeString(s);

    }

}
