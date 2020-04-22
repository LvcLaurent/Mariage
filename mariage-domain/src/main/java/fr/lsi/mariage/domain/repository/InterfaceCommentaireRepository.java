package fr.lsi.mariage.domain.repository;

import fr.lsi.mariage.domain.entiy.CommentaireEntity;
import fr.lsi.mariage.domain.exception.MariageException;

/**
 * Interface pour les actions que nous effecturons en base de données
 * 
 * @author Laurent SION
 *
 */
public interface InterfaceCommentaireRepository {
	
	/**
	 * Etre sur que c'est un nouveau domicile
	 * 
	 * @param invite invité a sauvegarder
	 * @throws MariageException Exception du code
	 */
	void nouvelleSauvegarde(final CommentaireEntity commentaire) throws MariageException;
	
	/**
	 * Remonte le commentaire par l'uid de l'invite
	 * 
	 * @param uuid
	 * @return
	 */
	CommentaireEntity getByInvite (final String uuid);

}
