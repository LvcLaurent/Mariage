package fr.lsi.mariage.application.portail;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import fr.lsi.mariage.domain.application.portail.PortailInterface;
import fr.lsi.mariage.domain.entiy.CommentaireEntity;
import fr.lsi.mariage.domain.entiy.DomicileEntity;
import fr.lsi.mariage.domain.exception.MariageException;
import fr.lsi.mariage.domain.exception.MariageFonctionelleException;
import fr.lsi.mariage.domain.model.Commentaire;
import fr.lsi.mariage.domain.model.Domicile;
import fr.lsi.mariage.domain.repository.InterfaceCommentaireRepository;
import fr.lsi.mariage.domain.repository.InterfaceDomicileRepository;
import fr.lsi.mariage.domain.repository.InterfaceInviteRepository;

@Service
public class PortailService implements PortailInterface {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PortailService.class);
	
	@Autowired
	InterfaceInviteRepository inviteRepo;
	
	@Autowired
	InterfaceDomicileRepository domicileRepo;
	
	@Autowired
	InterfaceCommentaireRepository commentaireRepo;	

	@Override
	public String lancementConfirmation(final String uid, final String commentaire, final Boolean repas, final Boolean vin) throws MariageException {
		Domicile domicile = new Domicile(domicileRepo.rechercheParInvite(uid));
		
		domicile.setReponse(Boolean.TRUE);
		if(domicile.getInviteRepas()) {
			domicile.setPresenceRepas(repas);
			domicile.setPresenceVin(vin);
		}else {
			domicile.setPresenceVin(vin);
			if(repas) {
				LOGGER.info(domicile.getHabitant1().getNom()+" "+domicile.getHabitant1().getPrenom()+" n'arrive pas à valider sa présence REPAS");
				throw new MariageFonctionelleException(HttpStatus.CONFLICT, "Impossible de valider votre repas", "Votre code d'activation ne permet pas cette validation", Integer.valueOf(4001));
			}
		}

		Commentaire commentaireTable = new Commentaire(domicile.getHabitant1(), domicile, commentaire);
		domicileRepo.save(new DomicileEntity(domicile));
		
		commentaireRepo.nouvelleSauvegarde(new CommentaireEntity(commentaireTable));
		return "ok";
	}

	@Override
	public Domicile rechercheDomicileByCodeActivation(String uid) throws MariageException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String lancementInvitation(String codeActivation) throws MariageException {
		LOGGER.info("lancement d'une invitation");
		Domicile domicile = new Domicile(domicileRepo.rechercheParInvite(codeActivation));
		LOGGER.info("pour : "+domicile.getHabitant1().getNom()+" "+domicile.getHabitant1().getPrenom());
		domicile.setInvitationExp(Boolean.TRUE);
		
		domicileRepo.save(new DomicileEntity(domicile));
		
		return "ok";
	}

	@Override
	public ArrayList<DomicileEntity> oublieInvitation() throws MariageException {
		return domicileRepo.getOublieInvitation();
	}

	@Override
	public String suppressionInvitation(String codeActivation) throws MariageException {
		LOGGER.info("suppression d'une invitation");
		Domicile domicile = new Domicile(domicileRepo.rechercheParInvite(codeActivation));
		LOGGER.info("pour : "+domicile.getHabitant1().getNom()+" "+domicile.getHabitant1().getPrenom());
		domicile.setInvitationExp(Boolean.FALSE);
		
		domicileRepo.save(new DomicileEntity(domicile));
		
		return "ok";
	}

	@Override
	public Domicile getDomicile(String uid) throws MariageException {
		LOGGER.info("récupération d'un domicile");
		Domicile domicile = new Domicile(domicileRepo.rechercheParInvite(uid));
		return domicile;
	}

}
