package com.hcl.flagpicker.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
 
/**
 * @author Dinesh P
 *RecordNotFoundException: A customized exception when no data found
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8049606894039707780L;

	public RecordNotFoundException(String exception) {
        super(exception);
    }
}