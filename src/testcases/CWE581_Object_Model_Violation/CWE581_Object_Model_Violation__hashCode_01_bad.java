/*
 * @description A class defines equals() but not hashcode(), which possibly breaks a 
 * java invariant that if a.equals(b) == true then a.hashCode() == b.hashCode()
 * 
 * This is the "bad" version.
 * There is no need to implement the bad() and good() methods in this test case.
 *
 * */

package testcases.CWE581_Object_Model_Violation;

import testcasesupport.*;

public class CWE581_Object_Model_Violation__hashCode_01_bad extends AbstractTestCaseClassIssueBad 
{

	private String s = "test";
	public void setS(String _s) 
    {
		s = _s;
	}
	
	/* FLAW: equals() is defined but hashcode() is not */
	public boolean equals(Object o)
	{
		if (!(o instanceof CWE581_Object_Model_Violation__hashCode_01_bad))
		{
			return false;
		}

		CWE581_Object_Model_Violation__hashCode_01_bad obj = (CWE581_Object_Model_Violation__hashCode_01_bad)o;

		if (obj.s.equals(this.s))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void bad() { }

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
