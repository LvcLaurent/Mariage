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
		this.setNom(invite.getNom());
		this.setPrenom(invite.getPrenom());
		this.setSurnom(invite.getSurnom());
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
