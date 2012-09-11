package testcasesupport;

public class Main {

	public static void main(String[] args) {
		
		if(args.length != 0) {
		
			if(args[0].equals("-h") || args[0].equals("--help")) {
		
				System.err.println("To use this main, you can either run the program with no " +
				"command line arguments to run all test cases or you can specify one or more classes to test");
				System.err.println("For example:");
				System.err.println("java testcasesupport.Main testcases.CWE690_Unchecked_Return_Value_to_NULL_Pointer_Dereference.custom_function.CWE690_Unchecked_Return_Value_to_NULL_Pointer_Dereference__custom_function_01 testcases.CWE481_Assigning_instead_of_Comparing.bool.CWE481_Assigning_instead_of_Comparing__bool_01");
				System.exit(1);
			}
			
			/* User supplied some class names on the command line, just use those with introspection
			 *
			 * String classNames[] = { "CWE481_Assigning_instead_of_Comparing__boolean_01",
			 *		"CWE476_Null_Pointer_Dereference__getProperty_01" };
 			 * could read class names from command line or use
			 * http://sadun-util.sourceforge.net/api/org/sadun/util/
			 * ClassPackageExplorer.html
			 */

			for (String className : args) {

				try {
					
					/* String classNameWithPackage = "testcases." + className; */
					
					/* IO.writeLine("classNameWithPackage = " + classNameWithPackage); */

					Class<?> myClass = Class.forName(className);

					AbstractTestCase myObject = (AbstractTestCase) myClass
							.newInstance();

					myObject.runTest(className);

				} catch (Exception ex) {

					IO.writeLine("Could not run test for class " + className);
					ex.printStackTrace();

				}
				
				IO.writeLine(""); /* leave a blank line between classes */

			}

		} else {
		
			/* No command line args were used, we want to run every testcase */
			
			/* needed to separate these calls into other methods because
			   we were running into the size limit Java has for a single method */
			runTestCWE1();
			runTestCWE2();
			runTestCWE3();
			runTestCWE4();
			runTestCWE5();
			runTestCWE6();
			runTestCWE7();
			runTestCWE8();
			runTestCWE9();
		}			
	}

private static void runTestCWE1() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-1 */

			/* END-AUTOGENERATED-JAVA-TESTS-1 */
}

private static void runTestCWE2() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-2 */

			/* END-AUTOGENERATED-JAVA-TESTS-2 */
}

private static void runTestCWE3() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-3 */

			/* END-AUTOGENERATED-JAVA-TESTS-3 */
}

