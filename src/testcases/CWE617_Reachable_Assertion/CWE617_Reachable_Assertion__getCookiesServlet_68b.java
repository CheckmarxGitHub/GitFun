/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__getCookiesServlet_68b.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: sources-sink-68b.tmpl.java
*/
/*
 * @description
 * CWE: 617 Assertion is reachable
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * BadSink:  possibility of assertion being triggered
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

//!! other imports come from the label definitions

import javax.servlet.http.*;

public class CWE617_Reachable_Assertion__getCookiesServlet_68b
{

    public void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE617_Reachable_Assertion__getCookiesServlet_68a.data;

        /* POTENTIAL FLAW: assertion is evaluated */
        assert data.length() > 0;

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE617_Reachable_Assertion__getCookiesServlet_68a.data;

        /* POTENTIAL FLAW: assertion is evaluated */
        assert data.length() > 0;

    }
}
