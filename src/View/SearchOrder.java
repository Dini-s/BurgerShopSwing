package View;

import Control.BurgerShop;
import DB.CustomerList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class SearchOrder extends JFrame
{
    //public static CustomerList list=new CustomerList();
    private JLabel titleLabel;

    private JLabel id;
    private JLabel custId;
    private JLabel Name;
    private JLabel qty;
    private JLabel total;
    private JLabel status;
    private JLabel custId1;
    private JLabel Name1;
    private JLabel qty1;
    private JLabel total1;
    private JLabel status1;

    private JTextField id1;


    SearchOrder() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Search Order Details");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel();
        titleLabel.setBounds(0, 0, 800, 60);
        titleLabel.setText("Search Order Details");
        titleLabel.setFont(new Font("", 1, 25));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBackground(Color.RED);
        titleLabel.setOpaque(true);
        add(titleLabel);

        id=new JLabel("Enter OrderID: ");
        id.setFont(new Font("",1,15));
        id.setBounds(150,100,250,50);
        add(id);

        id1=new JTextField();
        id1.setBounds(270,100,200,40);
        id1.setFont(new Font("",1,15));
        add(id1);

        custId=new JLabel("Customer ID :");
        custId.setBounds(180,180,300,50);
        custId.setFont(new Font("",1,15));
        add(custId);

        custId1=new JLabel();
        custId1.setBounds(290,180,300,50);
        custId1.setFont(new Font("",1,15));
        add(custId1);

        Name=new JLabel ("Name :");
        Name.setBounds(180,220,300,50);
        Name.setFont(new Font("",1,15));
        add(Name);

        Name1=new JLabel();
        Name1.setBounds(290,220,300,50);
        Name1.setFont(new Font("",1,15));
        add(Name1);

        qty=new JLabel("Quantity :");
        qty.setBounds(180,280,300,50);
        qty.setFont(new Font("",1,15));
        add(qty);

        qty1=new JLabel();
        qty1.setBounds(290,280,300,50);
        qty1.setFont(new Font("",1,15));
        add(qty1);

        total=new JLabel("Total :");
        total.setFont(new Font("",1,15));
        total.setBounds(180,340,300,50);
        add(total);

        total1=new JLabel();
        total1.setFont(new Font("",1,15));
        total1.setBounds(290,340,300,50);
        add(total1);

        status=new JLabel("Order Status :");
        status.setFont(new Font("",1,15));
        status.setBounds(180,400,300,50);
        add(status);

        status1=new JLabel();
        status1.setFont(new Font("",1,15));
        status1.setBounds(290,400,300,50);
        add(status1);

        id1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCustomerId();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCustomerId();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCustomerId();
            }

            private void updateCustomerId() {
                String ordID=id1.getText();
                if(BurgerShop.list.isContains(ordID)){
                    JOptionPane.showMessageDialog(null,"OrderID found.");
                    custId1.setText(BurgerShop.list.getObject(ordID).getPhone());
                    Name1.setText(BurgerShop.list.getObject(ordID).getCustomerName());
                    qty1.setText(String.valueOf(BurgerShop.list.getObject(ordID).getQty()));
                    total1.setText(String.valueOf(BurgerShop.list.getObject(ordID).getTotal()));
                    if(BurgerShop.list.getObject(ordID).getOrdStatus()==2){
                        status1.setText("Cancel....");
                    }
                    else if(BurgerShop.list.getObject(ordID).getOrdStatus()==0){
                        status1.setText("Preparing....");
                    }
                    else{
                        status1.setText("Delivered....");
                    }
                    //status1.setText(String.valueOf(BurgerShop.list.getObject(ordID).getOrdStatus()));
                }

            }
        });

        ButtonPattern btnBack = new ButtonPattern("Back", 50);
        btnBack.setBounds(580,480,180,50);
        btnBack.setFont(new Font("",1,15));
        add(btnBack);
        btnBack.addActionListener(evt ->{
            setVisible(false);
            SearchContent s1=new SearchContent();
            s1.setVisible(true);

        });



    }
}
