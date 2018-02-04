package com.mytaxi.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.domainvalue.UsageStatus;

@Entity
@Table(
    name = "car"
)
public class CarDO {

	@Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column
    private Float rating;

    @Column(nullable = false)
    @NotNull(message = "EngineType can not be null!")
    private String engineType;

    @Column(nullable = false)
    @NotNull(message = "SeatCount can not be null!")
    private Integer seatCount;

    @Column
    private Boolean convertible;

    @Column(nullable = false)
    @NotNull(message = "licensePlate can not be null!")
    private String licensePlate;

    @Column(nullable = false)
    @NotNull(message = "manufacturer can not be null!")
    private String manufacturer;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateUpdated = ZonedDateTime.now();
	
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UsageStatus usageStatus;
    
    private CarDO() {
    }

	public CarDO(Float rating, String engineType, Integer seatCount, Boolean convertible, String licensePlate,
			String manufacturer) {
		this.rating = rating;
		this.engineType = engineType;
		this.seatCount = seatCount;
		this.convertible = convertible;
		this.licensePlate = licensePlate;
		this.manufacturer = manufacturer;
		this.dateCreated = ZonedDateTime.now();
		this.dateUpdated = ZonedDateTime.now();
		this.usageStatus = UsageStatus.AVAILABLE;
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
		this.dateUpdated = ZonedDateTime.now();
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
		this.dateUpdated = ZonedDateTime.now();
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
		this.dateUpdated = ZonedDateTime.now();
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
		this.dateUpdated = ZonedDateTime.now();
	}

	public Boolean getConvertible() {
		return convertible;
	}

	public void setConvertible(Boolean convertible) {
		this.convertible = convertible;
		this.dateUpdated = ZonedDateTime.now();
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
		this.dateUpdated = ZonedDateTime.now();
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
		this.dateUpdated = ZonedDateTime.now();
	}

	public ZonedDateTime getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(ZonedDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public UsageStatus getUsageStatus() {
		return usageStatus;
	}

	public void setUsageStatus(UsageStatus usageStatus) {
		this.usageStatus = usageStatus;
		this.dateUpdated = ZonedDateTime.now();
	}
    
}