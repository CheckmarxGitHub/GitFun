/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE182_Data_Collapse_Unsafe__getParameterServlet_42.java
Label Definition File: CWE182_Data_Collapse_Unsafe.label.xml
Template File: sources-sink-42.tmpl.java
*/
/*
 * @description
 * CWE: 182 Attempt to sanitize user input collapses data into an unsafe expression
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: A hardcoded string
 * BadSink: badSanitization String.replaceAll sanitization
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package testcases.CWE182_Data_Collapse_Unsafe;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE182_Data_Collapse_Unsafe__getParameterServlet_42 extends AbstractTestCaseServlet
{

    private String bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* read parameter from request */
        data = request.getParameter("name");

        return data;
    }

    /* use badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = bad_source(request, response);

        /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
        response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

    }

    private String goodG2B_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodG2B_source(request, response);

        /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
        response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
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
