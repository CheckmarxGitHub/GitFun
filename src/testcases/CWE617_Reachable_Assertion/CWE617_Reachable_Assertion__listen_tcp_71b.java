/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__listen_tcp_71b.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: sources-sink-71b.tmpl.java
*/
/*
 * @description
 * CWE: 617 Assertion is reachable
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : possibility of assertion being triggered
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE617_Reachable_Assertion__listen_tcp_71b
{

    public void bad_sink(Object data_obj ) throws Throwable
    {
        String data = (String)data_obj;

        /* POTENTIAL FLAW: assertion is evaluated */
        assert data.length() > 0;

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(Object data_obj ) throws Throwable
    {
        String data = (String)data_obj;

        /* POTENTIAL FLAW: assertion is evaluated */
        assert data.length() > 0;

    }

}
