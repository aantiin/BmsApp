package id.web.antin.dao;

import java.util.List;

import id.web.antin.model.Author;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml",
		"classpath:/applicationContextDao.xml" })
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class AuthorDaoTest {
	private static final Log log = LogFactory.getLog(AuthorDaoTest.class);

	@Autowired
	AuthorDao authorDao;

	@Test
	public void testAll() {

		Author a = new Author();
		a.setName("Lews Therin");
		a.setContact("Manhattan, New York");
		authorDao.add(a);
		
		Author result = authorDao.findById(a.getId());

		Assert.assertNotNull(result);
		Assert.assertEquals(a.getId(), result.getId());
		
		authorDao.remove(result);
		List<Author> list = authorDao.findAll();
		
		Assert.assertEquals(0,list.size());
	}
	
	@Test
	public void testFindAll() {
		buildData();		

		List<Author> list = authorDao.findAll();
		log.info("List = "+list);
		Assert.assertEquals(4, list.size());
	}
	
	public void buildData(){
		for(int i=0; i< 4; i++){
			Author author = new Author("nama"+i, "contact"+i);		
			authorDao.add(author);
		}
	}
	
}
