package model;
import view.Simulare;
import fisier.Fisier;
import java.util.*;
import java.util.concurrent.Semaphore;

public class Producator extends Thread{
    protected static Semaphore semafor= new Semaphore(0);
    private List<Client> listaclienti;
    private List<Consumator> consumatori;
    private final Simulare sim;
    private final int timpdesim;
    private int iteratiisim=0;
    private int nrclienti=0;

    public Producator(int timpdesim,int nrcozi,int nrclienti)
    {
        this.timpdesim = timpdesim;
        this.sim=new Simulare(nrcozi,timpdesim);
        this.nrclienti=nrclienti;
    }
    public void generareClienti(int nrclienti, int minintervalsosire, int maxintervalsosire, int minintervalservire, int maxintervalservire)
    {
        Random random = new Random();
        int j= 1;
        listaclienti = new ArrayList<>();
        for (int i = 0; i < nrclienti; i++)
        {
            int timpser=random.nextInt(maxintervalservire - minintervalservire + 1) + minintervalservire;
            int timpsos=random.nextInt(maxintervalsosire - minintervalsosire + 1) +minintervalsosire;
            listaclienti.add(new Client(j++,timpsos,timpser));
        }
        Collections.sort(listaclienti, Comparator.comparing(Client::getArrivalt));
    }
    public void creareConsumatori(int nrconsumatori)
    {
        consumatori = new ArrayList<>();
        for (int i = 0; i < nrconsumatori; i++)
        {
            consumatori.add(new Consumator(1));
        }
        for (int i = 0; i < nrconsumatori; i++)
        {
            consumatori.get(i).start();
        }
    }
    public boolean cozineocupate()
    {
        for(int i=0;i<consumatori.size();i++)
        {
            if (!consumatori.get(i).getClienti().isEmpty())
            {
                return false;
            }
        }
        return true;
    }
    public int gettimpminasteptare()
    {
        int timpmin = Integer.MAX_VALUE;
        int nrcoada = 0;
        for (int i = 0; i < consumatori.size(); i++)
        {
            int minim = consumatori.get(i).getTimpAsteptare();
            if (minim < timpmin)
            {
                timpmin = minim;
                nrcoada = i;
            }
        }
        return nrcoada;
    }
    public void stopsim()
    {
        for (int i = 0; i < consumatori.size(); i++)
        {
            consumatori.get(i).r=0;
        }
    }
    @Override
    public void run()
    {
        while (iteratiisim <= timpdesim)
        {
            while (listaclienti.size() > 0 && listaclienti.get(0).arrivalt == iteratiisim)
            {
                Client c = listaclienti.remove(0);
                consumatori.get(gettimpminasteptare()).adaugClient(c);
            }
            sim.updateladate(consumatori,iteratiisim);
            Fisier.dateinfisier(consumatori,listaclienti,iteratiisim);
            if(cozineocupate() && listaclienti.isEmpty()) break;
            semafor.release(consumatori.size());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
           iteratiisim++;
        }
        this.stopsim();
    }
}



