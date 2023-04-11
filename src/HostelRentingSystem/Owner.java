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

public class Owner extends JDialog {
	private JTable tblHostel;
	private JTable tblBook;
	private JTable tblRent;
	private JTable tblFree;
	DefaultTableModel tblAllModel = new DefaultTableModel();
	DefaultTableModel tblRentModel = new DefaultTableModel();
	DefaultTableModel tblFreeModel = new DefaultTableModel();
	DBConnection connect = new DBConnection();
	Connection con = null;
	
    public Owner(String userId) {
        setTitle("Owner Panel");
        setSize(800, 500);
        try {
			con = connect.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();

        JPanel panel3 = new JPanel();
        
        JPanel panel4 = new JPanel();

        tabbedPane.addTab("All", null, panel1, "All");
        panel1.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 759, 411);
        panel1.add(scrollPane);
        
        tblHostel = new JTable();
        tblHostel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int row = tblHostel.getSelectedRow();
        		if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Confirm Existing",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					dispose();
					
				}
        	}
        });
        scrollPane.setViewportView(tblHostel);
        
        tabbedPane.addTab("Rent", null, panel3, "Rent");
        panel3.setLayout(null);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 11, 759, 411);
        panel3.add(scrollPane_2);
        
        tblRent = new JTable();
        scrollPane_2.setViewportView(tblRent);
        tabbedPane.addTab("Free", null, panel4, "Free");
        panel4.setLayout(null);
        
        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(10, 11, 759, 411);
        panel4.add(scrollPane_3);
        
        tblFree = new JTable();
        scrollPane_3.setViewportView(tblFree);

        getContentPane().add(tabbedPane);

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        createAllTable();
        createRentTable();
        createFreeTable();
        
        fillHostelData(userId);
        fillRentData(userId);
        fillFreeData(userId);
    }

    public void createAllTable() {
    	tblAllModel.addColumn("Hostel Name");
    	tblAllModel.addColumn("Building No:");
    	tblAllModel.addColumn("Room No:");
    	tblAllModel.addColumn("State");
    	tblAllModel.addColumn("City");
    	tblAllModel.addColumn("Street");
    	tblAllModel.addColumn("Gender Type");
    	tblAllModel.addColumn("Action");
		tblHostel.setModel(tblAllModel);
		setColumnWidth(0,50,tblHostel);
		setColumnWidth(1,30,tblHostel);
		setColumnWidth(2,30,tblHostel);
		setColumnWidth(3,40,tblHostel);
		setColumnWidth(4,20,tblHostel);
		setColumnWidth(5,50,tblHostel);
		setColumnWidth(6,40,tblHostel);
		setColumnWidth(7,30,tblHostel);
	}
    
    public void createRentTable() {
    	tblRentModel.addColumn("State");
    	tblRentModel.addColumn("City");
    	tblRentModel.addColumn("Street");
    	tblRentModel.addColumn("Building No:");
    	tblRentModel.addColumn("Room No:");
    	tblRentModel.addColumn("Small Room No:");
    	tblRentModel.addColumn("Seeker Name");
    	tblRentModel.addColumn("Phone No");
    	tblRentModel.addColumn("Action");
    	tblRent.setModel(tblRentModel);
		setColumnWidth(0,40,tblRent);
		setColumnWidth(1,20,tblRent);
		setColumnWidth(2,50,tblRent);
		setColumnWidth(3,30,tblRent);
		setColumnWidth(4,30,tblRent);
		setColumnWidth(5,55,tblRent);
		setColumnWidth(6,50,tblRent);
		setColumnWidth(7,50,tblRent);
		setColumnWidth(8,40,tblRent);
	}
    
    public void createFreeTable() {
    	tblFreeModel.addColumn("State");
    	tblFreeModel.addColumn("City");
    	tblFreeModel.addColumn("Street");
    	tblFreeModel.addColumn("Building No:");
    	tblFreeModel.addColumn("Room No:");
    	tblFreeModel.addColumn("Small Room No:");
    	tblFreeModel.addColumn("Gender Type");
		tblFree.setModel(tblFreeModel);
		setColumnWidth(0,40,tblFree);
		setColumnWidth(0,40,tblFree);
		setColumnWidth(2,40,tblFree);
		setColumnWidth(3,40,tblFree);
		setColumnWidth(4,20,tblFree);
		setColumnWidth(5,50,tblFree);
		setColumnWidth(5,50,tblFree);
	}
    
	public void setColumnWidth(int index,int width,JTable tableName) {
		DefaultTableColumnModel columnModel = (DefaultTableColumnModel)tableName.getColumnModel();
		TableColumn tc = columnModel.getColumn(index);
		tc.setPreferredWidth(width);
	}
    
	public void fillHostelData(String ownerId) {		
		String[] hostelData = new String[8];		
		try {
			Statement ste = con.createStatement();
			String query = "select * from hostel where userid='"+ownerId+"'";
			ResultSet rs = ste.executeQuery(query);
			while(rs.next()) {
				hostelData[0] = rs.getString(2);//hostelName
				hostelData[1] = rs.getString(3);//Building No
				hostelData[2] = rs.getString(4);//Room No
				hostelData[3] = rs.getString(6);//State
				hostelData[4] = rs.getString(7);//City
				hostelData[5] = rs.getString(8);//Street
				hostelData[6] = rs.getString(10);//Gender Type
				hostelData[7] = "Edit";
				tblAllModel.addRow(hostelData);
			}
			tblHostel.setModel(tblAllModel);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void fillRentData(String ownerId) {		
		String[] rentData = new String[8];		
		try {
			Statement ste = con.createStatement();
			String query = "select hostel.state,hostel.city,hostel.street,hostel.buildingno,hostel.roomno,room.smroomno,user.username,user.phoneno from renting,rentingdetail,user,room,hostel where room.hostelid=hostel.hostelid and rentingdetail.roomid=room.roomid and renting.rentid=rentingdetail.rentid and renting.userid=user.userid and rentingdetail.userid="+ownerId+"";
			ResultSet rs = ste.executeQuery(query);
			while(rs.next()) {
				rentData[0] = rs.getString(1);//state
				rentData[1] = rs.getString(2);//city
				rentData[2] = rs.getString(3);//street
				rentData[3] = rs.getString(4);//buildingno
				rentData[4] = rs.getString(5);//roomno
				rentData[5] = rs.getString(6);//smroomno
				rentData[6] = rs.getString(7);//seeker name
				rentData[7] = rs.getString(8);//seeker phoneno
				tblRentModel.addRow(rentData);
			}
			tblRent.setModel(tblRentModel);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void fillFreeData(String ownerId) {		
		String[] freeData = new String[7];		
		try {
			Statement ste = con.createStatement();
			String query = "select hostel.state,hostel.city,hostel.street,hostel.buildingno,hostel.roomno,room.smroomno,hostel.gendertype from user,room,hostel where room.hostelid=hostel.hostelid and hostel.userid=user.userid and room.available=true and hostel.userid="+ownerId+"";
			ResultSet rs = ste.executeQuery(query);
			while(rs.next()) {
				freeData[0] = rs.getString(1);//state
				freeData[1] = rs.getString(2);//city
				freeData[2] = rs.getString(3);//street
				freeData[3] = rs.getString(4);//buildingno
				freeData[4] = rs.getString(5);//roomno
				freeData[5] = rs.getString(6);//smroomno
				freeData[6] = rs.getString(7);//gender type
				
				tblFreeModel.addRow(freeData);
			}
			tblFree.setModel(tblFreeModel);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
