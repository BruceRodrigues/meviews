package br.portfolio.meviews.view.impl.navigator;

import br.portfolio.meviews.presentation.api.base.BasePresenter;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class Navigator {

	private static VerticalLayout mainContent = new VerticalLayout();

	private static VerticalLayout root;

	public static void setRoot(VerticalLayout layout) {
		root = layout;
		if (root != null) {
			mainContent.addComponent(root);
		}
	}

	public static void navigate(BasePresenter<?> presenter) {
		root.removeAllComponents();
		root.addComponent((Component) presenter.getView());
	}

	public static void setTopBar(Component component) {
		mainContent.addComponent(component);
		mainContent.setComponentAlignment(component, Alignment.TOP_CENTER);
	}

	public static VerticalLayout getMainContent() {
		return mainContent;
	}
}
