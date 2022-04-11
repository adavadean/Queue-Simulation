package view;
import javax.swing.*;
public class View {

    public static void main(String []args){
        ViewJFrame R=new ViewJFrame();
        R.setTitle(" Simulare cozi ");
    }
}
class ViewJFrame extends JFrame {

    ViewJPanel P=new ViewJPanel();
    ViewJFrame(){
        setDefaultCloseOperation(ViewJFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
        setResizable(false);
        add(P);
        setVisible(true);
    }
}