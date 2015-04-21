package br.portfolio.meviews.presentation.api.base;

public interface BaseView<PRESENTER extends BasePresenter<?>> {

	void setPresenter(PRESENTER presenter);

}
