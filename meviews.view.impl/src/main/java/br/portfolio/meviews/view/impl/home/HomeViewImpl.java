package br.portfolio.meviews.view.impl.home;

import br.portfolio.meviews.presentation.api.home.HomePresenter;
import br.portfolio.meviews.presentation.api.home.HomeView;
import br.portfolio.meviews.view.impl.base.BaseViewImpl;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

public class HomeViewImpl extends BaseViewImpl<HomePresenter> implements HomeView {

	private static final long serialVersionUID = 1L;

	@Override
	protected void init() {
		Button home = new Button("teste");

		HorizontalLayout topBar = new HorizontalLayout();
		topBar.setWidth("100%");

		topBar.addComponent(home);

		this.addComponent(topBar);
		this.setComponentAlignment(topBar, Alignment.TOP_CENTER);
	}

}
