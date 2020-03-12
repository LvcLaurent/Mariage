package fr.lsi.mariage.domain.entiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.lsi.mariage.domain.model.Invite;

@Entity
@Table(name="INVITE")
public class InviteEntity implements IoEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7913830450310334211L;

	/**
	 * Id unique de la personnes
	 */
	@Column(name="uuid")
	@Id
	private String codeUID;

	/**
	 * code pour l'activation au portal
	 */
	@Column(name="code_portail")
	private String codeEnregistrement;
	
	/**
	 * Nom de l'invite
	 */
	@Column(name="nom")
	private String nom;
	
	/**
	 * Prenom de l'invite
	 */
	@Column(name="prenom")
	private String prenom;
	
	/**
	 * Surnom de l'invite
	 */
	@Column(name="surnom")
	private String surnom;
	
	/**
	 * table choisie
	 */
	@Column(name="nom_table")
	private String table;
	
	/**
	 * présent au repas
	 */
	@Column(name="presenceRepas")
	private Boolean presenceRepas;
	
	
	/**
	 * présent au Vin d'honneur
	 */
	@Column(name="PresenceVin")
	private Boolean PresenceVin;
	
	/**
	 * si il est invité au repas
	 */
	@Column(name="inviteRepas")
	private Boolean inviteRepas;
	
	/**
	 * Création de l'invite
	 * 
	 * @param nom nom de l'invite
	 * @param prenom prenom de l'invite
	 */
	public InviteEntity(final String nom, final String prenom) {
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	
	/**
	 * Constructeur par defaut
	 */
	public InviteEntity() {
		super();
	}
	
	/**
	 * Constructeur depuis le DTO
	 * 
	 * @param invite le DTO
	 */
	public InviteEntity(final Invite invite) {
		this.setCodeUID(invite.getCodeUID().toString());
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
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the surnom
	 */
	public String getSurnom() {
		return surnom;
	}

	/**
	 * @param surnom the surnom to set
	 */
	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}

	/**
	 * @return the table
	 */
	public String getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(String table) {
		this.table = table;
	}

	/**
	 * @return the presenceRepas
	 */
	public Boolean getPresenceRepas() {
		return presenceRepas;
	}

	/**
	 * @param presenceRepas the presenceRepas to set
	 */
	public void setPresenceRepas(Boolean presenceRepas) {
		this.presenceRepas = presenceRepas;
	}

	/**
	 * @return the presenceVin
	 */
	public Boolean getPresenceVin() {
		return PresenceVin;
	}

	/**
	 * @param presenceVin the presenceVin to set
	 */
	public void setPresenceVin(Boolean presenceVin) {
		PresenceVin = presenceVin;
	}

	/**
	 * @return the inviteRepas
	 */
	public Boolean getInviteRepas() {
		return inviteRepas;
	}

	/**
	 * @param inviteRepas the inviteRepas to set
	 */
	public void setInviteRepas(Boolean inviteRepas) {
		this.inviteRepas = inviteRepas;
	}
	
	/**
	 * @return the codeUID
	 */
	public String getCodeUID() {
		return codeUID;
	}

	/**
	 * @param codeUID the codeUID to set
	 */
	public void setCodeUID(String codeUID) {
		this.codeUID = codeUID;
	}

	/**
	 * @return the codeEnregistrement
	 */
	public String getCodeEnregistrement() {
		return codeEnregistrement;
	}

	/**
	 * @param codeEnregistrement the codeEnregistrement to set
	 */
	public void setCodeEnregistrement(String codeEnregistrement) {
		this.codeEnregistrement = codeEnregistrement;
	}

}
