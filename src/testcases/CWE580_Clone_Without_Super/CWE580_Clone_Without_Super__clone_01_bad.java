/*
 * @description A class defines clone() but does not call super.clone().
 * 
 * This is the "bad" version, which has a clone() that does not
 * call super.clone().
 * 
 * */

 package testcases.CWE580_Clone_Without_Super;

import java.util.Date;
import testcasesupport.*;

public class CWE580_Clone_Without_Super__clone_01_bad extends AbstractTestCaseClassIssueBad implements Cloneable
{
	/* Just to have something to do in clone() other than return the object */
	private Date testdate = new Date();

    public void setDate(Date d) {
		testdate = d;
    }
		
	protected final Object clone() throws CloneNotSupportedException {
		/* FLAW: super.clone() is not called */
		CWE580_Clone_Without_Super__clone_01_bad obj = new CWE580_Clone_Without_Super__clone_01_bad();	 
		obj.setDate(new Date(testdate.getTime()));
		return obj;
    }
	
	public void bad() throws CloneNotSupportedException
    { 
		/* Use the clone method */
		CWE580_Clone_Without_Super__clone_01_bad myClone = (CWE580_Clone_Without_Super__clone_01_bad)clone();

        myClone.setDate(new Date());
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
