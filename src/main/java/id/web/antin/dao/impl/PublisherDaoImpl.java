package id.web.antin.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import id.web.antin.dao.PublisherDao;
import id.web.antin.helper.QueryHelper;
import id.web.antin.model.Publisher;

@Repository("PublisherDao")
public class PublisherDaoImpl extends CommonDaoImpl<Publisher, Long> implements PublisherDao{
	private static Log log = LogFactory.getLog(PublisherDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Publisher> find(QueryHelper criterias, int page, int maxRows) {
		StringBuilder sb = new StringBuilder("FROM Publisher WHERE ");

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
		
		log.info("query = " + sb.toString());
		List<Publisher> result = query.list();
		
		log.info("result override query = " + result);
		return result;
	}
}
