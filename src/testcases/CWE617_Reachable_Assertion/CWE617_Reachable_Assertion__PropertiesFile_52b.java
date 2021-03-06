/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__PropertiesFile_52b.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: sources-sink-52b.tmpl.java
*/
/*
 * @description
 * CWE: 617 Assertion is reachable
 * BadSource: PropertiesFile Read a value from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : possibility of assertion being triggered
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE617_Reachable_Assertion__PropertiesFile_52b
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE617_Reachable_Assertion__PropertiesFile_52c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE617_Reachable_Assertion__PropertiesFile_52c()).goodG2B_sink(data );
    }

}
