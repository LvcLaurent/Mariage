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
	 * table choisie
	 */
	private String table;
	
	/**
	 * présent au repas
	 */
	private Boolean presenceRepas;
	
	
	/**
	 * présent au Vin d'honneur
	 */
	private Boolean PresenceVin;
	
	/**
	 * si il est invité au repas
	 */
	private Boolean inviteRepas;
	
	/**
	 * Création de l'invite
	 * 
	 * @param nom nom de l'invite
	 * @param prenom prenom de l'invite
	 * @param inviteRepas vrai pour le cas ou il est invité
	 */
	public Invite(final String nom, final String prenom, final boolean inviteRepas) {
		UUID uuid = UUID.randomUUID();
		this.setCodeUID(uuid.toString());
		this.setCodeEnregistrement(uuid.toString().substring(0, 7));
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setInviteRepas(inviteRepas);
		
		if(inviteRepas) {
			this.setPresenceVin(Boolean.TRUE);
			this.setPresenceRepas(Boolean.TRUE);
		} else {
			this.setPresenceVin(Boolean.TRUE);
			this.setPresenceRepas(Boolean.FALSE);
		}
	}
	
	public Invite(final InviteEntity invite) {
		this.setCodeUID(invite.getCodeUID());
		this.setInviteRepas(invite.getInviteRepas());
		this.setNom(invite.getNom());
		this.setPrenom(invite.getPrenom());
		this.setPresenceRepas(invite.getPresenceRepas());
		this.setPresenceVin(invite.getPresenceVin());
		this.setSurnom(invite.getSurnom());
		this.setTable(invite.getTable());
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
	 * @return the table
	 */
	public final String getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public final void setTable(String table) {
		this.table = table;
	}

	/**
	 * @return the presenceRepas
	 */
	public final Boolean getPresenceRepas() {
		return presenceRepas;
	}

	/**
	 * @param presenceRepas the presenceRepas to set
	 */
	public final void setPresenceRepas(Boolean presenceRepas) {
		this.presenceRepas = presenceRepas;
	}

	/**
	 * @return the presenceVin
	 */
	public final Boolean getPresenceVin() {
		return PresenceVin;
	}

	/**
	 * @param presenceVin the presenceVin to set
	 */
	public final void setPresenceVin(Boolean presenceVin) {
		PresenceVin = presenceVin;
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
