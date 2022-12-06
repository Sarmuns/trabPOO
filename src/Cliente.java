public abstract class Cliente extends Pessoa implements ClientInterface{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void cashback(){};

    public void cashback(int x) throws cashbackException {};
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
