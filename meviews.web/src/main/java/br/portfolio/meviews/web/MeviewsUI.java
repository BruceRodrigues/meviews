package br.portfolio.meviews.web;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

import br.portfolio.meviews.presentation.api.home.HomePresenter;
import br.portfolio.meviews.presentation.api.home.HomeView;
import br.portfolio.meviews.presentation.api.login.LoginPresenter;
import br.portfolio.meviews.presentation.api.login.LoginView;
import br.portfolio.meviews.presentation.api.navigator.Navigator;
import br.portfolio.meviews.presentation.impl.home.HomePresenterImpl;
import br.portfolio.meviews.presentation.impl.login.LoginPresenterImpl;
import br.portfolio.meviews.presentation.impl.navigator.NavigatorImpl;
import br.portfolio.meviews.view.impl.controller.ViewControllerImpl;
import br.portfolio.meviews.view.impl.home.HomeViewImpl;
import br.portfolio.meviews.view.impl.login.LoginViewImpl;
import br.portfolio.meviews.view.impl.topbar.TopBarViewImpl;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.server.VaadinCDIServlet;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("meviewstheme")
@Widgetset("br.portfolio.meviews.web.MeviewsWidgetset")
@CDIUI("")
public class MeviewsUI extends UI {

	private static final long serialVersionUID = 1L;

	@Inject
	private BeanManager beanManager;

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		ViewControllerImpl controller = new ViewControllerImpl();
		Navigator navigator = new NavigatorImpl(controller);

		controller.getMainContent().removeAllComponents();

		this.setContent(controller.getMainContent());

		VerticalLayout root = new VerticalLayout();
		TopBarViewImpl topBar = new TopBarViewImpl();

		controller.setTopBar(topBar);
		controller.setRoot(root);

		{
			navigator.register(HomePresenter.class, HomePresenterImpl.class, HomeView.class, HomeViewImpl.class);
			navigator.register(LoginPresenter.class, LoginPresenterImpl.class, LoginView.class, LoginViewImpl.class);
		}

		navigator.natigate(LoginPresenter.class);

	}

	@WebServlet(urlPatterns = "/*", name = "MeviewsUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MeviewsUI.class, productionMode = false)
	public static class MeviewsUIServlet extends VaadinCDIServlet {

		private static final long serialVersionUID = 1L;
	}
}
