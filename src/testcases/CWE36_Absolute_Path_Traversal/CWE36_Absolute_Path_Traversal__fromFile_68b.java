/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__fromFile_68b.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-68b.tmpl.java
*/
/*
 * @description
 * CWE: 36 Absolute Path Traversal
 * BadSource: fromFile Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * BadSink: readFile read line from file from disk
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE36_Absolute_Path_Traversal;

import testcasesupport.*;

//!! other imports come from the label definitions

import java.io.*;
import javax.servlet.http.*;

public class CWE36_Absolute_Path_Traversal__fromFile_68b
{

    public void bad_sink() throws Throwable
    {
        String data = CWE36_Absolute_Path_Traversal__fromFile_68a.data;

        /* POTENTIAL FLAW: unvalidated or sandboxed value */
        File fIn = new File(data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink() throws Throwable
    {
        String data = CWE36_Absolute_Path_Traversal__fromFile_68a.data;

        /* POTENTIAL FLAW: unvalidated or sandboxed value */
        File fIn = new File(data);
        if( fIn.exists() && fIn.isFile() )
        {
            IO.writeLine(new BufferedReader(new FileReader(fIn)).readLine());
        }

    }
}
