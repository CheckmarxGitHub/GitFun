/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__fromFile_54d.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: sources-sink-54d.tmpl.java
*/
/*
 * @description
 * CWE: 617 Assertion is reachable
 * BadSource: fromFile Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : possibility of assertion being triggered
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE617_Reachable_Assertion__fromFile_54d
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE617_Reachable_Assertion__fromFile_54e()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE617_Reachable_Assertion__fromFile_54e()).goodG2B_sink(data );
    }

}
