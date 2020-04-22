package fr.lsi.mariage.exposition.pojo.invite;
/**
 * Classe de sortie du service Recherche Uid
 * 
 * @author Laurent SION
 *
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class UidRechercheOut {
	
	/**
	 * personne
	 */
	@JsonProperty("personne")
	private String personne;
	
	/**
	 * Message Perso
	 */
	@JsonProperty("message")
	private String perso;
	
	/**
	 * Si la personne est invité au repas
	 */
	@JsonProperty("repas")
	private Boolean repas;
	
	/**
	 * Constructeur
	 */
	public UidRechercheOut() {
		super();
	}

	/**
	 * @return the personne
	 */
	public final String getPersonne() {
		return personne;
	}

	/**
	 * @param personne the personne to set
	 */
	public final void setPersonne(String personne) {
		this.personne = personne;
	}

	/**
	 * @return the perso
	 */
	public final String getPerso() {
		return perso;
	}

	/**
	 * @param perso the perso to set
	 */
	public final void setPerso(String perso) {
		this.perso = perso;
	}

	/**
	 * @return the repas
	 */
	public final Boolean getRepas() {
		return repas;
	}

	/**
	 * @param repas the repas to set
	 */
	public final void setRepas(Boolean repas) {
		this.repas = repas;
	}
	
	

}
