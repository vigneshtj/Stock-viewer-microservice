package com.share.view.dbservice;

import javax.persistence.*;

@Entity
@Table(name = "quotes", catalog = "test")
public class Quote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	  
	  @Column(name = "userName")  
	private String userName;
	  
	  @Column(name = "quote")
	private String quote;
	
	  public Quote() {
	 }
	  
	public Quote(String userName, String quote) {
        this.userName = userName;
        this.quote = quote;
    }
	
	
	
	public Integer getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getQuote() {
		return quote;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}

	
	
}
