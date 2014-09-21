package id.web.antin.service.impl;

import id.web.antin.dao.AuthorDao;
import id.web.antin.model.Author;
import id.web.antin.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AuthorService")
public class AuthorServiceImpl extends CommonServiceImpl<Author, Long>
		implements AuthorService {

	private AuthorDao authorDao;

	@Autowired
	private AuthorServiceImpl(AuthorDao authorDao) {
		super(authorDao);
		this.authorDao = authorDao;
	}
}
