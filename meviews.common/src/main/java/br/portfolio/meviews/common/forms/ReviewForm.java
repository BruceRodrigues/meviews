package br.portfolio.meviews.common.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewForm implements Serializable {

	private static final long serialVersionUID = 3230743680254111036L;

	private UserForm user;

	private MovieForm movie;

	private long rate;

	private String review;

}
