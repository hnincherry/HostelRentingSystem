package HostelRentingSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

//public class RoomRegistration extends JDialog {
//	private JTextField txtRoomNo;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			RoomRegistration dialog = new RoomRegistration();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Create the dialog.
//	 */
//	public RoomRegistration() {
//		setTitle("Room Registration");
//		setBounds(100, 100, 600, 500);
//		getContentPane().setLayout(new BorderLayout());
//		{
//			JPanel panel = new JPanel();
//			panel.setBorder(new TitledBorder(null, "Enter Small Room Number", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//			getContentPane().add(panel, BorderLayout.CENTER);
//			panel.setLayout(null);
//			
//			for(int i=0;i<5;i++) {
//				JLabel lblNewLabel = new JLabel("Room No:");
//				lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
//				lblNewLabel.setBounds(10, 32, 67, 23);
//				panel.add(lblNewLabel);
//			}	
//			txtRoomNo = new JTextField();
//			txtRoomNo.setBounds(87, 33, 101, 23);
//			panel.add(txtRoomNo);
//			txtRoomNo.setColumns(10);
//			
//			
//		}
//	}
//}
//import javax.swing.*;
//import javax.swing.border.Border;
//import javax.swing.border.TitledBorder;
//
//import java.awt.*;
//
//public class RoomRegistration extends JFrame {
//
//    public RoomRegistration() {
//        setTitle("Dynamic JLabel Example");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JButton btnConfirm = new JButton("Confirm");
//        btnConfirm.setBounds(232, 385, 102, 42);
//		getContentPane().add(btnConfirm);
//			
//		GridLayout gridLayout = new GridLayout(0,4,20,20);
//        // Create a JPanel to hold the JLabels
//        JPanel panel = new JPanel(gridLayout);
//        panel.setBorder((Border) new TitledBorder(null, "Enter Small Room Number", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//        
//        
//        // Create 10 JLabels dynamically
//        for (int i = 1; i <= 5; i++) {
//        	JLabel lblNewLabel = new JLabel("Room No:");
//			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
//			lblNewLabel.setPreferredSize(new Dimension(200, 20));
//			panel.add(lblNewLabel);
//			
//			JTextField txtRoomNo = new JTextField();
//			//txtRoomNo.setPreferredSize(new Dimension(200, 20));
//			panel.add(txtRoomNo);
//			//txtRoomNo.setColumns(10);
//			
//			JLabel lblNewLabel_1 = new JLabel("Price:");
//			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
//			panel.add(lblNewLabel_1);
//			
//			JTextField txtPrice = new JTextField();
//			panel.add(txtPrice);
//			//txtPrice.setColumns(10);	
//        }
//		
//        // Add the JPanel to the JFrame
//        getContentPane().add(panel, BorderLayout.CENTER);
//        //setBounds(100, 100, 600, 500);
//        setResizable(false);
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new RoomRegistration();
//    }
//}

public class RoomRegistration {
	
	public RoomRegistration(String roomCount) {
		JFrame frame = new JFrame("GridLayout Example");
        JPanel panel = new JPanel(new GridLayout(0, 4,10,10));
        int count = Integer.parseInt(roomCount);
        
        for(int i=0;i<count;i++) {
        	JLabel lblNewLabel = new JLabel("Room No:");
    		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    		lblNewLabel.setPreferredSize(new Dimension(140, 25));
    		panel.add(lblNewLabel);
    		
    		JTextField txtRoomNo = new JTextField();
    		panel.add(txtRoomNo);
    		
    		JLabel lblNewLabel_1 = new JLabel("Price:");
    		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
    		panel.add(lblNewLabel_1);
    		
    		JTextField txtPrice = new JTextField();
    		panel.add(txtPrice);
        }
    		
		JButton btnConfirm = new JButton("Confirm");
		//btnConfirm.setBounds(232, 385, 102, 42);
        //panel.add(btnConfirm);
        
		frame.getContentPane().add(btnConfirm, BorderLayout.SOUTH);
        frame.getContentPane().add(panel);
        frame.setResizable(false);
        frame.setBounds(100, 100, 600, 500);
        frame.pack();
        frame.setVisible(true);
	}
//    public static void main(String[] args) {
//    	new RoomRegistration();
//    }
}

