package io.egen.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Alert {

	public enum Priority {
		HIGH, MEDIUM, LOW;
	}

	public enum AlertType {
		FUELVOLUME, SPEED, ENGINEHP, ENGINELIGHTSON, ENGINECOOLANTLOW, CRUISECONTROLON, ENGINERPM, TIREPRESSURE;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long alertId;

	@OneToOne
	private Reading reading;

	@OneToOne
	private Vehicle vehicle;

	@Enumerated(EnumType.STRING)
	private Priority priorityValue;

	@Enumerated(EnumType.STRING)
	private AlertType alertType;

	public Priority getPriorityValue() {
		return priorityValue;
	}

	public AlertType getAlertType() {
		return alertType;
	}

	public void setAlertType(AlertType alertType) {
		this.alertType = alertType;
	}

	public void setPriorityValue(Priority priorityValue) {
		this.priorityValue = priorityValue;
	}

	public long getAlertId() {
		return alertId;
	}

	public void setAlertId(long alertId) {
		this.alertId = alertId;
	}

	public Reading getReading() {
		return reading;
	}

	public void setReading(Reading reading) {
		this.reading = reading;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Alert [alertId=" + alertId + ", reading=" + reading + ", vehicle=" + vehicle + ", priorityValue="
				+ priorityValue + ", alertType=" + alertType + "]";
	}
}
