package br.portfolio.meviews.presentation.api.login;

import br.portfolio.meviews.presentation.api.base.BaseView;

public interface LoginView extends BaseView<LoginPresenter> {

	void nofityMessage(String message);

}
