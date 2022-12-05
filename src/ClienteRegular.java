import java.util.Random;
public class ClienteRegular extends Cliente implements ClientInterface{
    private int id;
    private String name;
    private int desconto = 0;

    public int getDesconto() {
        return desconto;
    }


    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public int getId() {
        return id;
    }

    public ClienteRegular() {
    }

    public ClienteRegular(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void definirDesconto(){
        Random rand = new Random();
        int limite = 16;
        int desconto = rand.nextInt(limite);
        System.out.println("Clientes não VIP tem até 15% de desconto via sorteio");
        setDesconto(desconto);
        System.out.println("Desconto atual de: "+desconto+"%");
    }

    public void cashback(){
        System.out.println("Clientes não VIPs não tem direito a cashback");
    }

    public void cashback(int x){};

    @Override
    public String toString() {
        return "ClienteRegular{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desconto=" + desconto +
                '}';
    }
}
