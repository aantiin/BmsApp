package id.web.antin.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import id.web.antin.dao.CategoryDao;
import id.web.antin.helper.QueryHelper;
import id.web.antin.model.Category;
@Repository("CategoryDao")
public class CategoryDaoImpl extends CommonDaoImpl<Category, Long> implements CategoryDao{
	private static final Log log = LogFactory.getLog(CategoryDaoImpl.class);

	@Override
	public List<Category> find(QueryHelper criteria, int page, int maxRows) {
		StringBuilder sb = new StringBuilder("FROM Category WHERE ");

		switch (criteria.getOperator()) {
		case EQ:
			sb.append(criteria.getFieldName()).append(" = :value");
			break;
		case LIKE:
			sb.append(criteria.getFieldName()).append(" like :value");
			break;
		}

		Query query = session().createQuery(sb.toString());

		switch (criteria.getOperator()) {
		case EQ:
			query.setParameter("value", criteria.getValue());
			break;
		case LIKE:
			query.setParameter("value", "%" + criteria.getValue() + "%");
			break;
		}
		List<Category> result = query.list();
		log.info("result override query = " + result);
		return result;
	}
}
