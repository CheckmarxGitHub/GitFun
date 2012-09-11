/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE114_Process_Control__basic_01.java
Label Definition File: CWE114_Process_Control__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 114 Process Control
* Sinks:
*    GoodSink: use System.load() to load a library
*    BadSink : use System.loadLibrary() to load a library
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE114_Process_Control;

import testcasesupport.*;

public class CWE114_Process_Control__basic_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {

        String libName = "test.dll";

        /* FLAW: Attempt to load a library with System.loadLibrary() without
         * the full path to the library. */
        System.loadLibrary(libName);

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        String root = "C:\\libs\\";
        String libName = "test.dll";

        /* FIX: Use System.load() which allows you to specify a full path to the library */
        System.load(root + libName);

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

