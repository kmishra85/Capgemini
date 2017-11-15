package com.cg.cheapstays.bean;

public class HotelDetails {

	
	private String hotelId;
	private String city;
	private String hotelName;
	private String address;
	private String description;
	private float avgRatePerNight; 
	private String phoneNo1;
	private String phoneNo2;
	private String rating; 
	private String email;
	private String fax;
	
	public HotelDetails() {
	
	}
	
	
	
	

	public HotelDetails(String hotelId, String hotelName) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
	}





	public HotelDetails(String hotelId, String city, String hotelName,
			String address, String description, float avgRatePerNight,
			String phoneNo1, String phoneNo2, String rating, String email,
			String fax) {
		super();
		this.hotelId = hotelId;
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerNight = avgRatePerNight;
		this.phoneNo1 = phoneNo1;
		this.phoneNo2 = phoneNo2;
		this.rating = rating;
		this.email = email;
		this.fax = fax;
	}



	public HotelDetails(String city, String hotelName,
			String address, String description, float avgRatePerNight,
			String phoneNo1, String phoneNo2, String rating, String email,
			String fax) {
		super();
		
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerNight = avgRatePerNight;
		this.phoneNo1 = phoneNo1;
		this.phoneNo2 = phoneNo2;
		this.rating = rating;
		this.email = email;
		this.fax = fax;
	}

	@Override
	public String toString() {
		return "HotelDetails [hotelId=" + hotelId + ", city=" + city
				+ ", hotelName=" + hotelName + ", address=" + address
				+ ", description=" + description + ", avgRatePerNight="
				+ avgRatePerNight + ", phoneNo1=" + phoneNo1 + ", phoneNo2="
				+ phoneNo2 + ", rating=" + rating + ", email=" + email
				+ ", fax=" + fax + "]";
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAvgRatePerNight() {
		return avgRatePerNight;
	}

	public void setAvgRatePerNight(float avgRatePerNight) {
		this.avgRatePerNight = avgRatePerNight;
	}

	public String getPhoneNo1() {
		return phoneNo1;
	}

	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}

	public String getPhoneNo2() {
		return phoneNo2;
	}

	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
	
	
	
}
