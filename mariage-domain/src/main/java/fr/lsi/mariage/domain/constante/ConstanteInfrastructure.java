package fr.lsi.mariage.domain.constante;

import org.springframework.http.HttpStatus;

public interface ConstanteInfrastructure {

	static final String MESSAGE_SAUVEGARDE_NEW_IMPOSSIBLE = "Sauvegarde impossible";
	static final String INFO_SAUVEGARDE_NEW_IMPOSSIBLE = "L'uid est déjà connu dans la base de donnée";
	static final Integer CODE_SAUVEGARDE_NEW_IMPOSSIBLE = 2001;
	static final HttpStatus STATUS_SAUVEGARDE_NEW_IMPOSSIBLE = HttpStatus.INTERNAL_SERVER_ERROR;
	
}
