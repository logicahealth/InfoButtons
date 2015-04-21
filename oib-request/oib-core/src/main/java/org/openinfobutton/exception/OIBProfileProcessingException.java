package org.openinfobutton.exception;


import org.openinfobutton.schemas.kb.KnowledgeResourceProfile;

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
