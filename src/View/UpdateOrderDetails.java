package View;

import Control.BurgerShop;
import Model.Customer;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateOrderDetails extends JFrame {

    private JLabel orderStatus;
    private JLabel ordID;
    private JLabel custID;
    private JLabel custName;
    private JLabel ordQty;
    private JLabel total;
    private JLabel msgLabel;
    private JLabel total1;
    private JLabel titleLabel;

    private JComboBox<String> ordStatusCombo;

    private JTextField ordID1;
    private JTextField custID1;
    private JTextField custName1;
    private JTextField ordQty1;

    private ButtonPattern btnUpdate;
    private ButtonPattern btnBack;


    UpdateOrderDetails(){
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Update Order");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel();
        titleLabel.setBounds(0, 0, 800, 60);
        titleLabel.setText("Update Order");
        titleLabel.setFont(new Font("", 1, 25));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBackground(Color.RED);
        titleLabel.setOpaque(true);
        add(titleLabel);

        orderStatus =new JLabel();
        orderStatus.setText("Order Status:");
        orderStatus.setBounds(75,90,300,50);
        orderStatus.setFont(new Font("",1,15));
        add(orderStatus);

        String[] status={"Pending..","Delivered","Cancelled"};
        ordStatusCombo=new JComboBox<>(status);
        ordStatusCombo.setBounds(200,90,200,50);
        add(ordStatusCombo);

        //msg for canceled and delivered orders
        msgLabel=new JLabel();
        msgLabel.setForeground(Color.RED);
        msgLabel.setBounds(450,120,150,100);
        add(msgLabel);

        ordID =new JLabel();
        ordID.setText("Order ID:");
        ordID.setBounds(75,150,300,50);
        ordID.setFont(new Font("",1,15));
        add(ordID);

        ordID1=new JTextField();
        ordID1.setBounds(200,150,200,40);
        add(ordID1);

        custID =new JLabel();
        custID.setText("Customer ID:");
        custID.setBounds(75,210,300,50);
        custID.setFont(new Font("",1,15));
        add(custID);

        custID1=new JTextField();
        custID1.setBounds(200,210,200,40);
        add(custID1);

        custName =new JLabel();
        custName.setText("Customer Name:");
        custName.setBounds(75,270,300,50);
        custName.setFont(new Font("",1,15));
        add(custName);

        custName1=new JTextField();
        custName1.setBounds(200,270,200,40);
        add(custName1);

        ordQty =new JLabel();
        ordQty.setText("Order QTY:");
        ordQty.setBounds(75,330,300,50);
        ordQty.setFont(new Font("",1,15));
        add(ordQty);

        ordQty1=new JTextField();
        ordQty1.setBounds(200,330,200,40);
        add(ordQty1);

        total =new JLabel();
        total.setText("Total:");
        total.setBounds(75,390,300,50);
        total.setFont(new Font("",1,15));
        add(total);

        total1 =new JLabel();
        total1.setBounds(200,390,300,50);
        total1.setFont(new Font("",1,15));
        total1.setForeground(Color.RED);
        add(total1);

        btnUpdate=new ButtonPattern("Update Order",50);
        btnUpdate.setFont(new Font("", 1, 15));
        btnUpdate.setBounds(400, 460, 180, 50);
        add(btnUpdate);

        btnBack=new ButtonPattern("Back",50);
        btnBack.setFont(new Font("", 1, 15));
        btnBack.setBounds(580, 460, 180, 50);
        add(btnBack);

        ordStatusCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ordStatusCombo.getSelectedItem().equals("Cancelled") || ordStatusCombo.getSelectedItem().equals("Delivered")){
                    custID1.setEditable(false);
                    custName1.setEditable(false);
                    ordQty1.setEditable(false);
                    msgLabel.setText("this Order can not change");

                }
                else{
                    custID1.setEditable(true);
                    custName1.setEditable(true);
                    ordQty1.setEditable(true);
                    msgLabel.setText("");

                }
            }
        });

        ordQty1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setTotal();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setTotal();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setTotal();
            }

            private void setTotal(){
                try {
                    int qty = Integer.parseInt(ordQty1.getText());
                    double price = qty * BurgerShop.UNITPRICE;
                    total1.setText(String.format("%.2f", price));
                }catch (NumberFormatException e){
                    total1.setText("0.00");
                }
            }
        });

        ordID1.getDocument().addDocumentListener(new DocumentListener() {
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
                String ordID=ordID1.getText();
                if(BurgerShop.list.isContains(ordID)){
                    JOptionPane.showMessageDialog(null,"OrderID found.");
                    custID1.setText(BurgerShop.list.getObject(ordID).getPhone());
                    custName1.setText(BurgerShop.list.getObject(ordID).getCustomerName());
                    ordQty1.setText(String.valueOf(BurgerShop.list.getObject(ordID).getQty()));

                }


            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String state=(String) ordStatusCombo.getSelectedItem();
                int num;
                if(state.equals("Pending..")){
                    num=0;
                }
                else if(state.equals("Delivered")){
                    num=1;
                }
                else{
                    num=2;
                }
                int qty=Integer.parseInt(ordQty1.getText());
                double tot=Double.parseDouble(total1.getText());
                String ID=ordID1.getText();
                Customer existDetail=BurgerShop.list.getObject(ID);
                if(existDetail!=null){
                    existDetail.setOrderStatus(num);
                    existDetail.setOrderQTY(qty);
                    existDetail.setPrice(tot);
                    JOptionPane.showMessageDialog(null, "Order Updated successfully!");
                }


            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                HomePage h=new HomePage();
                h.setVisible(true);
            }
        });


    }
}
