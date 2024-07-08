package View;

import Control.BurgerShop;
import Model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class SearchBestCustomer extends JFrame {

    private JLabel titleLabel;
    private JTable tbleData;
    private ButtonPattern btnBack;
    private DefaultTableModel dtm;
    SearchBestCustomer() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Search Best Customer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel();
        titleLabel.setBounds(0, 0, 800, 60);
        titleLabel.setText("Search Best Customer");
        titleLabel.setFont(new Font("", 1, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBackground(Color.RED);
        titleLabel.setOpaque(true);
        add(titleLabel);

        String[] columnNames={"Customer ID","Name","Total"};
        dtm=new DefaultTableModel(columnNames,0);
        tbleData=new JTable(dtm);

        JTableHeader header = tbleData.getTableHeader();
        tbleData.setRowHeight(0,50);
        //tbleData.setFont(new Font("",Font.BOLD,20));
        tbleData.getTableHeader().setPreferredSize(new Dimension(tbleData.getTableHeader().getWidth(), 40));


        JScrollPane pane=new JScrollPane(tbleData);
        pane.setBounds(150,120,500,300);
        add(pane);

        btnBack=new ButtonPattern("Back",50);
        btnBack.setBounds(580,480,180,50);
        btnBack.setFont(new Font("",1,15));
        add(btnBack);
        btnBack.addActionListener(evt ->{
            setVisible(false);
            SearchContent s1=new SearchContent();
            s1.setVisible(true);

        });

        loadCustomerData();



    }
    public void loadCustomerData(){
        Customer[] cust= BurgerShop.sortByPrice();

        for(Customer c1:cust){
            Object[] rowData={c1.getPhone(),c1.getCustomerName(),c1.getTotal()};
            dtm.addRow(rowData);
        }
    }
}
