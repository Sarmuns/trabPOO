import java.io.IOException;
import java.util.*;
import java.io.FileWriter;
class crudOperation {
    public static void main(String args[]) throws IOException, cashbackException, bonusException {
        List<Funcionario> c = new ArrayList < Funcionario>();

        c.add(new EmpregadoComDeficiencia(1, "Samu",1200,"Cegueira"));
        c.add(new Empregado(2, "Sam", 2000));
        c.add(new EmpregadoTerceirizado(3,"Samuel",800));

        List<Cliente> d = new ArrayList<Cliente>();

        d.add(new ClienteRegular(1,"Filipe"));
        d.add(new ClienteVIP(2,"Flip", true));

        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);


        int ch;
        do {
            System.out.println("1.Adicionar Funcionario");
            System.out.println("2.Mostrar Funcionarios");
            System.out.println("3.Procurar Funcionario");
            System.out.println("4.Deletar Funcionario");
            System.out.println("5.Atualizar Funcionario");
            System.out.println("6.Cadastrar Cliente");
            System.out.println("7.Mostrar Clientes");
            System.out.println("8.Procurar/Atualizar Cliente");
            System.out.println("9.Deletar Cliente");
            System.out.println("0.Sair");
            System.out.print("Digite sua escolha : ");
            ch = s.nextInt();
            switch (ch) {
                //INSERIR
                case 1:
                    System.out.println("1-Funcionario regular");
                    System.out.println("2-Funcionario com deficiencia");
                    System.out.println("3-Funcionario terceirizado");
                    int aux = s.nextInt();
                    System.out.print("id : ");
                    int eno = s.nextInt();
                    System.out.print("Nome : ");
                    String ename = s1.nextLine();
                    System.out.print("Salario : ");
                    int salary = s.nextInt();

                    if(aux==1){
                        c.add(new Empregado(eno, ename, salary));
                    } else if(aux==2){
                        System.out.println("Qual o tipo de deficiencia?");
                        System.out.println("Ex: cegueira, surdez");
                        String def = s1.nextLine();
                        c.add(new EmpregadoComDeficiencia(eno, ename, salary, def));
                    } else if(aux==3){
                        c.add(new EmpregadoTerceirizado(eno, ename, salary));
                    } else{
                        System.out.println("ERRO");
                        System.out.println("Digite 1, 2 ou 3");
                        System.out.println("---------------------");
                        break;
                    }
                    System.out.println("---------------------");
                    System.out.println("Funcionario adicionado com sucesso");
                    System.out.println("---------------------");
                    break;
                //MOSTRAR / GERAR RELATORIO
                case 2:
                    System.out.println("---------------------");
                    System.out.println("1-Gerar Arquivo de relatorio");
                    System.out.println("2-Visualização rapida");
                    aux = s.nextInt();
                    Iterator < Funcionario > i = c.iterator();
                    if(aux==1){
                        FileWriter fw = new FileWriter("relatorioFunc.txt");;
                        while (i.hasNext()) {
                            Funcionario e = i.next();
                            fw.write(e.toString() + "\n");
                        }
                        fw.close();
                        System.out.println("Arquivo gerado com sucesso");
                    } else if(aux==2){
                        while (i.hasNext()) {
                            Funcionario e = i.next();
                            System.out.println(e.toString());
                        }

                    } else{
                        System.out.println("ERRO");
                        System.out.println("Digite 1 ou 2");
                        System.out.println("---------------------");
                        break;
                    }

                    System.out.println("---------------------");
                    break;
                //PROCURAR POR DETALHES POR ID
                case 3:
                    boolean found = false;
                    System.out.print("Digite o id : ");
                    int id = s.nextInt();
                    System.out.println("---------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        Funcionario e = i.next();
                        if (e.getId() == id) {
                            System.out.println(e);
                            System.out.println("---------------------");
                            System.out.println("Deseja saber o valor do bonus natalino do funcionario?");
                            System.out.println("1- Sim");
                            System.out.println("2- Não");
                            System.out.println("3- Sim, com bonus especial");
                            aux = s.nextInt();
                            System.out.println("---------------------");
                            if(aux==1){
                                System.out.println(e.calcularBonus() + " R$");
                            }else if(aux==2) {
                            } else if(aux==3){
                                System.out.println("Digite quantos % de bonus: ");
                                int bonus = s.nextInt();
                                System.out.println(e.calcularBonus(bonus) + " R$");
                            } else{
                                System.out.println("ERRO");
                                System.out.println("Digite 1, 2 ou 3");
                                System.out.println("---------------------");
                                break;
                            }
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Funcionario nao encontrado");
                    }


                    System.out.println("---------------------");
                    break;
                //DELETAR
                case 4:
                    found = false;
                    System.out.print("Digite o id : ");
                    id = s.nextInt();
                    System.out.println("---------------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        Funcionario e = i.next();
                        if (e.getId() == id) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Funcionario nao encontrado");
                    } else {
                        System.out.println("Funcionario removido com sucesso");
                    }
                    System.out.println("---------------------");
                    break;
                //ATUALIZAR FUNCIONARIO
                case 5:
                    found = false;
                    System.out.print("Digite o id: ");
                    id = s.nextInt();
                    ListIterator < Funcionario > li = c.listIterator();
                    while (li.hasNext()) {
                        Funcionario e = li.next();
                        if (e.getId() == id) {
                            System.out.print("Digite o novo nome : ");
                            ename = s1.nextLine();
                            System.out.print("Digite o novo salario : ");
                            salary = s.nextInt();
                            li.set(new Empregado(id, ename, salary));
                            found = true;
                        }
                    }
                    System.out.println("---------------------");
                    if (!found) {
                        System.out.println("Funcionario não encontrado");
                    }
                    else {
                        System.out.println("Funcionario atualizado com sucesso");
                    }
                    System.out.println("---------------------");
                    break;
                    //Clientes
                    //CADASTRAR CLIENTES
                case 6:
                    System.out.println("1-Cliente regular");
                    System.out.println("2-Cliente VIP");
                    aux = s.nextInt();
                    System.out.print("Id: ");
                    eno = s.nextInt();
                    System.out.print("Nome: ");
                    ename = s1.nextLine();
                    if(aux==1){
                        d.add(new ClienteRegular(eno, ename));
                    } else if(aux==2){
                        System.out.println("O Cliente tem cashback ativo? (true/false)");
                        boolean cash = s2.nextBoolean();
                        d.add(new ClienteVIP(eno, ename, cash));

                    } else{
                        System.out.println("ERRO");
                        System.out.println("Digite 1 ou 2");
                        System.out.println("---------------------");
                        break;
                    }
                    System.out.println("---------------------");
                    break;
                    //IMPRIMIR CLIENTES
                case 7:

                    System.out.println("---------------------");
                    System.out.println("1-Gerar Arquivo de relatorio");
                    System.out.println("2-Visualização rapida");
                    aux = s.nextInt();
                    Iterator <Cliente> j = d.iterator();
                    if(aux==1){
                        FileWriter fw2 = new FileWriter("relatorioClient.txt");;
                        while (j.hasNext()) {
                            Cliente e = j.next();
                            fw2.write(e.toString() + "\n");
                        }
                        fw2.close();
                        System.out.println("Arquivo gerado com sucesso");
                    } else if(aux==2){
                        while (j.hasNext()) {
                            Cliente e = j.next();
                            System.out.println(e.toString());
                        }
                    } else{
                        System.out.println("ERRO");
                        System.out.println("Digite 1 ou 2");
                        System.out.println("---------------------");
                        break;
                    }
                    System.out.println("---------------------");
                    break;
                    //Procurar/Atualizar Cliente
                case 8:
                    found = false;
                    System.out.print("Digite o id : ");
                    id = s.nextInt();
                    System.out.println("---------------------");
                    j = d.iterator();
                    while (j.hasNext()) {
                        Cliente e = j.next();
                        if (e.getId() == id) {
                            System.out.println(e);
                            System.out.println("---------------------");
                            if(e instanceof ClienteVIP){
                                System.out.println("Esse é um cliente VIP");
                                if(((ClienteVIP) e).hasCashback()){
                                    System.out.println("Que tem direito a cashback");
                                    System.out.println("---------------------");
                                    System.out.println("Deseja remover o direito a cashback?");
                                    System.out.println("1 - Sim");
                                    System.out.println("2 - Não");
                                    aux = s.nextInt();
                                    if(aux==1){
                                        ((ClienteVIP) e).setCashbackStatus(false);
                                        System.out.println("Direito a cashback removido");
                                    } else if(aux==2){
                                        System.out.println("Direito a cashback mantido");
                                        System.out.println("Deseja definir um novo valor de cashback?");
                                        System.out.println("1 - Sim");
                                        System.out.println("2 - Não");
                                        int aux2 = s.nextInt();
                                        if(aux2==1){
                                            System.out.println("Digite a % de cashback nova");
                                            int cash = s.nextInt();
                                            e.cashback(cash);
                                        } else{
                                            System.out.println("ERRO");
                                            System.out.println("Digite 1 ou 2");
                                            System.out.println("---------------------");
                                            break;
                                        }
                                    }
                                } else if(!((ClienteVIP) e).hasCashback()){
                                    System.out.println("Que não tem direito a cashback");
                                    System.out.println("---------------------");
                                    System.out.println("Deseja adicionar o direito a cashback?");
                                    System.out.println("1 - Sim");
                                    System.out.println("2 - Não");
                                    aux = s.nextInt();
                                    if(aux==1){
                                        ((ClienteVIP) e).setCashbackStatus(true);
                                        System.out.println("Direito a cashback adicionado");
                                    } else if(aux==2){
                                        System.out.println("Direito a cashback mantido");
                                    } else{
                                        System.out.println("ERRO");
                                        System.out.println("Digite 1 ou 2");
                                        System.out.println("---------------------");
                                        break;
                                    }
                                }


                            }
                            System.out.println("Deseja rolar o desconto do cliente?");
                            System.out.println("1 - Sim");
                            System.out.println("2 - Não");
                            aux = s.nextInt();
                            if(aux==1){
                                e.definirDesconto();
                                System.out.println();
                            } else if(aux==2){
                                System.out.println("Desconto não randomizado");
                            } else{
                                System.out.println("ERRO");
                                System.out.println("Digite 1 ou 2");
                                System.out.println("---------------------");
                                break;
                            }


                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Cliente nao encontrado");
                    }


                    System.out.println("---------------------");
                    break;
                    //DELETAR
                case 9:
                    found = false;
                    System.out.print("Digite o id : ");
                    id = s.nextInt();
                    System.out.println("---------------------");
                    j = d.iterator();
                    while (j.hasNext()) {
                        Cliente e = j.next();
                        if (e.getId() == id) {
                            j.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Cliente nao encontrado");
                    } else {
                        System.out.println("Cliente removido com sucesso");
                    }
                    System.out.println("---------------------");

            }

        }
        while (ch != 0);
    }

}