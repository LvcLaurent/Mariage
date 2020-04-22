package fr.lsi.mariage.exposition.controleur.invite;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lsi.mariage.domain.application.portail.PortailInterface;
import fr.lsi.mariage.domain.entiy.DomicileEntity;
import fr.lsi.mariage.domain.exception.MariageException;
import fr.lsi.mariage.domain.model.Domicile;
import fr.lsi.mariage.exposition.pojo.invite.RequestPortailIn;
import fr.lsi.mariage.exposition.pojo.invite.RequestPortailOut;
import fr.lsi.mariage.exposition.pojo.invite.UidRechercheIn;
import fr.lsi.mariage.exposition.pojo.invite.UidRechercheOut;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Point d'entrée du portail
 * 
 * @author Laurent SION
 *
 */
@Api("API pour la gestion du portail d'activation.")
@RestController
public class GestionPortail {
	
private static final Logger LOGGER = LoggerFactory.getLogger(GestionPortail.class);
	
	@Autowired
	PortailInterface portailService;
	
    @ApiOperation(value = "Enregistrement du portail")
    @PostMapping(value = "/portail/save")
    public RequestPortailOut confirmationPresence(@RequestBody final RequestPortailIn request) throws MariageException {
    	LOGGER.info("confirmation en cours");
    	
    	RequestPortailOut reponse = new RequestPortailOut();
    	reponse.setCode(Integer.valueOf(200));
    	reponse.setInformation("validation ok");
    	reponse.setMessage(portailService.lancementConfirmation(request.getCodeActivation(), request.getCommentaire(), request.getRepas(), request.getVin()));
    	
    	return reponse;
    }
	
    @ApiOperation(value = "Pour confirmer qu'une invitation est imprimé")
    @PostMapping(value = "/confirmation/invitation")
    public RequestPortailOut confirmationInvitation(@RequestBody final RequestPortailIn request) throws MariageException {
    	LOGGER.info("confirmation en cours");
    	
    	RequestPortailOut reponse = new RequestPortailOut();
    	reponse.setCode(Integer.valueOf(200));
    	reponse.setInformation("validation ok");
    	reponse.setMessage(portailService.lancementInvitation(request.getCodeActivation()));
    	
    	return reponse;
    }
	
    @ApiOperation(value = "Pour supprimer qu'une invitation est imprimé")
    @PostMapping(value = "/suppression/invitation")
    public RequestPortailOut suppressionInvitation(@RequestBody final RequestPortailIn request) throws MariageException {
    	LOGGER.info("confirmation en cours");
    	
    	RequestPortailOut reponse = new RequestPortailOut();
    	reponse.setCode(Integer.valueOf(200));
    	reponse.setInformation("validation ok");
    	reponse.setMessage(portailService.suppressionInvitation(request.getCodeActivation()));
    	
    	return reponse;
    }
	
    @ApiOperation(value = "Liste des invité oublié")
    @PostMapping(value = "/oublie/invitation")
    public ArrayList<DomicileEntity> oublieInvitation() throws MariageException {
    	LOGGER.info("confirmation en cours");
    	return portailService.oublieInvitation();
    }
	
    @ApiOperation(value = "Savoir si la personne est invité au Repas")
    @PostMapping(value = "/cherche/uuid")
    public UidRechercheOut rechercheUuid(@RequestBody final UidRechercheIn request) throws MariageException {
    	LOGGER.info("recherche uuid en cours");
    	
    	Domicile domicile = portailService.getDomicile(request.getUid());
    	   	
    	UidRechercheOut reponse = new UidRechercheOut();
    	reponse.setRepas(domicile.getInviteRepas());
    	reponse.setPersonne(this.getPersonne(domicile));
    	reponse.setPerso(domicile.getPerso());
    	
    	
    	return reponse;
    }
    
    private String getPersonne(final Domicile domicile) {
    	StringBuilder sb = new StringBuilder();
    	
    	if(domicile.getHabitant2() == null) {
    		sb.append("Invitation pour ");
    		sb.append(domicile.getHabitant1().getPrenom());
    		sb.append(" ");
    		sb.append(domicile.getHabitant1().getNom());
    	}else {
    		if(domicile.getHabitant1().getNom().equals(domicile.getHabitant2().getNom())) {
    			sb.append("Invitation pour ");
        		sb.append(domicile.getHabitant1().getPrenom());
        		sb.append(" & ");
        		sb.append(domicile.getHabitant2().getPrenom());
        		sb.append(" ");
        		sb.append(domicile.getHabitant1().getNom());
    		}else {
    			sb.append("Invitation pour ");
        		sb.append(domicile.getHabitant1().getPrenom());
        		sb.append(" ");
        		sb.append(domicile.getHabitant1().getNom());
        		sb.append(" & ");
        		sb.append(domicile.getHabitant2().getPrenom());
        		sb.append(" ");
        		sb.append(domicile.getHabitant2().getNom());
    			
    		}
    	}
    	
    	
    	return sb.toString();
    }

}
