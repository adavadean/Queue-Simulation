package fisier;
import model.Client;
import model.Consumator;
import java.io.*;
import java.util.List;

public class Fisier {

    public static void dateinfisier(List<Consumator> consumatori, List<Client> listaclienti, int timpcurent)
    {
        FileWriter f;
        PrintWriter p;
        try {
            f = new FileWriter("Rezultat1.txt", true);
            p = new PrintWriter(f);
            p.write("Timp: " + timpcurent);
            p.write("\n");
            p.write("Clienți în așteptare:");
            for (Client c : listaclienti)
            {
                p.write("\n");
                p.write(c.toString());

            }
            p.write("\n");
            for (int i = 0; i < consumatori.size(); i++)
            {
                p.write("Coada " + (i + 1) + ":");
                if (consumatori.get(i).getClienti().isEmpty())
                    p.write("goală\n");
                else {
                    for (Client c : consumatori.get(i).getClienti())
                    {
                        p.write(c.toString());
                    }
                    p.write("\n");
                }
            }
            p.write("\n");
            p.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


