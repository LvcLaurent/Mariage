package fr.lsi.mariage.exposition.pojo.invite;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objet attendu pour créer un user
 * 
 * @author Laurent SION
 *
 */
public class CreationInviteIn {
	
	/**
	 * Nom de l'invité
	 */
	@JsonProperty("nom_un")
	private String nom1;
	
	/**
	 * Prenom de l'invité
	 */
	@JsonProperty("prenom_un")
	private String prenom1;
	
	/**
	 * Nom de l'invité 2
	 */
	@JsonProperty("nom_deux")
	private String nom2;
	
	/**
	 * Prenom de l'invité 2
	 */
	@JsonProperty("prenom_deux")
	private String prenom2;
	
	/**
	 * Nom de l'invité 3
	 */
	@JsonProperty("nom_trois")
	private String nom3;
	
	/**
	 * Prenom de l'invité 3
	 */
	@JsonProperty("prenom_trois")
	private String prenom3;
	
	/**
	 * Nom de l'invité 4
	 */
	@JsonProperty("nom_quatre")
	private String nom4;
	
	/**
	 * Prenom de l'invité 4
	 */
	@JsonProperty("prenom_quatre")
	private String prenom4;
	
	/**
	 * Nom de l'invité 
	 */
	@JsonProperty("nom_cinq")
	private String nom5;
	
	/**
	 * Prenom de l'invité 5
	 */
	@JsonProperty("prenom_cinq")
	private String prenom5;
	
	/**
	 * Prenom de l'invité 5
	 */
	@JsonProperty("adresse")
	private String adresse;
	
	/**
	 * Prenom de l'invité 5
	 */
	@JsonProperty("code_postal")
	private String codePostal;
	
	/**
	 * Prenom de l'invité 5
	 */
	@JsonProperty("ville")
	private String ville;
	
	/**
	 * Si la personne est invité au repas
	 */
	@JsonProperty("invite_repas")
	private Boolean inviteRepas;
	
	/**
	 * constructeur
	 */
	public CreationInviteIn() {
		super();
	}

	

	/**
	 * @return the inviteRepas
	 */
	public final Boolean getInviteRepas() {
		return inviteRepas;
	}

	/**
	 * @param inviteRepas the inviteRepas to set
	 */
	public final void setInviteRepas(Boolean inviteRepas) {
		this.inviteRepas = inviteRepas;
	}



	/**
	 * @return the nom1
	 */
	public final String getNom1() {
		return nom1;
	}



	/**
	 * @param nom1 the nom1 to set
	 */
	public final void setNom1(String nom1) {
		this.nom1 = nom1;
	}



	/**
	 * @return the prenom1
	 */
	public final String getPrenom1() {
		return prenom1;
	}



	/**
	 * @param prenom1 the prenom1 to set
	 */
	public final void setPrenom1(String prenom1) {
		this.prenom1 = prenom1;
	}



	/**
	 * @return the nom2
	 */
	public final String getNom2() {
		return nom2;
	}



	/**
	 * @param nom2 the nom2 to set
	 */
	public final void setNom2(String nom2) {
		this.nom2 = nom2;
	}



	/**
	 * @return the prenom2
	 */
	public final String getPrenom2() {
		return prenom2;
	}



	/**
	 * @param prenom2 the prenom2 to set
	 */
	public final void setPrenom2(String prenom2) {
		this.prenom2 = prenom2;
	}



	/**
	 * @return the nom3
	 */
	public final String getNom3() {
		return nom3;
	}



	/**
	 * @param nom3 the nom3 to set
	 */
	public final void setNom3(String nom3) {
		this.nom3 = nom3;
	}



	/**
	 * @return the prenom3
	 */
	public final String getPrenom3() {
		return prenom3;
	}



	/**
	 * @param prenom3 the prenom3 to set
	 */
	public final void setPrenom3(String prenom3) {
		this.prenom3 = prenom3;
	}



	/**
	 * @return the nom4
	 */
	public final String getNom4() {
		return nom4;
	}



	/**
	 * @param nom4 the nom4 to set
	 */
	public final void setNom4(String nom4) {
		this.nom4 = nom4;
	}



	/**
	 * @return the prenom4
	 */
	public final String getPrenom4() {
		return prenom4;
	}



	/**
	 * @param prenom4 the prenom4 to set
	 */
	public final void setPrenom4(String prenom4) {
		this.prenom4 = prenom4;
	}



	/**
	 * @return the nom5
	 */
	public final String getNom5() {
		return nom5;
	}



	/**
	 * @param nom5 the nom5 to set
	 */
	public final void setNom5(String nom5) {
		this.nom5 = nom5;
	}



	/**
	 * @return the prenom5
	 */
	public final String getPrenom5() {
		return prenom5;
	}



	/**
	 * @param prenom5 the prenom5 to set
	 */
	public final void setPrenom5(String prenom5) {
		this.prenom5 = prenom5;
	}



	/**
	 * @return the adresse
	 */
	public final String getAdresse() {
		return adresse;
	}



	/**
	 * @param adresse the adresse to set
	 */
	public final void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	/**
	 * @return the codePostal
	 */
	public final String getCodePostal() {
		return codePostal;
	}



	/**
	 * @param codePostal the codePostal to set
	 */
	public final void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}



	/**
	 * @return the ville
	 */
	public final String getVille() {
		return ville;
	}



	/**
	 * @param ville the ville to set
	 */
	public final void setVille(String ville) {
		this.ville = ville;
	}
	
	

}
