package br.portfolio.meviews.presentation.api.base;

import br.portfolio.meviews.presentation.api.navigator.Navigator;

public interface BasePresenter<VIEW extends BaseView<?>> {

	void setNavigator(Navigator nav);

	VIEW getView();

	void setView(VIEW view);

}
