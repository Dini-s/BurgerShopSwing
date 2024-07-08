package View;

import Control.BurgerShop;
import DB.CustomerList;
import Model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchCustomer extends JFrame {
    //public static CustomerList list=new CustomerList();

    private JLabel titleLabel;
    private  JLabel titleLabel2;

    private ButtonPattern btnBack;

    private JLabel labelId;
    private JLabel labelName;
    private JLabel labelName1;

    private JTable table;
    private DefaultTableModel dtm;

    private JTextField txtID;

    SearchCustomer() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Search Best Customer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel();
        titleLabel.setBounds(0, 0, 800, 60);
        titleLabel.setText("Search Customer");
        titleLabel.setFont(new Font("", 1, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBackground(Color.RED);
        titleLabel.setOpaque(true);
        add(titleLabel);

        labelId=new JLabel("Enter Customer Id:");
        labelId.setBounds(150,90,300,50);
        labelId.setFont(new Font("",1,15));
        add(labelId);

        txtID=new JTextField();
        txtID.setBounds(300,90,190,50);
        add(txtID);

        labelName=new JLabel("Name:");
        labelName.setBounds(150,150,250,50);
        labelName.setFont(new Font("",1,15));
        add(labelName);

        labelName1=new JLabel();
        labelName1.setBounds(250,150,300,50);
        add(labelName1);



        titleLabel2 = new JLabel();
        titleLabel2.setBounds(0, 210, 800, 30);
        titleLabel2.setText("Order Details");
        titleLabel2.setFont(new Font("", 1, 15));
        titleLabel2.setHorizontalAlignment(JLabel.CENTER);
        titleLabel2.setVerticalAlignment(JLabel.CENTER);
        titleLabel2.setForeground(Color.WHITE);
        titleLabel2.setBackground(Color.RED);
        titleLabel2.setOpaque(true);
        add(titleLabel2);

        String[] columnNames={"Order ID","Order Quantity","Total"};
        dtm=new DefaultTableModel(columnNames,0);
        table=new JTable(dtm);

        JTableHeader header = table.getTableHeader();
        table.setRowHeight(0,50);
        //tbleData.setFont(new Font("",Font.BOLD,20));
        table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 40));


        JScrollPane pane=new JScrollPane(table);
        pane.setBounds(150,260,500,200);
        add(pane);



        txtID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchCustomer();
            }
        });





        btnBack=new ButtonPattern("Back",50);
        btnBack.setBounds(580,480,180,50);
        btnBack.setFont(new Font("",1,15));
        add(btnBack);
        btnBack.addActionListener(evt ->{
            setVisible(false);
            SearchContent s1=new SearchContent();
            s1.setVisible(true);

        });
    }

    private void searchCustomer(){
        String ID=txtID.getText();
        if(BurgerShop.list.isContains(ID)){
            labelName1.setText(BurgerShop.list.getObject(ID).getCustomerName());
            updateOrderDetails(BurgerShop.list.getObject(ID));
        }
        else{
            JOptionPane.showMessageDialog(null,"Invalid Customer ID","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void updateOrderDetails(Customer customer){
        for(int i=0;i<BurgerShop.list.size();i++){
            Customer current=BurgerShop.list.get(i);
            if(customer.getPhone().equals(current.getPhone())){
                Object[] rowData= {
                        current.getOrdID(), current.getQty(), current.getTotal()
                };
                dtm.addRow(rowData);
            }
        }

    }

}
