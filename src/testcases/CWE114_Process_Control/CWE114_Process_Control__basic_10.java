/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE114_Process_Control__basic_10.java
Label Definition File: CWE114_Process_Control__basic.label.xml
Template File: point-flaw-10.tmpl.java
*/
/*
* @description
* CWE: 114 Process Control
* Sinks:
*    GoodSink: use System.load() to load a library
*    BadSink : use System.loadLibrary() to load a library
* Flow Variant: 10 Control flow: if(IO.static_t) and if(IO.static_f)
*
* */

package testcases.CWE114_Process_Control;

import testcasesupport.*;

public class CWE114_Process_Control__basic_10 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_t)
        {
            String libName = "test.dll";
            /* FLAW: Attempt to load a library with System.loadLibrary() without
             * the full path to the library. */
            System.loadLibrary(libName);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String root = "C:\\libs\\";
            String libName = "test.dll";

            /* FIX: Use System.load() which allows you to specify a full path to the library */
            System.load(root + libName);

        }
    }

    /* good1() changes IO.static_t to IO.static_f */
    private void good1() throws Throwable
    {
        if(IO.static_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String libName = "test.dll";
            /* FLAW: Attempt to load a library with System.loadLibrary() without
             * the full path to the library. */
            System.loadLibrary(libName);
        }
        else {

            String root = "C:\\libs\\";
            String libName = "test.dll";

            /* FIX: Use System.load() which allows you to specify a full path to the library */
            System.load(root + libName);

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(IO.static_t)
        {
            String root = "C:\\libs\\";
            String libName = "test.dll";
            /* FIX: Use System.load() which allows you to specify a full path to the library */
            System.load(root + libName);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String libName = "test.dll";

            /* FLAW: Attempt to load a library with System.loadLibrary() without
             * the full path to the library. */
            System.loadLibrary(libName);

        }

    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
