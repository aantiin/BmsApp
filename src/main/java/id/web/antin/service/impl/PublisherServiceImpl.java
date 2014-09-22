package id.web.antin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.web.antin.dao.PublisherDao;
import id.web.antin.model.Publisher;
import id.web.antin.service.PublisherService;

@Service("PublisherService")
public class PublisherServiceImpl extends CommonServiceImpl<Publisher, Long>
		implements PublisherService {
	private PublisherDao publisherDao;

	@Autowired
	public PublisherServiceImpl(PublisherDao publisherDao) {
		super(publisherDao);
		this.publisherDao = publisherDao;
	}

}
