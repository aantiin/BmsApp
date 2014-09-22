package id.web.antin.dao;

import id.web.antin.model.Category;

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
public class CategoryDaoTest {
	private static final Log log = LogFactory.getLog(CategoryDaoTest.class);
	@Autowired
	CategoryDao categoryDao;
	
	@Test
	public void testAll() {

		Category a = new Category("fiction","it's fiction novel");		
		categoryDao.add(a);
		
		Category result = categoryDao.findById(a.getId());

		Assert.assertNotNull(result);
		Assert.assertEquals(a.getId(), result.getId());
		
		categoryDao.remove(result);
		List<Category> list = categoryDao.findAll();
		
		Assert.assertEquals(0,list.size());
	}
	
	@Test
	public void testFindAll() {
		buildData();		

		List<Category> list = categoryDao.findAll();
		log.info("List = "+list);
		Assert.assertEquals(4, list.size());
	}
	
	public void buildData(){
		for(int i=0; i< 4; i++){
			Category author = new Category("name"+i, "description"+i);		
			categoryDao.add(author);
		}
	}
}
