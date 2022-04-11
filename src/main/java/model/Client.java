package model;

public class Client {
    private  int id;
    protected int arrivalt;
    protected int servicet;
    public Client(int id, int arrivalt, int servicet) {
        this.id = id;
        this.arrivalt = arrivalt;
        this.servicet = servicet;
    }
    public int getArrivalt() {
        return arrivalt;
    }
    public int getServicet() {
        return servicet;
    }
    @Override
    public String toString() {
        return "(" +id +","+arrivalt +","+servicet+") ";
    }
}
