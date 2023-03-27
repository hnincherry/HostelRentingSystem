package HostelRentingSystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Owner extends JFrame {
	private JTable tblHostel;
	private JTable tblBook;
	private JTable tblRent;
	private JTable tblFree;
	DefaultTableModel tblAllModel = new DefaultTableModel();
	DefaultTableModel tblBookModel = new DefaultTableModel();
	DefaultTableModel tblRentModel = new DefaultTableModel();
	DefaultTableModel tblFreeModel = new DefaultTableModel();

    public Owner() {
        setTitle("Owner Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        
        JPanel panel2 = new JPanel();

        JPanel panel3 = new JPanel();
        
        JPanel panel4 = new JPanel();

        tabbedPane.addTab("All", null, panel1, "All");
        panel1.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 759, 411);
        panel1.add(scrollPane);
        
        tblHostel = new JTable();
        scrollPane.setViewportView(tblHostel);
        
        tabbedPane.addTab("Booking", null, panel2, "Booking");
        panel2.setLayout(null);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 11, 759, 411);
        panel2.add(scrollPane_1);
        
        tblBook = new JTable();
        scrollPane_1.setViewportView(tblBook);
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
        createBookTable();
        createAllTable();
        createRentTable();
        createFreeTable();
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
		setColumnWidth(0,40,tblHostel);
		setColumnWidth(0,40,tblHostel);
		setColumnWidth(2,40,tblHostel);
		setColumnWidth(3,40,tblHostel);
		setColumnWidth(4,20,tblHostel);
		setColumnWidth(5,50,tblHostel);
		setColumnWidth(5,50,tblHostel);
	}
 
    public void createBookTable() {
    	tblBookModel.addColumn("Seeker Name");
    	tblBookModel.addColumn("Book Date");
    	tblBookModel.addColumn("State");
    	tblBookModel.addColumn("City");
    	tblBookModel.addColumn("Street");
    	tblBookModel.addColumn("Building No:");
    	tblBookModel.addColumn("Room No:");
    	tblBookModel.addColumn("Small Room No:");
		tblBookModel.addColumn("Gender Type");
		tblBookModel.addColumn("Start Date");
		tblBookModel.addColumn("End Date");
		tblBook.setModel(tblBookModel);
		setColumnWidth(0,40,tblBook);
		setColumnWidth(0,40,tblBook);
		setColumnWidth(2,40,tblBook);
		setColumnWidth(3,40,tblBook);
		setColumnWidth(4,20,tblBook);
		setColumnWidth(5,50,tblBook);
		setColumnWidth(5,50,tblBook);
		setColumnWidth(5,50,tblBook);
		setColumnWidth(5,50,tblBook);
		setColumnWidth(5,50,tblBook);
		setColumnWidth(5,50,tblBook);
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
		setColumnWidth(0,40,tblRent);
		setColumnWidth(2,40,tblRent);
		setColumnWidth(3,40,tblRent);
		setColumnWidth(4,20,tblRent);
		setColumnWidth(5,50,tblRent);
		setColumnWidth(5,50,tblRent);
		setColumnWidth(5,50,tblRent);
		setColumnWidth(5,50,tblRent);
	}
    
    public void createFreeTable() {
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
    
    public static void main(String[] args) {
        new Owner();
    }
}
