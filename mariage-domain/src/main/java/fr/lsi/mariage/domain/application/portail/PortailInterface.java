package fr.lsi.mariage.domain.application.portail;

import java.util.ArrayList;

import fr.lsi.mariage.domain.entiy.DomicileEntity;
import fr.lsi.mariage.domain.exception.MariageException;
import fr.lsi.mariage.domain.model.Domicile;

/**
 * Service pour la gestion des confirmations de présence
 * 
 * @author Laurent SION
 *
 */
public interface PortailInterface {
	
	/**
	 * Lancement des traitements pour la confirmation de présence
	 * 
	 * @param uid code unitaire de l'invité
	 * @param commentaire commentaire indiqué sur le portail
	 * @param repas présence repas
	 * @param vin présence vin d'honneur
	 * @return un texte perso si présent en base
	 * @throws MariageException Exception pendant les traitements ex : uid non connu
	 */
	String lancementConfirmation(final String uid, final String commentaire, final Boolean repas, final Boolean vin) throws MariageException;
	
	/**
	 * Pour une recherche en base de l'invité et retrouvé le domicil qui lui est afilié
	 * 
	 * @param uid
	 * @return
	 * @throws MariageException
	 */
	Domicile rechercheDomicileByCodeActivation(final String uid) throws MariageException;

	/**
	 * Validation de l'invitation
	 * 
	 * @param uid
	 * @return
	 * @throws MariageException
	 */
	String lancementInvitation(String codeActivation) throws MariageException;

	/**
	 * retourne la liste des invitations non envoyé
	 * 
	 * @return
	 * @throws MariageException
	 */
	ArrayList<DomicileEntity> oublieInvitation() throws MariageException;

	/**
	 * supprime la lettre de l'invitation
	 * 
	 * @param uid
	 * @return
	 * @throws MariageException
	 */
	String suppressionInvitation(String codeActivation) throws MariageException ;

	
	/**
	 * retourn un domicile
	 * 
	 * @param uid
	 * @return
	 * @throws MariageException
	 */
	Domicile getDomicile(String uid) throws MariageException;
	
	

}
