package meviews.persistense;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TB_MOVIE database table.
 * 
 */
@Entity
@Table(name="TB_MOVIE")
@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_MOVIE_COSEQMOVIE_GENERATOR", sequenceName="SQ_TB_MOVIE_CO_SEQ_MOVIE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_MOVIE_COSEQMOVIE_GENERATOR")
	@Column(name="CO_SEQ_MOVIE")
	private int coSeqMovie;

	@Column(name="DS_NAME")
	private String dsName;

	@Column(name="NU_RATE")
	private BigDecimal nuRate;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="tbMovie")
	private List<Review> tbReviews;

	//bi-directional many-to-many association to MovieGenre
	@ManyToMany(mappedBy="tbMovies")
	private List<MovieGenre> tbMovieGenres;

	public Movie() {
	}

	public int getCoSeqMovie() {
		return this.coSeqMovie;
	}

	public void setCoSeqMovie(int coSeqMovie) {
		this.coSeqMovie = coSeqMovie;
	}

	public String getDsName() {
		return this.dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public BigDecimal getNuRate() {
		return this.nuRate;
	}

	public void setNuRate(BigDecimal nuRate) {
		this.nuRate = nuRate;
	}

	public List<Review> getTbReviews() {
		return this.tbReviews;
	}

	public void setTbReviews(List<Review> tbReviews) {
		this.tbReviews = tbReviews;
	}

	public Review addTbReview(Review tbReview) {
		getTbReviews().add(tbReview);
		tbReview.setTbMovie(this);

		return tbReview;
	}

	public Review removeTbReview(Review tbReview) {
		getTbReviews().remove(tbReview);
		tbReview.setTbMovie(null);

		return tbReview;
	}

	public List<MovieGenre> getTbMovieGenres() {
		return this.tbMovieGenres;
	}

	public void setTbMovieGenres(List<MovieGenre> tbMovieGenres) {
		this.tbMovieGenres = tbMovieGenres;
	}

}