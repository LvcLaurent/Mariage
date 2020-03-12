package fr.lsi.mariage.exposition.pojo.invite;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.lsi.mariage.exposition.handler.GenericOut;

public class CreationInviteOut extends GenericOut {
	
	/**
	 * Code de l'invité en base
	 */
	@JsonProperty("uuid")
	private String codeInvite;

	/**
	 * Constructeur Du retour
	 * 
	 * @param message message de retour
	 * @param information information du retour
	 * @param code code retour
	 * @param codeInvite code de l'invite
	 */
	public CreationInviteOut(String message, String information, Integer code, String codeInvite) {
		super(message, information, code);
		this.setCodeInvite(codeInvite);
	}

	/**
	 * @return the codeInvite
	 */
	public final String getCodeInvite() {
		return codeInvite;
	}

	/**
	 * @param codeInvite the codeInvite to set
	 */
	public final void setCodeInvite(String codeInvite) {
		this.codeInvite = codeInvite;
	}
	
	

}
