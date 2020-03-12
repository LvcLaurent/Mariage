package fr.lsi.mariage.exposition.pojo.invite;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestByUuid {
	
	/**
	 * uuid
	 */
	@JsonProperty("uuid")
	private String uuid;
	
	/**
	 * Constructeur par default
	 */
	public RequestByUuid() {
		super();
	}

	/**
	 * @return the uuid
	 */
	public final String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public final void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	

}
