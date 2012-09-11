/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE182_Data_Collapse_Unsafe__getParameterServlet_66b.java
Label Definition File: CWE182_Data_Collapse_Unsafe.label.xml
Template File: sources-sink-66b.tmpl.java
*/
/*
 * @description
 * CWE: 182 Attempt to sanitize user input collapses data into an unsafe expression
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: A hardcoded string
 * Sinks: badSanitization
 *    BadSink : String.replaceAll sanitization
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE182_Data_Collapse_Unsafe;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE182_Data_Collapse_Unsafe__getParameterServlet_66b
{

    public void bad_sink(String data_array[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_array[2];

        /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
        response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data_array[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = data_array[2];

        /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
        response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

    }

}
