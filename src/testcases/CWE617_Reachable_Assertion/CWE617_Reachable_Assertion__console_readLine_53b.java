/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__console_readLine_53b.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: sources-sink-53b.tmpl.java
*/
/*
 * @description
 * CWE: 617 Assertion is reachable
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : possibility of assertion being triggered
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE617_Reachable_Assertion__console_readLine_53b
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE617_Reachable_Assertion__console_readLine_53c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE617_Reachable_Assertion__console_readLine_53c()).goodG2B_sink(data );
    }

}
