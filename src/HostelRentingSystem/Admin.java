package HostelRentingSystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin extends JDialog {
	private JTable tblOwner,tblSeeker;
	DefaultTableModel tblOwnerModel = new DefaultTableModel();
	DefaultTableModel tblSeekerModel = new DefaultTableModel();
	DBConnection connect = new DBConnection();
	Connection con = null;
	
    public Admin() {
        setTitle("Admin Panel");
        setSize(800, 500);
        try {
			con = connect.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();

        JPanel panel2 = new JPanel();

        tabbedPane.addTab("Owner", null, panel1, "Owner");
        panel1.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 759, 411);
        panel1.add(scrollPane);
        
        tblOwner = new JTable();
        tblOwner.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        	}
        });
        scrollPane.setViewportView(tblOwner);
        
        tabbedPane.addTab("Seeker", null, panel2, "Seeker");
        panel2.setLayout(null);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 11, 759, 411);
        panel2.add(scrollPane_2);
        
        tblSeeker = new JTable();
        scrollPane_2.setViewportView(tblSeeker);      

        getContentPane().add(tabbedPane);

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        createOwnerTable();
        createSeekerTable();
        
//        fillHostelData(userId);
//        fillRentData(userId);
//        fillFreeData(userId);
    }

    public void createOwnerTable() {
    	tblOwnerModel.addColumn("Owner Name");
    	tblOwnerModel.addColumn("Phone No");
    	tblOwnerModel.addColumn("Nrc");
    	tblOwnerModel.addColumn("Password");
    	tblOwnerModel.addColumn("Status");
		tblOwner.setModel(tblOwnerModel);
		setColumnWidth(0,40,tblOwner);
		setColumnWidth(0,40,tblOwner);
		setColumnWidth(2,40,tblOwner);
		setColumnWidth(3,40,tblOwner);
		setColumnWidth(4,20,tblOwner);
	}
    
    public void createSeekerTable() {
    	tblSeekerModel.addColumn("Seeker Name");
    	tblSeekerModel.addColumn("Phone No");
    	tblSeekerModel.addColumn("Nrc");
    	tblSeekerModel.addColumn("Password");
    	tblSeekerModel.addColumn("Status");
		tblSeeker.setModel(tblSeekerModel);
		setColumnWidth(0,40,tblSeeker);
		setColumnWidth(0,40,tblSeeker);
		setColumnWidth(2,40,tblSeeker);
		setColumnWidth(3,40,tblSeeker);
		setColumnWidth(4,20,tblSeeker);
	}
    
	public void setColumnWidth(int index,int width,JTable tableName) {
		DefaultTableColumnModel columnModel = (DefaultTableColumnModel)tableName.getColumnModel();
		TableColumn tc = columnModel.getColumn(index);
		tc.setPreferredWidth(width);
	}
    
//	public void fillHostelData(String ownerId) {		
//		String[] hostelData = new String[8];		
//		try {
//			Statement ste = con.createStatement();
//			String query = "select * from hostel where userid='"+ownerId+"'";
//			ResultSet rs = ste.executeQuery(query);
//			while(rs.next()) {
//				hostelData[0] = rs.getString(2);//hostelName
//				hostelData[1] = rs.getString(3);//Building No
//				hostelData[2] = rs.getString(4);//Room No
//				hostelData[3] = rs.getString(6);//State
//				hostelData[4] = rs.getString(7);//City
//				hostelData[5] = rs.getString(8);//Street
//				hostelData[6] = rs.getString(10);//Gender Type
//				hostelData[7] = "Edit";
//				tblAllModel.addRow(hostelData);
//			}
//			tblHostel.setModel(tblAllModel);
//		}catch(SQLException e) {
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		}
//	}
//	
//	public void fillRentData(String ownerId) {		
//		String[] rentData = new String[8];		
//		try {
//			Statement ste = con.createStatement();
//			String query = "select hostel.state,hostel.city,hostel.street,hostel.buildingno,hostel.roomno,room.smroomno,user.username,user.phoneno from renting,rentingdetail,user,room,hostel where room.hostelid=hostel.hostelid and rentingdetail.roomid=room.roomid and renting.rentid=rentingdetail.rentid and renting.userid=user.userid and rentingdetail.userid="+ownerId+"";
//			ResultSet rs = ste.executeQuery(query);
//			while(rs.next()) {
//				rentData[0] = rs.getString(1);//state
//				rentData[1] = rs.getString(2);//city
//				rentData[2] = rs.getString(3);//street
//				rentData[3] = rs.getString(4);//buildingno
//				rentData[4] = rs.getString(5);//roomno
//				rentData[5] = rs.getString(6);//smroomno
//				rentData[6] = rs.getString(7);//seeker name
//				rentData[7] = rs.getString(8);//seeker phoneno
//				tblRentModel.addRow(rentData);
//			}
//			tblRent.setModel(tblRentModel);
//		}catch(SQLException e) {
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		}
//	}
//	
//	public void fillFreeData(String ownerId) {		
//		String[] freeData = new String[7];		
//		try {
//			Statement ste = con.createStatement();
//			String query = "select hostel.state,hostel.city,hostel.street,hostel.buildingno,hostel.roomno,room.smroomno,hostel.gendertype from user,room,hostel where room.hostelid=hostel.hostelid and hostel.userid=user.userid and room.available=true and hostel.userid="+ownerId+"";
//			ResultSet rs = ste.executeQuery(query);
//			while(rs.next()) {
//				freeData[0] = rs.getString(1);//state
//				freeData[1] = rs.getString(2);//city
//				freeData[2] = rs.getString(3);//street
//				freeData[3] = rs.getString(4);//buildingno
//				freeData[4] = rs.getString(5);//roomno
//				freeData[5] = rs.getString(6);//smroomno
//				freeData[6] = rs.getString(7);//gender type
//				
//				tblFreeModel.addRow(freeData);
//			}
//			tblFree.setModel(tblFreeModel);
//		}catch(SQLException e) {
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		}
//	}
}
