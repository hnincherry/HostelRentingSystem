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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class UpdatePrice extends JDialog {
	SqlQuery sqlquery = new SqlQuery();
	private JTextField txtPrice;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			CustomDialog dialog = new CustomDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public UpdatePrice(String roomId,String userId) {
		
		setTitle("Confirmation Dialog!!");
		setBounds(450, 230, 389, 183);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(21, 31, 48, 31);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(102, 32, 231, 31);
		getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				String price = txtPrice.getText();
				sqlquery.updatePrice(price,roomId);	
				Owner.fillFreeData(userId);
				clear();
				setVisible(false);
			}
		});
		btnUpdate.setBounds(134, 93, 82, 40);
		getContentPane().add(btnUpdate);		
	}
	
	public void clear() {
		txtPrice.setText("");
	}
}
