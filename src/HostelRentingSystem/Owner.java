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
import java.util.ArrayList;
import java.util.List;

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
	SqlQuery sqlquery = new SqlQuery();
	List<String[]> freeDataList = new ArrayList<>();
	
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
        tblFree.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int row = tblFree.getSelectedRow();
        		if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete small room?","Confirm Deleting",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					sqlquery.deleteRoom(tblFree.getValueAt(row, 6).toString());	
					fillFreeData(userId);
        			//System.out.println("Small Romm No => "+tblFree.getValueAt(row, 6));
				}
        	}
        });
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
		tblHostel.setModel(tblAllModel);
		setColumnWidth(0,50,tblHostel);
		setColumnWidth(1,30,tblHostel);
		setColumnWidth(2,30,tblHostel);
		setColumnWidth(3,40,tblHostel);
		setColumnWidth(4,20,tblHostel);
		setColumnWidth(5,50,tblHostel);
		setColumnWidth(6,40,tblHostel);
	}
    
    public void createRentTable() {
    	tblRentModel.addColumn("Hostel Name");
    	tblRentModel.addColumn("State");
    	tblRentModel.addColumn("City");
    	tblRentModel.addColumn("Street");
    	tblRentModel.addColumn("Building No:");
    	tblRentModel.addColumn("Room No:");
    	tblRentModel.addColumn("Small Room No:");
    	tblRentModel.addColumn("Seeker Name");
    	tblRentModel.addColumn("Phone No");
    	tblRent.setModel(tblRentModel);
    	setColumnWidth(0,50,tblRent);
		setColumnWidth(1,30,tblRent);
		setColumnWidth(2,30,tblRent);
		setColumnWidth(3,30,tblRent);
		setColumnWidth(4,30,tblRent);
		setColumnWidth(5,45,tblRent);
		setColumnWidth(6,45,tblRent);
		setColumnWidth(7,30,tblRent);
		setColumnWidth(8,40,tblRent);
	}
    
    public void createFreeTable() {
    	tblFreeModel.addColumn("Hostel Name");
    	tblFreeModel.addColumn("State");
    	tblFreeModel.addColumn("City");
    	tblFreeModel.addColumn("Street");
    	tblFreeModel.addColumn("Building No:");
    	tblFreeModel.addColumn("Room No:");
    	tblFreeModel.addColumn("Small Room No:");
    	tblFreeModel.addColumn("Gender Type");
		tblFree.setModel(tblFreeModel);
		setColumnWidth(0,50,tblFree);
		setColumnWidth(1,30,tblFree);
		setColumnWidth(2,30,tblFree);
		setColumnWidth(3,40,tblFree);
		setColumnWidth(4,20,tblFree);
		setColumnWidth(5,50,tblFree);
		setColumnWidth(6,40,tblFree);
		setColumnWidth(7,30,tblFree);
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
				tblAllModel.addRow(hostelData);
			}
			tblHostel.setModel(tblAllModel);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void fillRentData(String ownerId) {		
		String[] rentData = new String[9];		
		try {
			Statement ste = con.createStatement();
			String query = "select hostelname,hostel.state,hostel.city,hostel.street,hostel.buildingno,hostel.roomno,room.smroomno,user.username,user.phoneno from renting,rentingdetail,user,room,hostel where room.hostelid=hostel.hostelid and rentingdetail.roomid=room.roomid and renting.rentid=rentingdetail.rentid and renting.userid=user.userid and rentingdetail.userid="+ownerId+"";
			ResultSet rs = ste.executeQuery(query);
			while(rs.next()) {
				rentData[0] = rs.getString(1);// hostelname
				rentData[1] = rs.getString(2);// state
				rentData[2] = rs.getString(3);// city
				rentData[3] = rs.getString(4);// street
				rentData[4] = rs.getString(5);// buildingno
				rentData[5] = rs.getString(6);// roomno
				rentData[6] = rs.getString(7);// smroomno
				rentData[7] = rs.getString(8);// seeker name
				rentData[8] = rs.getString(9);//seeker phoneno
				tblRentModel.addRow(rentData);
			}
			tblRent.setModel(tblRentModel);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void fillFreeData(String ownerId) {	
		freeDataList.clear();
		try {
			Statement ste = con.createStatement();
			String query = "select hostelname,hostel.state,hostel.city,hostel.street,hostel.buildingno,hostel.roomno,room.smroomno,hostel.gendertype from user,room,hostel where room.hostelid=hostel.hostelid and hostel.userid=user.userid and room.available=true and hostel.userid="+ownerId+"";
			ResultSet rs = ste.executeQuery(query);
			while(rs.next()) {
				String[] freeData = new String[8];		
				freeData[0] = rs.getString(1);// hostelname
				freeData[1] = rs.getString(2);// state
				freeData[2] = rs.getString(3);// city
				freeData[3] = rs.getString(4);// street
				freeData[4] = rs.getString(5);// buildingno
				freeData[5] = rs.getString(6);// roomno
				freeData[6] = rs.getString(7);// smroomno
				freeData[7] = rs.getString(8);//gender type	
				freeDataList.add(freeData);
				
			}
			bindFreeTableData(freeDataList);
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void bindFreeTableData(List<String[]> freeDataList) {
		tblFreeModel.setRowCount(0);
		// TODO Auto-generated method stub
		for(String[] data: freeDataList) {
			tblFreeModel.addRow(data);
		}
		tblFree.setModel(tblFreeModel);
	}
}
