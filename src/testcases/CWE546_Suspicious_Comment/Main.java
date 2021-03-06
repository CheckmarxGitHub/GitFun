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

			/* END-AUTOGENERATED-JAVA-TESTS-4 */
}

private static void runTestCWE5() {
/* BEGIN-AUTOGENERATED-JAVA-TESTS-5 */
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_01()).runTest("CWE546_Suspicious_Comment__bug_01");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_02()).runTest("CWE546_Suspicious_Comment__bug_02");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_03()).runTest("CWE546_Suspicious_Comment__bug_03");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_04()).runTest("CWE546_Suspicious_Comment__bug_04");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_05()).runTest("CWE546_Suspicious_Comment__bug_05");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_06()).runTest("CWE546_Suspicious_Comment__bug_06");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_07()).runTest("CWE546_Suspicious_Comment__bug_07");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_08()).runTest("CWE546_Suspicious_Comment__bug_08");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_09()).runTest("CWE546_Suspicious_Comment__bug_09");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_10()).runTest("CWE546_Suspicious_Comment__bug_10");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_11()).runTest("CWE546_Suspicious_Comment__bug_11");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_12()).runTest("CWE546_Suspicious_Comment__bug_12");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_13()).runTest("CWE546_Suspicious_Comment__bug_13");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_14()).runTest("CWE546_Suspicious_Comment__bug_14");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_15()).runTest("CWE546_Suspicious_Comment__bug_15");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_16()).runTest("CWE546_Suspicious_Comment__bug_16");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_17()).runTest("CWE546_Suspicious_Comment__bug_17");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__bug_19()).runTest("CWE546_Suspicious_Comment__bug_19");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_01()).runTest("CWE546_Suspicious_Comment__fixme_01");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_02()).runTest("CWE546_Suspicious_Comment__fixme_02");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_03()).runTest("CWE546_Suspicious_Comment__fixme_03");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_04()).runTest("CWE546_Suspicious_Comment__fixme_04");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_05()).runTest("CWE546_Suspicious_Comment__fixme_05");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_06()).runTest("CWE546_Suspicious_Comment__fixme_06");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_07()).runTest("CWE546_Suspicious_Comment__fixme_07");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_08()).runTest("CWE546_Suspicious_Comment__fixme_08");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_09()).runTest("CWE546_Suspicious_Comment__fixme_09");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_10()).runTest("CWE546_Suspicious_Comment__fixme_10");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_11()).runTest("CWE546_Suspicious_Comment__fixme_11");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_12()).runTest("CWE546_Suspicious_Comment__fixme_12");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_13()).runTest("CWE546_Suspicious_Comment__fixme_13");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_14()).runTest("CWE546_Suspicious_Comment__fixme_14");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_15()).runTest("CWE546_Suspicious_Comment__fixme_15");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_16()).runTest("CWE546_Suspicious_Comment__fixme_16");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_17()).runTest("CWE546_Suspicious_Comment__fixme_17");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__fixme_19()).runTest("CWE546_Suspicious_Comment__fixme_19");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_01()).runTest("CWE546_Suspicious_Comment__hack_01");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_02()).runTest("CWE546_Suspicious_Comment__hack_02");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_03()).runTest("CWE546_Suspicious_Comment__hack_03");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_04()).runTest("CWE546_Suspicious_Comment__hack_04");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_05()).runTest("CWE546_Suspicious_Comment__hack_05");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_06()).runTest("CWE546_Suspicious_Comment__hack_06");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_07()).runTest("CWE546_Suspicious_Comment__hack_07");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_08()).runTest("CWE546_Suspicious_Comment__hack_08");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_09()).runTest("CWE546_Suspicious_Comment__hack_09");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_10()).runTest("CWE546_Suspicious_Comment__hack_10");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_11()).runTest("CWE546_Suspicious_Comment__hack_11");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_12()).runTest("CWE546_Suspicious_Comment__hack_12");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_13()).runTest("CWE546_Suspicious_Comment__hack_13");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_14()).runTest("CWE546_Suspicious_Comment__hack_14");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_15()).runTest("CWE546_Suspicious_Comment__hack_15");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_16()).runTest("CWE546_Suspicious_Comment__hack_16");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_17()).runTest("CWE546_Suspicious_Comment__hack_17");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__hack_19()).runTest("CWE546_Suspicious_Comment__hack_19");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_01()).runTest("CWE546_Suspicious_Comment__later_01");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_02()).runTest("CWE546_Suspicious_Comment__later_02");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_03()).runTest("CWE546_Suspicious_Comment__later_03");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_04()).runTest("CWE546_Suspicious_Comment__later_04");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_05()).runTest("CWE546_Suspicious_Comment__later_05");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_06()).runTest("CWE546_Suspicious_Comment__later_06");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_07()).runTest("CWE546_Suspicious_Comment__later_07");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_08()).runTest("CWE546_Suspicious_Comment__later_08");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_09()).runTest("CWE546_Suspicious_Comment__later_09");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_10()).runTest("CWE546_Suspicious_Comment__later_10");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_11()).runTest("CWE546_Suspicious_Comment__later_11");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_12()).runTest("CWE546_Suspicious_Comment__later_12");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_13()).runTest("CWE546_Suspicious_Comment__later_13");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_14()).runTest("CWE546_Suspicious_Comment__later_14");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_15()).runTest("CWE546_Suspicious_Comment__later_15");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_16()).runTest("CWE546_Suspicious_Comment__later_16");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_17()).runTest("CWE546_Suspicious_Comment__later_17");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__later_19()).runTest("CWE546_Suspicious_Comment__later_19");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_01()).runTest("CWE546_Suspicious_Comment__todo_01");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_02()).runTest("CWE546_Suspicious_Comment__todo_02");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_03()).runTest("CWE546_Suspicious_Comment__todo_03");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_04()).runTest("CWE546_Suspicious_Comment__todo_04");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_05()).runTest("CWE546_Suspicious_Comment__todo_05");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_06()).runTest("CWE546_Suspicious_Comment__todo_06");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_07()).runTest("CWE546_Suspicious_Comment__todo_07");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_08()).runTest("CWE546_Suspicious_Comment__todo_08");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_09()).runTest("CWE546_Suspicious_Comment__todo_09");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_10()).runTest("CWE546_Suspicious_Comment__todo_10");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_11()).runTest("CWE546_Suspicious_Comment__todo_11");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_12()).runTest("CWE546_Suspicious_Comment__todo_12");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_13()).runTest("CWE546_Suspicious_Comment__todo_13");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_14()).runTest("CWE546_Suspicious_Comment__todo_14");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_15()).runTest("CWE546_Suspicious_Comment__todo_15");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_16()).runTest("CWE546_Suspicious_Comment__todo_16");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_17()).runTest("CWE546_Suspicious_Comment__todo_17");
			(new testcases.CWE546_Suspicious_Comment.CWE546_Suspicious_Comment__todo_19()).runTest("CWE546_Suspicious_Comment__todo_19");
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