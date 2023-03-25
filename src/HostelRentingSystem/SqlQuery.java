package HostelRentingSystem;

import java.sql.*;
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
		if(tableName.equals("brand")) {
			query = "insert into brand values('"+data[0]+"','"+data[1]+"')";
		} else if(tableName.equals("type")) {
			query = "insert into type(typeId,typeName) values('"+data[0]+"','"+data[1]+"')";
		} else if(tableName.equals("merchandise")) {
			query = "insert into merchandise values('"+data[0]+"','"+data[1]+"','"+data[2]+"')";
		} else if(tableName.equals("itemdetail")) {
			query = "insert into itemdetail values('"+data[0]+"','"+data[1]+"','"+data[2]+"',0,'"+data[3]+"',0)";
		} else if(tableName.equals("customer")) {
			query = "insert into customer values('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"')";
		} else if(tableName.equals("supplier")) {
			query = "insert into supplier values('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"')";
		} else if(tableName.equals("purchase")) {
			int date = data[2].indexOf("(");
			query = "insert into purchase values('"+data[0]+"','"+data[1]+"','"+data[2].substring(0,date)+"')";
		} else if(tableName.equals("purchasedetail")) {
			query = "insert into purchasedetail values('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"')";
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
 
	//Get Merchandise Data
	public String[] getMerchandiseData(String merId) {
		try {
			String[] str = new String[2];
			ste = con.createStatement();
			query = "select * from merchandise where merId='"+merId+"'";
			rs = ste.executeQuery(query);
			rs.next();
			str[0] = rs.getString(2);//brandId
			str[1] = rs.getString(3);//typeID
			return str;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
 
	//Get Supplier Data
	public String[] getSupplierData(String supId) {
		try {
			String[] str = new String[4];
			ste = con.createStatement();
			query = "select * from supplier where supplierId='"+supId+"'";
			rs = ste.executeQuery(query);
			rs.next();
			str[0] = rs.getString(2);
			str[1] = rs.getString(3);
			str[2] = rs.getString(4);
			str[3] = rs.getString(5);
			return str;
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
 
	//Get Hostel Data
	public String[] getHostelData() {
		try {
			String[] str = new String[4];
			ste = con.createStatement();
			query = "select hostelname,smroomno,city,price from hostel,room where hostel.hostelid=room.hostelid";
			rs = ste.executeQuery(query);
			
			while(rs.next()) {
				str[0] = rs.getString(1);//hostelname
				str[1] = rs.getString(2);//smroomno
				str[2] = rs.getString(3);//city
				str[3] = rs.getString(4);//price
				System.out.println("ResultSet => "+ rs.getString(2));
			}
			
			return str;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
}
