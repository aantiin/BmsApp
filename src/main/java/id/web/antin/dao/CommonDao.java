package id.web.antin.dao;

import id.web.antin.helper.QueryHelper;
import id.web.antin.model.Author;

import java.io.Serializable;
import java.util.List;

public interface CommonDao<E, PK extends Serializable> {
	List<E> findAll();

	E findById(PK id);

	boolean exists(PK id);

	PK add(E object);

	void update(E object);

	void remove(E object);

	List<E> find(List<QueryHelper> filters, int page, int maxRows);
	List<E> find(QueryHelper filters, int page, int maxRows);
}
