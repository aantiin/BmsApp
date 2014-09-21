package id.web.antin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 
 * @author antin
 *
 */
@Entity
public class Author {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String contact;
	
	public Author(){		
	}
	
	public Author(String name, String contact) {
		super();
		this.name = name;
		this.contact = contact;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String toString() {
		return "[author name: " +name +", contact: " +contact+"]";
	}
}
