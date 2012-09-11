/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE182_Data_Collapse_Unsafe__getParameterServlet_53c.java
Label Definition File: CWE182_Data_Collapse_Unsafe.label.xml
Template File: sources-sink-53c.tmpl.java
*/
/*
 * @description
 * CWE: 182 Attempt to sanitize user input collapses data into an unsafe expression
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: A hardcoded string
 * Sinks: badSanitization
 *    BadSink : String.replaceAll sanitization
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE182_Data_Collapse_Unsafe;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE182_Data_Collapse_Unsafe__getParameterServlet_53c
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE182_Data_Collapse_Unsafe__getParameterServlet_53d()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE182_Data_Collapse_Unsafe__getParameterServlet_53d()).goodG2B_sink(data , request, response);
    }

}
