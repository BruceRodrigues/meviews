package br.portfolio.meviews.view.impl.base;

import br.portfolio.meviews.presentation.api.base.BasePresenter;
import br.portfolio.meviews.presentation.api.base.BaseView;

import com.vaadin.ui.VerticalLayout;

public class BaseViewImpl<PRESENTER extends BasePresenter<?>> extends
		VerticalLayout implements BaseView {

	private static final long serialVersionUID = 1L;

	protected PRESENTER presenter;

	public BaseViewImpl() {
		this.init();
	}

	private void init() {

	}

	public void setPresenter(PRESENTER presenter) {
		this.presenter = presenter;
	}

}