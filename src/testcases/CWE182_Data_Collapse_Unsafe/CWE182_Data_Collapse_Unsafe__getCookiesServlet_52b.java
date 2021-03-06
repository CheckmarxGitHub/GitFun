/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE182_Data_Collapse_Unsafe__getCookiesServlet_52b.java
Label Definition File: CWE182_Data_Collapse_Unsafe.label.xml
Template File: sources-sink-52b.tmpl.java
*/
/*
 * @description
 * CWE: 182 Attempt to sanitize user input collapses data into an unsafe expression
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * Sinks: badSanitization
 *    BadSink : String.replaceAll sanitization
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE182_Data_Collapse_Unsafe;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE182_Data_Collapse_Unsafe__getCookiesServlet_52b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE182_Data_Collapse_Unsafe__getCookiesServlet_52c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE182_Data_Collapse_Unsafe__getCookiesServlet_52c()).goodG2B_sink(data , request, response);
    }

}
