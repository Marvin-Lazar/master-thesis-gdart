import tools.aqua.concolic.Verifier;

public class Example2 {
    public static void main(String[] args) {
        Object o = Verifier.nondetObject();
        A a = (A) o; //correct downcast
        B b = (B) a; //incorrect downcast

        System.out.println(a);
    }
}