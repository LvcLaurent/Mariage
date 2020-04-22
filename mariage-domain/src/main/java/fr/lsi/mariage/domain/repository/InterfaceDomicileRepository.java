package fr.lsi.mariage.domain.repository;

import java.util.ArrayList;

import fr.lsi.mariage.domain.entiy.DomicileEntity;
import fr.lsi.mariage.domain.entiy.InviteEntity;
import fr.lsi.mariage.domain.exception.MariageException;

/**
 * Interface pour les actions que nous effecturons en base de données
 * 
 * @author Laurent SION
 *
 */
public interface InterfaceDomicileRepository {
	
	/**
	 * Récupération d'un domicile par uid:
	 * 		Code d'activation sur le portail
	 * 
	 * @param uid
	 * @return
	 */
	DomicileEntity getByUuid(final String uid);
	
	/**
	 * Etre sur que c'est un nouveau domicile
	 * 
	 * @param invite invité a sauvegarder
	 * @throws MariageException Exception du code
	 */
	void nouvelleSauvegarde(final DomicileEntity domicile) throws MariageException;

	
	/**
	 * Remonte les domiciles sans adresse
	 *
	 * @return
	 */
	ArrayList<DomicileEntity> checkAdresseManquante();
	
	/**
	 * Sauvegarde de l'entité
	 * 
	 * @param entity
	 * @return
	 * @throws MariageException
	 */
	DomicileEntity save(DomicileEntity entity) throws MariageException;
	
	/**
	 * Retourne tout les invités
	 * 
	 * @return
	 */
	ArrayList<DomicileEntity> allDomicile();

	/**
	 * supression d'un groupe d'invité
	 * 
	 * @param uuid
	 */
	void suppressionByUuid(final String uuid);
	
	/**
	 * Recherche Domicile via l'invité numéro 1
	 * 
	 * @param uidPortail
	 * @return
	 * @throws MariageException
	 */
	DomicileEntity rechercheParInvite(final String uidPortail) throws MariageException;


	
	/**
	 * Recherche Domicile via l'invité numéro 1
	 * 
	 * @return
	 * @throws MariageException
	 */
	ArrayList<DomicileEntity> getOublieInvitation() throws MariageException;

}
