package HostelRentingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;

import HostelRentingSystem.Hostel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {
 
	private JPanel contentPane;
	SqlQuery sqlquery = new SqlQuery();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * Create the frame.
	 */
	public Home() {
		setTitle("Hostel Renting System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
 
		DefaultListModel<Hostel> listModel = new DefaultListModel<Hostel>();
		
		//ArrayList<Hostel> nameArr = new ArrayList<Hostel>();
		String[] hostelArr = {"Rose","Jasmine","Myalay","Cherry","Khayay"};
		// sample data like from db
		// hostel name, room number, address - city, price
		// [Hostel(), Hostel()]
		String[] strQuery = new String[4];
		String[] strData = new String[4];

		strQuery = sqlquery.getHostelData();
		for(int i=0;i<strQuery.length;i++) {
			System.out.println("Hostel Data => "+i+strQuery[i] + "\n");			
		}
			
		Hostel hostel = new Hostel("Rose","R-0001","Sanchaung",50000);
				
		ImageIcon icon = new ImageIcon(getClass().getResource("/search-icon.png"));
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setBounds(10, 7, 217, 27);
		contentPane.add(comboBox);
 
		JButton btnSearch = new JButton(new ImageIcon((icon.getImage()).getScaledInstance(27, 25, java.awt.Image.SCALE_SMOOTH)));
		btnSearch.setBounds(226, 6, 35, 28);
		contentPane.add(btnSearch);
 
		JButton btnSignin = new JButton("Sign In");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSignin.setBounds(271, 9, 87, 25);
		contentPane.add(btnSignin);
 
		JButton btnSignup = new JButton("Sign Up");
		btnSignup.setBounds(370, 9, 87, 25);
		contentPane.add(btnSignup);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 449, 321);
		contentPane.add(scrollPane);
	    
	    JList<Hostel> hostelList = new JList<>(listModel);
	    hostelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    hostelList.setCellRenderer(new ListCellRenderer());
	    
	    for (int i = 0; i < 5; i++) {
	        listModel.addElement(hostel);
	    }
	    hostelList.setModel(listModel);
	    
	    hostelList.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    		if(!e.getValueIsAdjusting()) {
	    			JList<Hostel> list = (JList<Hostel>) e.getSource();
	    			int selectedIndex = list.getSelectedIndex();
	    			Hostel selectedHostel = list.getSelectedValue();
	    			System.out.print("Selected Index => "+selectedIndex+"\nSelected Value => "+selectedHostel);
	    		}
	    	}
	    });
		scrollPane.setViewportView(hostelList);

	}
}



