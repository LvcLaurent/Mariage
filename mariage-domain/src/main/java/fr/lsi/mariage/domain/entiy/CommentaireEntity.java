package fr.lsi.mariage.domain.entiy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.lsi.mariage.domain.model.Commentaire;
import fr.lsi.mariage.domain.model.Invite;

@Entity
@Table(name = "COMMENTAIRE")
public class CommentaireEntity implements IoEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8738861530571912019L;

	/**
	 * uuid du domicile
	 */
	@Id
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "domicile")
	private DomicileEntity domicile;
	
	/**
	 * uuid de l'invite
	 */
	@Id
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "invite")
	private InviteEntity invite;
	
	/**
	 * Commentaire pendant la confirmation
	 */
	@Column(name="commentaire")
	private String commentaire;
	
	/**
	 * Constructeur par defaut
	 */
	public CommentaireEntity() {
		super();
	}

	/**
	 * Constructeur Mappeur
	 * 
	 * @param commentaire
	 */
	public CommentaireEntity(final Commentaire commentaire) {
		this.setCommentaire(commentaire.getCommentaire());
		this.setDomicile(new DomicileEntity(commentaire.getDomicile()));
		this.setInvite(new InviteEntity(commentaire.getInvite()));
	}

	/**
	 * @return the domicile
	 */
	public DomicileEntity getDomicile() {
		return domicile;
	}

	/**
	 * @param domicile the domicile to set
	 */
	public void setDomicile(DomicileEntity domicile) {
		this.domicile = domicile;
	}

	/**
	 * @return the invite
	 */
	public InviteEntity getInvite() {
		return invite;
	}

	/**
	 * @param invite the invite to set
	 */
	public void setInvite(InviteEntity invite) {
		this.invite = invite;
	}

	/**
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

}
