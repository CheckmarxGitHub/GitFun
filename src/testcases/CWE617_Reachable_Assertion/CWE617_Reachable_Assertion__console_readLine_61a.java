/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__console_readLine_61a.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: sources-sink-61a.tmpl.java
*/
/*
 * @description
 * CWE: 617 Assertion is reachable
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : possibility of assertion being triggered
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE617_Reachable_Assertion__console_readLine_61a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data = (new CWE617_Reachable_Assertion__console_readLine_61b()).bad_source();

        /* POTENTIAL FLAW: assertion is evaluated */
        assert data.length() > 0;

    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data = (new CWE617_Reachable_Assertion__console_readLine_61b()).goodG2B_source();

        /* POTENTIAL FLAW: assertion is evaluated */
        assert data.length() > 0;

    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}
