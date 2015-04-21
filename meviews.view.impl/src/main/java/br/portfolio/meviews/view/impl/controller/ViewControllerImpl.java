package br.portfolio.meviews.view.impl.controller;

import br.portfolio.meviews.presentation.api.base.BasePresenter;
import br.portfolio.meviews.presentation.api.controller.ViewController;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class ViewControllerImpl implements ViewController {

	private VerticalLayout mainContent = new VerticalLayout();

	private VerticalLayout root;

	public void setRoot(VerticalLayout layout) {
		this.root = layout;
		if (this.root != null) {
			this.mainContent.addComponent(this.root);
		}
	}

	@Override
	public void updateView(BasePresenter<?> presenter) {
		this.root.removeAllComponents();
		this.root.addComponent((Component) presenter.getView());
	}

	public void setTopBar(Component component) {
		this.mainContent.addComponent(component);
		this.mainContent.setComponentAlignment(component, Alignment.TOP_CENTER);
	}

	public VerticalLayout getMainContent() {
		return this.mainContent;
	}
}
