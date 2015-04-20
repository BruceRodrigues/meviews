package br.portfolio.meviews.web;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("meviewstheme")
@Widgetset("br.portfolio.meviews.web.MeviewsWidgetset")
public class MeviewsUI extends UI {

	private static final long serialVersionUID = 1L;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		this.setContent(layout);

		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Thank you for clicking"));
			}
		});
		layout.addComponent(button);

	}

	@WebServlet(urlPatterns = "/*", name = "MeviewsUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MeviewsUI.class, productionMode = false)
	public static class MeviewsUIServlet extends VaadinServlet {

		private static final long serialVersionUID = 1L;
	}
}
