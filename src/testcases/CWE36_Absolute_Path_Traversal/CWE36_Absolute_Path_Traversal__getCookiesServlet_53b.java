/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__getCookiesServlet_53b.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-53b.tmpl.java
*/
/*
 * @description
 * CWE: 36 Absolute Path Traversal
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : read line from file from disk
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE36_Absolute_Path_Traversal__getCookiesServlet_53b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE36_Absolute_Path_Traversal__getCookiesServlet_53c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE36_Absolute_Path_Traversal__getCookiesServlet_53c()).goodG2B_sink(data , request, response);
    }

}
