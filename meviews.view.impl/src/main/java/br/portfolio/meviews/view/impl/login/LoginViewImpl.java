package br.portfolio.meviews.view.impl.login;

import br.portfolio.meviews.presentation.api.login.LoginPresenter;
import br.portfolio.meviews.presentation.api.login.LoginView;
import br.portfolio.meviews.view.impl.base.BaseViewImpl;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class LoginViewImpl extends BaseViewImpl<LoginPresenter> implements LoginView {

	private static final long serialVersionUID = 1L;

	@Override
	protected void init() {
		super.init();

		VerticalLayout loginPanel = new VerticalLayout();
		loginPanel.setWidth("500px");
		loginPanel.setHeight("300px");

		final TextField userName = new TextField("Username:");
		final TextField password = new TextField("Password:");

		Button loginButton = new Button("Login");
		loginButton.setWidth("80px");
		loginButton.setHeight("50px");
		loginButton.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				LoginViewImpl.this.presenter.checkLoginAndTryNavigate(userName.getValue(), password.getValue());
			}
		});

		loginPanel.addComponent(userName);
		loginPanel.addComponent(password);
		loginPanel.addComponent(loginButton);

		this.addComponent(loginPanel);
		this.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
	}

	@Override
	public void nofityMessage(String message) {
		Notification notification = new Notification(message);
		notification.setDelayMsec(500);
		notification.show(UI.getCurrent().getPage());
	}

}
