package fr.lsi.mariage.domain.repository;

import fr.lsi.mariage.domain.entiy.InviteEntity;
import fr.lsi.mariage.domain.exception.MariageException;
import fr.lsi.mariage.domain.exception.MariageFonctionelleException;

/**
 * Interface pour les actions que nous effecturons en base de données
 * 
 * @author Laurent SION
 *
 */
public interface InterfaceInviteRepository {
	
	/**
	 * Récupération d'un invité par uid:
	 * 		Code d'activation sur le portail
	 * 
	 * @param uid
	 * @return
	 */
	InviteEntity getByUuid(final String uid);
	
	/**
	 * Etre sur que c'est un nouvelle invité
	 * 
	 * @param invite invité a sauvegarder
	 * @throws MariageFonctionelleException Exception du code
	 */
	void nouvelleSauvegarde(final InviteEntity invite) throws MariageFonctionelleException;
	
	/**
	 * Sauvegarde de l'entité
	 * 
	 * @param entity
	 * @return
	 * @throws MariageException
	 */
	InviteEntity save(InviteEntity entity) throws MariageException;
	
	
	
}
