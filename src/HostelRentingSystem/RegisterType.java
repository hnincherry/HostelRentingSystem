package HostelRentingSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class RegisterType extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisterType dialog = new RegisterType();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisterType() {
		setTitle("Choose Register Type");
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(null);
		
		JLabel lblOwner = new JLabel("Owner");
		lblOwner.setBounds(108, 72, 93, 22);
		lblOwner.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(lblOwner);
		
		JLabel lblSeeker = new JLabel("Seeker");
		lblSeeker.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSeeker.setBounds(378, 72, 93, 22);
		getContentPane().add(lblSeeker);
		
		JLabel lblNewLabel = new JLabel("<html><center>Owner can register for hostel information and management for room</center></html>");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 129, 250, 72);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>Seeker can find hostel and booking for room</center></html>");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(300, 129, 250, 72);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnOwner = new JButton("Owner Register");
		btnOwner.setBounds(56, 267, 145, 38);
		getContentPane().add(btnOwner);
		
		JButton btnSeeker = new JButton("Seeker Register");
		btnSeeker.setBounds(348, 267, 145, 38);
		getContentPane().add(btnSeeker);

	}
}

//import javax.swing.*;
//import java.awt.*;
//
//public class RegisterType {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Choose Register Type");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setBounds(100, 100, 600, 500);
//
//        // Create a JPanel to hold the components
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//
//		JLabel lblOwner = new JLabel("Owner");
//		lblOwner.setBounds(200, 72, 93, 22);
//		lblOwner.setFont(new Font("Arial", Font.PLAIN, 18));
//		panel.add(lblOwner);
//		
////		JLabel lblNewLabel = new JLabel("<html><center>Owner can register for hostel information and management for room</center></html>");
////		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
////		lblNewLabel.setBounds(25, 129, 250, 72);
////		panel.add(lblNewLabel);
//		
//        // Create a vertical JSeparator
//        JSeparator separator = new JSeparator(JSeparator.VERTICAL);
//        //separator.setPreferredSize(new Dimension(1, 50)); // Set the height of the separator
//
//        // Add the separator to the panel
//        panel.add(Box.createHorizontalGlue()); // Align the separator to the center of the panel
//        panel.add(separator);
//        //panel.add(Box.createHorizontalGlue()); // Align the separator to the center of the panel
//
//        JLabel lblSeeker = new JLabel("Seeker");
//		lblSeeker.setFont(new Font("Arial", Font.PLAIN, 18));
//		lblSeeker.setBounds(356, 72, 93, 22);
//		panel.add(lblSeeker);
//		
//        // Add the panel to the frame
//        frame.getContentPane().add(panel, BorderLayout.WEST);
//
//        // Display the frame
//        frame.setVisible(true);
//    }
//}
