package br.portfolio.meviews.presentation.api.login;

import br.portfolio.meviews.presentation.api.base.BasePresenter;

public interface LoginPresenter extends BasePresenter<LoginView> {

	void goToHome();

	void checkLoginAndTryNavigate(String name, String password);

}
