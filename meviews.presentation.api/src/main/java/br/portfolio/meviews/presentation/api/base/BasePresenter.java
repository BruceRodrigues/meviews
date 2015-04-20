package br.portfolio.meviews.presentation.api.base;

public interface BasePresenter<VIEW extends BaseView> {

	VIEW getView();

}
