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
package edu.utah.openinfobutton.externalresource.implementation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.openinfobutton.schemas.kb.TerminologyInference.CodeInference.InferenceDefinition.LocalMappings.Mapping;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * The Class TerminologyMappings.
 */
@Lazy
@Component
public class TerminologyMappings
{

    /** The filename. */
    String filename = "validMappings.csv";

    /** The valid mappings. */
    List<Mapping> validMappings;

    /**
     * Instantiates a new terminology mappings.
     */
    public TerminologyMappings()
    {
        try
        {
            validMappings = new ArrayList<Mapping>();
            final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            final InputStream mapInput = classLoader.getResourceAsStream( filename );
            final BufferedReader br = new BufferedReader( new InputStreamReader( mapInput ) );
            String strLine = "";
            StringTokenizer st = null;
            while ( ( strLine = br.readLine() ) != null )
            {
                try
                {
                    final Mapping mapping = new Mapping();
                    st = new StringTokenizer( strLine, "," );
                    mapping.setSourceName( st.nextToken() );
                    mapping.setSourceValue( st.nextToken() );
                    mapping.setTargetName( st.nextToken() );
                    // st.nextToken();
                    mapping.setTargetValue( st.nextToken() );
                    // mapping.setMapID(st.nextToken());
                    validMappings.add( mapping );
                }
                catch ( final NoSuchElementException e )
                {
                }
            }

        }
        catch ( final FileNotFoundException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch ( final IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Gets the valid mappings.
     *
     * @return the valid mappings
     */
    public List<Mapping> getValidMappings()
    {
        return validMappings;
    }

    /**
     * Sets the valid mappings.
     *
     * @param validMappings the new valid mappings
     */
    public void setValidMappings( List<Mapping> validMappings )
    {
        this.validMappings = validMappings;
    }

    // public static void main(String args[])
    // {
    // TerminologyMappings tm = new TerminologyMappings();
    // System.out.println(tm.validMappings);
    // }

}
