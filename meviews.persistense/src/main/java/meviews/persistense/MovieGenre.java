package meviews.persistense;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TB_MOVIE_GENRE database table.
 * 
 */
@Entity
@Table(name = "TB_MOVIE_GENRE")
@NamedQuery(name = "MovieGenre.findAll", query = "SELECT m FROM MovieGenre m")
public class MovieGenre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CO_MOVIE_GENRE")
	private int coMovieGenre;

	@Column(name = "DS_NAME")
	private String dsName;

	// bi-directional many-to-many association to Movie
	@ManyToMany
	@JoinTable(name = "RL_MOVIE_GENRE", joinColumns = { @JoinColumn(name = "CO_GENRE", referencedColumnName = "CO_MOVIE_GENRE") }, inverseJoinColumns = { @JoinColumn(name = "CO_MOVIE") })
	private List<Movie> tbMovies;

	public MovieGenre() {
	}

	public String getDsName() {
		return this.dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public List<Movie> getTbMovies() {
		return this.tbMovies;
	}

	public void setTbMovies(List<Movie> tbMovies) {
		this.tbMovies = tbMovies;
	}

}