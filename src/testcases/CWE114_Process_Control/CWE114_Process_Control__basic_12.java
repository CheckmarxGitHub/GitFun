/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE114_Process_Control__basic_12.java
Label Definition File: CWE114_Process_Control__basic.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 114 Process Control
* Sinks:
*    GoodSink: use System.load() to load a library
*    BadSink : use System.loadLibrary() to load a library
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE114_Process_Control;

import testcasesupport.*;

public class CWE114_Process_Control__basic_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
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

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            String root = "C:\\libs\\";
            String libName = "test.dll";
            /* FIX: Use System.load() which allows you to specify a full path to the library */
            System.load(root + libName);
        }
        else {

            String root = "C:\\libs\\";
            String libName = "test.dll";

            /* FIX: Use System.load() which allows you to specify a full path to the library */
            System.load(root + libName);

        }
    }

    public void good() throws Throwable
    {
        good1();
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
