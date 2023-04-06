package HostelRentingSystem;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
 
public class SqlQuery {
	static Connection con = null;
	static Statement ste;
	static String query,queryUpdate;
	ResultSet rs;
	DBConnection connect = new DBConnection();
 
	public SqlQuery() {
		try {
			con = connect.getConnection();
		} 
		catch(SQLException sqle) {
			System.out.print(sqle);
		} catch(Exception e) {
			System.out.print(e);
		} 
	}
 
	//Insert Query
	public static boolean insertData(String tableName,String[] data) {
		if(tableName.equals("hostel")) {
			query = "insert into hostel(hostelname,buildingno,roomno,smroomcount,state,city,street,userid,gendertype) values('"+data[0]+"','"+data[1]+"','"+data[2]+"',"+data[3]+",'"+data[4]+"','"+data[5]+"','"+data[6]+"',"+data[7]+",'"+data[8]+"')";
		} else if(tableName.equals("room")) {
			query = "insert into room(smroomno,available,price,hostelid) values('"+data[0]+"',"+true+","+data[1]+","+data[2]+")";
		} else if(tableName.equals("user")) {
			query = "insert into user(username,phoneno,nrc,state,city,street,password,roleid,status,gender) values('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"',"+data[7]+",'"+data[8]+"','"+data[9]+"')";
		} else if(tableName.equals("renting")) {
			query = "insert into renting(userid,rentDate) values("+data[0]+",'"+data[1]+"')";
		} else if(tableName.equals("payment")) {
			query = "insert into payment(amount,paymenttype) values("+data[0]+",'"+data[1]+"')";
		} else if(tableName.equals("rentingdetail")) {
			query = "insert into rentingdetail values("+data[0]+","+data[1]+","+data[2]+","+data[3]+",'"+data[4]+"','"+data[5]+"')";
		} else if(tableName.equals("reversion")) {
			query = "insert into reversion(roomid,userid,announcedate,reversedate) values('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"')";
		}
		try {
			ste = con.createStatement();
			if(ste.executeUpdate(query) == 1) {
				return true;
			} else {
				return false;
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
 
	//Check Duplicate
	public boolean isDuplicate(String tableName,String[] data) {
		if(tableName.equals("brand")) {
			query = "select * from brand where brandName='"+data[0]+"'";
		} else if(tableName.equals("type")) {
			query = "select * from type where typeName='"+data[0]+"'";
		} else if(tableName.equals("merchandise")) {
			query = "select * from merchandise where brandId='"+data[0]+"' and typeId='"+data[1]+"'";
		} else if(tableName.equals("itemdetail")) {
			query = "select * from itemdetail where merId='"+data[0]+"' and itemName='"+data[1]+"'";
		} else if(tableName.equals("customer")) {
			query = "select * from customer where customerName='"+data[0]+"' and address='"+data[1]+"' and phoneNo='"+data[2]+"' and email='"+data[3]+"'";
		} else if(tableName.equals("supplier")) {
			query = "select * from supplier where supplierName='"+data[0]+"' and supplierAddress='"+data[1]+"' and supplierPhoneNo='"+data[2]+"' and email='"+data[3]+"'";
		}
		try {
			ste = con.createStatement();
			rs = ste.executeQuery(query);
			if(rs.next()) {
				return true;
			} else {
				return false;
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"SQL Exception",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			return false;
		}
	}
 
	//Get ID for Combobox
	public String[] getID(String tableName) {
		try {
			if(tableName.equals("merchandise")) {
				rs = connect.sqlSelect("merId", "merchandise");
			} else if(tableName.equals("brand")) {
				rs = connect.sqlSelect("brandId", "brand");
			} else if(tableName.equals("type")) {
				rs = connect.sqlSelect("typeId", "type");
			} else if(tableName.equals("supplier")) {
				rs = connect.sqlSelect("supplierId", "supplier");
			} else if(tableName.equals("itemdetail")) {
				rs = connect.sqlSelect("itemId", "itemdetail");
			}
			int rowCount = 0;
			while(rs.next()) {
				rowCount++;
			}
			String[] temp = new String[rowCount];
			rs.beforeFirst();
			int i = 0;
			while(rs.next()) {
				temp[i] = rs.getString(1);
				i++;
			}
			return temp;
		} catch(SQLException sqle) {
			System.out.print(sqle);
			return null;
		} catch(Exception e) {
			System.out.print(e);
			return null;
		}
	}
 
	//Get User ID
	public String getUserId(String phoneNo) {
		try {
			String userId;
			ste = con.createStatement();
			query = "select * from user where phoneno='"+phoneNo+"'";
			rs = ste.executeQuery(query);
			rs.next();
			userId = rs.getString(1);
			return userId;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
 
	//Get Hostel ID
	public String getId(String tableName) {
		try {
			String id;
			ste = con.createStatement();
			if(tableName.equals("hostel")) {
				query = "select hostelid from hostel";
			}
			rs = ste.executeQuery(query);
			rs.last();
			id = rs.getString(1);
			return id;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
	
	//Get ID From Rent,Payment
	public String getRentingDetailId(String tableName) {
		String id;
		try {
			if(tableName.equals("renting")) {
				rs = connect.sqlSelect("rentid", "renting");
			} else if(tableName.equals("payment")) {
				rs = connect.sqlSelect("paymentid", "payment");
			}
				
			rs.last();
			id = rs.getString(1);
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
 
	//Get Item Data
	public String[] getItemData(String itemId) {
		try {
			String[] str = new String[6];
			ste = con.createStatement();
			query = "select * from itemdetail where itemId='"+itemId+"'";
			rs = ste.executeQuery(query);
			//System.out.println("ResultSet => "+ rs);
			if(rs.next()) {
				str[0] = rs.getString(1);//itemId
				str[1] = rs.getString(2);//merId
				str[2] = rs.getString(3);//itemName
				str[3] = rs.getString(4);//salePrice
				str[4] = rs.getString(5);//remark
				str[5] = rs.getString(6);//totalQty
			}
			return str;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
 
	//Get User Info
		public String[] getUserInfo(String phoneNo,String password) {
			try {
				String[] str = new String[5];
				ste = con.createStatement();
				query = "select * from user where phoneno='"+phoneNo+"' and password='"+password+"' and status='active'";
				rs = ste.executeQuery(query);
				
				if(rs.next()) {
					str[0] = rs.getString(3);//phoneNo
					//str[3] = rs.getString(4);//nrc
					//str[4] = rs.getString(5);//state
					//str[5] = rs.getString(6);//city
					//str[6] = rs.getString(7);//street
					str[1] = rs.getString(8);//password
					str[2] = rs.getString(9);//roleid
					str[3] = rs.getString(1);//userId
					str[4] = rs.getString(2);//userName
					//str[9] = rs.getString(10);//status
					//str[10] = rs.getString(11);//gender
				}
				return str;
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				return null;
			}
		}
		
	//Get Data for Seeker Profile
	public String[] getSeekerProfile(String phoneno,String password) {
		try {
			String[] seekerData = new String[9];
			ste = con.createStatement();
			query = "select hostelname,buildingno,roomno,smroomno,hostel.state,hostel.city,hostel.street,startdate,enddate,rentingdetail.userid,price from renting,rentingdetail,hostel,room,user where rentingdetail.roomid=room.roomid and room.hostelid=hostel.hostelid and renting.rentid=rentingdetail.rentid and renting.userid=user.userid and phoneno='"+phoneno+"' and password='"+password+"'";
			rs = ste.executeQuery(query);
			if(rs.last()) {
				seekerData[0] = rs.getString(1);//hostelname
				seekerData[1] = rs.getString(2);//buildingno
				seekerData[2] = rs.getString(3);//roomno
				seekerData[3] = rs.getString(4);//smroomno
				seekerData[4] = rs.getString(5) + " Street/"+rs.getString(6)+"/"+rs.getString(7);//street/city/state
				seekerData[5] = rs.getString(8);//startdate
				seekerData[6] = rs.getString(9);//enddate
				seekerData[7] = rs.getString(10);//owner id
				seekerData[8] = rs.getString(11);//price
			}
			return seekerData;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
	
	//Get Hostel Data
	public ArrayList<String[]> getHostelData() {
		try {
			ArrayList<String[]> hostelList = new ArrayList<String[]>();
			ste = con.createStatement();
			query = "select hostelname,smroomno,hostel.street,hostel.city,hostel.state,price,gendertype,username,phoneno,room.roomid from hostel,room,user where hostel.hostelid=room.hostelid and hostel.userid=user.userid and user.roleid=3 and available=true";
			rs = ste.executeQuery(query);
			
			while(rs.next()) {
				String[] str = new String[8];
				str[0] = rs.getString(1);//hostelname
				str[1] = rs.getString(2);//smroomno
				str[2] = rs.getString(3) +" Street/"+ rs.getString(4) +"/"+ rs.getString(5);//street/city/state
				str[3] = rs.getString(6);//price
				str[4] = rs.getString(7);//gendertype
				str[5] = rs.getString(8);//owner username
				str[6] = rs.getString(9);//owner password
				str[7] = rs.getString(10);//roomid
				hostelList.add(str);
				//System.out.println("ResultSet => "+ rs.getString(2));
			}
			
			return hostelList;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
	
	//Update Room Available
	public boolean updateRoom(String roomId,boolean flag) throws SQLException {
		try {
			String query = "update room set available="+flag+" where roomid="+roomId+"";
			boolean update = connect.executeSql(query);
			if(update) {
				System.out.println("Room Update Success");
			}
			return update;
		} catch(Exception e) {
			System.out.print(e);
			return false;
		}		
	}
	
	//Get OwnerName 
	public String[] getOwnerData(String userId) {
		try {
			String[] data = new String[2];
			ste = con.createStatement();
			query = "select username,phoneno from user where userid='"+userId+"'";
			rs = ste.executeQuery(query);
			if(rs.next()) {
				data[0] = rs.getString(1);//ownername
				data[1] = rs.getString(2);//phoneno
				System.out.println("Stay Data => "+data[0]+"////"+data[1]);
			}
			return data;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
	
	//Get Room Id According to roomNo 
		public String getRoomId(String roomNo) {
			try {
				String roomId;
				ste = con.createStatement();
				query = "select roomId from room where smroomno='"+roomNo+"'";
				rs = ste.executeQuery(query);
				rs.next();
				roomId = rs.getString(1);
				return roomId;
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				return null;
			}
		}
		
	//Get Password According to phoneNo 
		public String getPassword(String phoneNo) {
			try {
				String password;
				ste = con.createStatement();
				query = "select password from user where phoneno='"+phoneNo+"'";
				rs = ste.executeQuery(query);
				rs.next();
				password = rs.getString(1);
				return password;
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				return null;
			}
		}

}
