package br.portfolio.meviews.view.impl.topbar;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;

public class TopBarViewImpl extends CustomComponent {

	private static final long serialVersionUID = 1L;

	public TopBarViewImpl() {
		this.init();
	}

	private void init() {

		Button home = new Button("Home");
		home.setIcon(FontAwesome.HOME);
		Button movies = new Button("Movies");
		movies.setIcon(FontAwesome.APPLE);
		Button upload = new Button("Upload");
		upload.setIcon(FontAwesome.UPLOAD);

		HorizontalLayout topBar = new HorizontalLayout();
		topBar.setWidthUndefined();
		topBar.setMargin(true);
		topBar.setSpacing(true);

		topBar.addComponent(home);
		topBar.addComponent(movies);
		topBar.addComponent(upload);

		this.setCompositionRoot(topBar);

	}

}
