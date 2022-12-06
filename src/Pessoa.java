public abstract class Pessoa {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void dizNome(){
        System.out.println("Nome : "+getName());
    }
    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + '\'' +
                '}';
    }
}
