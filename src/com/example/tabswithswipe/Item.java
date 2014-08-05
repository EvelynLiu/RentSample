package com.example.tabswithswipe;

public class Item {
	private String id;
	private String price;
	private String type;
	private String size;
	private String address;
	private String desc;
	private String link;
	private String title;
	private String pubdate;
	 
	public void setId(String id) {
		this.id = id;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getId() {
		return id;
	}
	public String getPrice() {
		return price;
	}
	public String getType() {
		return type;
	}
	public String getSize() {
		return size;
	}
	public String getAddress() {
		return address;
	}
	public String getDesc() {
		return desc;
	}
	public String getLink() {
		return link;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
}
