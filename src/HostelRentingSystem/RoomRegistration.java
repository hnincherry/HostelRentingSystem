package HostelRentingSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;


public class RoomRegistration {
	private JTextField txtRoomNo;
	private JTextField txtPrice;
	SqlQuery sqlquery = new SqlQuery();
	ArrayList<JTextField> txtRoomArray = new ArrayList<JTextField>();
	ArrayList<JTextField> txtPriceArray = new ArrayList<JTextField>();
	
	public RoomRegistration(String hostelName,String buildingNo,String roomNo,String roomCount,String state,String city,String street,String gender) {
		JFrame frame = new JFrame("Room Registration");
        JPanel panel = new JPanel(new GridLayout(0, 4,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        int count = Integer.parseInt(roomCount);
        
        for(int j=0;j<count;j++) {
        	txtRoomArray.add(new JTextField());
        	txtPriceArray.add(new JTextField());
        }
        
        for(int i=0;i<count;i++) {
        	JLabel lblNewLabel = new JLabel("Room No:");
    		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    		lblNewLabel.setPreferredSize(new Dimension(140, 30));
    		panel.add(lblNewLabel);
    		
    		//txtRoomNo = new JTextField();
    		panel.add(txtRoomArray.get(i));
    		
    		JLabel lblNewLabel_1 = new JLabel("Price:");
    		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
    		panel.add(lblNewLabel_1);
    		
    		//txtPrice = new JTextField();
    		panel.add(txtPriceArray.get(i));
        }
    		
//        JButton btnCancel = new JButton("Cancel");
//        btnCancel.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//clear();
//			}
//		});
//        panel.add(btnCancel);
        
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(Checking.IsNull(txtRoomNo.getText()) || Checking.IsLetter(txtRoomNo.getText())) {
//					JOptionPane.showMessageDialog(null, "You must enter valid Room Number");
//					txtRoomNo.requestFocus();
//					txtRoomNo.selectAll();
//				} else if(Checking.IsNull(txtPrice.getText()) || !Checking.IsAllDigit(txtPrice.getText())) {
//					JOptionPane.showMessageDialog(null, "You must enter valid Price");
//					txtPrice.requestFocus();
//					txtPrice.selectAll();
//				} else {
					String[] hostelData = new String[9];
					String[] roomData = new String[3];
					
					hostelData[0] = hostelName;
					hostelData[1] = buildingNo;
					hostelData[2] = roomNo;
					hostelData[3] = roomCount;
					hostelData[4] = state;
					hostelData[5] = city;
					hostelData[6] = street;
					hostelData[7] = "3";
					hostelData[8] = gender;
					boolean save = sqlquery.insertData("hostel", hostelData);
					String hostelId = sqlquery.getId("hostel");
					System.out.println("Hostel ID => "+hostelId);
					if(save) {
						// ["Room No", "Price", "HostelID"]
						// String[][] == new 
						// [
						// 	["Room No", "Price", "HostelID"],
						//  ["Room No", "Price", "HostelID"],
						//  ["Room No", "Price", "HostelID"]
						// ]
						String[][] roomList = new String[count][3];
						for(int k=0;k<count;k++) {
							String roomNo = txtRoomArray.get(k).getText();
							String price = txtPriceArray.get(k).getText();
							String[] room = {roomNo, price, hostelId}; // ["Room No", "Price", "HostelID"]
							roomList[k] = room; 
						}
						System.out.println("Room List => "+Arrays.toString(roomList));
						for(String[] data: roomList) {
//							String roomNo = data[0];
//							String price = data[1];
//							String hostelID = data[2];
							sqlquery.insertData("room",data);
						}
						JOptionPane.showMessageDialog(null, "Successfully Saved Room data");
//						roomData[0] = txtRoomNo.getText();
//						roomData[1] = txtPrice.getText();
//						roomData[2] = hostelId;
//						save = sqlquery.insertData("room", roomData);
//						if(save) {
//							JOptionPane.showMessageDialog(null, "Successfully Saved Room Data");
//						}
//						txtRoomNo.setText("");
//						txtPrice.setText("");
//						txtRoomNo.requestFocus();
					}
				//}
			}
		});
		
        panel.add(btnConfirm);
        
//        JButton btnClose = new JButton("Close");
//        btnClose.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Confirm Existing",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
//					//dispose();
//				}
//			}
//		});
//        panel.add(btnClose);
        
		//frame.getContentPane().add(btnConfirm, BorderLayout.SOUTH);
        frame.getContentPane().add(panel);
        frame.setResizable(false);
        frame.setBounds(380, 180, 550, 500);
        frame.pack();
        frame.setVisible(true);
	}
//    public static void main(String[] args) {
//    	new RoomRegistration("4");
//    }
	
}

