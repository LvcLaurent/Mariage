package fr.lsi.mariage.exposition.controleur.invite;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.lsi.mariage.domain.application.invite.InviteInterface;
import fr.lsi.mariage.domain.model.Domicile;
import fr.lsi.mariage.exposition.pojo.invite.RequestByUuid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("API pour la gestion des invités dans la base.")
@RestController
public class GestionInvite {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GestionInvite.class);
	
	@Autowired
	InviteInterface inviteService;
	
    @ApiOperation(value = "Vérification des adresses")
    @GetMapping(value = "/invite/check")
    public ArrayList<Domicile> checkAdresseIndispo() {
    		
 		LOGGER.info("vérification des adresses");
    	return inviteService.checkInviteSansAdresse();
    }
	
    @ApiOperation(value = "regarder la base")
    @GetMapping(value = "/invite/all")
    public ArrayList<Domicile> checkAllAdresse() {
    	
 		LOGGER.info("requète sur toute la bases");
    	return inviteService.allDomicile();
    }
	
    @ApiOperation(value = "regarder par identifiant unique")
    @PostMapping(value = "/invite/rechercheParUuid")
    public Domicile checkByUuid(@RequestBody final RequestByUuid uuid) {
    	
 		LOGGER.info("requète sur toute l'uid "+uuid.getUuid());
    	return inviteService.checkByUuid(uuid.getUuid());
    }

}
