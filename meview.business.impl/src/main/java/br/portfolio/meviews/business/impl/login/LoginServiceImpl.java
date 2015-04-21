package br.portfolio.meviews.business.impl.login;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import meviews.persistense.QUser;
import meviews.persistense.User;
import br.portfolio.meviews.business.api.login.LoginService;
import br.portfolio.meviews.business.impl.base.BaseServiceImpl;
import br.portfolio.meviews.common.exceptions.InvalidLoginException;
import br.portfolio.meviews.common.forms.UserForm;

import com.mysema.query.jpa.impl.JPAQuery;

@Stateless
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {

	@PersistenceContext(unitName = "meviews.persistense")
	private EntityManager em;

	@Override
	public UserForm getUser(String userName, String password) throws InvalidLoginException {
		JPAQuery query = new JPAQuery(this.em);
		User user = query.from(QUser.user).where(QUser.user.dsName.eq(userName).and(QUser.user.dsPassword.eq(password))).singleResult(QUser.user);
		if (user == null) {
			throw new InvalidLoginException("Username or password invalid");
		}
		UserForm form = new UserForm();
		form.setId(user.getCoSeqUser());
		form.setEmail(user.getDsEmail());
		form.setName(user.getDsName());

		return form;

	}

}
