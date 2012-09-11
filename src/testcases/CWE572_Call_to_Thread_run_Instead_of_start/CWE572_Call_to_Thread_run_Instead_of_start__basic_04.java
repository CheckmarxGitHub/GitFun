/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE572_Call_to_Thread_run_Instead_of_start__basic_04.java
Label Definition File: CWE572_Call_to_Thread_run_Instead_of_start__basic.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 572 Call to Thread run instead of Thread start
* Sinks:
*    GoodSink: calls thread start
*    BadSink : calls thread run
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE572_Call_to_Thread_run_Instead_of_start;

import testcasesupport.*;

import java.io.*;

public class CWE572_Call_to_Thread_run_Instead_of_start__basic_04 extends AbstractTestCase
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad() throws Throwable
    {
        if (private_final_t)
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

    /* good1() changes private_final_t to private_final_f */
    private void good1() throws Throwable
    {
        if(private_final_f)
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
        if(private_final_t)
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
