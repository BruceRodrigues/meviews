package br.portfolio.meviews.business.api.login;

import br.portfolio.meviews.business.api.base.BaseService;
import br.portfolio.meviews.common.exceptions.InvalidLoginException;
import br.portfolio.meviews.common.forms.UserForm;

public interface LoginService extends BaseService {

	UserForm getUser(String userName, String password) throws InvalidLoginException;

}
