package fr.lsi.mariage.domain.application.invite;

import java.util.ArrayList;

import fr.lsi.mariage.domain.exception.MariageException;
import fr.lsi.mariage.domain.model.Domicile;
import fr.lsi.mariage.domain.model.Invite;

/**
 * Création d'un interface
 * 
 * @author Laurent SION
 *
 */
public interface InviteInterface {
	
	/**
	 * Création d'un invité on récupère le code de l'invite
	 * 
	 * @param invite l'invité qu'on enregistre
	 * @return le code créer 
	 * @throws MariageException 
	 */
	String creationInvite(final Domicile domicile) throws MariageException;
	
	/**
	 * Retourne les invités sans adresse
	 * 
	 * @return
	 */
	ArrayList<Domicile> checkInviteSansAdresse();
	
	/**
	 * Modification d'un invité
	 * 
	 * @param invite invite temporaire pour récupérer les informations
	 * @param code le code d'autorisation
	 * @return
	 */
	String modification(final Invite invite, final String code);
	

	
	/**
	 * Retourne tout les invités
	 * 
	 * @return
	 */
	ArrayList<Domicile> allDomicile();

	/**
	 * Recherche par identifiant
	 * 
	 * @return
	 */
	Domicile checkByUuid(final String uuid);

	/**
	 * Modification d'un invité on récupère le code de l'invite
	 * 
	 * @param invite l'invité qu'on enregistre
	 * @return le code créer 
	 * @throws MariageException 
	 */
	String modificationInvite(final Domicile domicile) throws MariageException;

}