/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE182_Data_Collapse_Unsafe__getQueryStringServlet_71b.java
Label Definition File: CWE182_Data_Collapse_Unsafe.label.xml
Template File: sources-sink-71b.tmpl.java
*/
/*
 * @description
 * CWE: 182 Attempt to sanitize user input collapses data into an unsafe expression
 * BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
 * GoodSource: A hardcoded string
 * Sinks: badSanitization
 *    BadSink : String.replaceAll sanitization
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE182_Data_Collapse_Unsafe;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE182_Data_Collapse_Unsafe__getQueryStringServlet_71b
{

    public void bad_sink(Object data_obj , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (String)data_obj;

        /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
        response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(Object data_obj , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (String)data_obj;

        /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
        response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

    }

}
