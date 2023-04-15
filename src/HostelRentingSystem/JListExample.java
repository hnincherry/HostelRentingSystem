package HostelRentingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class JListExample extends JFrame {
    private JList<String> dataList;
    private DefaultListModel<String> dataModel;
    private JScrollPane scrollPane;
    private JComboBox<String> filterComboBox;

    private ArrayList<String> originalDataList;

    public JListExample() {
        setTitle("JList Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // create the data list and model
        dataModel = new DefaultListModel<String>();
        dataList = new JList<String>(dataModel);
        scrollPane = new JScrollPane(dataList);
        add(scrollPane, BorderLayout.CENTER);

        // create the filter combo box
        filterComboBox = new JComboBox<String>();
        filterComboBox.addItem("All");
        filterComboBox.addItem("Item 1");
        filterComboBox.addItem("Item 2");
        filterComboBox.addItem("Item 3");
        filterComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateDataList();
            }
        });
        add(filterComboBox, BorderLayout.NORTH);

        // create some sample data
        originalDataList = new ArrayList<String>();
        originalDataList.add("Item 1");
        originalDataList.add("Item 2");
        originalDataList.add("Item 3");

        // populate the data model with the sample data
        for (String item : originalDataList) {
            dataModel.addElement(item);
        }

        pack();
        setVisible(true);
    }

    private void updateDataList() {
        // clear the data model
        dataModel.clear();

        // get the selected filter from the combo box
        String selectedFilter = (String) filterComboBox.getSelectedItem();

        // add the original data back to the model if the "All" filter is selected
        if (selectedFilter.equals("All")) {
            for (String item : originalDataList) {
                dataModel.addElement(item);
            }
        }
        // otherwise, add only the items that match the selected filter
        else {
            for (String item : originalDataList) {
                if (item.contains(selectedFilter)) {
                    dataModel.addElement(item);
                }
            }
        }
    }

    public static void main(String[] args) {
        new JListExample();
    }
}