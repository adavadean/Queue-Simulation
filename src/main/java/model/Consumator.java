package model;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Consumator extends Thread {

    private BlockingQueue<Client> clienti;
    protected int r;
    public Consumator(int r) {
        this.clienti = new LinkedBlockingDeque<>();
        this.r = r;
    }
    public void adaugClient(Client client)
    {

        clienti.add(client);
    }
    public void eliminClient()
    {

        clienti.remove();

    }
    public int getTimpAsteptare()
    {
        int timpasteptare = 0;
        for (Client c : clienti)
        {
            timpasteptare= timpasteptare + c.getServicet();
        }

        return timpasteptare;
    }
    @Override
    public void run()
    {
        while (r==1)
        {
            if (clienti.size() > 0)
            {
                Client c=clienti.element();
                if(c.servicet>1)
                {
                    c.servicet--;
                }
                else{
                    eliminClient();
                }
            }
            try { sleep(1000); } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            try {
                Producator.semafor.acquire(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    public BlockingQueue<Client> getClienti()
    {
        return clienti;
    }
}
