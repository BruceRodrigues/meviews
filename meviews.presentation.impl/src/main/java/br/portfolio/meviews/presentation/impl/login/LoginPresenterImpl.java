package br.portfolio.meviews.presentation.impl.login;

import javax.ejb.EJB;

import br.portfolio.meviews.business.api.login.LoginService;
import br.portfolio.meviews.common.exceptions.InvalidLoginException;
import br.portfolio.meviews.presentation.api.home.HomePresenter;
import br.portfolio.meviews.presentation.api.login.LoginPresenter;
import br.portfolio.meviews.presentation.api.login.LoginView;
import br.portfolio.meviews.presentation.impl.base.BasePresenterImpl;

public class LoginPresenterImpl extends BasePresenterImpl<LoginView> implements LoginPresenter {

	@EJB
	private LoginService service;

	@Override
	public void goToHome() {
		this.navigator.natigate(HomePresenter.class);
	}

	@Override
	public void checkLoginAndTryNavigate(String name, String password) {
		try {
			this.service.getUser(name, password);
			this.goToHome();
		} catch (InvalidLoginException e) {
			this.notify(e.getMessage());
		}
	}

	private void notify(String message) {
		this.view.nofityMessage(message);
	}

}
