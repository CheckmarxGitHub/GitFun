/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE572_Call_to_Thread_run_Instead_of_start__basic_08.java
Label Definition File: CWE572_Call_to_Thread_run_Instead_of_start__basic.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 572 Call to Thread run instead of Thread start
* Sinks:
*    GoodSink: calls thread start
*    BadSink : calls thread run
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE572_Call_to_Thread_run_Instead_of_start;

import testcasesupport.*;

import java.io.*;

public class CWE572_Call_to_Thread_run_Instead_of_start__basic_08 extends AbstractTestCase
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        if (private_returns_t())
        {
            IO.writeLine("bad() Main thread name is: " + Thread.currentThread().getName());
            Thread t = new Thread()
            {
                public void run()
                {
                    IO.writeLine("bad() In thread: " + Thread.currentThread().getName());
                }
            };
            t.run(); /* FLAW: Called Thread.run() instead of Thread.start() */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            IO.writeLine("good() Main thread name is: " + Thread.currentThread().getName());
            Thread t = new Thread()
            {
                public void run()
                {
                    IO.writeLine("good() In thread: " + Thread.currentThread().getName());
                }
            };

            t.start(); /* FIX: Correctly called Thread.start() */

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("bad() Main thread name is: " + Thread.currentThread().getName());
            Thread t = new Thread()
            {
                public void run()
                {
                    IO.writeLine("bad() In thread: " + Thread.currentThread().getName());
                }
            };
            t.run(); /* FLAW: Called Thread.run() instead of Thread.start() */
        }
        else {

            IO.writeLine("good() Main thread name is: " + Thread.currentThread().getName());
            Thread t = new Thread()
            {
                public void run()
                {
                    IO.writeLine("good() In thread: " + Thread.currentThread().getName());
                }
            };

            t.start(); /* FIX: Correctly called Thread.start() */

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_returns_t())
        {
            IO.writeLine("good() Main thread name is: " + Thread.currentThread().getName());
            Thread t = new Thread()
            {
                public void run()
                {
                    IO.writeLine("good() In thread: " + Thread.currentThread().getName());
                }
            };
            t.start(); /* FIX: Correctly called Thread.start() */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            IO.writeLine("bad() Main thread name is: " + Thread.currentThread().getName());
            Thread t = new Thread()
            {
                public void run()
                {
                    IO.writeLine("bad() In thread: " + Thread.currentThread().getName());
                }
            };

            t.run(); /* FLAW: Called Thread.run() instead of Thread.start() */

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
