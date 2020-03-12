package fr.lsi.mariage.domain.exception;

import org.springframework.http.HttpStatus;

public class MariageFonctionelleException extends MariageException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7564356787608348416L;
	
	public MariageFonctionelleException(final HttpStatus status, final String message, final String information, final Integer code) {
		this.setCode(code);
		this.setInformation(information);
		this.setMessage(message);
		this.setStatus(status);
	}

}
