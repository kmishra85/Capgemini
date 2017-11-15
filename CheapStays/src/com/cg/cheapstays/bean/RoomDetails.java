package com.cg.cheapstays.bean;

import java.sql.Blob;

public class RoomDetails {

	private String hotelId;
	private String roomId;
	private String roomNo; 
	private String roomType;
	private float per_night_rate;
	private String availability;
	private Blob photo;
	
	public RoomDetails() {
	
	}

	public RoomDetails(String hotelId, String roomId, String roomNo,
			String roomType, float per_night_rate, String availability,
			Blob photo) {
		super();
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.per_night_rate = per_night_rate;
		this.availability = availability;
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "RoomDetails [hotelId=" + hotelId + ", roomId=" + roomId
				+ ", roomNo=" + roomNo + ", roomType=" + roomType
				+ ", per_night_rate=" + per_night_rate + ", availability="
				+ availability + ", photo=" + photo + "]";
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public float getPer_night_rate() {
		return per_night_rate;
	}

	public void setPer_night_rate(float per_night_rate) {
		this.per_night_rate = per_night_rate;
	}

	public String isAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	
	
	
}
