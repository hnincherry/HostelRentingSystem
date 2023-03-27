package HostelRentingSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HostelDetail extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HostelDetail dialog = new HostelDetail();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HostelDetail() {
		setTitle("Hostel Detail Form");
		setBounds(380, 120, 600, 500);
		getContentPane().setLayout(null);
	}

}
