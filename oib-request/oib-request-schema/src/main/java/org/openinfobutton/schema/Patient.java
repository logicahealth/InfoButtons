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
package org.openinfobutton.schema;

import org.openinfobutton.schemas.kb.Code;

// TODO: Auto-generated Javadoc
/**
 * The Class Patient.
 */
public class Patient
{

    /** The gender. */
    private Code gender;

    /** The age group. */
    private Code ageGroup;

    /** The age. */
    private Float age;

    /**
     * Instantiates a new patient.
     *
     * @param gender the gender
     * @param ageGroup the age group
     * @param age the age
     */
    public Patient( Code gender, Code ageGroup, Float age )
    {

        this.gender = gender;
        this.ageGroup = ageGroup;
        this.age = age;

    }

    /**
     * Instantiates a new patient.
     */
    public Patient()
    {

        this( CodeUtility.getCode(), CodeUtility.getCode(), new Float( 0 ) );
    }

    /**
     * Gets the gender.
     *
     * @return the gender
     */
    public Code getGender()
    {

        return this.gender;
    }

    /**
     * Gets the age group.
     *
     * @return the age group
     */
    public Code getAgeGroup()
    {

        return this.ageGroup;
    }

    /**
     * Gets the age.
     *
     * @return the age
     */
    public Float getAge()
    {

        return this.age;
    }

    /**
     * Sets the gender.
     *
     * @param gender the new gender
     */
    public void setGender( Code gender )
    {

        this.gender = gender;

    }

    /**
     * Sets the age group.
     *
     * @param ageGroup the new age group
     */
    public void setAgeGroup( Code ageGroup )
    {

        this.ageGroup = ageGroup;
    }

    /**
     * Sets the age.
     *
     * @param age the new age
     */
    public void setAge( Float age )
    {

        this.age = age;
    }

}
