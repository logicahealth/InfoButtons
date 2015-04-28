package org.openinfobutton.exception;


/*

Simple named error wrapper for exceptions that occur due to mis-configured profiles that still validate
against the XSD.
 */
public class OIBProfileProcessingException extends IllegalArgumentException {

    private static final long serialVersionUID = 4429230597523361366L;

    public OIBProfileProcessingException()
    {
    }

    public OIBProfileProcessingException(String message)
    {
        super(message);
    }

    public OIBProfileProcessingException (String message, Throwable cause)
    {
        super (message, cause);
    }
}
