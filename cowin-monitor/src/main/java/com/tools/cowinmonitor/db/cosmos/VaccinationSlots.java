package com.tools.cowinmonitor.db.cosmos;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;

@Container(containerName = "vaccine")
public class VaccinationSlots {
	
	@Id
	private String id;
	
	private String vaccine_count;
	
	private String center_name;
	
	private String dose_value;
	
	
	private int hourValue;
	
	private int minuteValue;
	
	private int vaccineCountAvg;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVaccine_count() {
		return vaccine_count;
	}

	public void setVaccine_count(String vaccine_count) {
		this.vaccine_count = vaccine_count;
	}

	public String getCenter_name() {
		return center_name;
	}

	public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}

	public String getDose_value() {
		return dose_value;
	}

	public void setDose_value(String dose_value) {
		this.dose_value = dose_value;
	}

	public int getHourValue() {
		return hourValue;
	}

	public void setHourValue(int hourValue) {
		this.hourValue = hourValue;
	}

	public int getMinuteValue() {
		return minuteValue;
	}

	public void setMinuteValue(int minuteValue) {
		this.minuteValue = minuteValue;
	}

	public int getVaccineCountAvg() {
		return vaccineCountAvg;
	}

	public void setvaccineCountAvg(int vaccineCountAvg) {
		this.vaccineCountAvg = vaccineCountAvg;
	}
	
	public VaccinationSlots() {
		
	}

	public VaccinationSlots(String id, String vaccine_count, String center_name, String dose_value, int hourValue,
			int minuteValue, int vaccineCountAvg) {
		super();
		this.id = id;
		this.vaccine_count = vaccine_count;
		this.center_name = center_name;
		this.dose_value = dose_value;
		this.hourValue = hourValue;
		this.minuteValue = minuteValue;
		this.vaccineCountAvg = vaccineCountAvg;
	}
	
	
	
	
}
