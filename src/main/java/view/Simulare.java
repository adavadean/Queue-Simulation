package view;
import model.Consumator;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Simulare extends JFrame {

    JFrame frame;
    JPanel panel, lpanel, top;
    JLabel label,simlabel;
    JTextField textfield;
    ArrayList<JLabel> sirlabels = new ArrayList<>();
    ArrayList<JTextField> sirtextfields = new ArrayList<>();
    JScrollPane scroll;
    public Simulare(int nrcozi, int timpcurent)
    {
        frame = new JFrame();
        panel = new JPanel();
        for (int i = 0; i < nrcozi; i++)
        {
            label=new JLabel("Coada "+(i+1)+":");
            label.setOpaque(true);
            sirlabels.add(label);
            textfield = new JTextField("închisă", 20);
            textfield.setOpaque(true);
            textfield.setEditable(false);
            sirtextfields.add(textfield);
        }
        lpanel = new JPanel(new GridBagLayout());
        GridBagConstraints textfieldc = new GridBagConstraints();
        GridBagConstraints labelc = new GridBagConstraints();
        scroll = new JScrollPane(lpanel);
        for (int i=0; i< nrcozi; i++)
        {
            textfieldc.gridx = 0;
            textfieldc.gridy = i;
            labelc.gridx = 1;
            labelc.gridy = i;
            lpanel.add(sirlabels.get(i),textfieldc);
            lpanel.add(sirtextfields.get(i),labelc);
        }
        top = new JPanel(new GridBagLayout());
        simlabel=new JLabel("Timpul: "+timpcurent);
        top.add(simlabel);
        panel.add(top, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        frame.add(panel);
        frame.setSize(700, 200);
        if(nrcozi==2)
            frame.setSize(700, 150);
        if(nrcozi>5)
            frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Simulare în progres");
    }
    public void updateladate(List<Consumator> consumatori, int timpcurent)
    {
        simlabel.setText("Timpul: "+timpcurent);
        for(int i=0; i < consumatori.size(); i++)
        {
            String sir="";
            if(consumatori.get(i).getClienti().isEmpty())
                sir="goală";
            else {
                for (int j = 0; j < consumatori.get(i).getClienti().size(); j++)
                {
                    sir+=  "☺";
                }
            }
            sirtextfields.get(i).setText(sir);
        }
    }
}












