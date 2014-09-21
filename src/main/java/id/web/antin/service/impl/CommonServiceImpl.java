package id.web.antin.service.impl;

import id.web.antin.dao.CommonDao;
import id.web.antin.helper.QueryHelper;
import id.web.antin.service.CommonService;

import java.io.Serializable;
import java.util.List;

public class CommonServiceImpl<E, PK extends Serializable> implements
		CommonService<E, PK> {

	protected CommonDao<E, PK> dao;

	public CommonServiceImpl(CommonDao<E, PK> commonDao) {
		this.dao = commonDao;
	}

	@Override
	public List<E> findAll() {
		return dao.findAll();
	}

	@Override
	public E findById(PK id) {
		return findById(id);
	}

	@Override
	public boolean exists(PK id) {
		return dao.exists(id);
	}

	@Override
	public PK add(E object) {
		return dao.add(object);
	}

	@Override
	public void update(E object) {
		dao.update(object);
	}

	@Override
	public void remove(E object) {
		dao.remove(object);

	}

	@Override
	public List<E> find(List<QueryHelper> criteria, int page, int maxRows) {
		return dao.find(criteria, page, maxRows);
	}

	@Override
	public List<E> find(QueryHelper criteria, int page, int maxRows) {
		return dao.find(criteria, page, maxRows);
	}
}
