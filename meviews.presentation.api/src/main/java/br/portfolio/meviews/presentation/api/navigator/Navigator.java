package br.portfolio.meviews.presentation.api.navigator;

import br.portfolio.meviews.presentation.api.base.BasePresenter;
import br.portfolio.meviews.presentation.api.base.BaseView;

public interface Navigator {

	<PRESENTER extends BasePresenter<?>> void natigate(Class<PRESENTER> clazz);

	<PRESENTER extends BasePresenter<VIEW>, VIEW extends BaseView<PRESENTER>> void register(Class<PRESENTER> presenterClass, Class<? extends PRESENTER> presenterImpl,
			Class<VIEW> viewClass, Class<? extends VIEW> viewImpl);

}
