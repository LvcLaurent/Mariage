package fr.lsi.mariage.domain.repository;

import java.util.ArrayList;

import fr.lsi.mariage.domain.entiy.DomicileEntity;
import fr.lsi.mariage.domain.exception.MariageException;
import fr.lsi.mariage.domain.exception.MariageFonctionelleException;
import fr.lsi.mariage.domain.model.Domicile;

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

}
