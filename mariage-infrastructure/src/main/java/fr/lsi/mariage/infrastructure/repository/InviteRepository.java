package fr.lsi.mariage.infrastructure.repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.lsi.mariage.domain.constante.ConstanteInfrastructure;

import fr.lsi.mariage.domain.entiy.InviteEntity;
import fr.lsi.mariage.domain.exception.MariageFonctionelleException;
import fr.lsi.mariage.domain.repository.AbstractJpaRepository;
import fr.lsi.mariage.domain.repository.InterfaceInviteRepository;

@Repository
public class InviteRepository extends AbstractJpaRepository<InviteEntity> implements InterfaceInviteRepository{
	
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(InviteRepository.class);

	@Override
	protected Class<InviteEntity> getEntityClass() {
		return InviteEntity.class;
	}

	@Override
	@Transactional
	public boolean isNew(final InviteEntity entity) {
		if(getByUuid(entity.getCodeUID()) == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public InviteEntity getByUuid(final String uid) {
		String hql = "from InviteEntity i "
				+ "where i.codeUID = '"+uid+"'";
		try {
			LOGGER.info("Recherche si uid est en base");
			InviteEntity result = (InviteEntity) em.createQuery(hql).getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	@Transactional
	public void nouvelleSauvegarde(InviteEntity invite) throws MariageFonctionelleException {
		if (isNew(invite)) {
			LOGGER.info("Sauvegarde de "+invite.getNom()+" "+invite.getPrenom()+ " en base");
            em.persist(invite);
        } else {
        	throw new MariageFonctionelleException(ConstanteInfrastructure.STATUS_SAUVEGARDE_NEW_IMPOSSIBLE, 
        			ConstanteInfrastructure.MESSAGE_SAUVEGARDE_NEW_IMPOSSIBLE,
        			ConstanteInfrastructure.INFO_SAUVEGARDE_NEW_IMPOSSIBLE,
        			ConstanteInfrastructure.CODE_SAUVEGARDE_NEW_IMPOSSIBLE);
        }

		
	}

}
