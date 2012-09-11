/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE572_Call_to_Thread_run_Instead_of_start__basic_19.java
Label Definition File: CWE572_Call_to_Thread_run_Instead_of_start__basic.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 572 Call to Thread run instead of Thread start
* Sinks:
*    GoodSink: calls thread start
*    BadSink : calls thread run
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE572_Call_to_Thread_run_Instead_of_start;

import testcasesupport.*;

import java.io.*;

public class CWE572_Call_to_Thread_run_Instead_of_start__basic_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
    }

    public void good() throws Throwable
    {
        good1();
    }

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

