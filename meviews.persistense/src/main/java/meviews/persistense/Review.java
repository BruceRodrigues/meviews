package meviews.persistense;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TB_REVIEW database table.
 * 
 */
@Entity
@Table(name="TB_REVIEW")
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_REVIEW_COSEQREVIEW_GENERATOR", sequenceName="SQ_TB_REVIEW_CO_SEQ_REVIEW")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_REVIEW_COSEQREVIEW_GENERATOR")
	@Column(name="CO_SEQ_REVIEW")
	private int coSeqReview;

	@Column(name="DS_REVIEW")
	private String dsReview;

	@Column(name="NU_RATE")
	private BigDecimal nuRate;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="CO_MOVIE")
	private Movie tbMovie;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="CO_USER")
	private User tbUser;

	public Review() {
	}

	public int getCoSeqReview() {
		return this.coSeqReview;
	}

	public void setCoSeqReview(int coSeqReview) {
		this.coSeqReview = coSeqReview;
	}

	public String getDsReview() {
		return this.dsReview;
	}

	public void setDsReview(String dsReview) {
		this.dsReview = dsReview;
	}

	public BigDecimal getNuRate() {
		return this.nuRate;
	}

	public void setNuRate(BigDecimal nuRate) {
		this.nuRate = nuRate;
	}

	public Movie getTbMovie() {
		return this.tbMovie;
	}

	public void setTbMovie(Movie tbMovie) {
		this.tbMovie = tbMovie;
	}

	public User getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(User tbUser) {
		this.tbUser = tbUser;
	}

}