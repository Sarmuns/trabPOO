import java.util.Random;

public class ClienteVIP extends ClienteRegular implements ClientInterface {
    private int id;
    private String name;
    private int desconto = 0;
    private boolean cashbackStatus;
    private int cashbackValor = 0;



    public int getCashbackValor() {
        return cashbackValor;
    }

    public void setCashbackValor(int cashbackValor) {
        this.cashbackValor = cashbackValor;
    }

    public boolean hasCashback() {
        return cashbackStatus;
    }

    public void setCashbackStatus(boolean cashbackStatus) {
        this.cashbackStatus = cashbackStatus;
    }

    @Override
    public int getDesconto() {
        return desconto;
    }

    @Override
    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    @Override
    public int getId() {
        return id;
    }

    public ClienteVIP(int id, String name) {
        super(id, name);
    }

    public ClienteVIP(int id, String name, boolean cashbackStatus) {
        this.id = id;
        this.name = name;
        this.cashbackStatus = cashbackStatus;
    }

    public void definirDesconto(){
        Random rand = new Random();
        int limite = 26;
        int desconto = rand.nextInt(limite);
        System.out.println("Clientes VIP tem até 25% de desconto via sorteio");
        setDesconto(desconto);
        System.out.println("Desconto atual de: "+desconto+"%");

    }

    public void cashback(){
        if(cashbackStatus){
            System.out.println("Cashback ativo");
        } else {
            System.out.println("Cashback não ativo");
        }
    }

    public void cashback(int X) throws cashbackException {
        if(X>10){
            throw new cashbackException();
        }
        if(cashbackStatus){
            System.out.println("Cashback ativo");
            setCashbackValor(X);
            System.out.println(X+"% de cashback total");
        } else {
            System.out.println("Cashback não ativo");
        }
    }

    @Override
    public String toString() {
        return "ClienteVIP{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desconto=" + desconto +
                ", cashbackStatus=" + cashbackStatus +
                ", cashbackValor=" + cashbackValor +
                '}';
    }
}
