/*
 * @description This abstract class is meant to be used by testcases that have a flaw
 * outside of good or bad function.  These flaws are part of the class.  For an example, see
 * CWE 580.

  */

package testcasesupport;

public abstract class AbstractTestCaseClassIssueBad implements Cloneable {
	
	public abstract void bad() throws Throwable;
	
	/* from a static method like main(), there is not an easy way to get the current
	 * classes's name.  We do a trick here to make it work so that we don't have
	 * to edit the main for each test case or use a string member to contain the class
	 * name
	 */
	public static void mainFromParent(String[] args)
		throws ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		StackTraceElement e[] = Thread.currentThread().getStackTrace();
	
		String myClassName = e[e.length -1].getClassName();
	
		Class<?> myClass = Class.forName(myClassName);
	
		AbstractTestCaseClassIssueBad myObject = (AbstractTestCaseClassIssueBad) myClass.newInstance();
		
		myObject.runTest(myClassName);
	}
	
	public void runTest(String classname) {

		IO.writeLine("Starting tests for Class " + classname);

		try {

			bad();
			IO.writeLine("Completed bad() for Class " + classname);

		} catch (Throwable t) {

			IO.writeLine("Caught a throwable from bad() for Class "
					+ classname);

			IO.writeLine("Throwable's message = " + t.getMessage());
			
			StackTraceElement stes[] = t.getStackTrace();

			IO.writeLine("Stack trace below");

			for (StackTraceElement ste : stes) {

				IO.writeLine(ste.toString());

			} 

		} 

	} // runTest
	
} // class
