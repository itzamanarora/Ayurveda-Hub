package com.ayur.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long product_id;
	

	@Column(name = "product_title", length = 500 )
	private String productTitle;
	
	@Column(name = "product_size", length = 255)
	private String product_size;
	
	@Column(name = "product_desc", length = 1500)
	private String product_desc;


	@Column(name = "product_ingredient", length = 1500)
	private String product_ingredient;

	@Column(name = "product_stock", length = 100)
	private int product_stock;


	@Column(name = "product_price", length = 20)
	private int product_price;
	

	@Column(name = "product_category_type", length = 255)
	private String productCategorytype;

	@Column(name = "product_category", length = 255)
	private String productCategory;

	@Column(name = "product_image_url")
	private String product_image_url;
	
	@Column(name = "product_image_url2")
	private String product_image_url2;
	
	@Column(name = "product_image_url3")
	private String product_image_url3;
	
	@Column(name = "product_image_url4")
	private String product_image_url4;
	
	@Column(name = "product_orgprice", length = 20)
	private int product_orgprice;

	@Column(name = "product_info", length = 1500)
	private String product_info;
	
	@Column(name ="product_status")
	private String product_status;

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProduct_size() {
		return product_size;
	}

	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public String getProduct_ingredient() {
		return product_ingredient;
	}

	public void setProduct_ingredient(String product_ingredient) {
		this.product_ingredient = product_ingredient;
	}

	public int getProduct_stock() {
		return product_stock;
	}

	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProductCategorytype() {
		return productCategorytype;
	}

	public void setProductCategorytype(String productCategorytype) {
		this.productCategorytype = productCategorytype;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProduct_image_url() {
		return product_image_url;
	}

	public void setProduct_image_url(String product_image_url) {
		this.product_image_url = product_image_url;
	}

	public int getProduct_orgprice() {
		return product_orgprice;
	}

	public void setProduct_orgprice(int product_orgprice) {
		this.product_orgprice = product_orgprice;
	}

	public String getProduct_info() {
		return product_info;
	}

	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}

	public String getProduct_status() {
		return product_status;
	}

	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}

	public String getProduct_image_url2() {
		return product_image_url2;
	}

	public void setProduct_image_url2(String product_image_url2) {
		this.product_image_url2 = product_image_url2;
	}

	public String getProduct_image_url3() {
		return product_image_url3;
	}

	public void setProduct_image_url3(String product_image_url3) {
		this.product_image_url3 = product_image_url3;
	}

	public String getProduct_image_url4() {
		return product_image_url4;
	}

	public void setProduct_image_url4(String product_image_url4) {
		this.product_image_url4 = product_image_url4;
	}

	public Products(Long product_id, String productTitle, String product_size, String product_desc,
			String product_ingredient, int product_stock, int product_price, String productCategorytype,
			String productCategory, String product_image_url, String product_image_url2, String product_image_url3,
			String product_image_url4, int product_orgprice, String product_info, String product_status) {
		super();
		this.product_id = product_id;
		this.productTitle = productTitle;
		this.product_size = product_size;
		this.product_desc = product_desc;
		this.product_ingredient = product_ingredient;
		this.product_stock = product_stock;
		this.product_price = product_price;
		this.productCategorytype = productCategorytype;
		this.productCategory = productCategory;
		this.product_image_url = product_image_url;
		this.product_image_url2 = product_image_url2;
		this.product_image_url3 = product_image_url3;
		this.product_image_url4 = product_image_url4;
		this.product_orgprice = product_orgprice;
		this.product_info = product_info;
		this.product_status = product_status;
	}

	public Products() {
		super();
	}

	
	
}
