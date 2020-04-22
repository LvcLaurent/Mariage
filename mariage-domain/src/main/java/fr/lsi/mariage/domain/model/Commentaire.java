package fr.lsi.mariage.domain.model;

import fr.lsi.mariage.domain.entiy.CommentaireEntity;

/**
 * Dto qui relis le domicile au commentaire qu'il nous a associé
 * 
 * @author Laurent SION
 *
 */

public class Commentaire {
	
	/**
	 * uuid du domicile
	 */
	private Domicile domicile;
	
	/**
	 * uuid de l'invite
	 */
	private Invite invite;
	
	/**
	 * Commentaire pendant la confirmation
	 */
	private String commentaire;
	
	/**
	 * Constructeur par defaut
	 */
	public Commentaire() {
		super();
	}
	
	/**
	 * Constructeur du DTO
	 * 
	 * @param invite
	 * @param domicile
	 * @param commentaire
	 */
	public Commentaire(final Invite invite, final Domicile domicile, final String commentaire) {
		this.setCommentaire(commentaire);
		this.setDomicile(domicile);
		this.setInvite(invite);
	}

	/**
	 * Constructeur Mappeur
	 * 
	 * @param commentaire
	 */
	public Commentaire(final CommentaireEntity commentaire) {
		this.setCommentaire(commentaire.getCommentaire());
		this.setDomicile(new Domicile(commentaire.getDomicile()));
		this.setInvite(new Invite(commentaire.getInvite()));
	}

	/**
	 * @return the domicile
	 */
	public final Domicile getDomicile() {
		return domicile;
	}

	/**
	 * @param domicile the domicile to set
	 */
	public final void setDomicile(Domicile domicile) {
		this.domicile = domicile;
	}

	/**
	 * @return the invite
	 */
	public final Invite getInvite() {
		return invite;
	}

	/**
	 * @param invite the invite to set
	 */
	public final void setInvite(Invite invite) {
		this.invite = invite;
	}

	/**
	 * @return the commentaire
	 */
	public final String getCommentaire() {
		return commentaire;
	}

	/**
	 * @param commentaire the commentaire to set
	 */
	public final void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	

}
