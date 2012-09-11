/*
 * @description A user function in this helper class returns null.  Calling methods should 
 *   be checking returned values against null.
 * 
 * */

package testcases.CWE690_NULL_Deref_from_Return;

public class CWE690_NULL_Deref_from_Return__Class__Helper {

	static String getStringBad() {
		return null;	
	}
	
	static String getStringGood() {
		return "getStringG";	
	}
	
	static StringBuilder getStringBuilderBad() 
	{
		return null;
	}
	
	static StringBuilder getStringBuilderGood()
	{
		return new StringBuilder("getStringBuilderGood");
	}
}
