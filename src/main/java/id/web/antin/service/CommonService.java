package id.web.antin.service;

import id.web.antin.helper.QueryHelper;

import java.io.Serializable;
import java.util.List;

public interface CommonService<E, PK extends Serializable> {
	List<E> findAll();

	E findById(PK id);

	boolean exists(PK id);

	PK add(E object);

	void update(E object);

	void remove(E object);

	List<E> find(List<QueryHelper> criterias, int page, int maxRows);
	List<E> find(QueryHelper criteria, int page, int maxRows);
}
