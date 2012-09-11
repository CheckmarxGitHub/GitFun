/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__fromFile_68b.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-68b.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: fromFile Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * BadSink: readFile no validation
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

//!! other imports come from the label definitions

import java.io.*;
import javax.servlet.http.*;

public class CWE23_Relative_Path_Traversal__fromFile_68b
{

    public void bad_sink() throws Throwable
    {
        String data = CWE23_Relative_Path_Traversal__fromFile_68a.data;

        String root = "C:\\uploads\\";
        /* POTENTIAL FLAW: no validation of concatenated value */
        File fIn = new File(root + data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink() throws Throwable
    {
        String data = CWE23_Relative_Path_Traversal__fromFile_68a.data;

        String root = "C:\\uploads\\";
        /* POTENTIAL FLAW: no validation of concatenated value */
        File fIn = new File(root + data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }
}
