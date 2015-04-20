package br.portfolio.meviews.view.impl.components;

import lombok.Getter;
import lombok.Setter;

import com.vaadin.server.Resource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@Getter
@Setter
public class Card extends CustomComponent {

	private static final long serialVersionUID = 1L;

	private Resource icon;

	private String name;

	private CardInformations info;

	public Card() {
		this(null, null);
	}

	public Card(String name, Resource icon) {
		this(name, icon, null);
	}

	public Card(String name, Resource icon, CardInformations info) {
		this.name = name;
		this.icon = icon;
		this.info = info;
		this.init();
	}

	private void init() {
		VerticalLayout vertical = new VerticalLayout();

		Label labelIcon = new Label();
		Label labelName = new Label(this.name);

		vertical.addComponent(labelIcon);
		vertical.addComponent(labelName);

		this.setCompositionRoot(vertical);
	}
}
