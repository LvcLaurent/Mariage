package fr.lsi.mariage.exposition.handler;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Message de retour Generique, utilisé lors de la création du message en cas de capture d'exception
 * 
 * @author Laurent SION
 *
 */
public class GenericOut {
	
	
	/**
	 * Message principal
	 */
	@JsonProperty("message")
	private String message;
	
	/**
	 * code de retour
	 */
	@JsonProperty("code")
	private Integer code;
	
	/**
	 * Message d'information
	 */
	@JsonProperty("info")
	private String information;
	
	/**
	 * Constructeur de Generic Out
	 */
	public GenericOut(final String message, final String information, final Integer code) {
		this.setCode(code);
		this.setInformation(information);
		this.setMessage(message);
	}

	/**
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public final void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public final Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public final void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the information
	 */
	public final String getInformation() {
		return information;
	}

	/**
	 * @param information the information to set
	 */
	public final void setInformation(String information) {
		this.information = information;
	}
	
	

}
