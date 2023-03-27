package HostelRentingSystem;

import javax.swing.*;    
import java.awt.event.*;    
public class Owner implements ActionListener{    
	JFrame f;    
	JMenuBar mb;    
	JMenu manage;    
	JMenuItem all,book,rent,free;    
	JTextArea ta;    
	Owner(){ 	
		f = new JFrame();  
		f.setTitle("Owner Panel");
		all = new JMenuItem("All");    
		book = new JMenuItem("Booking");    
		rent = new JMenuItem("Rent");    
		free = new JMenuItem("Free"); 
		
		mb=new JMenuBar();    
		manage = new JMenu("Room Management");    
		
		all.addActionListener(this);    
		book.addActionListener(this);    
		rent.addActionListener(this);    
		free.addActionListener(this);  

		manage.add(all);
		manage.add(book);
		manage.add(rent);
		manage.add(free); 
		mb.add(manage);
   
		ta=new JTextArea();    
		ta.setBounds(5,5,360,320);    
		f.add(mb);
		f.add(ta);    
		f.setJMenuBar(mb);  
		
		f.setLayout(null);    
		f.setBounds(100, 100, 600, 500);
		f.setResizable(false);
		f.setVisible(true);    
	}     
	public void actionPerformed(ActionEvent e) { 
		if(e.getSource()==all) 
			System.out.println("All");
			//ta.setText("All");  
		if(e.getSource()==book)  
			System.out.println("Booking");
			//ta.setText("Booking");    
		if(e.getSource()==rent)  
			System.out.println("Rent");
			//ta.setText("Rent");   
		if(e.getSource()==free) 
			System.out.println("Free");
			//ta.setText("Free");   
	}     
	
	public static void main(String[] args) {    
		new Owner();    
	}    
}    
