package com.ayur.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "category")
@Data
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long category_id;
	
	
	@Column(name = "categorytype", length = 1000)
	@Enumerated(EnumType.STRING)
	private categorytype categorytype;

	@Column(name = "categoryname", length = 255)
	private String categoryname;

	public enum categorytype {
		HAIR, SKIN, HEALTH;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public categorytype getCategorytype() {
		return categorytype;
	}

	public void setCategorytype(categorytype categorytype) {
		this.categorytype = categorytype;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Category(Long category_id, Category.categorytype categorytype, String categoryname) {
		super();
		this.category_id = category_id;
		this.categorytype = categorytype;
		this.categoryname = categoryname;
	}

	public Category() {
		super();
	}
	
	
}
