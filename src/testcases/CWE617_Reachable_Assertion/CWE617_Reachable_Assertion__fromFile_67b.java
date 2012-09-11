/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__fromFile_67b.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: sources-sink-67b.tmpl.java
*/
/*
 * @description
 * CWE: 617 Assertion is reachable
 * BadSource: fromFile Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : possibility of assertion being triggered
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE617_Reachable_Assertion__fromFile_67b
{

    public void bad_sink(CWE617_Reachable_Assertion__fromFile_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        /* POTENTIAL FLAW: assertion is evaluated */
        assert data.length() > 0;

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE617_Reachable_Assertion__fromFile_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        /* POTENTIAL FLAW: assertion is evaluated */
        assert data.length() > 0;

    }

}
