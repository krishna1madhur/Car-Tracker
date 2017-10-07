package io.egen.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Tires {
	private double frontLeft;
	private double frontRight;
	private double rearLeft;
	private double rearRight;

	public double getFrontLeft() {
		return frontLeft;
	}

	public void setFrontLeft(double frontLeft) {
		this.frontLeft = frontLeft;
	}

	public double getFrontRight() {
		return frontRight;
	}

	public void setFrontRight(double frontRight) {
		this.frontRight = frontRight;
	}

	public double getRearLeft() {
		return rearLeft;
	}

	public void setRearLeft(double rearLeft) {
		this.rearLeft = rearLeft;
	}

	public double getRearRight() {
		return rearRight;
	}

	public void setRearRight(double rearRight) {
		this.rearRight = rearRight;
	}

	@Override
	public String toString() {
		return "Tires [frontLeft=" + frontLeft + ", frontRight=" + frontRight + ", rearLeft=" + rearLeft
				+ ", rearRight=" + rearRight + "]";
	}
}
