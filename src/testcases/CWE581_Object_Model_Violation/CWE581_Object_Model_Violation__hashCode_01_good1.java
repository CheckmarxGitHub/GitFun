/*
 * @description A class defines equals() but not hashcode(), which possibly breaks a 
 * java invariant that if a.equals(b) == true then a.hashCode() == b.hashCode()
 * 
 * This is the "good" version, which defines both hashCode() and equals().
 * There is no need to implement the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE581_Object_Model_Violation;

import testcasesupport.*;

public class CWE581_Object_Model_Violation__hashCode_01_good1 extends AbstractTestCaseClassIssueGood 
{

	private String s = "test";
	public void setS(String _s) 
    {
		s = _s;
	}
	
	public boolean equals(Object o)
	{
		if (!(o instanceof CWE581_Object_Model_Violation__hashCode_01_good1))
		{
			return false;
		}

		CWE581_Object_Model_Violation__hashCode_01_good1 obj = (CWE581_Object_Model_Violation__hashCode_01_good1)o;

		if (obj.s.equals(this.s))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private int SEED = 12345; /* Helps to prevent collisions */
	/* FIX: hashcode() is defined in addition to equals() */
	public int hashCode() 
    {
	  return s.hashCode() + SEED;
	}

	private void good1() { }
	
	public void good() 
    {
        good1();
	}
		
	/* Below is the main(). It is only used when building this testcase on 
	   its own for testing or for building a binary to use in testing binary 
	   analysis tools. It is not used when compiling all the testcases as one 
	   application, which is how source code analysis tools are tested. */ 
	public static void main(String[] args) 
		throws ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		mainFromParent(args);
	}

}
