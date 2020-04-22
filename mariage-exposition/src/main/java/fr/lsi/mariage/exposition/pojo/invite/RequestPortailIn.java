package fr.lsi.mariage.exposition.pojo.invite;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestPortailIn {
	
	/**
	 * message perso
	 */
	@JsonProperty("commentaire")
	private String commentaire;
	
	/**
	 * Code d'activation
	 */
	@JsonProperty("code")
	private String codeActivation;
	
	/**
	 * Présence Repas
	 */
	@JsonProperty("repas")
	private Boolean repas;
	
	/**
	 * Présence Vin
	 */
	@JsonProperty("vin")
	private Boolean vin;
	
	/**
	 * Constructeur par defaut
	 */
	public RequestPortailIn() {
		super();
	}

	/**
	 * @return the commentaire
	 */
	public final String getCommentaire() {
		return commentaire;
	}

	/**
	 * @param commentaire the commentaire to set
	 */
	public final void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	/**
	 * @return the codeActivation
	 */
	public final String getCodeActivation() {
		return codeActivation;
	}

	/**
	 * @param codeActivation the codeActivation to set
	 */
	public final void setCodeActivation(String codeActivation) {
		this.codeActivation = codeActivation;
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

	/**
	 * @return the vin
	 */
	public final Boolean getVin() {
		return vin;
	}

	/**
	 * @param vin the vin to set
	 */
	public final void setVin(Boolean vin) {
		this.vin = vin;
	}
	
	

}
