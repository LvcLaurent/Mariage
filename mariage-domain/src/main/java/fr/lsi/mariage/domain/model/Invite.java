package fr.lsi.mariage.domain.model;

import java.util.UUID;

import fr.lsi.mariage.domain.entiy.InviteEntity;

public class Invite {

	/**
	 * Id unique de la personnes
	 */
	private String codeUID;

	/**
	 * code pour l'activation au portal
	 */
	private String codeEnregistrement;
	
	/**
	 * Nom de l'invite
	 */
	private String nom;
	
	/**
	 * Prenom de l'invite
	 */
	private String prenom;
	
	/**
	 * Surnom de l'invite
	 */
	private String surnom;
	
	/**
	 * Création de l'invite
	 * 
	 * @param nom nom de l'invite
	 * @param prenom prenom de l'invite
	 * @param inviteRepas vrai pour le cas ou il est invité
	 */
	public Invite(final String nom, final String prenom) {
		UUID uuid = UUID.randomUUID();
		this.setCodeUID(uuid.toString());
		this.setCodeEnregistrement(uuid.toString().substring(0, 7));
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	
	public Invite(final InviteEntity invite) {
		this.setCodeUID(invite.getCodeUID());
		this.setNom(invite.getNom());
		this.setPrenom(invite.getPrenom());
		this.setSurnom(invite.getSurnom());
		this.setCodeEnregistrement(invite.getCodeEnregistrement());
	}

	/**
	 * @return the nom
	 */
	public final String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public final void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public final String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public final void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the surnom
	 */
	public final String getSurnom() {
		return surnom;
	}

	/**
	 * @param surnom the surnom to set
	 */
	public final void setSurnom(String surnom) {
		this.surnom = surnom;
	}
	
	/**
	 * @return the codeUID
	 */
	public final String getCodeUID() {
		return codeUID;
	}

	/**
	 * @param codeUID the codeUID to set
	 */
	public final void setCodeUID(String codeUID) {
		this.codeUID = codeUID;
	}

	/**
	 * @return the codeEnregistrement
	 */
	public final String getCodeEnregistrement() {
		return codeEnregistrement;
	}

	/**
	 * @param codeEnregistrement the codeEnregistrement to set
	 */
	public final void setCodeEnregistrement(String codeEnregistrement) {
		this.codeEnregistrement = codeEnregistrement;
	}
	
	

}
