package View;

import Control.BurgerShop;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame {

    ButtonPattern btnPlaceOrder;
    ButtonPattern btnSearch;
    ButtonPattern btnViewOrder;
    ButtonPattern btnUpdate;

    ButtonPattern btnExit;

    private JLabel titleLabel;
    private JLabel label;
    private ImageIcon image;
    private JLabel img;

    public HomePage(){
        setSize(800,600);
        setTitle("HomePage");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        //placeOrderButton
        btnPlaceOrder=new ButtonPattern("Place Order",50);
        btnPlaceOrder.setBounds(450,130,300,50);
        btnPlaceOrder.setFocusable(true);
        add(btnPlaceOrder);
        btnPlaceOrder.addActionListener(evt ->{
            setVisible(false);
            PlaceOrder p1=new PlaceOrder();
            p1.setVisible(true);

        });

        btnSearch=new ButtonPattern("Search",50);
        btnSearch.setBounds(450,200,300,50);
        btnSearch.setFocusable(false);
        btnSearch.addActionListener(evt ->{
            setVisible(false);
            SearchContent sc=new SearchContent();
            sc.setVisible(true);

        });
        add(btnSearch);

        btnViewOrder=new ButtonPattern("View Orders",50);
        btnViewOrder.setBounds(450,270,300,50);
        btnViewOrder.setFocusable(false);
        btnViewOrder.addActionListener(evt ->{
            setVisible(false);
            ViewOrders vo=new ViewOrders();
            vo.setVisible(true);

        });
        add(btnViewOrder);

        btnUpdate=new ButtonPattern("Update Orders",50);
        btnUpdate.setBounds(450,340,300,50);
        btnUpdate.setFocusable(false);
        btnUpdate.addActionListener(evt ->{
            setVisible(false);
            UpdateOrderDetails u=new UpdateOrderDetails();
            u.setVisible(true);
        });
        add(btnUpdate);

        btnExit=new ButtonPattern("Exit",50);
        btnExit.setBounds(650,450,100,50);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt ->{



        });
        add(btnExit);

        JPanel white = new JPanel();
        white.setBackground(Color.WHITE);
        white.setBounds(0, 0, 400,600);
        add(white);

        titleLabel=new JLabel("Welcome To Burgers");
        titleLabel.setBounds(5,10,300,50);
        titleLabel.setFont(new Font("",Font.BOLD,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(new Color(255,215,10));
        white.add(titleLabel);

        image=new ImageIcon("C:\\Users\\ACER\\Desktop\\BurgerShopFinal\\src\\images.jpg");
        img=new JLabel(image);

        img.setBounds(5,-500,500,500);
        img.setVerticalAlignment(JLabel.BOTTOM);
        white.add(img);
    }

}
