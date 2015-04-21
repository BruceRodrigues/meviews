package br.portfolio.meviews.presentation.impl.navigator;

import java.util.HashMap;
import java.util.Map;

import br.portfolio.meviews.presentation.api.base.BasePresenter;
import br.portfolio.meviews.presentation.api.base.BaseView;
import br.portfolio.meviews.presentation.api.controller.ViewController;
import br.portfolio.meviews.presentation.api.navigator.Navigator;

public class NavigatorImpl implements Navigator {

	private Map<Class<? extends BasePresenter<?>>, Class<? extends BaseView<?>>> registers = new HashMap<Class<? extends BasePresenter<?>>, Class<? extends BaseView<?>>>();

	private Map<Class<? extends BasePresenter<?>>, Class<?>> presentersImpl = new HashMap<Class<? extends BasePresenter<?>>, Class<?>>();

	private Map<Class<? extends BasePresenter<?>>, Class<?>> viewsImpl = new HashMap<Class<? extends BasePresenter<?>>, Class<?>>();

	private RegistersKeeper currentRegister = new RegistersKeeper();

	private ViewController viewController;

	public NavigatorImpl(ViewController controller) {
		this.viewController = controller;
	}

	@Override
	public <PRESENTER extends BasePresenter<VIEW>, VIEW extends BaseView<PRESENTER>> void register(Class<PRESENTER> presenterClass, Class<? extends PRESENTER> presenterImpl,
			Class<VIEW> viewClass, Class<? extends VIEW> viewImpl) {
		this.registers.put(presenterClass, viewClass);
		this.presentersImpl.put(presenterClass, presenterImpl);
		this.viewsImpl.put(presenterClass, viewImpl);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <PRESENTER extends BasePresenter<?>> void natigate(Class<PRESENTER> clazz) {
		if (this.registers.containsKey(clazz)) {
			if (this.currentRegister != null) {
				this.currentRegister.clear();
				try {
					BaseView view = (BaseView) this.viewsImpl.get(clazz).newInstance();
					BasePresenter presenter = (BasePresenter) this.presentersImpl.get(clazz).newInstance();
					view.setPresenter(presenter);
					presenter.setView(view);
					presenter.setNavigator(this);
					this.currentRegister.updateRegisters(presenter, view);
					this.viewController.updateView(presenter);
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
					System.out.println("Failed to create a new presenter or view");
				}
			}
		}
		System.out.println("Presenter not found");
	}

	protected class RegistersKeeper {

		protected BasePresenter<?> presenterInterface;

		protected BaseView<?> viewInterface;

		protected void clear() {
			this.viewInterface = null;
			this.presenterInterface = null;
		}

		protected void updateRegisters(BasePresenter<?> presenter, BaseView<?> view) {
			this.presenterInterface = presenter;
			this.viewInterface = view;

		}

	}
}
