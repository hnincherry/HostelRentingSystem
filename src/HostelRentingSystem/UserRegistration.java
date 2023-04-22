package HostelRentingSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;


public class UserRegistration extends JDialog {
	private JLabel lblNewLabel;
	private JLabel lblPhone;
	private JLabel lblNrc;
	private JLabel lblState;
	private JLabel lblCity;
	private JLabel lblStreet;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtState;
	private JTextField txtCity;
	private JTextField txtStreet;
	private JTextField txtNRCno;
	private JComboBox cboNation;
	private JComboBox cboCode;
	private JComboBox cboCity;
	private JButton btnRegister;
	private JPanel panel;
	Map<Integer,List<String>> map = new HashMap<>();
	CityShortName shortName = new CityShortName();
	ArrayList listCode = new ArrayList();
	private JLabel lblPassowrd;
	private JPasswordField txtPass;
	private JButton btnClose;
	private JButton btnCancel;
	String[] userData = new String[10];
	String gender,nrc;
	private JRadioButton rdoFemale;
	SqlQuery sqlquery = new SqlQuery();
	private JRadioButton rdoMale;

	/**
	 * Create the dialog.
	 */
	public UserRegistration(String roleId) {
		setTitle("User Registration Form");
		setBounds(350, 50, 700, 600);
		setResizable(false);
		getContentPane().setLayout(null);
		//int roleId = id;
		panel = new JPanel();
		panel.setForeground(new Color(0, 191, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sign In Form", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(135, 206, 235)));
		panel.setBounds(10, 11, 664, 539);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setBounds(22, 32, 46, 21);
		panel.add(lblNewLabel);
		
		lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPhone.setForeground(new Color(0, 191, 255));
		lblPhone.setBounds(22, 86, 46, 14);
		panel.add(lblPhone);
		
		lblPassowrd = new JLabel("Password:");
		lblPassowrd.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPassowrd.setForeground(new Color(0, 191, 255));
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPhone.setForeground(new Color(0, 191, 255));
		lblPassowrd.setBounds(22, 140, 82, 14);
		panel.add(lblPassowrd);
		
		lblNrc = new JLabel("NRC:");
		lblNrc.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNrc.setForeground(new Color(0, 191, 255));
		lblNrc.setBounds(22, 195, 46, 14);
		panel.add(lblNrc);
		
		lblState = new JLabel("State:");
		lblState.setFont(new Font("Arial", Font.PLAIN, 15));
		lblState.setForeground(new Color(0, 191, 255));
		lblState.setBounds(22, 248, 46, 14);
		panel.add(lblState);
		
		lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCity.setForeground(new Color(0, 191, 255));
		lblCity.setBounds(22, 304, 46, 21);
		panel.add(lblCity);
		
		lblStreet = new JLabel("Street:");
		lblStreet.setFont(new Font("Arial", Font.PLAIN, 15));
		lblStreet.setForeground(new Color(0, 191, 255));
		lblStreet.setBounds(22, 369, 46, 14);
		panel.add(lblStreet);
		
		txtName = new JTextField();
		txtName.setBounds(213, 28, 424, 31);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(213, 79, 424, 31);
		panel.add(txtPhone);
		txtPhone.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(213, 133, 424, 31);
		panel.add(txtPass);
		txtPass.setColumns(10);
		
		txtState = new JTextField();
		txtState.setBounds(213, 241, 424, 31);
		panel.add(txtState);
		txtState.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setBounds(213, 300, 424, 31);
		panel.add(txtCity);
		txtCity.setColumns(10);
		
		txtStreet = new JTextField();
		txtStreet.setBounds(213, 362, 424, 31);
		panel.add(txtStreet);
		txtStreet.setColumns(10);
		
		cboCode = new JComboBox();
		cboCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				fillCode();				
			}
		});
		cboCode.setModel(new DefaultComboBoxModel(new String[] {"---Select---","1/", "2/", "3/", "4/", "5/", "6/", "7/", "8/", "9/", "10/", "11/", "12/", "13/", "14/"}));
		cboCode.setBounds(213, 188, 82, 31);
		panel.add(cboCode);
		
		cboCity = new JComboBox();
		cboCity.setModel(new DefaultComboBoxModel(new String[] {"---Select---"}));
		cboCity.setBounds(321, 188, 95, 31);
		panel.add(cboCity);
		
