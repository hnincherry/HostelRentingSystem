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
	public String[] getIDForChoice(String tableName) {
 
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
 
	//Get Brand Name
	public String getBrandName(String brandId) {
		try {
			String brandName;
			ste = con.createStatement();
			query = "select * from brand where brandId='"+brandId+"'";
			rs = ste.executeQuery(query);
			rs.next();
			brandName = rs.getString(2);
			return brandName;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
 
	//Get Type Name
	public String getTypeName(String typeId) {
		try {
			String typeName;
			ste = con.createStatement();
			query = "select * from type where typeId='"+typeId+"'";
			rs = ste.executeQuery(query);
			rs.next();
			typeName = rs.getString(2);
			return typeName;
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
				String[] str = new String[3];
				ste = con.createStatement();
				query = "select * from user where phoneno='"+phoneNo+"' and password='"+password+"' and status='active'";
				rs = ste.executeQuery(query);
				
				if(rs.next()) {
					//str[0] = rs.getString(1);//userId
					//str[1] = rs.getString(2);//userName
					str[0] = rs.getString(3);//phoneNo
					//str[3] = rs.getString(4);//nrc
					//str[4] = rs.getString(5);//state
					//str[5] = rs.getString(6);//city
					//str[6] = rs.getString(7);//street
					str[1] = rs.getString(8);//password
					str[2] = rs.getString(9);//roleid
					//str[9] = rs.getString(10);//status
					//str[10] = rs.getString(11);//gender
				}
				return str;
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
			query = "select hostelname,smroomno,city,price from hostel,room where hostel.hostelid=room.hostelid";
			rs = ste.executeQuery(query);
			
			while(rs.next()) {
				String[] str = new String[4];
				str[0] = rs.getString(1);//hostelname
				str[1] = rs.getString(2);//smroomno
				str[2] = rs.getString(3);//city
				str[3] = rs.getString(4);//price
				hostelList.add(str);
				System.out.println("ResultSet => "+ rs.getString(2));
			}
			
			return hostelList;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
	

}
