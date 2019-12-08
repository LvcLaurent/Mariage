package fr.lsi.mariage.entiy;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="UTILISATEUR")
public class Utilisateur {
	
	/**
	 * Id unique de l'utilisateur
	 */
	@Id
	@Column(name="I_ID")
	private String uuid;
	
	/**
	 * Nom d'utilisateur
	 */
	@Column(name="L_LOGIN")
	private String login;
	
	/**
	 * Password
	 */
	@Column(name="C_PASSWORD")
	private String password;
	
	/**
	 * Date de Création
	 */
	@Column(name="D_CREATION")
	private LocalDate dateCreation;
	
	/**
	 * Date de Modification
	 */
	@Column(name="D_MODIFICATION")
	private LocalDate dateModification;
	
	/**
	 * Date de Création
	 */
	@Column(name="D_DERNIERE_CONNEXION")
	private LocalDate dateDerniereConnexion;
	
	/**
	 * Constructeur d'un Utilisateur
	 */
	public Utilisateur() {
		super();
	}

	/**
	 * @return the uuid
	 */
	public final String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public final void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the login
	 */
	public final String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public final void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the dateCreation
	 */
	public final LocalDate getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public final void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * @return the dateModification
	 */
	public final LocalDate getDateModification() {
		return dateModification;
	}

	/**
	 * @param dateModification the dateModification to set
	 */
	public final void setDateModification(LocalDate dateModification) {
		this.dateModification = dateModification;
	}

	/**
	 * @return the dateDerniereConnexion
	 */
	public final LocalDate getDateDerniereConnexion() {
		return dateDerniereConnexion;
	}

	/**
	 * @param dateDerniereConnexion the dateDerniereConnexion to set
	 */
	public final void setDateDerniereConnexion(LocalDate dateDerniereConnexion) {
		this.dateDerniereConnexion = dateDerniereConnexion;
	}

}
