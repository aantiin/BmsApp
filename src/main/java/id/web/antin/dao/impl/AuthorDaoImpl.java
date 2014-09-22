package id.web.antin.dao.impl;

import id.web.antin.dao.AuthorDao;
import id.web.antin.helper.QueryHelper;
import id.web.antin.model.Author;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("AuthorDao")
public class AuthorDaoImpl extends CommonDaoImpl<Author, Long> implements
		AuthorDao {

	private static final Log log = LogFactory.getLog(AuthorDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> find(QueryHelper criterias, int page, int maxRows) {
		StringBuilder sb = new StringBuilder("FROM Author WHERE ");

		switch (criterias.getOperator()) {
		case EQ:
			sb.append(criterias.getFieldName()).append(" = :value");
			break;
		case LIKE:
			sb.append(criterias.getFieldName()).append(" like :value");
			break;
		}

		Query query = session().createQuery(sb.toString());

		switch (criterias.getOperator()) {
		case EQ:
			query.setParameter("value", criterias.getValue());
			break;
		case LIKE:
			query.setParameter("value", "%" + criterias.getValue() + "%");
			break;
		}
		List<Author> result = query.list();
		log.info("result override query = " + result);
		return result;
	}

}
