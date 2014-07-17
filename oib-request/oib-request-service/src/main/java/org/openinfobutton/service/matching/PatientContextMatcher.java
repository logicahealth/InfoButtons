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
package org.openinfobutton.service.matching;

import java.util.List;

import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schema.Patient;
import org.openinfobutton.schema.PatientContext;
import org.openinfobutton.schemas.kb.CodedContextElement;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientContextMatcher.
 */
public class PatientContextMatcher
    extends ContextMatcher
{

    /** The patient context. */
    public PatientContext patientContext;

    /** The patient gender. */
    public CodedContextElement patientGender;

    /** The patient age. */
    public CodedContextElement patientAge;

    /** The request. */
    KnowledgeRequest request;

    /** The supported code systems. */
    List<String> supportedCodeSystems;

    /**
     * Instantiates a new patient context matcher.
     *
     * @param patientGender the patient gender
     * @param patientAge the patient age
     * @param request the request
     * @param supportedCodeSystems the supported code systems
     */
    public PatientContextMatcher( CodedContextElement patientGender, CodedContextElement patientAge,
                                  KnowledgeRequest request, List<String> supportedCodeSystems )
    {

        this.patientContext = request.getPatientContext();
        this.patientGender = patientGender;
        this.patientAge = patientAge;
        this.request = request;
        this.supportedCodeSystems = supportedCodeSystems;
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.matching.ContextMatcher#MatchContext()
     */
    @Override
    public Boolean MatchContext()
    {
        final Patient patient = patientContext.getPatient();
        if ( !CodeMatch( patient.getGender(), patientGender, supportedCodeSystems, false, request ) )
        {
            return false;
        }
        if ( !CodeMatch( patient.getAgeGroup(), patientAge, supportedCodeSystems, false, request ) )
        {
            return false;
        }
        return true;
    }
}
