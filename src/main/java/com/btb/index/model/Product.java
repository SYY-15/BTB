package com.btb.index.model;

/**
 * 商品model
 * @author 18381
 *
 */
public class Product {
	private int id;
	private String prodoctName;
	private double prodoctPrice;
	private String prodoctUrl;
	private String prodoctPicture;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProdoctName() {
		return prodoctName;
	}
	public void setProdoctName(String prodoctName) {
		this.prodoctName = prodoctName;
	}
	public double getProdoctPrice() {
		return prodoctPrice;
	}
	public void setProdoctPrice(double prodoctPrice) {
		this.prodoctPrice = prodoctPrice;
	}
	public String getProdoctUrl() {
		return prodoctUrl;
	}
	public void setProdoctUrl(String prodoctUrl) {
		this.prodoctUrl = prodoctUrl;
	}
	public String getProdoctPicture() {
		return prodoctPicture;
	}
	public void setProdoctPicture(String prodoctPicture) {
		this.prodoctPicture = prodoctPicture;
	}
	@Override
	public String toString() {
		return "Prodoct [id=" + id + ", prodoctName=" + prodoctName + ", prodoctPrice=" + prodoctPrice + ", prodoctUrl="
				+ prodoctUrl + ", prodoctPicture=" + prodoctPicture + "]";
	}
	
}
