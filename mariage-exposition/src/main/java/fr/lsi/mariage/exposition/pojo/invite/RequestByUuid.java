package fr.lsi.mariage.exposition.pojo.invite;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestByUuid {
	
	/**
	 * uuid
	 */
	@JsonProperty("uuid")
	private String uuid;
	
	/**
	 * admin
	 */
	@JsonProperty("admin")
	private String admin;
	
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

	/**
	 * @return the admin
	 */
	public final String getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public final void setAdmin(String admin) {
		this.admin = admin;
	}
	
	

}
