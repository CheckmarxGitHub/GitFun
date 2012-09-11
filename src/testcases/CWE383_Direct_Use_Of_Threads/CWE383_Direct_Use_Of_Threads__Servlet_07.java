/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE383_Direct_Use_Of_Threads__Servlet_07.java
Label Definition File: CWE383_Direct_Use_Of_Threads__Servlet.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 383 J2EE Bad Practices Direct Use Of Threads
* Sinks:
*    GoodSink: does not use Threads
*    BadSink : performs thread management
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE383_Direct_Use_Of_Threads;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE383_Direct_Use_Of_Threads__Servlet_07 extends AbstractTestCaseServlet
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if (private_five==5)
        {
            /* FLAW: performing thread management in J2EE */
            Runnable r = new Runnable()
            {
                public void run()
                {
                    try
                    {
                        Thread.sleep(10000); /* perform a long calculation */
                    }
                    catch (InterruptedException e)
                    {
                        IO.writeLine("InterruptedException");
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();
            /* wait for the thread, check every second */
            while(true)
            {
                if (!t.isAlive())
                {
                    break;
                }
                Thread.sleep(1000);
            }
            response.getWriter().write("thread is done!");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: not performing thread management in J2EE */
            Thread.sleep(10000); /* perform a long calculation */
            response.getWriter().write("thread is done!");

        }
    }

    /* good1() changes private_five==5 to private_five!=5 */
    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: performing thread management in J2EE */
            Runnable r = new Runnable()
            {
                public void run()
                {
                    try
                    {
                        Thread.sleep(10000); /* perform a long calculation */
                    }
                    catch (InterruptedException e)
                    {
                        IO.writeLine("InterruptedException");
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();
            /* wait for the thread, check every second */
            while(true)
            {
                if (!t.isAlive())
                {
                    break;
                }
                Thread.sleep(1000);
            }
            response.getWriter().write("thread is done!");
        }
        else {

            /* FIX: not performing thread management in J2EE */
            Thread.sleep(10000); /* perform a long calculation */
            response.getWriter().write("thread is done!");

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        if(private_five==5)
        {
            /* FIX: not performing thread management in J2EE */
            Thread.sleep(10000); /* perform a long calculation */
            response.getWriter().write("thread is done!");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: performing thread management in J2EE */
            Runnable r = new Runnable()
            {
                public void run()
                {
                    try
                    {
                        Thread.sleep(10000); /* perform a long calculation */
                    }
                    catch (InterruptedException e)
                    {
                        IO.writeLine("InterruptedException");
                    }
                }
            };

            Thread t = new Thread(r);
            t.start();

            /* wait for the thread, check every second */
            while(true)
            {
                if (!t.isAlive())
                {
                    break;
                }
                Thread.sleep(1000);
            }

            response.getWriter().write("thread is done!");

        }

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
        good2(request, response);
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
