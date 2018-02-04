package com.mytaxi.datatransferobject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mytaxi.domainvalue.UsageStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {
	@JsonIgnore
    private Long id;

    private Float rating;

    @NotNull(message = "Each car has known engineType!")
    private String engineType;

    @NotNull(message = "seatCount can not be null!")
    private Integer seatCount;

    private Boolean convertible;

    @NotNull(message = "licensePlate can not be null!")
    private String licensePlate;

    @NotNull(message = "manufacturer can not be null!")
    private ManufacturerDTO manufacturer;
    
    @NotNull(message = "UsageStatus can not be null!")
    private UsageStatus usageStatus;
    
    public CarDTO() {
	}
    
    public CarDTO(Long id, Float rating, String engineType, Integer seatCount, Boolean convertible, String licensePlate,
    		ManufacturerDTO manufacturer, UsageStatus usageStatus) {
		this.id = id;
		this.rating = rating;
		this.engineType = engineType;
		this.seatCount = seatCount;
		this.convertible = convertible;
		this.licensePlate = licensePlate;
		this.manufacturer = manufacturer;
		this.usageStatus = usageStatus;
	}
    
    public static CarDTOBuilder newBuilder() {
    	return new CarDTOBuilder();
    }

	@JsonProperty
    public Long getId()
    {
        return id;
    }

	public Float getRating() {
		return rating;
	}

	public String getEngineType() {
		return engineType;
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public Boolean getConvertible() {
		return convertible;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public ManufacturerDTO getManufacturer() {
		return manufacturer;
	}
	
	public UsageStatus getUsageStatus() {
		return usageStatus;
	}
	
	public static class CarDTOBuilder {
		private Long id;
	    private Float rating;
	    private String engineType;
	    private Integer seatCount;
	    private Boolean convertible;
	    private String licensePlate;
	    private ManufacturerDTO manufacturer;
	    private UsageStatus usageStatus;
	    
	    public CarDTOBuilder setId(Long id) {
	    	this.id = id;
	    	return this;
	    }

		public CarDTOBuilder setRating(Float rating) {
			this.rating = rating;
	    	return this;
		}

		public CarDTOBuilder setEngineType(String engineType) {
			this.engineType = engineType;
	    	return this;
		}

		public CarDTOBuilder setSeatCount(Integer seatCount) {
			this.seatCount = seatCount;
	    	return this;
		}

		public CarDTOBuilder setConvertible(Boolean convertible) {
			this.convertible = convertible;
	    	return this;
		}

		public CarDTOBuilder setLicensePlate(String licensePlate) {
			this.licensePlate = licensePlate;
	    	return this;
		}

		public CarDTOBuilder setManufacturer(ManufacturerDTO manufacturer) {
			this.manufacturer = manufacturer;
	    	return this;
		}
		
		public CarDTOBuilder setUsageStatus(UsageStatus usageStatus) {
			this.usageStatus = usageStatus;
			return this;
		}
		
		public CarDTO createCarDTO() {
			return new CarDTO(id, rating, engineType, seatCount, convertible, licensePlate, manufacturer, usageStatus);
		}
	    
	}

    
}
