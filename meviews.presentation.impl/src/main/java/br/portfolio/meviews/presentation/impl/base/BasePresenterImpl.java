package br.portfolio.meviews.presentation.impl.base;

import br.portfolio.meviews.presentation.api.base.BasePresenter;
import br.portfolio.meviews.presentation.api.base.BaseView;

public class BasePresenterImpl<VIEW extends BaseView> implements
		BasePresenter<VIEW> {

	protected VIEW view;

	public BasePresenterImpl() {
		this.init();
	}

	private void init() {

	}

	public void setView(VIEW view) {
		this.view = view;
	}

	@Override
	public VIEW getView() {
		return this.view;
	}

}
