/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE182_Data_Collapse_Unsafe__getQueryStringServlet_51b.java
Label Definition File: CWE182_Data_Collapse_Unsafe.label.xml
Template File: sources-sink-51b.tmpl.java
*/
/*
 * @description
 * CWE: 182 Attempt to sanitize user input collapses data into an unsafe expression
 * BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
 * GoodSource: A hardcoded string
 * BadSink: badSanitization String.replaceAll sanitization
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE182_Data_Collapse_Unsafe;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE182_Data_Collapse_Unsafe__getQueryStringServlet_51b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
        response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
        response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

    }
}
