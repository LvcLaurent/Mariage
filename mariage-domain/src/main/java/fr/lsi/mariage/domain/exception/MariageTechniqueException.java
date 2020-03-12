package fr.lsi.mariage.domain.exception;

import org.springframework.http.HttpStatus;

public class MariageTechniqueException extends MariageException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6055021398848919614L;
	
	public MariageTechniqueException(final HttpStatus status, final String message, final String information, final Integer code) {
		this.setCode(code);
		this.setInformation(information);
		this.setMessage(message);
		this.setStatus(status);
	}
	

}
