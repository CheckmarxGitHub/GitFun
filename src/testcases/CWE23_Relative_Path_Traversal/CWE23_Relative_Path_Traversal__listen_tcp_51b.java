/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__listen_tcp_51b.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-51b.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * BadSink: readFile no validation
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE23_Relative_Path_Traversal__listen_tcp_51b
{

    public void bad_sink(String data ) throws Throwable
    {

        String root = "C:\\uploads\\";
        /* POTENTIAL FLAW: no validation of concatenated value */
        File fIn = new File(root + data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {

        String root = "C:\\uploads\\";
        /* POTENTIAL FLAW: no validation of concatenated value */
        File fIn = new File(root + data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }
}
