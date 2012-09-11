/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__getCookiesServlet_71b.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-71b.tmpl.java
*/
/*
 * @description
 * CWE: 36 Absolute Path Traversal
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : read line from file from disk
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE36_Absolute_Path_Traversal__getCookiesServlet_71b
{

    public void bad_sink(Object data_obj , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (String)data_obj;

        /* POTENTIAL FLAW: unvalidated or sandboxed value */
        File fIn = new File(data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(Object data_obj , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = (String)data_obj;

        /* POTENTIAL FLAW: unvalidated or sandboxed value */
        File fIn = new File(data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }

}
