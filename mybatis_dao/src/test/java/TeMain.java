import com.it.test.demo;



public class TeMain {
    public static void main(String[] args){
        try {
            demo d = new demo();
            //d.findUserByIdTest();
            d.finUserByIdTestDao();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
