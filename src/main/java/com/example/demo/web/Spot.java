package com.example.demo.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Spot {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private Boolean reserved;
private Boolean premium;
private String spotusername;





@ManyToOne
private User spotuser;





		
	public Spot(Boolean reserved, Boolean premium, String spotusername) {
		super();
		this.reserved = reserved;
		this.premium = premium;
		this.spotusername = spotusername;
	}
	
	public Spot(Boolean reserved, Boolean premium) {
		super();
		this.reserved = reserved;
		this.premium = premium;
	}
		public Spot() {
			super();
		}
		public Spot(Boolean reserved, Boolean premium, User spotuser) {
			super();
			this.reserved = reserved;
			this.premium = premium;
			this.spotuser = spotuser;
		}
	


				public Spot(Long id, Boolean reserved, Boolean premium) {
					super();
					this.id = id;
					this.reserved = reserved;
					this.premium = premium;
				}


public String getSpotusername() {
	return spotusername;
}
public void setSpotusername(String spotusername) {
	this.spotusername = spotusername;
}	
				
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Boolean getReserved() {
	return reserved;
}

public void setReserved(Boolean reserved) {
	this.reserved = reserved;
}

public Boolean getPremium() {
	return premium;
}

public void setPremium(Boolean premium) {
	this.premium = premium;
}

public User getSpotuser() {
return spotuser;
}


public void setSpotuser(User spotuser) {
this.spotuser = spotuser;
}

@Override
public String toString() {
	return "Spot [id=" + id + ", reserved=" + reserved + ", premium=" + premium + ", spotuser=" + spotuser + "]";
}




}

