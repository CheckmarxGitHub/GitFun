/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__URLConnection_66b.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: sources-sink-66b.tmpl.java
*/
/*
 * @description
 * CWE: 617 Assertion is reachable
 * BadSource: URLConnection Read a string from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : possibility of assertion being triggered
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE617_Reachable_Assertion__URLConnection_66b
{

    public void bad_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

        /* POTENTIAL FLAW: assertion is evaluated */
        assert data.length() > 0;

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

        /* POTENTIAL FLAW: assertion is evaluated */
        assert data.length() > 0;

    }

}
