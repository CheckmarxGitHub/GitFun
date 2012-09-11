/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__Environment_54b.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-54b.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: Environment Read a string from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE23_Relative_Path_Traversal__Environment_54b
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE23_Relative_Path_Traversal__Environment_54c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE23_Relative_Path_Traversal__Environment_54c()).goodG2B_sink(data );
    }

}
