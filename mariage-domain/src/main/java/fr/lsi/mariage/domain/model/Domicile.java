package fr.lsi.mariage.domain.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.lsi.mariage.domain.entiy.DomicileEntity;

public class Domicile {

	/**
	 * Id unique du domicile
	 */
	private String codeUID;

	/**
	 * adresse du domicile
	 */
	private String adresse;

	/**
	 * code Postal
	 */
	private String codePostal;

	/**
	 * ville
	 */
	private String ville;

	/**
	 * Habitant du domicile
	 */
	private Invite habitant1;

	/**
	 * Habitant du domicile
	 */
	private Invite habitant2;

	/**
	 * Habitant du domicile
	 */
	private Invite habitant3;

	/**
	 * Habitant du domicile
	 */
	private Invite habitant4;

	/**
	 * Habitant du domicile
	 */
	private Invite habitant5;

	/**
	 * Constructeur par défaut
	 */
	public Domicile() {
		super();
		UUID uuid = UUID.randomUUID();
		this.setCodeUID(uuid.toString());
	}

	/**
	 * Constructeur Mapper
	 */
	public Domicile(final DomicileEntity domicile) {
		this();
		this.setAdresse(domicile.getAdresse());
		this.setCodePostal(domicile.getCodePostal());
		this.setCodeUID(domicile.getCodeUID());
		this.setVille(domicile.getVille());
		this.setHabitant1(new Invite(domicile.getHabitant1()));
		if (domicile.getHabitant2() != null) {
			this.setHabitant2(new Invite(domicile.getHabitant2()));
		}
		if (domicile.getHabitant3() != null) {
			this.setHabitant3(new Invite(domicile.getHabitant3()));
		}
		if (domicile.getHabitant4() != null) {
			this.setHabitant4(new Invite(domicile.getHabitant4()));
		}
		if (domicile.getHabitant5() != null) {
			this.setHabitant5(new Invite(domicile.getHabitant5()));
		}

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
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the habitant1
	 */
	public Invite getHabitant1() {
		return habitant1;
	}

	/**
	 * @param habitant1 the habitant1 to set
	 */
	public void setHabitant1(Invite habitant1) {
		this.habitant1 = habitant1;
	}

	/**
	 * @return the habitant2
	 */
	public Invite getHabitant2() {
		return habitant2;
	}

	/**
	 * @param habitant2 the habitant2 to set
	 */
	public void setHabitant2(Invite habitant2) {
		this.habitant2 = habitant2;
	}

	/**
	 * @return the habitant3
	 */
	public Invite getHabitant3() {
		return habitant3;
	}

	/**
	 * @param habitant3 the habitant3 to set
	 */
	public void setHabitant3(Invite habitant3) {
		this.habitant3 = habitant3;
	}

	/**
	 * @return the habitant4
	 */
	public Invite getHabitant4() {
		return habitant4;
	}

	/**
	 * @param habitant4 the habitant4 to set
	 */
	public void setHabitant4(Invite habitant4) {
		this.habitant4 = habitant4;
	}

	/**
	 * @return the habitant5
	 */
	public Invite getHabitant5() {
		return habitant5;
	}

	/**
	 * @param habitant5 the habitant5 to set
	 */
	public void setHabitant5(Invite habitant5) {
		this.habitant5 = habitant5;
	}

}
