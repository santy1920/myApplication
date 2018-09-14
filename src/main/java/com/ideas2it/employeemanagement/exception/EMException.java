package com.ideas2it.employeemanagement.exception;

/**
 * EMException is a custom Exception class defined by user
 * specifically for the application designed. It is used to handle
 * multiple exceptions at the same time and avoid program being terminated.
 *
 * @author Santhosh Kumar
 */
public class EMException extends Throwable {
    
    private static int code;

    public EMException(int code) {
        super();
        this.code = code;
    }

    public EMException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public EMException(String message, Throwable cause) {
        super(message, cause);
    }
 
    public EMException(Throwable cause) {
        super(cause);
    }

    public EMException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }
	
    public int getCode() {
        return this.code;
    }
}
