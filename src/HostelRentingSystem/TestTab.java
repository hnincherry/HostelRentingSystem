package HostelRentingSystem;

//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JTabbedPane;
//import javax.swing.JToolBar;
//
//public class TestTab extends JFrame {
//
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TestTab frame = new TestTab();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public TestTab() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setToolTipText("Search\r\nHome");
//		tabbedPane.setBounds(10, 0, 414, 29);
//		contentPane.add(tabbedPane);
//		
//		JToolBar toolBar = new JToolBar();
//		toolBar.setBounds(20, 40, 375, 63);
//		contentPane.add(toolBar);
//	}
//}

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class TestTab extends JFrame {

    public TestTab() {
        setTitle("Tabbed Pane Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("This is panel 1"));
        panel1.add(new JButton("Button 1"));

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("This is panel 2"));
        panel2.add(new JButton("Button 2"));

        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("This is panel 3"));
        panel3.add(new JButton("Button 3"));

        tabbedPane.addTab("Tab 1", null, panel1, "Tab 1 tooltip");
        tabbedPane.addTab("Tab 2", null, panel2, "Tab 2 tooltip");
        tabbedPane.addTab("Tab 3", null, panel3, "Tab 3 tooltip");

        add(tabbedPane);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TestTab();
    }
}

