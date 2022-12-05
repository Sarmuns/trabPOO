public class EmpregadoComDeficiencia extends Funcionario{
    private int id;
    private String name;
    private int salary;
    private String tipoDeficiencia;
    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    @Override
    public int getId() {
        return id;
    }

    public EmpregadoComDeficiencia(int id, String name, int salary, String tipoDeficiencia) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.tipoDeficiencia = tipoDeficiencia;
    }

    public double calcularBonus(){
        System.out.println("25% do salario de bonus:");
        return(this.salary*0.25);
    }

    public double calcularBonus(int X){
        System.out.println(X+"% de bonus especial");
        return (this.salary*X/100);
    }

    @Override
    public String toString() {
        return "EmpregadoComDeficiencia{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", tipoDeficiencia='" + tipoDeficiencia + '\'' +
                '}';
    }
}
