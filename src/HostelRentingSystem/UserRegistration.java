package HostelRentingSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

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
	private JComboBox cboNRCnational;
	private JComboBox cboNRCstate;
	private JComboBox cboNRCcity;
	private JButton btnRegister;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserRegistration dialog = new UserRegistration();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserRegistration() {
		setTitle("User Registration Form");
		setBounds(380, 120, 600, 500);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sign In Form", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(135, 206, 235)));
		panel.setBounds(10, 11, 564, 450);
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
		
		lblNrc = new JLabel("NRC:");
		lblNrc.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNrc.setForeground(new Color(0, 191, 255));
		lblNrc.setBounds(22, 135, 46, 14);
		panel.add(lblNrc);
		
		lblState = new JLabel("State:");
		lblState.setFont(new Font("Arial", Font.PLAIN, 15));
		lblState.setForeground(new Color(0, 191, 255));
		lblState.setBounds(22, 187, 46, 14);
		panel.add(lblState);
		
		lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCity.setForeground(new Color(0, 191, 255));
		lblCity.setBounds(22, 244, 46, 14);
		panel.add(lblCity);
		
		lblStreet = new JLabel("Street:");
		lblStreet.setFont(new Font("Arial", Font.PLAIN, 15));
		lblStreet.setForeground(new Color(0, 191, 255));
		lblStreet.setBounds(22, 299, 46, 14);
		panel.add(lblStreet);
		
		txtName = new JTextField();
		txtName.setBounds(194, 26, 344, 31);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(194, 77, 344, 31);
		panel.add(txtPhone);
		txtPhone.setColumns(10);
		
		txtState = new JTextField();
		txtState.setBounds(194, 178, 344, 31);
		panel.add(txtState);
		txtState.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setBounds(194, 235, 344, 31);
		panel.add(txtCity);
		txtCity.setColumns(10);
		
		txtStreet = new JTextField();
		txtStreet.setBounds(194, 290, 344, 31);
		panel.add(txtStreet);
		txtStreet.setColumns(10);
		
		cboNRCstate = new JComboBox();
		cboNRCstate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cboNRCstate.getSelectedIndex()==0)
				{
					cboNRCcity.removeAllItems();
					cboNRCcity.addItem("KAPATA");
					cboNRCcity.addItem("KAMATA");
					cboNRCcity.addItem("KAMANA");
					cboNRCcity.addItem("KHAPHANA");
					cboNRCcity.addItem("KHABADA");
					cboNRCcity.addItem("KHALAPHA");
					cboNRCcity.addItem("SADANA");
					cboNRCcity.addItem("SAPABA");
					cboNRCcity.addItem("SABATA");
					cboNRCcity.addItem("SALANA");

					
					
				}
				if(cboNRCstate.getSelectedIndex()==1)
				{
					cboNRCcity.removeAllItems();
					cboNRCcity.addItem("DAMASA");
					cboNRCcity.addItem("PHASANA");
					cboNRCcity.addItem("PHAYASA");
					cboNRCcity.addItem("BALAKHA");
					cboNRCcity.addItem("MASANA");
					cboNRCcity.addItem("YATHANA");
					cboNRCcity.addItem("LAKANA");
					
				}
				if(cboNRCstate.getSelectedIndex()==2)
				{
					cboNRCcity.removeAllItems();
					cboNRCcity.addItem("KAKAYA");
					cboNRCcity.addItem("KASAKA");
					cboNRCcity.addItem("KADANA");
					cboNRCcity.addItem("KAMAMA");
					cboNRCcity.addItem("SAKALA");
					cboNRCcity.addItem("PAKANA");

				}
			}
		});
		cboNRCstate.setModel(new DefaultComboBoxModel(new String[] {"1/", "2/", "3/", "4/", "5/", "6/", "7/", "8/", "9/", "10/", "11/", "12/", "13/", "14/"}));
		cboNRCstate.setBounds(194, 123, 51, 31);
		panel.add(cboNRCstate);
		
		cboNRCcity = new JComboBox();
		cboNRCcity.setBounds(255, 122, 96, 31);
		panel.add(cboNRCcity);
		
		cboNRCnational = new JComboBox();
		cboNRCnational.setModel(new DefaultComboBoxModel(new String[] {"N", "E", "P"}));
		cboNRCnational.setBounds(368, 123, 64, 31);
		panel.add(cboNRCnational);
		
		txtNRCno = new JTextField();
		txtNRCno.setBounds(442, 122, 96, 31);
		panel.add(txtNRCno);
		txtNRCno.setColumns(10);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(136, 376, 97, 36);
		panel.add(btnRegister);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(319, 376, 97, 36);
		panel.add(btnReset);
	}
}