private static void runTestCWE4() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-4 */
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_01()).runTest("CWE476_NULL_Pointer_Dereference__Integer_01");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_02()).runTest("CWE476_NULL_Pointer_Dereference__Integer_02");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_03()).runTest("CWE476_NULL_Pointer_Dereference__Integer_03");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_04()).runTest("CWE476_NULL_Pointer_Dereference__Integer_04");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_05()).runTest("CWE476_NULL_Pointer_Dereference__Integer_05");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_06()).runTest("CWE476_NULL_Pointer_Dereference__Integer_06");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_07()).runTest("CWE476_NULL_Pointer_Dereference__Integer_07");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_08()).runTest("CWE476_NULL_Pointer_Dereference__Integer_08");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_09()).runTest("CWE476_NULL_Pointer_Dereference__Integer_09");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_10()).runTest("CWE476_NULL_Pointer_Dereference__Integer_10");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_11()).runTest("CWE476_NULL_Pointer_Dereference__Integer_11");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_12()).runTest("CWE476_NULL_Pointer_Dereference__Integer_12");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_13()).runTest("CWE476_NULL_Pointer_Dereference__Integer_13");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_14()).runTest("CWE476_NULL_Pointer_Dereference__Integer_14");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_15()).runTest("CWE476_NULL_Pointer_Dereference__Integer_15");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_16()).runTest("CWE476_NULL_Pointer_Dereference__Integer_16");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_17()).runTest("CWE476_NULL_Pointer_Dereference__Integer_17");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_19()).runTest("CWE476_NULL_Pointer_Dereference__Integer_19");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_31()).runTest("CWE476_NULL_Pointer_Dereference__Integer_31");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_41()).runTest("CWE476_NULL_Pointer_Dereference__Integer_41");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_42()).runTest("CWE476_NULL_Pointer_Dereference__Integer_42");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_45()).runTest("CWE476_NULL_Pointer_Dereference__Integer_45");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_51a()).runTest("CWE476_NULL_Pointer_Dereference__Integer_51a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_52a()).runTest("CWE476_NULL_Pointer_Dereference__Integer_52a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_53a()).runTest("CWE476_NULL_Pointer_Dereference__Integer_53a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_54a()).runTest("CWE476_NULL_Pointer_Dereference__Integer_54a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_61a()).runTest("CWE476_NULL_Pointer_Dereference__Integer_61a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_66a()).runTest("CWE476_NULL_Pointer_Dereference__Integer_66a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_67a()).runTest("CWE476_NULL_Pointer_Dereference__Integer_67a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_68a()).runTest("CWE476_NULL_Pointer_Dereference__Integer_68a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__Integer_71a()).runTest("CWE476_NULL_Pointer_Dereference__Integer_71a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_01()).runTest("CWE476_NULL_Pointer_Dereference__int_array_01");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_02()).runTest("CWE476_NULL_Pointer_Dereference__int_array_02");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_03()).runTest("CWE476_NULL_Pointer_Dereference__int_array_03");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_04()).runTest("CWE476_NULL_Pointer_Dereference__int_array_04");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_05()).runTest("CWE476_NULL_Pointer_Dereference__int_array_05");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_06()).runTest("CWE476_NULL_Pointer_Dereference__int_array_06");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_07()).runTest("CWE476_NULL_Pointer_Dereference__int_array_07");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_08()).runTest("CWE476_NULL_Pointer_Dereference__int_array_08");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_09()).runTest("CWE476_NULL_Pointer_Dereference__int_array_09");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_10()).runTest("CWE476_NULL_Pointer_Dereference__int_array_10");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_11()).runTest("CWE476_NULL_Pointer_Dereference__int_array_11");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_12()).runTest("CWE476_NULL_Pointer_Dereference__int_array_12");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_13()).runTest("CWE476_NULL_Pointer_Dereference__int_array_13");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_14()).runTest("CWE476_NULL_Pointer_Dereference__int_array_14");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_15()).runTest("CWE476_NULL_Pointer_Dereference__int_array_15");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_16()).runTest("CWE476_NULL_Pointer_Dereference__int_array_16");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_17()).runTest("CWE476_NULL_Pointer_Dereference__int_array_17");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_19()).runTest("CWE476_NULL_Pointer_Dereference__int_array_19");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_31()).runTest("CWE476_NULL_Pointer_Dereference__int_array_31");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_41()).runTest("CWE476_NULL_Pointer_Dereference__int_array_41");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_42()).runTest("CWE476_NULL_Pointer_Dereference__int_array_42");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_45()).runTest("CWE476_NULL_Pointer_Dereference__int_array_45");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_51a()).runTest("CWE476_NULL_Pointer_Dereference__int_array_51a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_52a()).runTest("CWE476_NULL_Pointer_Dereference__int_array_52a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_53a()).runTest("CWE476_NULL_Pointer_Dereference__int_array_53a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_54a()).runTest("CWE476_NULL_Pointer_Dereference__int_array_54a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_61a()).runTest("CWE476_NULL_Pointer_Dereference__int_array_61a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_67a()).runTest("CWE476_NULL_Pointer_Dereference__int_array_67a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_68a()).runTest("CWE476_NULL_Pointer_Dereference__int_array_68a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__int_array_71a()).runTest("CWE476_NULL_Pointer_Dereference__int_array_71a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_01()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_01");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_02()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_02");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_03()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_03");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_04()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_04");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_05()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_05");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_06()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_06");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_07()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_07");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_08()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_08");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_09()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_09");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_10()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_10");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_11()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_11");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_12()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_12");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_13()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_13");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_14()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_14");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_15()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_15");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_16()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_16");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_17()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_17");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_19()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_19");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_31()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_31");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_41()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_41");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_42()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_42");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_45()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_45");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_51a()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_51a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_52a()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_52a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_53a()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_53a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_54a()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_54a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_61a()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_61a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_66a()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_66a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_67a()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_67a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_68a()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_68a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__StringBuilder_71a()).runTest("CWE476_NULL_Pointer_Dereference__StringBuilder_71a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_01()).runTest("CWE476_NULL_Pointer_Dereference__String_01");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_02()).runTest("CWE476_NULL_Pointer_Dereference__String_02");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_03()).runTest("CWE476_NULL_Pointer_Dereference__String_03");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_04()).runTest("CWE476_NULL_Pointer_Dereference__String_04");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_05()).runTest("CWE476_NULL_Pointer_Dereference__String_05");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_06()).runTest("CWE476_NULL_Pointer_Dereference__String_06");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_07()).runTest("CWE476_NULL_Pointer_Dereference__String_07");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_08()).runTest("CWE476_NULL_Pointer_Dereference__String_08");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_09()).runTest("CWE476_NULL_Pointer_Dereference__String_09");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_10()).runTest("CWE476_NULL_Pointer_Dereference__String_10");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_11()).runTest("CWE476_NULL_Pointer_Dereference__String_11");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_12()).runTest("CWE476_NULL_Pointer_Dereference__String_12");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_13()).runTest("CWE476_NULL_Pointer_Dereference__String_13");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_14()).runTest("CWE476_NULL_Pointer_Dereference__String_14");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_15()).runTest("CWE476_NULL_Pointer_Dereference__String_15");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_16()).runTest("CWE476_NULL_Pointer_Dereference__String_16");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_17()).runTest("CWE476_NULL_Pointer_Dereference__String_17");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_19()).runTest("CWE476_NULL_Pointer_Dereference__String_19");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_31()).runTest("CWE476_NULL_Pointer_Dereference__String_31");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_41()).runTest("CWE476_NULL_Pointer_Dereference__String_41");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_42()).runTest("CWE476_NULL_Pointer_Dereference__String_42");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_45()).runTest("CWE476_NULL_Pointer_Dereference__String_45");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_51a()).runTest("CWE476_NULL_Pointer_Dereference__String_51a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_52a()).runTest("CWE476_NULL_Pointer_Dereference__String_52a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_53a()).runTest("CWE476_NULL_Pointer_Dereference__String_53a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_54a()).runTest("CWE476_NULL_Pointer_Dereference__String_54a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_61a()).runTest("CWE476_NULL_Pointer_Dereference__String_61a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_66a()).runTest("CWE476_NULL_Pointer_Dereference__String_66a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_67a()).runTest("CWE476_NULL_Pointer_Dereference__String_67a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_68a()).runTest("CWE476_NULL_Pointer_Dereference__String_68a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__String_71a()).runTest("CWE476_NULL_Pointer_Dereference__String_71a");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_01()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_01");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_02()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_02");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_03()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_03");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_04()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_04");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_05()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_05");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_06()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_06");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_07()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_07");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_08()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_08");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_09()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_09");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_10()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_10");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_11()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_11");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_12()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_12");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_13()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_13");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_14()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_14");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_15()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_15");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_16()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_16");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_17()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_17");
			(new testcases.CWE476_NULL_Pointer_Dereference.CWE476_NULL_Pointer_Dereference__undefinedValue_19()).runTest("CWE476_NULL_Pointer_Dereference__undefinedValue_19");
			/* END-AUTOGENERATED-JAVA-TESTS-4 */
}

private static void runTestCWE5() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-5 */

			/* END-AUTOGENERATED-JAVA-TESTS-5 */
}

private static void runTestCWE6() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-6 */

			/* END-AUTOGENERATED-JAVA-TESTS-6 */
}

private static void runTestCWE7() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-7 */

			/* END-AUTOGENERATED-JAVA-TESTS-7 */
}

private static void runTestCWE8() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-8 */

			/* END-AUTOGENERATED-JAVA-TESTS-8 */
}

private static void runTestCWE9() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-9 */

			/* END-AUTOGENERATED-JAVA-TESTS-9 */
}
}