package HostelRentingSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.border.EtchedBorder;

public class SignIn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPhone;
	private JPasswordField txtPass;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnSingin;
	private JLabel lbllogo;
	private JPanel panel;

	/**
	 * Launch the application.
	
	private void JButton1ActionPerformed(java.awt.event.ActionEvent evt)
	{
		((javax.swing.border.TitledBorder)panel.getBorder()).setTitleFont(new Font("Arial",Font.ITALIC,20));
		panel.repaint();
	}
	 * 
	 */
	public static void main(String[] args) {
		try {
			SignIn dialog = new SignIn();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SignIn() {
		setTitle("Sign In");
		setBounds(380, 120, 600, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sign In Form", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(135, 206, 235)));
		panel.setBounds(10, 11, 564, 439);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Phone No");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setBounds(95, 125, 89, 23);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(0, 191, 255));
		lblNewLabel_1.setBounds(95, 173, 109, 36);
		panel.add(lblNewLabel_1);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(312, 114, 215, 34);
		panel.add(txtPhone);
		txtPhone.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(312, 182, 215, 36);
		panel.add(txtPass);
		
		btnSingin = new JButton("Sign In");
		btnSingin.setBounds(228, 266, 97, 36);
		panel.add(btnSingin);
		
		lbllogo = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lbllogo.setIcon(new ImageIcon(img));
		lbllogo.setBounds(242, 43, 65, 66);
		panel.add(lbllogo);
		
	
	}

	private int EtchedBorder(Font font) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
