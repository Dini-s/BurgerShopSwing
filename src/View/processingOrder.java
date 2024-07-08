package View;

import Control.BurgerShop;
import Model.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

public class processingOrder extends JFrame {

    private  JLabel titleLabel;
    private JTable table;
    private DefaultTableModel dtm;
    processingOrder(){
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Search Order Details");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel();
        titleLabel.setBounds(0, 0, 800, 60);
        titleLabel.setText("Processing Orders");
        titleLabel.setFont(new Font("", 1, 25));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBackground(Color.RED);
        titleLabel.setOpaque(true);
        add(titleLabel);

        String[] columnNames={"Order ID","Customer Id","Name","Order Qty","Total"};
        dtm=new DefaultTableModel(columnNames,0);
        table=new JTable(dtm);

        JTableHeader header = table.getTableHeader();
        table.setRowHeight(0,50);

        TableColumn column = table.getColumnModel().getColumn(2);
        column.setPreferredWidth(250);

        //tbleData.setFont(new Font("",Font.BOLD,20));
        table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 40));

        loadData();

        JScrollPane pane=new JScrollPane(table);
        pane.setBounds(85,120,600,200);
        add(pane);
        ButtonPattern btnBack = new ButtonPattern("Back", 50);
        btnBack.setBounds(580,480,180,50);
        btnBack.setFont(new Font("",1,15));
        add(btnBack);
        btnBack.addActionListener(evt ->{
            setVisible(false);
            ViewOrders s1=new ViewOrders();
            s1.setVisible(true);

        });
    }
    private void loadData(){
        for(int i=0;i< BurgerShop.list.size();i++){
            if(BurgerShop.list.get(i).getOrdStatus()==0){
                Customer current=BurgerShop.list.get(i);
                Object[] rowData={
                    current.getOrdID(),current.getPhone(),current.getCustomerName(),current.getQty(),current.getTotal()
                };
                dtm.addRow(rowData);
            }
        }
    }

}
