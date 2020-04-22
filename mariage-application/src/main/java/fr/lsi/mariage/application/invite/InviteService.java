package fr.lsi.mariage.application.invite;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lsi.mariage.domain.application.invite.InviteInterface;
import fr.lsi.mariage.domain.entiy.DomicileEntity;
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

		if (domicile.getInviteRepas()) {
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

		if (!ancien.getReponse()) {
			ancien.setInviteRepas(domicile.getInviteRepas());
			if (ancien.getInviteRepas()) {
				ancien.setPresenceRepas(Boolean.TRUE);
				ancien.setPresenceVin(Boolean.TRUE);
			} else {
				ancien.setPresenceRepas(Boolean.FALSE);
				ancien.setPresenceVin(Boolean.TRUE);

			}
		}

		ancien.setAdresse(domicile.getAdresse());
		ancien.setCodePostal(domicile.getCodePostal());
		ancien.setVille(domicile.getVille());
		ancien.setInviteRepas(domicile.getInviteRepas());
		ancien.getHabitant1().setNom(domicile.getHabitant1().getNom());
		ancien.getHabitant1().setPrenom(domicile.getHabitant1().getPrenom());
		if (ancien.getHabitant2() != null) {
			ancien.getHabitant2().setNom(domicile.getHabitant2().getNom());
			ancien.getHabitant2().setPrenom(domicile.getHabitant2().getPrenom());
		} else if (domicile.getHabitant2() != null) {
			ancien.setHabitant2(new Invite(domicile.getHabitant2().getNom(), domicile.getHabitant2().getPrenom()));
		}
		if (ancien.getHabitant3() != null) {
			ancien.getHabitant3().setNom(domicile.getHabitant3().getNom());
			ancien.getHabitant3().setPrenom(domicile.getHabitant3().getPrenom());
		} else if (domicile.getHabitant3() != null) {
			ancien.setHabitant3(new Invite(domicile.getHabitant3().getNom(), domicile.getHabitant3().getPrenom()));
		}
		if (ancien.getHabitant4() != null) {
			ancien.getHabitant4().setNom(domicile.getHabitant4().getNom());
			ancien.getHabitant4().setPrenom(domicile.getHabitant4().getPrenom());
		} else if (domicile.getHabitant4() != null) {
			ancien.setHabitant4(new Invite(domicile.getHabitant4().getNom(), domicile.getHabitant4().getPrenom()));
		}
		if (ancien.getHabitant5() != null) {
			ancien.getHabitant5().setNom(domicile.getHabitant5().getNom());
			ancien.getHabitant5().setPrenom(domicile.getHabitant5().getPrenom());
		} else if (domicile.getHabitant5() != null) {
			ancien.setHabitant5(new Invite(domicile.getHabitant5().getNom(), domicile.getHabitant5().getPrenom()));
		}

		domicileRepo.save(new DomicileEntity(ancien));

		return domicile.getCodeUID();
	}

	@Override
	public void suppresion(String uuid) {
		domicileRepo.suppressionByUuid(uuid);

	}

}
