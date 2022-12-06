public class bonusException extends Exception{
    @Override
    public String getMessage(){
        return "25% é o maximo de bonus permitido";
    }
}
