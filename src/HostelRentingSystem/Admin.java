package HostelRentingSystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Admin extends JTabbedPane {
	private JTable tblOwner,tblSeeker;
	
	DefaultTableModel tblOwnerModel = new DefaultTableModel();
	DefaultTableModel tblSeekerModel = new DefaultTableModel();
	
	public Admin() {
        super(JTabbedPane.LEFT);
        setPreferredSize(new Dimension(800, 500)); // set preferred size of tabbed pane
        
        //tblOwner = new JTable();
        // add tabs     
        JScrollPane scrollPane = new JScrollPane();
        addTab("Owner", null, scrollPane, null);
        
        tblOwner = new JTable();
        scrollPane.setViewportView(tblOwner);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        addTab("Seeker", null, scrollPane_1, null);
        
        tblSeeker = new JTable();
        scrollPane_1.setViewportView(tblSeeker);
        createOwnerTable();
        createSeekerTable();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Admin Panel");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new Admin());
                frame.setLocationRelativeTo(null);
        		frame.setBounds(380, 120, 600, 500);
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });
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
}
