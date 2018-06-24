package exception;

public class UbiveloxException extends Exception
{
    /**
     *
     */
    public UbiveloxException()
    {
    }





    /**
     * @param message
     */
    public UbiveloxException(final String message)
    {
        super(message);
    }





    /**
     * @param cause
     */
    public UbiveloxException(final Throwable cause)
    {
        super(cause);
    }





    /**
     * @param message
     * @param cause
     */
    public UbiveloxException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

}