		cboNation = new JComboBox();
		cboNation.setModel(new DefaultComboBoxModel(new String[] {"---Select---", "N", "E", "P"}));
		cboNation.setBounds(439, 188, 93, 31);
		panel.add(cboNation);
		
		txtNRCno = new JTextField();
		txtNRCno.setBounds(542, 188, 95, 31);
		panel.add(txtNRCno);
		txtNRCno.setColumns(10);
		
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean duplicate = sqlquery.isPhonenoDuplicate(txtPhone.getText());
				boolean duplicateNrc = sqlquery.isNrcDuplicate(cboCode.getSelectedItem().toString(),cboCity.getSelectedItem().toString(),cboNation.getSelectedItem().toString(),txtNRCno.getText());
				
				if(Checking.IsNull(txtName.getText()) || Checking.IsValidName(txtName.getText()))
				{
					JOptionPane.showMessageDialog(null, "You must enter valid Name");
					txtName.requestFocus();
					txtName.selectAll();
				}
				else if(Checking.IsNull(txtPhone.getText()) || Checking.IsLetter(txtPhone.getText()) || !Checking.IsPhoneNo(txtPhone.getText()))
				{
					JOptionPane.showMessageDialog(null, "You must enter valid Phone Number");
					txtPhone.requestFocus();
					txtPhone.selectAll();
				}
				else if(!Checking.IsPassNo(txtPass.getText()))
				{
					JOptionPane.showMessageDialog(null, "Your password should be at least 8");
					txtPass.requestFocus();
					txtPass.selectAll();					
				}
				else if(Checking.IsNull(txtState.getText()))
				{
					JOptionPane.showMessageDialog(null, "You must enter valid State");
					txtState.requestFocus();
					txtState.selectAll();
				}
				else if(Checking.IsNull(txtCity.getText()))
				{
					JOptionPane.showMessageDialog(null, "You must enter valid City");
					txtCity.requestFocus();
					txtCity.selectAll();
				}
				else if(Checking.IsNull(txtStreet.getText()))
				{
					JOptionPane.showMessageDialog(null, "You must enter valid Street");
					txtStreet.requestFocus();
					txtStreet.selectAll();
				}
				else if(cboCode.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(null, "You must choose Code for NRC");
					cboCode.requestFocus();
				}
				else if(cboCity.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(null, "You must choose City for NRC");
					cboCity.requestFocus();					
				}
				else if(cboNation.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(null, "You must choose Nation for NRC");
					cboNation.requestFocus();
					
				}				
				else if(Checking.IsNull(txtNRCno.getText()) || !Checking.IsNrc(txtNRCno.getText()) || !Checking.IsAllDigit(txtNRCno.getText()))
				{
					JOptionPane.showMessageDialog(null, "You must enter valid NRC Code");
					txtNRCno.requestFocus();
					txtNRCno.selectAll();
				} else if(duplicate)
				{
					JOptionPane.showMessageDialog(null, "Registration PhoneNo is already exist!!");	
				} else if(duplicateNrc) {
					JOptionPane.showMessageDialog(null, "Registration NRC is already exist!!");	
				} 
				else {
					String code,city,nation,number;
					code = (String) cboCode.getSelectedItem();
					city = (String) cboCity.getSelectedItem();
					nation = (String) cboNation.getSelectedItem();
					number = txtNRCno.getText();
					nrc = code + city + "(" + nation + ")" + number;
					
					//System.out.println("NRC => "+ nrc);
					userData[0] = txtName.getText();
					userData[1] = txtPhone.getText();
					userData[2] = nrc;
					userData[3] = txtState.getText();
					userData[4] = txtCity.getText();
					userData[5] = txtStreet.getText();
					userData[6] = txtPass.getText();
					userData[7] = roleId;
					userData[8] = "pending";
					userData[9] = gender;//gender
					
					
					boolean save = sqlquery.insertData("user", userData);
					if(save) {
						JOptionPane.showMessageDialog(null, "Thank You for Registration. Admin will approve account in a few day!!!");
						clear();
					}				
				}
				
			}
			private Object String(String text) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnRegister.setBounds(305, 472, 97, 36);
		panel.add(btnRegister);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				
			}
		});
		btnCancel.setBounds(108, 472, 97, 36);
		panel.add(btnCancel);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnClose.setBounds(495, 472, 89, 36);
		panel.add(btnClose);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(new Color(0, 191, 255));
		lblGender.setFont(new Font("Arial", Font.PLAIN, 15));
		lblGender.setBounds(22, 413, 82, 14);
		panel.add(lblGender);
		
		rdoMale = new JRadioButton("Male");
		rdoMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoMale.isSelected()) {
					rdoFemale.setSelected(false);
					gender = "Male";
				}
			}
		});
		rdoMale.setBounds(258, 410, 82, 23);
		panel.add(rdoMale);
		
		rdoFemale = new JRadioButton("Female");
		rdoFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoFemale.isSelected()) {
					rdoMale.setSelected(false);
					gender = "Female";
				}
			}
		});
		rdoFemale.setBounds(464, 410, 82, 23);
		panel.add(rdoFemale);
		
		
	}
	
	public void fillCode() {
		map = shortName.getCityCode();
		if(cboCode.getSelectedIndex() == 1)
		{
			System.out.println("Short Name => "+ map.get(1));	
			listCode = (ArrayList) map.get(1);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++) 
			{
 
				cboCity.addItem(listCode.get(i));
			}
		} 
		else if(cboCode.getSelectedIndex() == 2) {
			System.out.println("Short Name => "+ map.get(2));	
			listCode = (ArrayList) map.get(2);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
			
		}
		else if(cboCode.getSelectedIndex() == 3) {
			System.out.println("Short Name => "+ map.get(3));	
			listCode = (ArrayList) map.get(3);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
			
		}
		else if(cboCode.getSelectedIndex() == 4) {
			System.out.println("Short Name => "+ map.get(4));	
			listCode = (ArrayList) map.get(4);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
			
		}
		else if(cboCode.getSelectedIndex() == 5) {
			System.out.println("Short Name => "+ map.get(5));	
			listCode = (ArrayList) map.get(5);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
			
		}
		else if(cboCode.getSelectedIndex() == 6) {
			System.out.println("Short Name => "+ map.get(6));	
			listCode = (ArrayList) map.get(6);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
			
		}
		else if(cboCode.getSelectedIndex() == 7) {
			System.out.println("Short Name => "+ map.get(7));	
			listCode = (ArrayList) map.get(7);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
			
		}
		else if(cboCode.getSelectedIndex() == 8) {
			System.out.println("Short Name => "+ map.get(8));	
			listCode = (ArrayList) map.get(8);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
			
		}
		else if(cboCode.getSelectedIndex() == 9) {
			System.out.println("Short Name => "+ map.get(9));	
			listCode = (ArrayList) map.get(9);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
			
		}
		else if(cboCode.getSelectedIndex() == 10) {
			System.out.println("Short Name => "+ map.get(10));	
			listCode = (ArrayList) map.get(10);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
			
		}
		else if(cboCode.getSelectedIndex() == 11) {
			System.out.println("Short Name => "+ map.get(11));	
			listCode = (ArrayList) map.get(11);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
			
		}
		else if(cboCode.getSelectedIndex() == 12) {
			System.out.println("Short Name => "+ map.get(12));	
			listCode = (ArrayList) map.get(12);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
			
		}
		else if(cboCode.getSelectedIndex() == 13) {
			System.out.println("Short Name => "+ map.get(13));	
			listCode = (ArrayList) map.get(13);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
			
		}
		else if(cboCode.getSelectedIndex() == 14) {
			System.out.println("Short Name => "+ map.get(14));	
			listCode = (ArrayList) map.get(14);
			cboCity.removeAllItems();
			for(int i=0;i<listCode.size();i++)
			{
 
				cboCity.addItem(listCode.get(i));
			}
			
		}
		
	}
	
	public void clear()
	{
		txtName.setText("");
		txtPhone.setText("");
		txtPass.setText("");
		cboCode.setSelectedIndex(0);
		cboCity.setSelectedIndex(0);
		cboNation.setSelectedIndex(0);
		txtNRCno.setText("");
		txtState.setText("");
		txtCity.setText("");
		txtStreet.setText("");
		txtName.requestFocus();
		rdoMale.setSelected(false);
		rdoFemale.setSelected(false);
	}
}