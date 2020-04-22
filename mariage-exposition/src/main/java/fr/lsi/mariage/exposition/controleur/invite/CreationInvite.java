package fr.lsi.mariage.exposition.controleur.invite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lsi.mariage.domain.application.invite.InviteInterface;
import fr.lsi.mariage.domain.exception.MariageException;
import fr.lsi.mariage.domain.exception.MariageFonctionelleException;
import fr.lsi.mariage.domain.model.Domicile;
import fr.lsi.mariage.domain.model.Invite;
import fr.lsi.mariage.exposition.pojo.invite.CreationInviteIn;
import fr.lsi.mariage.exposition.pojo.invite.CreationInviteOut;
import fr.lsi.mariage.exposition.pojo.invite.ModificationInviteIn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("API pour la création des groupes d'invité.")
@RestController
public class CreationInvite {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreationInvite.class);

	@Autowired
	InviteInterface inviteService;

	@ApiOperation(value = "Ajout d'un groupe")
	@PostMapping(value = "/invite/creation")
	public CreationInviteOut creation(@RequestBody final CreationInviteIn request) throws MariageException {
		if(!"tulipe62".equals(request.getCodeAdmin())) {
			LOGGER.warn("Code admin NOK : "+request.getCodeAdmin());
			throw new MariageFonctionelleException(HttpStatus.FORBIDDEN, "Code faux", "Faite une demande à l'admin", Integer.valueOf(2002));
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Création de l'invite ");
		sb.append(request.getNom1());
		sb.append(" ");
		sb.append(request.getPrenom1());
		if (request.getPrenom2() != null && !(request.getPrenom2().isEmpty())) {
			sb.append(" et sa famille.");
		}
		LOGGER.info(sb.toString());

		CreationInviteOut reponse = new CreationInviteOut("Invite Crée", "", Integer.valueOf(2000), inviteService
				.creationInvite(this.createDomicile(request)));

		return reponse;
	}
	
	@ApiOperation(value = "modification d'un ligne en base")
    @PostMapping(value = "/invite/modification")
    public CreationInviteOut modification(@RequestBody final ModificationInviteIn request) throws MariageException {
		if(!"tulipe62".equals(request.getCodeAdmin())) {
			LOGGER.warn("Code admin NOK : "+request.getCodeAdmin());
			throw new MariageFonctionelleException(HttpStatus.FORBIDDEN, "Code faux", "Faite une demande à l'admin", Integer.valueOf(2003));
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Mise a jour de l'invite ");
		sb.append(request.getNom1());
		sb.append(" ");
		sb.append(request.getPrenom1());
		if (request.getPrenom2() != null && !(request.getPrenom2().isEmpty())) {
			sb.append(" et sa famille.");
		}
		LOGGER.info(sb.toString());

		CreationInviteOut reponse = new CreationInviteOut("Invite Crée", "", Integer.valueOf(2000), inviteService
				.modificationInvite(this.createDomicile(request)));

		return reponse;
    }

	private Domicile createDomicile(final CreationInviteIn req) {
		Domicile dom = new Domicile();
		
		dom.setAdresse(req.getAdresse());
		dom.setCodePostal(req.getCodePostal());
		dom.setVille(req.getVille());
		dom.setInviteRepas(req.getInviteRepas());
		dom.setReponse(Boolean.FALSE);
		if(dom.getInviteRepas()) {
			dom.setPresenceRepas(Boolean.TRUE);
			dom.setPresenceVin(Boolean.TRUE);
		} else {
			dom.setPresenceRepas(Boolean.FALSE);
			dom.setPresenceVin(Boolean.TRUE);
			
		}

		Invite inv1 = new Invite(req.getNom1(), req.getPrenom1());
		dom.setHabitant1(inv1);
		if (req.getPrenom2() != null && !(req.getPrenom2().isEmpty()) && req.getNom2() != null
				&& !(req.getNom2().isEmpty())) {
			Invite inv2 = new Invite(req.getNom2(), req.getPrenom2());
			dom.setHabitant2(inv2);
		}
		if (req.getPrenom3() != null && !(req.getPrenom3().isEmpty()) && req.getNom3() != null
				&& !(req.getNom3().isEmpty())) {
			Invite inv3 = new Invite(req.getNom3(), req.getPrenom3());
			dom.setHabitant3(inv3);
		}
		if (req.getPrenom4() != null && !(req.getPrenom4().isEmpty()) && req.getNom4() != null
				&& !(req.getNom4().isEmpty())) {
			Invite inv4 = new Invite(req.getNom4(), req.getPrenom4());
			dom.setHabitant4(inv4);
		}
		if (req.getPrenom5() != null && !(req.getPrenom5().isEmpty()) && req.getNom5() != null
				&& !(req.getNom5().isEmpty())) {
			Invite inv5 = new Invite(req.getNom5(), req.getPrenom5());
			dom.setHabitant5(inv5);
		}
		

		return dom;
	}
	private Domicile createDomicile(final ModificationInviteIn req) {
		Domicile dom = new Domicile();
		
		dom.setCodeUID(req.getUuid());
		dom.setAdresse(req.getAdresse());
		dom.setCodePostal(req.getCodePostal());
		dom.setVille(req.getVille());
		dom.setInviteRepas(req.getInviteRepas());

		Invite inv1 = new Invite(req.getNom1(), req.getPrenom1());
		dom.setHabitant1(inv1);
		if (req.getPrenom2() != null && !(req.getPrenom2().isEmpty()) && req.getNom2() != null
				&& !(req.getNom2().isEmpty())) {
			Invite inv2 = new Invite(req.getNom2(), req.getPrenom2());
			dom.setHabitant2(inv2);
		}
		if (req.getPrenom3() != null && !(req.getPrenom3().isEmpty()) && req.getNom3() != null
				&& !(req.getNom3().isEmpty())) {
			Invite inv3 = new Invite(req.getNom3(), req.getPrenom3());
			dom.setHabitant3(inv3);
		}
		if (req.getPrenom4() != null && !(req.getPrenom4().isEmpty()) && req.getNom4() != null
				&& !(req.getNom4().isEmpty())) {
			Invite inv4 = new Invite(req.getNom4(), req.getPrenom4());
			dom.setHabitant4(inv4);
		}
		if (req.getPrenom5() != null && !(req.getPrenom5().isEmpty()) && req.getNom5() != null
				&& !(req.getNom5().isEmpty())) {
			Invite inv5 = new Invite(req.getNom5(), req.getPrenom5());
			dom.setHabitant5(inv5);
		}
		

		return dom;
	}

}
