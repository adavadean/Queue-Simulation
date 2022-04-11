package view;
import controller.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewJPanel extends JPanel implements ActionListener {
    Controller controller=new Controller(this);
    JLabel l1=new JLabel("Număr persoane:");
    JLabel l2=new JLabel("Număr cozi:");
    JLabel l3=new JLabel("Interval de simulare:");
    JLabel l4=new JLabel("Interval timp de sosire:");
    JLabel l5=new JLabel("Interval timp de servire:");
    JTextField t1=new JTextField();
    JTextField t2=new JTextField();
    JTextField t3=new JTextField();
    JTextField t4=new JTextField();
    JTextField t5=new JTextField();
    JTextField t6=new JTextField();
    JTextField t7=new JTextField();
    JButton b1=new JButton("Porniți simularea");
    ViewJPanel(){
        setLayout(null);
        l1.setBounds(100,20,350,20);
        t1.setBounds(250,20,50,20);
        l2.setBounds(100,80,350,20);
        t2.setBounds(250,80,50,20);
        l3.setBounds(100,140,350,20);
        t3.setBounds(250,140,50,20);
        l4.setBounds(100,200,350,20);
        t4.setBounds(250,200,50,20);
        t5.setBounds(350,200,50,20);
        l5.setBounds(100,260,350,20);
        t6.setBounds(250,260,50,20);
        t7.setBounds(350,260,50,20);
        b1.setBounds(200,320,300,50);
        b1.setActionCommand("Porniti simularea");
        b1.addActionListener(this.controller);
        add(b1);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(t7);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
    }
    @Override
    public void actionPerformed(ActionEvent e) {}
    public String getnrclienti() {
        return t1.getText();
    }
    public String  getnrcozi() {return t2.getText();}
    public String  getintervalsim() {
        return t3.getText();
    }
    public String  getminintervalsosire() {return t4.getText();}
    public String getmaxintervalsosire() {
        return t5.getText();
    }
    public String  getminintervalservire() {
        return t6.getText();
    }
    public String  getmaxintervalservire() {
        return t7.getText();
    }
}
