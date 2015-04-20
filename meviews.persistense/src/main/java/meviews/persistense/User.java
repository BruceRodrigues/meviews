package meviews.persistense;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_USER database table.
 * 
 */
@Entity
@Table(name="TB_USER")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_USER_COSEQUSER_GENERATOR", sequenceName="SQ_TB_USER_CO_SEQ_USER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_USER_COSEQUSER_GENERATOR")
	@Column(name="CO_SEQ_USER")
	private int coSeqUser;

	@Column(name="DS_EMAIL")
	private String dsEmail;

	@Column(name="DS_NAME")
	private String dsName;

	@Column(name="DS_PASSWORD")
	private String dsPassword;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="tbUser")
	private List<Review> tbReviews;

	//bi-directional many-to-many association to User
	@ManyToMany
	@JoinTable(
		name="RL_USER_FRIENDS"
		, joinColumns={
			@JoinColumn(name="CO_FRIEND")
			}
		, inverseJoinColumns={
			@JoinColumn(name="CO_USER")
			}
		)
	private List<User> tbUsers1;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="tbUsers1")
	private List<User> tbUsers2;

	public User() {
	}

	public int getCoSeqUser() {
		return this.coSeqUser;
	}

	public void setCoSeqUser(int coSeqUser) {
		this.coSeqUser = coSeqUser;
	}

	public String getDsEmail() {
		return this.dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsName() {
		return this.dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public String getDsPassword() {
		return this.dsPassword;
	}

	public void setDsPassword(String dsPassword) {
		this.dsPassword = dsPassword;
	}

	public List<Review> getTbReviews() {
		return this.tbReviews;
	}

	public void setTbReviews(List<Review> tbReviews) {
		this.tbReviews = tbReviews;
	}

	public Review addTbReview(Review tbReview) {
		getTbReviews().add(tbReview);
		tbReview.setTbUser(this);

		return tbReview;
	}

	public Review removeTbReview(Review tbReview) {
		getTbReviews().remove(tbReview);
		tbReview.setTbUser(null);

		return tbReview;
	}

	public List<User> getTbUsers1() {
		return this.tbUsers1;
	}

	public void setTbUsers1(List<User> tbUsers1) {
		this.tbUsers1 = tbUsers1;
	}

	public List<User> getTbUsers2() {
		return this.tbUsers2;
	}

	public void setTbUsers2(List<User> tbUsers2) {
		this.tbUsers2 = tbUsers2;
	}

}