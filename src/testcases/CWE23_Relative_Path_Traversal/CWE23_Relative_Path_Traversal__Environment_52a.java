/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__Environment_52a.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-52a.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: Environment Read a string from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE23_Relative_Path_Traversal;

import testcasesupport.*;

import java.io.*;
import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE23_Relative_Path_Traversal__Environment_52a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        (new CWE23_Relative_Path_Traversal__Environment_52b()).bad_sink(data );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE23_Relative_Path_Traversal__Environment_52b()).goodG2B_sink(data );
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
