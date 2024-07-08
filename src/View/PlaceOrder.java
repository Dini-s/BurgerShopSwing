package View;

import Control.BurgerShop;
import DB.CustomerList;
import Model.Customer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaceOrder extends JFrame {

    //lables
    private JLabel lableOrderId;
    private JLabel lableCustomerID;
    private JLabel lableCustomerName;
    private JLabel lableQty;
    private JLabel lableStatus;
    private JLabel netTotal;
    private JLabel titleLable;
    private  JLabel ordId;
    private JLabel amount;



    //buttons
    private ButtonPattern btnPlaceOrder;
    private ButtonPattern btnBack;
    private ButtonPattern btnCancel;

    //text field



    private  JTextField txtPhone;
    private JTextField customerName;
    private JTextField qty;

    //public static CustomerList list=new CustomerList();

    public String ordsId;

    public PlaceOrder() {

        Customer customer = new Customer();

        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("PlaceOrder");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);


        titleLable = new JLabel();
        titleLable.setBounds(0, 0, 800, 60);
        titleLable.setText("Place Order");
        titleLable.setFont(new Font("", 1, 30));
        titleLable.setForeground(Color.WHITE);
        titleLable.setVerticalAlignment(JLabel.CENTER);
        titleLable.setHorizontalAlignment(JLabel.CENTER);
        titleLable.setBackground(Color.RED);
        titleLable.setOpaque(true);

        add(titleLable);

        lableOrderId = new JLabel();
        lableOrderId.setText("Order Id:");
        lableOrderId.setBounds(80, 130, 300, 50);
        lableOrderId.setFont(new Font("", 1, 15));
        add(lableOrderId);


        lableCustomerID = new JLabel();
        lableCustomerID.setText("Customer ID:");
        lableCustomerID.setBounds(80, 200, 300, 50);
        lableCustomerID.setFont(new Font("", 1, 15));
        add(lableCustomerID);

        lableCustomerName = new JLabel();
        lableCustomerName.setText("Customer Name:");
        lableCustomerName.setBounds(80, 270, 300, 50);
        lableCustomerName.setFont(new Font("", 1, 15));
        add(lableCustomerName);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(65, 350, 350, 10);
        add(separator);

        lableQty = new JLabel();
        lableQty.setText("Burger QTY:");
        lableQty.setBounds(80, 400, 300, 50);
        lableQty.setFont(new Font("", 1, 15));
        add(lableQty);

        lableStatus = new JLabel();
        lableStatus.setText("Order Status:");
        lableStatus.setBounds(80, 450, 300, 50);
        lableStatus.setFont(new Font("", 1, 15));
        add(lableStatus);

        //ordsId=BurgerShop.getOrdID();
        ordId = new JLabel(BurgerShop.getOrdID());
        ordId.setBounds(200, 130, 200, 50);
        add(ordId);

        txtPhone = new JTextField();
        txtPhone.setBounds(230, 200, 220, 40);

        add(txtPhone);
        txtPhone.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCustomerName();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCustomerName();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCustomerName();
            }

            private void updateCustomerName() {
                String p_num = txtPhone.getText();
                if (BurgerShop.list.isContains(p_num)) {
                    customerName.setText(BurgerShop.list.getObject(p_num).getCustomerName());
                }
            }
        });


        customerName = new JTextField();
        customerName.setBounds(220, 285, 220, 40);
        add(customerName);

        qty = new JTextField();
        qty.setBounds(190, 400, 220, 40);
        add(qty);

        JLabel setStatus = new JLabel("Pending.....");
        setStatus.setBounds(200, 455, 300, 40);
        setStatus.setFont(new Font("", 1, 15));
        add(setStatus);

        netTotal = new JLabel();
        netTotal.setText("Net Amount :");
        netTotal.setBounds(500, 430, 300, 50);
        netTotal.setFont(new Font("", 1, 15));
        add(netTotal);

        amount = new JLabel();
        amount.setText("0");
        amount.setBounds(650, 430, 300, 50);
        amount.setFont(new Font("", 1, 20));
        amount.setForeground(Color.red);
        add(amount);

        JButton btnAdd = new JButton("Calculate Net Price");
        btnAdd.setBounds(570, 390, 150, 40);
        btnAdd.setFocusable(false);
        btnAdd.setFont(new Font("", 1, 10));
        btnAdd.setBorderPainted(false);
        btnAdd.setBackground(Color.RED);
        add(btnAdd);
        btnAdd.addActionListener(evt -> {
            int qty1 = Integer.parseInt(qty.getText());
            qty1 *= BurgerShop.UNITPRICE;
            amount.setText(qty1 + "/=");
        });

        btnPlaceOrder = new ButtonPattern("Place Order", 50);
        btnPlaceOrder.setFont(new Font("", 1, 18));
        btnPlaceOrder.setBounds(495, 170, 250, 50);

        btnPlaceOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double price = Integer.parseInt(qty.getText()) * BurgerShop.UNITPRICE;
                int qty1 = Integer.parseInt(qty.getText());
               /* customer.setCustomerName(customerName.getText());
                customer.setOrdersId( ordId.getText());
                customer.setPhone(txtPhone.getText());
                customer.setOrderStatus(BurgerShop.PREPARING);
                customer.setOrderQTY(qty1);
                customer.setOrderValue(price);
                BurgerShop.list.add(customer);*/
                BurgerShop.list.add(new Customer(txtPhone.getText(), customerName.getText(), ordId.getText(), BurgerShop.PREPARING, qty1, price));
                System.out.println(BurgerShop.list.getLast().toString());
                JOptionPane.showMessageDialog(null, "Order placed successfully!");

                ordId.setText(BurgerShop.getOrdID());
                clearFields();
            }
        });
        add(btnPlaceOrder);

        btnBack = new ButtonPattern("Back to home page", 50);
        btnBack.setFont(new Font("", 1, 15));
        btnBack.setBounds(495, 240, 250, 50);

        btnBack.addActionListener(evt -> {

            btnBack.setBackground(Color.GREEN);
            setVisible(false);
            HomePage h1 = new HomePage();
            h1.setVisible(true);

        });
        add(btnBack);

        btnCancel = new ButtonPattern("Cancel", 50);
        btnCancel.setFont(new Font("", 1, 15));
        btnCancel.setBounds(495, 310, 250, 50);

        btnCancel.addActionListener(evt -> {

            btnCancel.setBackground(Color.GREEN);
            clearFields();


        });
        add(btnCancel);

    }
    public void clearFields(){

        txtPhone.setText(null);
        customerName.setText(null);
        qty.setText(null);
        amount.setText("0");
    }





}
