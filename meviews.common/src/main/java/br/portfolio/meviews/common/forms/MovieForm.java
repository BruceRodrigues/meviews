package br.portfolio.meviews.common.forms;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.portfolio.meviews.common.enums.Genre;

@Getter
@Setter
public class MovieForm implements Serializable {

	private static final long serialVersionUID = 7148928733004007278L;

	private String name;

	private long rate;

	private List<ReviewForm> reviews;

	private List<Genre> genres;

}
