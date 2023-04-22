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

public class CustomDialog extends JDialog {
	SqlQuery sqlquery = new SqlQuery();

	/**
	 * Create the dialog.
	 */
	public CustomDialog(String room,String userId,String roomId) {
		
		setTitle("Confirmation Dialog!!");
		setBounds(450, 230, 389, 183);
		getContentPane().setLayout(null);
		
		//System.out.println("Room Id => "+roomId);
		JLabel lblNewLabel = new JLabel("What do you want to do?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(72, 11, 215, 41);
		getContentPane().add(lblNewLabel);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
        		if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete small room?","Confirm Deleting",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					sqlquery.deleteRoom(room);	
					Owner.fillFreeData(userId);
				}
			}
		});
		btnDelete.setBounds(72, 97, 89, 23);
		getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
        		if(JOptionPane.showConfirmDialog(null, "Are you want to update room price?","Confirm Updating",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
        			UpdatePrice update = new UpdatePrice(roomId,userId);
        			update.setVisible(true);
				}
			}
		});
		btnUpdate.setBounds(211, 97, 89, 23);
		getContentPane().add(btnUpdate);
		
		JLabel lblNewLabel_1 = new JLabel("Update OR Delete Selected Room?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(62, 48, 249, 33);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel_1);
	}
}
