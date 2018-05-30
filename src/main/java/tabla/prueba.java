package tabla;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="Prueba")
public class prueba implements Serializable{
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="PAGES")
	private Integer pages;
	
	public prueba() {
		
	}
	
	public prueba(int id, String title, Integer pages) {
		this.id=id;
		this.title=title;
		this.pages=pages;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public Integer getPages() {
		return this.pages;
	}
	
	public void setPages(Integer pages) {
		this.pages=pages;
	}

}