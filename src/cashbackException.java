public class cashbackException extends Exception{
    @Override
    public String getMessage(){
        return "O cashback máximo permitido é de 10%";
    }
}
