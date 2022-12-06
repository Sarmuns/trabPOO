class Empregado extends Funcionario{
    private int id;
    private String name;
    private int salary;

    public Empregado() {
    }

    Empregado(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public int getSalary() {
        return salary;
    }
    public String getName() {
        return name;
    }

    public double calcularBonus(){
        System.out.println("15% do salario de bonus");
        return (this.salary*0.15);
    }

    public double calcularBonus(int X) throws bonusException{
        if(X>25){
            throw new bonusException();
        } else{
            System.out.println(X+"% de bonus especial");
            return (this.salary*X/100);
        }
    }

    @Override
    public String toString() {
        return "Empregado{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}