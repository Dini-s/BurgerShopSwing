package View;

import javax.swing.*;
import java.awt.*;

public class SearchContent extends JFrame {
    private JLabel titleLabel;

    private ImageIcon image;
    private JLabel image2;

    ButtonPattern btnBestCust;
    ButtonPattern btnSearchCust;
    ButtonPattern btnSearchOrder;
    ButtonPattern btnBack;



    public SearchContent(){

        setSize(800,600);
        setLocationRelativeTo(null);
        setTitle("Search Content");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel=new JLabel();
        titleLabel.setBounds(0,0,800,60);
        titleLabel.setText("Search Content");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBackground(Color.RED);
        titleLabel.setOpaque(true);
        add(titleLabel);

        JPanel white = new JPanel();
        white.setBackground(Color.WHITE);
        white.setBounds(0, 60, 400,600);
        add(white);

        JLabel lableSpace=new JLabel(" ");
        lableSpace.setBounds(0, 0, 400,60);
        white.add(lableSpace);

        image=new ImageIcon("C:\\Users\\ACER\\Desktop\\BurgerShopFinal\\src\\images.jpg");
        image2=new JLabel(image);
        image2.setBounds(5,100,500,500);
        image2.setVerticalAlignment(JLabel.BOTTOM);
        white.add(image2);

        btnBestCust=new ButtonPattern("Search Best Customer ",50);
        btnBestCust.setBounds(450,170,250,50);
        setFont(new Font("",1,15));
        btnBestCust.addActionListener(evt ->{

            btnBestCust.setBackground(Color.GREEN);

            btnSearchCust.setBackground(Color.RED);
            btnSearchOrder.setBackground(Color.RED);

            setVisible(false);
            SearchBestCustomer b1=new SearchBestCustomer();
            b1.setVisible(true);

        });
        add(btnBestCust);

        btnSearchCust=new ButtonPattern("Search Customer ",50);
        btnSearchCust.setBounds(450,240,250,50);
        setFont(new Font("",1,15));
        btnSearchCust.addActionListener(evt ->{

            btnSearchCust.setBackground(Color.GREEN);

            btnBestCust.setBackground(Color.RED);
            btnSearchOrder.setBackground(Color.RED);

            setVisible(false);
            SearchCustomer c1=new SearchCustomer();
            c1.setVisible(true);



        });
        add(btnSearchCust);

        btnSearchOrder=new ButtonPattern("Search Order Details ",50);
        btnSearchOrder.setBounds(450,310,250,50);
        setFont(new Font("",1,15));
        btnSearchOrder.addActionListener(evt ->{

            btnSearchOrder.setBackground(Color.GREEN);

            btnSearchCust.setBackground(Color.RED);
            btnSearchOrder.setBackground(Color.RED);

            setVisible(false);
            SearchOrder c1=new SearchOrder();
            c1.setVisible(true);

        });
        add(btnSearchOrder);

        btnBack=new ButtonPattern("Back",50);
        btnBack.setBounds(650,450,100,50);
        btnBack.setFocusable(false);
        btnBack.addActionListener(evt ->{
            setVisible(false);
            HomePage h=new HomePage();
            h.setVisible(true);



        });
        add(btnBack);

    }
}
