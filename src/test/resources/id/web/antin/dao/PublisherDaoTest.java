package id.web.antin.dao;

import id.web.antin.model.Publisher;

import java.util.List;

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
public class PublisherDaoTest {
	private static final Log log = LogFactory.getLog(AuthorDaoTest.class);

	@Autowired
	PublisherDao publisherDao;

	@Test
	public void testAll() {

		Publisher a = new Publisher("Gramedia","Jl. Palmerah", "021-897867");
		publisherDao.add(a);
		
		Publisher result = publisherDao.findById(a.getId());

		Assert.assertNotNull(result);
		Assert.assertEquals(a.getId(), result.getId());
		
		publisherDao.remove(result);
		List<Publisher> list = publisherDao.findAll();
		
		Assert.assertEquals(0,list.size());
	}
	
	@Test
	public void testFindAll() {
		buildData();		

		List<Publisher> list = publisherDao.findAll();
		log.info("List = "+list);
		Assert.assertEquals(4, list.size());
	}
	
	public void buildData(){
		for(int i=0; i< 4; i++){
			Publisher author = new Publisher("nama"+i, "address"+i, "contact"+i);		
			publisherDao.add(author);
		}
	}
}
