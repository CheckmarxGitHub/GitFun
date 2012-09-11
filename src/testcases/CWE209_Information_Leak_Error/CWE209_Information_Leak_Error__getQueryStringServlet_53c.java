/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__getQueryStringServlet_53c.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 209 Information exposure through error message
 * BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
 * GoodSource: A hardcoded string
 * Sinks: stackDump
 *    GoodSink: Generic error message
 *    BadSink : Error causes stack dump
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE209_Information_Leak_Error__getQueryStringServlet_53c
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE209_Information_Leak_Error__getQueryStringServlet_53d()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE209_Information_Leak_Error__getQueryStringServlet_53d()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE209_Information_Leak_Error__getQueryStringServlet_53d()).goodB2G_sink(data , request, response);
    }
}
