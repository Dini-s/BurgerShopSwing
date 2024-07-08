package View;

import Control.BurgerShop;

import javax.swing.*;
import java.awt.*;

public class ViewOrders extends JFrame {
    private ButtonPattern btnDeliver;
    private ButtonPattern btnProcess;
    private ButtonPattern btnCancel;
    private ButtonPattern btnExit;
    private ButtonPattern btnBack;
    private JLabel titleLabel;
    private JLabel titleLabel2;

    private ImageIcon image;
    private JLabel img;
    ViewOrders(){
        setSize(800,600);
        setTitle("View Orders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);



        btnDeliver=new ButtonPattern("Delivered Orders",50);
        btnDeliver.setBounds(450,170,300,50);
        btnDeliver.setFocusable(false);
        add(btnDeliver);
        btnDeliver.addActionListener(evt ->{
            setVisible(false);
            DeliveredOrder d1=new DeliveredOrder();
            d1.setVisible(true);
        });

        btnProcess=new ButtonPattern("Processing Orders",50);
        btnProcess.setBounds(450,240,300,50);
        btnProcess.setFocusable(false);
        btnProcess.addActionListener(evt ->{
            setVisible(false);
            processingOrder p1=new processingOrder();
            p1.setVisible(true);
        });
        add(btnProcess);

        btnCancel=new ButtonPattern("Canceled Orders",50);
        btnCancel.setBounds(450,310,300,50);
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(evt ->{
            setVisible(false);
            CanceledOrder c1=new CanceledOrder();
            c1.setVisible(true);
        });
        add(btnCancel);

        btnExit=new ButtonPattern("Exit",50);
        btnExit.setBounds(650,450,100,50);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt ->{

            //BurgerShop.exit();

        });
        add(btnExit);

        btnBack=new ButtonPattern("Home Page",50);
        btnBack.setBounds(475,450,100,50);
        btnBack.setFocusable(false);
        btnBack.addActionListener(evt ->{
            setVisible(false);
            HomePage h1=new HomePage();
            h1.setVisible(true);

        });
        add(btnBack);

        JPanel white = new JPanel();
        white.setBackground(Color.WHITE);
        white.setBounds(0, 0, 400,600);
        add(white);

        titleLabel=new JLabel("Welcome to Burgers");
        titleLabel.setBounds(5,10,300,100);
        titleLabel.setFont(new Font("",Font.BOLD,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.ORANGE);
        white.add(titleLabel);

        image=new ImageIcon("C:\\Users\\ACER\\Desktop\\BurgerShopFinal\\src\\images.jpg");
        img=new JLabel(image);

        img.setBounds(5,120,500,500);
        img.setVerticalAlignment(JLabel.BOTTOM);
        white.add(img);

        titleLabel2=new JLabel();
        titleLabel2.setText("View Orders");
        titleLabel2.setBounds(400,0,400,60);
        titleLabel2.setFont(new Font("",1,20));
        titleLabel2.setHorizontalAlignment(JLabel.CENTER);
        titleLabel2.setVerticalAlignment(JLabel.CENTER);
        titleLabel2.setBackground(Color.RED);
        titleLabel2.setForeground(Color.WHITE);
        titleLabel2.setOpaque(true);
        add(titleLabel2);
    }
}
