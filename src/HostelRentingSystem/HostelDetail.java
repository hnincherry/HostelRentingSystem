package HostelRentingSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import HostelRentingSystem.Checking;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HostelDetail extends JDialog {
	Border blackline=BorderFactory.createLineBorder(Color.black);

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			HostelDetail dialog = new HostelDetail();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public HostelDetail(String hostelName,String roomno,String address,String genderType,int price,String ownerName,String ownerPhone,String roomId) {
		System.out.println("Data => "+hostelName+roomno+address+genderType+price+ownerName+ownerPhone);
		getContentPane().setBackground(new Color(192, 192, 192));
		setTitle("Hostel Detail Form");
		setBounds(380, 120, 600, 500);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblNew = new JLabel("Owner Name");
		lblNew.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNew.setBounds(30, 72, 102, 30);
		getContentPane().add(lblNew);
		
		JLabel lblNew_1 = new JLabel("Owner PhoneNo");
		lblNew_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNew_1.setBounds(30, 113, 143, 30);
		getContentPane().add(lblNew_1);
		
		JLabel lblNew_2 = new JLabel("Room No");
		lblNew_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNew_2.setBounds(30, 165, 102, 30);
		getContentPane().add(lblNew_2);
		
		JLabel lblNew_3 = new JLabel("Price");
		lblNew_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNew_3.setBounds(30, 218, 143, 30);
		getContentPane().add(lblNew_3);
		
		JLabel lblNew_4 = new JLabel("Address");
		lblNew_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNew_4.setBounds(30, 270, 102, 30);
		getContentPane().add(lblNew_4);
		
		JLabel lblGenderType = new JLabel("Gender Type");
		lblGenderType.setFont(new Font("Arial", Font.PLAIN, 15));
		lblGenderType.setBounds(30, 315, 102, 30);
		getContentPane().add(lblGenderType);
		
		JButton btnBook = new JButton("Rent");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn signin = new SignIn("rent",ownerName,roomno,price,ownerPhone,roomId);
				signin.setVisible(true);
			}
		});
		btnBook.setBounds(256, 385, 102, 42);
		getContentPane().add(btnBook);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Confirm Existing",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		btnClose.setBounds(154, 385, 102, 42);
		getContentPane().add(btnClose);
		
		JLabel lblOwnerName = new JLabel(ownerName);
		lblOwnerName.setBounds(237, 72, 317, 30);
		lblOwnerName.setBorder(blackline);
		getContentPane().add(lblOwnerName);
		
		JLabel lblPhoneNo = new JLabel(ownerPhone);
		lblPhoneNo.setBorder(blackline);
		lblPhoneNo.setBounds(237, 113, 317, 30);
		getContentPane().add(lblPhoneNo);
		
		JLabel lblRoomNo = new JLabel(roomno);
		lblRoomNo.setBorder(blackline);
		lblRoomNo.setBounds(237, 165, 317, 30);
		getContentPane().add(lblRoomNo);
		
		JLabel lblPrice = new JLabel(price+"");
		lblPrice.setBorder(blackline);
		lblPrice.setBounds(237, 218, 317, 30);
		getContentPane().add(lblPrice);
		
		JLabel lblAddress = new JLabel(address);
		lblAddress.setBorder(blackline);
		lblAddress.setBounds(237, 270, 317, 30);
		getContentPane().add(lblAddress);
		
		JLabel lblGender = new JLabel(genderType);
		lblGender.setBorder(blackline);
		lblGender.setBounds(235, 315, 319, 30);
		getContentPane().add(lblGender);
		
		JLabel lblHostelName = new JLabel(hostelName);
		lblHostelName.setBorder(blackline);
		lblHostelName.setBounds(237, 24, 317, 30);
		getContentPane().add(lblHostelName);
		
		JLabel lblHostelName_1 = new JLabel("Hostel Name");
		lblHostelName_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblHostelName_1.setBounds(30, 24, 102, 30);
		getContentPane().add(lblHostelName_1);
	}
}
