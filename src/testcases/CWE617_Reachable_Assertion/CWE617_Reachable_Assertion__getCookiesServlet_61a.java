/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__getCookiesServlet_61a.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: sources-sink-61a.tmpl.java
*/
/*
 * @description
 * CWE: 617 Assertion is reachable
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : possibility of assertion being triggered
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE617_Reachable_Assertion__getCookiesServlet_61a extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (new CWE617_Reachable_Assertion__getCookiesServlet_61b()).bad_source(request, response);

        /* POTENTIAL FLAW: assertion is evaluated */
        assert data.length() > 0;

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (new CWE617_Reachable_Assertion__getCookiesServlet_61b()).goodG2B_source(request, response);

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
