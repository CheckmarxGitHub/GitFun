/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__Environment_67b.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-67b.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: Environment Read a string from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE23_Relative_Path_Traversal__Environment_67b
{

    public void bad_sink(CWE23_Relative_Path_Traversal__Environment_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        String root = "C:\\uploads\\";
        /* POTENTIAL FLAW: no validation of concatenated value */
        File fIn = new File(root + data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE23_Relative_Path_Traversal__Environment_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        String root = "C:\\uploads\\";
        /* POTENTIAL FLAW: no validation of concatenated value */
        File fIn = new File(root + data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }

}
