import tools.aqua.concolic.Verifier;

public class Example37 {
    public static void main(String[] args) {
        A a1 = (A) Verifier.nondetObject(); 
        A a2 = (A) Verifier.nondetObject(); 

        if (a1.getY() == a2.getY()) {
            assert false;
        }
    }
}
