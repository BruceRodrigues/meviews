package br.portfolio.meviews.common.forms;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm implements Serializable {

	private static final long serialVersionUID = -7323376488708274880L;

	private String name;

	private String email;

	private List<UserForm> friends;

	private List<ReviewForm> reviews;

}
