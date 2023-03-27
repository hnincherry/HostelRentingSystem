package HostelRentingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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
					frame.setResizable(false);
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
		setBounds(380, 120, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
 
		DefaultListModel<Hostel> listModel = new DefaultListModel<Hostel>();
		ArrayList<String[]> strQuery = new ArrayList<String[]>();

		strQuery = sqlquery.getHostelData();
		ArrayList<Hostel> hostelArrList = new ArrayList<Hostel>();
		for(int i=0;i<strQuery.size();i++) {
			Hostel hostel = new Hostel();
			String[] data = strQuery.get(i);
			
			hostel.setHostelName(data[0]);
			hostel.setRoomNo(data[1]);
			hostel.setAddress(data[2]);
			hostel.setPrice(Integer.parseInt(data[3]));
			System.out.println("Hostel Data => "+i+ hostel  + "\n");
			hostelArrList.add(hostel);
		}
		
		for(Hostel hostelData : hostelArrList) {
			listModel.addElement(hostelData);
		}
			
		ImageIcon icon = new ImageIcon(getClass().getResource("/search-icon.png"));
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setBounds(10, 7, 319, 27);
		contentPane.add(comboBox);
 
		JButton btnSearch = new JButton(new ImageIcon((icon.getImage()).getScaledInstance(27, 25, java.awt.Image.SCALE_SMOOTH)));
		btnSearch.setBounds(327, 7, 35, 27);
		contentPane.add(btnSearch);
 
		JButton btnSignin = new JButton("Sign In");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn signin = new SignIn();
				signin.setVisible(true);
			}
		});
		btnSignin.setBounds(390, 8, 87, 25);
		contentPane.add(btnSignin);
 
		JButton btnSignup = new JButton("Sign Up");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterType type = new RegisterType();
				type.setVisible(true);
			}
		});
		btnSignup.setBounds(487, 8, 87, 25);
		contentPane.add(btnSignup);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 564, 405);
		contentPane.add(scrollPane);
	    
	    JList<Hostel> hostelList = new JList<>(listModel);
	    hostelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    hostelList.setCellRenderer(new ListCellRenderer());    
	    hostelList.setModel(listModel);
	    
	    hostelList.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent e) {
	    		if(!e.getValueIsAdjusting()) {
	    			JList<Hostel> list = (JList<Hostel>) e.getSource();
	    			int selectedIndex = list.getSelectedIndex();
	    			Hostel selectedHostel = list.getSelectedValue();
	    			System.out.println("Selected Index => "+selectedIndex+"\nSelected Value => "+selectedHostel);
	    			HostelDetail detail = new HostelDetail();
	    			detail.setVisible(true);	    		}
	    	}
	    });
		scrollPane.setViewportView(hostelList);

	}
}



