/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE182_Data_Collapse_Unsafe__getParameterServlet_19.java
Label Definition File: CWE182_Data_Collapse_Unsafe.label.xml
Template File: sources-sink-19.tmpl.java
*/
/*
* @description
* CWE: 182 Attempt to sanitize user input collapses data into an unsafe expression
* BadSource: getParameterServlet Read data from a querystring using getParameter
* GoodSource: A hardcoded string
* BadSink: badSanitization String.replaceAll sanitization
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE182_Data_Collapse_Unsafe;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE182_Data_Collapse_Unsafe__getParameterServlet_19 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        {

            Logger log_bad = Logger.getLogger("local-logger");

            /* read parameter from request */
            data = request.getParameter("name");

            /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
            response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

            /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
            response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

        }
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

            /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
            response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            Logger log_bad = Logger.getLogger("local-logger");

            /* read parameter from request */
            data = request.getParameter("name");

            /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
            response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

        }
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
