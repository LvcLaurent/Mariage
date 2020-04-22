package fr.lsi.mariage.infrastructure.repository;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import fr.lsi.mariage.domain.constante.ConstanteInfrastructure;
import fr.lsi.mariage.domain.entiy.DomicileEntity;
import fr.lsi.mariage.domain.exception.MariageException;
import fr.lsi.mariage.domain.exception.MariageFonctionelleException;
import fr.lsi.mariage.domain.repository.AbstractJpaRepository;
import fr.lsi.mariage.domain.repository.InterfaceDomicileRepository;

@Repository
public class DomicileRepository extends AbstractJpaRepository<DomicileEntity> implements InterfaceDomicileRepository{
	
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DomicileRepository.class);

	@Override
	@Transactional
	public DomicileEntity getByUuid(String uid) {
		String hql = "from DomicileEntity d "
				+ "where d.codeUID = '"+uid+"'";
		try {
			LOGGER.info("Recherche si uid est en base");
			DomicileEntity result = (DomicileEntity) em.createQuery(hql).getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	@Transactional
	public void nouvelleSauvegarde(DomicileEntity domicile) throws MariageException {
		if (isNew(domicile)) {
			LOGGER.info("Sauvegarde de "+domicile.getCodeUID()+" en base");
            em.persist(domicile);
        } else {
        	throw new MariageFonctionelleException(ConstanteInfrastructure.STATUS_SAUVEGARDE_NEW_IMPOSSIBLE, 
        			ConstanteInfrastructure.MESSAGE_SAUVEGARDE_NEW_IMPOSSIBLE,
        			ConstanteInfrastructure.INFO_SAUVEGARDE_NEW_IMPOSSIBLE,
        			ConstanteInfrastructure.CODE_SAUVEGARDE_NEW_IMPOSSIBLE);
        }
		
	}

	@Override
	@Transactional
	public ArrayList<DomicileEntity> checkAdresseManquante() {
		String hql = "from DomicileEntity d "
				+ "where d.adresse is null";
		try {
			LOGGER.info("Recherche des lignes sans Adresse");
			ArrayList<DomicileEntity> result = (ArrayList<DomicileEntity>) em.createQuery(hql).getResultList();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	protected Class<DomicileEntity> getEntityClass() {
		return DomicileEntity.class;
	}

	@Override
	@Transactional
	public boolean isNew(DomicileEntity entity) throws MariageException {
		if(getByUuid(entity.getCodeUID()) == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<DomicileEntity> allDomicile() {
		String hql = "from DomicileEntity d ";
		try {
			LOGGER.info("requète sur tout la base");
			ArrayList<DomicileEntity> result = (ArrayList<DomicileEntity>) em.createQuery(hql).getResultList();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional
	@Override
    public DomicileEntity save(DomicileEntity entity) throws MariageException {
        if (isNew(entity)) {
        	LOGGER.info("persist");
            em.persist(entity);
            return entity;
        } else if (!em.contains(entity)) {
        	LOGGER.info("merge");
            return em.merge(entity);
        }

        return entity;
    }

	@Override
	@Transactional
	public void suppressionByUuid(String uuid) {
		DomicileEntity entity = this.getByUuid(uuid);
		LOGGER.info("supression du domicile");
		this.delete(entity);
		
	}

	@Override
	public DomicileEntity rechercheParInvite(final String uidPortail) throws MariageException {
		String hql = "from DomicileEntity d "
				+ "where d.habitant1.codeEnregistrement = '"+uidPortail+"'";
		try {
			LOGGER.info("Recherche si le code portail est en base");
			DomicileEntity result = (DomicileEntity) em.createQuery(hql).getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public ArrayList<DomicileEntity> getOublieInvitation() throws MariageException {
		String hql = "from DomicileEntity d "
				+ "where d.invitationExp=false";
		try {
			LOGGER.info("Recherche des adresses sans validation");
			ArrayList<DomicileEntity> result = (ArrayList<DomicileEntity>) em.createQuery(hql).getResultList();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

}
