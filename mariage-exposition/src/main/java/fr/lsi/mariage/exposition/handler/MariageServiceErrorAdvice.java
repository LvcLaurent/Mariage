package fr.lsi.mariage.exposition.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import fr.lsi.mariage.domain.exception.MariageException;

/**
 * Classe permettant la capture des exceptions avant l'envoi de la réponse
 * 
 * @author Laurent SION
 *
 */
@ControllerAdvice
public class MariageServiceErrorAdvice {
	
	
	@ExceptionHandler({MariageException.class})
    public ResponseEntity<GenericOut> handleRunTimeException(MariageException e) {
        return error(e);
    }
	
	
	//@ExceptionHandler({Exception.class})
    public ResponseEntity<GenericOut> handleRunTimeException(Exception e) {
        return error(e);
    }

	private ResponseEntity<GenericOut> error(MariageException e) {
        return ResponseEntity.status(e.getStatus()).body(new GenericOut(e.getMessage(), e.getInformation(), e.getCode()));
    }

	private ResponseEntity<GenericOut> error(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericOut("Erreur Système", "Veuillez contactez l'admin", Integer.valueOf(500)));
    }


}
