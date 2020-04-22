package fr.lsi.mariage.infrastructure.repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.lsi.mariage.domain.constante.ConstanteInfrastructure;
import fr.lsi.mariage.domain.entiy.CommentaireEntity;
import fr.lsi.mariage.domain.exception.MariageException;
import fr.lsi.mariage.domain.exception.MariageFonctionelleException;
import fr.lsi.mariage.domain.repository.AbstractJpaRepository;
import fr.lsi.mariage.domain.repository.InterfaceCommentaireRepository;

@Repository
public class CommentaireRepository extends AbstractJpaRepository<CommentaireEntity> implements InterfaceCommentaireRepository {
	
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentaireRepository.class);

	@Override
	@Transactional
	public void nouvelleSauvegarde(final CommentaireEntity commentaire) throws MariageException {
		if (isNew(commentaire)) {
			LOGGER.info("Sauvegarde du commentaire en base");
            em.persist(commentaire);
        } else {
        	throw new MariageFonctionelleException(ConstanteInfrastructure.STATUS_SAUVEGARDE_NEW_IMPOSSIBLE, 
        			ConstanteInfrastructure.MESSAGE_SAUVEGARDE_NEW_IMPOSSIBLE,
        			ConstanteInfrastructure.INFO_SAUVEGARDE_NEW_IMPOSSIBLE,
        			ConstanteInfrastructure.CODE_SAUVEGARDE_NEW_IMPOSSIBLE);
        }
		
	}

	@Override
	protected Class<CommentaireEntity> getEntityClass() {
		return CommentaireEntity.class;
	}

	@Override
	@Transactional
	public boolean isNew(CommentaireEntity entity) throws MariageException {
		if(getByInvite(entity.getInvite().getCodeUID()) == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public CommentaireEntity getByInvite(String uuid) {
		String hql = "from CommentaireEntity c "
				+ "where c.invite.codeUID = '"+uuid+"'";
		try {
			LOGGER.info("Recherche du commentaire par l'invité");
			CommentaireEntity result = (CommentaireEntity) em.createQuery(hql).getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

}
