package testcasesupport;

import javax.servlet.http.*;

public class ServletMain extends HttpServlet {

	private static final long serialVersionUID = 1L; /* needed since Servlets are serializable */
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doGetCWE1(request, response);
		doGetCWE2(request, response);
		doGetCWE3(request, response);
		doGetCWE4(request, response);
		doGetCWE5(request, response);
		doGetCWE6(request, response);
		doGetCWE7(request, response);
		doGetCWE8(request, response);
		doGetCWE9(request, response);
	}
	
	private static void doGetCWE1(HttpServletRequest request, HttpServletResponse response) {
		try {
			/* BEGIN-AUTOGENERATED-SERVLET-TESTS-1 */

			/* END-AUTOGENERATED-SERVLET-TESTS-1 */
		} catch (Throwable t) {

			/* this will only happen on an IOException or something (the runTest for the test cases will catch any exceptions from the test cases).  So, we just abort
			 * and write to the console (since we can't write to the response without possibly throwing another exception)
			 */
			
			System.out.println(
					" Caught thowable from doGetCWE1 ");

			System.out.println(" Throwable's message = " + t.getMessage());
			
			System.out.println("Stack trace below");

			StackTraceElement stes[] = t.getStackTrace();

			for (StackTraceElement ste : stes) {
				System.out.println("  " + ste.toString());
			} 
		}
	}
		
	private static void doGetCWE2(HttpServletRequest request, HttpServletResponse response) {
		try {
			/* BEGIN-AUTOGENERATED-SERVLET-TESTS-2 */

			/* END-AUTOGENERATED-SERVLET-TESTS-2 */
		} catch (Throwable t) {

			/* this will only happen on an IOException or something (the runTest for the test cases will catch any exceptions from the test cases).  So, we just abort
			 * and write to the console (since we can't write to the response without possibly throwing another exception)
			 */
			
			System.out.println(
					" Caught thowable from doGetCWE2 ");

			System.out.println(" Throwable's message = " + t.getMessage());
			
			System.out.println("Stack trace below");

			StackTraceElement stes[] = t.getStackTrace();

			for (StackTraceElement ste : stes) {
				System.out.println("  " + ste.toString());
			} 
		}
	}
		
	private static void doGetCWE3(HttpServletRequest request, HttpServletResponse response) {
		try {
			/* BEGIN-AUTOGENERATED-SERVLET-TESTS-3 */

			/* END-AUTOGENERATED-SERVLET-TESTS-3 */
		} catch (Throwable t) {

			/* this will only happen on an IOException or something (the runTest for the test cases will catch any exceptions from the test cases).  So, we just abort
			 * and write to the console (since we can't write to the response without possibly throwing another exception)
			 */
			
			System.out.println(
					" Caught thowable from doGetCWE3 ");

			System.out.println(" Throwable's message = " + t.getMessage());
			
			System.out.println("Stack trace below");

			StackTraceElement stes[] = t.getStackTrace();

			for (StackTraceElement ste : stes) {
				System.out.println("  " + ste.toString());
			} 
		}
	}

	private static void doGetCWE4(HttpServletRequest request, HttpServletResponse response) {
		try {
			/* BEGIN-AUTOGENERATED-SERVLET-TESTS-4 */

			/* END-AUTOGENERATED-SERVLET-TESTS-4 */
		} catch (Throwable t) {

			/* this will only happen on an IOException or something (the runTest for the test cases will catch any exceptions from the test cases).  So, we just abort
			 * and write to the console (since we can't write to the response without possibly throwing another exception)
			 */
			
			System.out.println(
					" Caught thowable from doGetCWE4 ");

			System.out.println(" Throwable's message = " + t.getMessage());
			
			System.out.println("Stack trace below");

			StackTraceElement stes[] = t.getStackTrace();

			for (StackTraceElement ste : stes) {
				System.out.println("  " + ste.toString());
			} 
		}
	}
		
	private static void doGetCWE5(HttpServletRequest request, HttpServletResponse response) {
		try {
			/* BEGIN-AUTOGENERATED-SERVLET-TESTS-5 */

			/* END-AUTOGENERATED-SERVLET-TESTS-5 */
		} catch (Throwable t) {

			/* this will only happen on an IOException or something (the runTest for the test cases will catch any exceptions from the test cases).  So, we just abort
			 * and write to the console (since we can't write to the response without possibly throwing another exception)
			 */
			
			System.out.println(
					" Caught thowable from doGetCWE5 ");

			System.out.println(" Throwable's message = " + t.getMessage());
			
			System.out.println("Stack trace below");

			StackTraceElement stes[] = t.getStackTrace();

			for (StackTraceElement ste : stes) {

				System.out.println("  " + ste.toString());
			} 
		}
	}		
		
	private static void doGetCWE6(HttpServletRequest request, HttpServletResponse response) {
		try {
			/* BEGIN-AUTOGENERATED-SERVLET-TESTS-6 */

			/* END-AUTOGENERATED-SERVLET-TESTS-6 */
		} catch (Throwable t) {

			/* this will only happen on an IOException or something (the runTest for the test cases will catch any exceptions from the test cases).  So, we just abort
			 * and write to the console (since we can't write to the response without possibly throwing another exception)
			 */
			
			System.out.println(
					" Caught thowable from doGetCWE6 ");

			System.out.println(" Throwable's message = " + t.getMessage());
			
			System.out.println("Stack trace below");

			StackTraceElement stes[] = t.getStackTrace();

			for (StackTraceElement ste : stes) {
				System.out.println("  " + ste.toString());
			} 
		}
	}

	private static void doGetCWE7(HttpServletRequest request, HttpServletResponse response) {
		try {
			/* BEGIN-AUTOGENERATED-SERVLET-TESTS-7 */
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_01()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_02()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_03()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_04()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_05()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_06()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_07()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_08()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_09()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_10()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_11()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_12()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_13()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_14()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_15()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_16()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_17()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_19()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_31()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_41()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_42()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_45()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_51a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_52a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_53a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_54a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_61a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_66a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_67a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_68a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getCookiesServlet_71a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_01()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_02()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_03()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_04()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_05()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_06()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_07()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_08()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_09()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_10()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_11()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_12()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_13()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_14()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_15()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_16()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_17()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_19()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_31()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_41()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_42()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_45()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_51a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_52a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_53a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_54a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_61a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_66a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_67a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_68a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getParameterServlet_71a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_01()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_02()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_03()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_04()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_05()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_06()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_07()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_08()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_09()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_10()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_11()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_12()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_13()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_14()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_15()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_16()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_17()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_19()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_31()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_41()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_42()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_45()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_51a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_52a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_53a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_54a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_61a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_66a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_67a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_68a()).runTest(request, response);
			(new testcases.CWE760_Predictable_Salt_One_Way_Hash.CWE760_Predictable_Salt_One_Way_Hash__getQueryStringServlet_71a()).runTest(request, response);
			/* END-AUTOGENERATED-SERVLET-TESTS-7 */
		} catch (Throwable t) {

			/* this will only happen on an IOException or something (the runTest for the test cases will catch any exceptions from the test cases).  So, we just abort
			 * and write to the console (since we can't write to the response without possibly throwing another exception)
			 */
			
			System.out.println(
					" Caught thowable from doGetCWE7 ");

			System.out.println(" Throwable's message = " + t.getMessage());
			
			System.out.println("Stack trace below");

			StackTraceElement stes[] = t.getStackTrace();

			for (StackTraceElement ste : stes) {
				System.out.println("  " + ste.toString());
			} 
		}
	}		
	
	private static void doGetCWE8(HttpServletRequest request, HttpServletResponse response) {
		try {
			/* BEGIN-AUTOGENERATED-SERVLET-TESTS-8 */

			/* END-AUTOGENERATED-SERVLET-TESTS-8 */
		} catch (Throwable t) {

			/* this will only happen on an IOException or something (the runTest for the test cases will catch any exceptions from the test cases).  So, we just abort
			 * and write to the console (since we can't write to the response without possibly throwing another exception)
			 */
			
			System.out.println(
					" Caught thowable from doGetCWE8 ");

			System.out.println(" Throwable's message = " + t.getMessage());
			
			System.out.println("Stack trace below");

			StackTraceElement stes[] = t.getStackTrace();

			for (StackTraceElement ste : stes) {
				System.out.println("  " + ste.toString());
			} 
		}
	}	
	
	private static void doGetCWE9(HttpServletRequest request, HttpServletResponse response) {
		try {
			/* BEGIN-AUTOGENERATED-SERVLET-TESTS-9 */

			/* END-AUTOGENERATED-SERVLET-TESTS-9 */
		} catch (Throwable t) {

			/* this will only happen on an IOException or something (the runTest for the test cases will catch any exceptions from the test cases).  So, we just abort
			 * and write to the console (since we can't write to the response without possibly throwing another exception)
			 */
			
			System.out.println(
					" Caught thowable from doGetCWE9 ");

			System.out.println(" Throwable's message = " + t.getMessage());
			
			System.out.println("Stack trace below");

			StackTraceElement stes[] = t.getStackTrace();

			for (StackTraceElement ste : stes) {
				System.out.println("  " + ste.toString());
			} 
		}
	}		
}
