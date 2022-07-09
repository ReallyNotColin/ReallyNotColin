public class Debug {
    private static final boolean IS_ON = false;

    public static void print(String msg){
        if(IS_ON){
            System.out.println(msg);
        }
    }
}
