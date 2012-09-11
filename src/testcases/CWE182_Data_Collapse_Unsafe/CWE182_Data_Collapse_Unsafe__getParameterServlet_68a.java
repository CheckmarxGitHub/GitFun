/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE182_Data_Collapse_Unsafe__getParameterServlet_68a.java
Label Definition File: CWE182_Data_Collapse_Unsafe.label.xml
Template File: sources-sink-68a.tmpl.java
*/
/*
 * @description
 * CWE: 182 Attempt to sanitize user input collapses data into an unsafe expression
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: A hardcoded string
 * BadSink: badSanitization String.replaceAll sanitization
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE182_Data_Collapse_Unsafe;

import testcasesupport.*;

//!! other imports come from the label definitions

import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE182_Data_Collapse_Unsafe__getParameterServlet_68a extends AbstractTestCaseServlet
{

    public static String data;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        Logger log_bad = Logger.getLogger("local-logger");

        /* read parameter from request */
        data = request.getParameter("name");

        (new CWE182_Data_Collapse_Unsafe__getParameterServlet_68b()).bad_sink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE182_Data_Collapse_Unsafe__getParameterServlet_68b()).goodG2B_sink(request, response);
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
