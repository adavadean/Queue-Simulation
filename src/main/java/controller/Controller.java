package controller;
import model.Producator;
import view.ViewJPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{

    public ViewJPanel vview;
    public Producator prod;

    public Controller(ViewJPanel vview)
    {
        this.vview = vview;

    }
        public void actionPerformed(ActionEvent e)
        {
            Integer intervalsim = Integer.parseInt(vview.getintervalsim());
            Integer nrcozi= Integer.parseInt(vview.getnrcozi());
            Integer nrclienti = Integer.parseInt(vview.getnrclienti());
            Integer minintervalsosire= Integer.parseInt(vview.getminintervalsosire());
            Integer maxintervalsosire = Integer.parseInt(vview.getmaxintervalsosire());
            Integer minintervalservire = Integer.parseInt(vview.getminintervalservire());
            Integer maxintervalservire = Integer.parseInt(vview.getmaxintervalservire());
            prod = new Producator(intervalsim, nrcozi, nrclienti);
            prod.generareClienti(nrclienti, minintervalsosire, maxintervalsosire, minintervalservire,maxintervalservire);
            prod.creareConsumatori(nrcozi);
            Thread T = new Thread(prod);
            T.start();
        }
    }