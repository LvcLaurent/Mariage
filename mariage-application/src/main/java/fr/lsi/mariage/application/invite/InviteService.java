package fr.lsi.mariage.application.invite;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lsi.mariage.domain.application.invite.InviteInterface;
import fr.lsi.mariage.domain.entiy.DomicileEntity;
import fr.lsi.mariage.domain.entiy.InviteEntity;
import fr.lsi.mariage.domain.exception.MariageException;
import fr.lsi.mariage.domain.model.Domicile;
import fr.lsi.mariage.domain.model.Invite;
import fr.lsi.mariage.domain.repository.InterfaceDomicileRepository;
import fr.lsi.mariage.domain.repository.InterfaceInviteRepository;

@Service
public class InviteService implements InviteInterface {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(InviteService.class);

	@Autowired
	InterfaceInviteRepository inviteRepo;

	@Autowired
	InterfaceDomicileRepository domicileRepo;

	@Override
	public String creationInvite(Domicile domicile) throws MariageException {

		LOGGER.info("Domicile créer : " + domicile.getCodeUID());

		if (domicile.getHabitant1().getInviteRepas()) {
			LOGGER.info("Invite Present au repas et au vin d'honneur");
		} else {
			LOGGER.info("Invite Present au vin d'honneur mais pas au repas");
		}

		domicileRepo.nouvelleSauvegarde(new DomicileEntity(domicile));

		return domicile.getCodeUID();
	}

	@Override
	public ArrayList<Domicile> checkInviteSansAdresse() {

		ArrayList<Domicile> result = new ArrayList<Domicile>();

		for (DomicileEntity domicile : domicileRepo.checkAdresseManquante()) {
			result.add(new Domicile(domicile));
		}

		return result;
	}

	@Override
	public String modification(Invite invite, final String code) {
		Invite aModif = new Invite(inviteRepo.getByUuid(invite.getCodeUID()));

		if ("LaurentTheBest".equals(code)) {
			aModif.setNom(invite.getNom());
			aModif.setPrenom(invite.getPrenom());
			aModif.setSurnom(invite.getSurnom());
			aModif.setTable(invite.getTable());

			try {
				inviteRepo.save(new InviteEntity(aModif));
			} catch (MariageException e) {
				return "Une erreur sur la sauvegarde en base";
			}

			return "modification effectué";
		} else {
			return "tu n'as pas le bon code";
		}

	}

	@Override
	public ArrayList<Domicile> allDomicile() {

		ArrayList<Domicile> result = new ArrayList<Domicile>();

		for (DomicileEntity domicile : domicileRepo.allDomicile()) {
			result.add(new Domicile(domicile));
		}

		return result;
	}

	@Override
	public Domicile checkByUuid(final String uuid) {

		return new Domicile(domicileRepo.getByUuid(uuid));
	}

	@Override
	public String modificationInvite(Domicile domicile) throws MariageException {
		LOGGER.info("Domicile à modifier : " + domicile.getCodeUID());

		Domicile ancien = new Domicile(domicileRepo.getByUuid(domicile.getCodeUID()));

		ancien.setAdresse(domicile.getAdresse());
		ancien.setCodePostal(domicile.getCodePostal());
		ancien.setVille(domicile.getVille());
		ancien.getHabitant1().setInviteRepas(domicile.getHabitant1().getInviteRepas());
		ancien.getHabitant1().setNom(domicile.getHabitant1().getNom());
		ancien.getHabitant1().setPrenom(domicile.getHabitant1().getPrenom());
		if (ancien.getHabitant2() != null) {
			ancien.getHabitant2().setInviteRepas(domicile.getHabitant2().getInviteRepas());
			ancien.getHabitant2().setNom(domicile.getHabitant2().getNom());
			ancien.getHabitant2().setPrenom(domicile.getHabitant2().getPrenom());
		}
		if (domicile.getHabitant2() != null) {
			ancien.setHabitant2(new Invite(ancien.getHabitant2().getNom(), ancien.getHabitant2().getPrenom(), ancien.getHabitant2().getInviteRepas()));
		}
		if (ancien.getHabitant3() != null) {
			ancien.getHabitant3().setInviteRepas(domicile.getHabitant3().getInviteRepas());
			ancien.getHabitant3().setNom(domicile.getHabitant3().getNom());
			ancien.getHabitant3().setPrenom(domicile.getHabitant3().getPrenom());
		}
		if (domicile.getHabitant3() != null) {
			ancien.setHabitant3(new Invite(ancien.getHabitant3().getNom(), ancien.getHabitant3().getPrenom(), ancien.getHabitant3().getInviteRepas()));
		}
		if (ancien.getHabitant4() != null) {
			ancien.getHabitant4().setInviteRepas(domicile.getHabitant4().getInviteRepas());
			ancien.getHabitant4().setNom(domicile.getHabitant4().getNom());
			ancien.getHabitant4().setPrenom(domicile.getHabitant4().getPrenom());
		}
		if (domicile.getHabitant4() != null) {
			ancien.setHabitant4(new Invite(ancien.getHabitant4().getNom(), ancien.getHabitant4().getPrenom(), ancien.getHabitant4().getInviteRepas()));
		}
		if (ancien.getHabitant5() != null) {
			ancien.getHabitant5().setInviteRepas(domicile.getHabitant5().getInviteRepas());
			ancien.getHabitant5().setNom(domicile.getHabitant5().getNom());
			ancien.getHabitant5().setPrenom(domicile.getHabitant5().getPrenom());
		}
		if (domicile.getHabitant5() != null) {
			ancien.setHabitant5(new Invite(ancien.getHabitant5().getNom(), ancien.getHabitant5().getPrenom(), ancien.getHabitant5().getInviteRepas()));
		}

		domicileRepo.save(new DomicileEntity(ancien));

		return domicile.getCodeUID();
	}

}
