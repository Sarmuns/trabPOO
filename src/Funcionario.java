public abstract class Funcionario extends Pessoa implements FuncInterface{
    private int id;
    private String name;
    private int salary;
    public String tipoEmpr;

    public Funcionario() {
    }

    public String getTipoEmpr() {
        return tipoEmpr;
    }

    public void setTipoEmpr(String tipoEmpr) {
        this.tipoEmpr = tipoEmpr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", tipoEmpr='" + tipoEmpr + '\'' +
                '}';
    }
}
