package fr.lsi.mariage.exposition.pojo.invite;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.lsi.mariage.exposition.handler.GenericOut;

public class RequestPortailOut extends GenericOut {
	
	/**
	 * message perso
	 */
	@JsonProperty("perso")
	private String messagePerso;
	
	/**
	 * Constructeur par defaut
	 */
	public RequestPortailOut() {
		super();
	}

	/**
	 * @return the messagePerso
	 */
	public final String getMessagePerso() {
		return messagePerso;
	}

	/**
	 * @param messagePerso the messagePerso to set
	 */
	public final void setMessagePerso(String messagePerso) {
		this.messagePerso = messagePerso;
	}

	
}
