package HostelRentingSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HostelRentingSystem.Checking;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HostelRegistration extends JDialog {
	private JTextField txtHostelName;
	private JTextField txtBuildingNo;
	private JTextField txtMainRoom;
	private JTextField txtRoomCount;
	private JTextField txtState;
	private JTextField txtCity;
	private JTextField txtStreet;
	private JComboBox cboGender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HostelRegistration dialog = new HostelRegistration();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HostelRegistration() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setTitle("Hostel Registration Form");
		setBounds(380, 120, 600, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNew = new JLabel("Hostel Name");
		lblNew.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNew.setBounds(30, 28, 102, 30);
		getContentPane().add(lblNew);
		
		JLabel lblBuildingNo = new JLabel("Building No:");
		lblBuildingNo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblBuildingNo.setBounds(30, 69, 102, 30);
		getContentPane().add(lblBuildingNo);
		
		JLabel lblMainRoomno = new JLabel("Main RoomNo:");
		lblMainRoomno.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMainRoomno.setBounds(30, 110, 102, 30);
		getContentPane().add(lblMainRoomno);
		
		JLabel lblSmallRoomCount = new JLabel("Small Room Count");
		lblSmallRoomCount.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSmallRoomCount.setBounds(30, 151, 143, 30);
		getContentPane().add(lblSmallRoomCount);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Arial", Font.PLAIN, 15));
		lblState.setBounds(30, 192, 102, 30);
		getContentPane().add(lblState);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCity.setBounds(30, 233, 102, 30);
		getContentPane().add(lblCity);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("Arial", Font.PLAIN, 15));
		lblStreet.setBounds(30, 274, 102, 30);
		getContentPane().add(lblStreet);
		
		JLabel lblGenderType = new JLabel("Gender Type");
		lblGenderType.setFont(new Font("Arial", Font.PLAIN, 15));
		lblGenderType.setBounds(30, 315, 102, 30);
		getContentPane().add(lblGenderType);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Checking.IsNull(txtHostelName.getText()) || !Checking.IsLetter(txtHostelName.getText())) {
					JOptionPane.showMessageDialog(null, "You must enter valid Hostel Name");
					txtHostelName.requestFocus();
					txtHostelName.selectAll();
				} else if(Checking.IsNull(txtBuildingNo.getText()) || Checking.IsLetter(txtBuildingNo.getText())) {
					JOptionPane.showMessageDialog(null, "You must enter valid Building No:");
					txtBuildingNo.requestFocus();
					txtBuildingNo.selectAll();
				} else if(Checking.IsNull(txtMainRoom.getText()) || Checking.IsLetter(txtMainRoom.getText())) {
					JOptionPane.showMessageDialog(null, "You must enter valid Main Room No:");
					txtMainRoom.requestFocus();
					txtMainRoom.selectAll();
				} else if(Checking.IsNull(txtRoomCount.getText()) || Checking.IsLetter(txtRoomCount.getText())) {
					JOptionPane.showMessageDialog(null, "You must enter valid Room Count");
					txtRoomCount.requestFocus();
					txtRoomCount.selectAll();
				} else if(Checking.IsNull(txtState.getText()) || !Checking.IsLetter(txtState.getText())) {
					JOptionPane.showMessageDialog(null, "You must enter valid State Name");
					txtState.requestFocus();
					txtState.selectAll();
				} else if(Checking.IsNull(txtCity.getText()) || !Checking.IsLetter(txtCity.getText())) {
					JOptionPane.showMessageDialog(null, "You must enter valid City Name");
					txtCity.requestFocus();
					txtCity.selectAll();
				} else if(Checking.IsNull(txtStreet.getText()) || !Checking.IsLetter(txtStreet.getText())) {
					JOptionPane.showMessageDialog(null, "You must enter valid Street Name");
					txtStreet.requestFocus();
					txtStreet.selectAll();
				} else if(cboGender.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "You must Choose Gender Type");
					cboGender.requestFocus();
				} else {
					new RoomRegistration(txtRoomCount.getText());
				} 
			}
		});
		btnNext.setBounds(232, 385, 102, 42);
		getContentPane().add(btnNext);
		
		txtHostelName = new JTextField();
		txtHostelName.setBounds(235, 28, 319, 25);
		getContentPane().add(txtHostelName);
		txtHostelName.setColumns(10);
		
		txtBuildingNo = new JTextField();
		txtBuildingNo.setColumns(10);
		txtBuildingNo.setBounds(235, 69, 319, 25);
		getContentPane().add(txtBuildingNo);
		
		txtMainRoom = new JTextField();
		txtMainRoom.setColumns(10);
		txtMainRoom.setBounds(235, 110, 319, 25);
		getContentPane().add(txtMainRoom);
		
		txtRoomCount = new JTextField();
		txtRoomCount.setColumns(10);
		txtRoomCount.setBounds(235, 151, 319, 25);
		getContentPane().add(txtRoomCount);
		
		txtState = new JTextField();
		txtState.setColumns(10);
		txtState.setBounds(235, 198, 319, 25);
		getContentPane().add(txtState);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(235, 239, 319, 25);
		getContentPane().add(txtCity);
		
		txtStreet = new JTextField();
		txtStreet.setColumns(10);
		txtStreet.setBounds(235, 280, 319, 25);
		getContentPane().add(txtStreet);
		
		cboGender = new JComboBox();
		cboGender.setModel(new DefaultComboBoxModel(new String[] {"---Select---", "Male", "Female"}));
		cboGender.setBounds(235, 320, 319, 25);
		getContentPane().add(cboGender);
	}
}
