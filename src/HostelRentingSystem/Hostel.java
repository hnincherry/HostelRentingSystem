package HostelRentingSystem;

class Hostel {
	
	private String hostelName,roomNo,address; 
	private int price;
	
	public Hostel() {
		this.hostelName = null;
		this.roomNo = null;
		this.address = null;
		this.price = 0;
	}
	
    public Hostel(String hostelName,String roomNo,String address,int price) {
        this.hostelName = hostelName;
        this.roomNo = roomNo;
        this.address = address;
        this.price = price;
    }

    public String getHostelName() {
    	return hostelName;
    }
    
    public void setHostelName(String name) {
    	this.hostelName = name;
    }
    
    public String getRoomNo() {
    	return roomNo;
    }
    
    public void setRoomNo(String roomNumber) {
    	this.roomNo = roomNumber;
    }
    
    public String getAddress() {
    	return address;
    }
    
    public void setAddress(String add) {
    	this.address = add;
    }
    
    public int getPrice() {
    	return price;
    }
    
    public void setPrice(int price) {
    	this.price = price;
    }
    
    @Override
    public String toString() {
        return "<html><h4>Hostel Name = "+hostelName+"</h4><h4>Room No = "+roomNo+"</h4>"+address+"<br>"+price+"</html>";
    }
}
