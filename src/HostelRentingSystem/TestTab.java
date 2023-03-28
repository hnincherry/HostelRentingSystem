package HostelRentingSystem;
import java.awt.*;
import javax.swing.*;

public class TestTab extends JTabbedPane {
    
    public TestTab() {
        super(JTabbedPane.LEFT);
        setPreferredSize(new Dimension(200, 200)); // set preferred size of tabbed pane
        
        // add tabs
        addTab("Tab 1", new JLabel("This is tab 1."));
        addTab("Tab 2", new JLabel("This is tab 2."));
        addTab("Tab 3", new JLabel("This is tab 3."));
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Vertical Tabbed Pane Example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new TestTab());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}


