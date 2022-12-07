public abstract class Pessoa {
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + '\'' +
                '}';
    }
}
