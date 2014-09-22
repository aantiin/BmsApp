package id.web.antin.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import id.web.antin.dao.CommonDao;
import id.web.antin.helper.QueryHelper;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public abstract class CommonDaoImpl<E, PK extends Serializable> implements
		CommonDao<E, PK> {
	private static Log log = LogFactory.getLog(CommonDaoImpl.class);
	private SessionFactory sessionFactory;
	private Class<? extends E> persistentClass;

	@SuppressWarnings("unchecked")
	public CommonDaoImpl() {
		this.persistentClass = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session session() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll() {
		return session().createCriteria(persistentClass).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findById(PK id) {
		return (E) session().get(persistentClass, id);
	}

	@Override
	public boolean exists(PK id) {
		E entity = findById(id);
		return entity != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PK add(E object) {
		return (PK) session().save(object);
	}

	@Override
	public void update(E object) {
		session().update(object);
	}

	@Override
	public void remove(E object) {
		session().delete(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> find(List<QueryHelper> criterias, int page, int maxRows) {

		String alias = "e";

		Criteria c = session().createCriteria(persistentClass, alias);

		createQueryCriteriaAlias(c, alias);

		for (QueryHelper f : criterias) {
			c.add(buildCriterion(f));
		}

		c.setFirstResult((page - 1) * maxRows);
		c.setMaxResults(maxRows);

		log.info("result .list = " + c.list());

		return c.list();
	}

	protected void createQueryCriteriaAlias(Criteria c, String alias) {
	}

	private Criterion buildCriterion(QueryHelper criteria) {
		Criterion c = null;

		switch (criteria.getOperator()) {

		case EQ:
			c = Restrictions.eq(criteria.getFieldName(), criteria.getValue());
			break;
		case LIKE:
			c = Restrictions.like(criteria.getFieldName(), criteria.getValue());
			break;
		default:
			break;
		}
		return c;
	}
}
