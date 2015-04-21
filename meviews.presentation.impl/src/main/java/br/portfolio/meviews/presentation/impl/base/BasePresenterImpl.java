package br.portfolio.meviews.presentation.impl.base;

import br.portfolio.meviews.presentation.api.base.BasePresenter;
import br.portfolio.meviews.presentation.api.base.BaseView;
import br.portfolio.meviews.presentation.api.navigator.Navigator;

public class BasePresenterImpl<VIEW extends BaseView<?>> implements BasePresenter<VIEW> {

	protected VIEW view;

	protected Navigator navigator;

	public BasePresenterImpl() {
		this.init();
	}

	private void init() {

	}

	@Override
	public void setView(VIEW view) {
		this.view = view;
	}

	@Override
	public VIEW getView() {
		return this.view;
	}

	@Override
	public void setNavigator(Navigator nav) {
		this.navigator = nav;
	}

}
