import tools.aqua.concolic.Verifier;

/**
 * This example checks the implementation of the isNull check.
 *
 * case 1: a is null
 * - If statement is not fullfilled -> assert statement is not reached
 * - add decision for a (is_null object 0)
 * ======================== END PATH [BEGIN].
 * [DECLARE] (declare-fun __object_0 () OBJECT)
 * [DECISION] (assert (is_null __object_0)) // branchCount=2, branchId=1
 * ======================== END PATH [END].
 *
 * ../sdk/mxbuild/darwin-aarch64/GRAALVM_ESPRESSO_NATIVE_CE_JAVA17/graalvm-espresso-native-ce-java17-22.2.0.1-dev/bin/javac -cp ../../verifier-stub/target/verifier-stub-1.0.jar:../../examples ../../examples/Example6.java
 * ../sdk/mxbuild/darwin-aarch64/GRAALVM_ESPRESSO_NATIVE_CE_JAVA17/graalvm-espresso-native-ce-java17-22.2.0.1-dev/bin/javac -cp ../../verifier-stub/target/verifier-stub-1.0.jar:../../examples ../../examples/A.java
 *
 * ../sdk/mxbuild/darwin-aarch64/GRAALVM_ESPRESSO_NATIVE_CE_JAVA17/graalvm-espresso-native-ce-java17-22.2.0.1-dev/bin/java -truffle -ea -Dconcolic.execution=true -Dconcolic.strings="hallo","test" -Dconcolic.bools="false" -Dconcolic.ints="5" -cp ../../examples:../../verifier-stub/target/verifier-stub-1.0.jar Example6
 *
 * case 2: a is not null
 * - If state is fullfuled --> assertion error is reached
 * - add deicison for a (object 0) (not (is_null __object_0))
 * ======================== END PATH [BEGIN].
 * [DECLARE] (declare-fun __int_0 () (_ BitVec 32))
 * [WITNESS] Example6.java : LExample6;.main([Ljava/lang/String;)V : 23 : 5
 * [DECLARE] (declare-fun __int_1 () (_ BitVec 32))
 * [WITNESS] Example6.java : LExample6;.main([Ljava/lang/String;)V : 23 : 0
 * [DECLARE] (declare-fun __object_0 () OBJECT)
 * [DECISION] (assert (not (is_null __object_0))) // branchCount=2, branchId=0
 * [ERROR] java/lang/AssertionError
 * ======================== END PATH [END].
 *
 * ../sdk/mxbuild/darwin-aarch64/GRAALVM_ESPRESSO_NATIVE_CE_JAVA17/graalvm-espresso-native-ce-java17-22.2.0.1-dev/bin/javac -cp ../../verifier-stub/target/verifier-stub-1.0.jar:../../examples ../../examples/Example6.java
 * ../sdk/mxbuild/darwin-aarch64/GRAALVM_ESPRESSO_NATIVE_CE_JAVA17/graalvm-espresso-native-ce-java17-22.2.0.1-dev/bin/javac -cp ../../verifier-stub/target/verifier-stub-1.0.jar:../../examples ../../examples/A.java
 *
 * ../sdk/mxbuild/darwin-aarch64/GRAALVM_ESPRESSO_NATIVE_CE_JAVA17/graalvm-espresso-native-ce-java17-22.2.0.1-dev/bin/java -truffle -ea -Dconcolic.execution=true -Dconcolic.strings="hallo","test" -Dconcolic.bools="false" -Dconcolic.constructors="LA;|(II)V" -Dconcolic.ints="5" -cp ../../examples:../../verifier-stub/target/verifier-stub-1.0.jar Example6
 */
public class Example6 {
	public static void main(String[] args) {
		A a = (A) Verifier.nondetObject(); 

		if(a != null) {
			assert false; 			 
		}
	}
}
