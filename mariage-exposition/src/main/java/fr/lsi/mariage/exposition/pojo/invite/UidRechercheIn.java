package fr.lsi.mariage.exposition.pojo.invite;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe d'entré du service Recherche Uid
 * 
 * @author Laurent SION
 *
 */
public class UidRechercheIn {
	
	/**
	 * code uid
	 */
	@JsonProperty("uid")
	private String uid;
	
	/**
	 * Constructeur
	 */
	public UidRechercheIn() {
		super();
	}

	/**
	 * @return the uid
	 */
	public final String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public final void setUid(String uid) {
		this.uid = uid;
	}
	
	

}
