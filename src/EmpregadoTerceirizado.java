public class EmpregadoTerceirizado extends Funcionario{
    private int id;
    private String name;
    private int salary;

    @Override
    public int getId() {
        return id;
    }


    public EmpregadoTerceirizado(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double calcularBonus(){
        System.out.println("Infelizmente terceirizados não tem bonus");
        return 0;
    }

    public double calcularBonus(int X){
        System.out.println("Infelizmente terceirizados não tem bonus especial");
        return 0;
    }

    @Override
    public String toString() {
        return "EmpregadoTerceirizado{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
