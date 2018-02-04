package com.mytaxi.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "manufacturer",
uniqueConstraints = @UniqueConstraint(name = "uc_manufacturerName", columnNames = {"manufacturerName"})
)
public class ManufacturerDO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "date_created")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime dateCreated = ZonedDateTime.now();

	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime dateUpdated = ZonedDateTime.now();

	@Column(nullable = false)
	private String manufacturerName;
	
	public ManufacturerDO() {
	}
	
	public ManufacturerDO(Long id, String manufacturerName) {
		this.id = id;
		this.manufacturerName = manufacturerName;
		this.dateCreated = ZonedDateTime.now();
		this.dateUpdated = ZonedDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public ZonedDateTime getDateUpdated() {
		return dateUpdated;
	}
	
	public void setDateUpdated(ZonedDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
		this.dateUpdated = ZonedDateTime.now();
	}
	
	
}
