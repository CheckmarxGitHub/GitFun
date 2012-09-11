/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__getParameterServlet_31.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-31.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE23_Relative_Path_Traversal__getParameterServlet_31 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data_copy;
        {
            String data;

            Logger log_bad = Logger.getLogger("local-logger");

            /* read parameter from request */
            data = request.getParameter("name");

            data_copy = data;
        }
        {
            String data = data_copy;

            String root = "C:\\uploads\\";
            /* POTENTIAL FLAW: no validation of concatenated value */
            File fIn = new File(root + data);
            if( fIn.exists() && fIn.isFile() )
            {
                IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
            }

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data_copy;
        {
            String data;

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

            data_copy = data;
        }
        {
            String data = data_copy;

            String root = "C:\\uploads\\";
            /* POTENTIAL FLAW: no validation of concatenated value */
            File fIn = new File(root + data);
            if( fIn.exists() && fIn.isFile() )
            {
                IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
            }

        }
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
