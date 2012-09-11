/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE584_Return_in_Finally__basic_04.java
Label Definition File: CWE584_Return_in_Finally__basic.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 584 Return in finally
* Sinks:
*    GoodSink: no return in finally block
*    BadSink : return in finally
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE584_Return_in_Finally;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE584_Return_in_Finally__basic_04 extends AbstractTestCase
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
            try
            {
                throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException iae)
            {
                IO.writeLine("preventing incidental issues");
            }
            finally
            {
                if(true) return; /* FLAW: will always return and prevent finally from completing normally */
                /* INCIDENTAL: 571 Always returns true */
                /* We need the "if(true)" above because the Java Language Spec requires that unreachable code generate a compiler error */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            try
            {
                throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException iae)
            {
                IO.writeLine("preventing incidental issues");
            }
            finally
            {
                /* FIX: cleanup code here and continue */
                IO.writeLine("In finally block, cleaning up");
            }

        }
    }

    /* good1() changes private_final_t to private_final_f */
    private void good1() throws Throwable
    {
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            try
            {
                throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException iae)
            {
                IO.writeLine("preventing incidental issues");
            }
            finally
            {
                if(true) return; /* FLAW: will always return and prevent finally from completing normally */
                /* INCIDENTAL: 571 Always returns true */
                /* We need the "if(true)" above because the Java Language Spec requires that unreachable code generate a compiler error */
            }
        }
        else {

            try
            {
                throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException iae)
            {
                IO.writeLine("preventing incidental issues");
            }
            finally
            {
                /* FIX: cleanup code here and continue */
                IO.writeLine("In finally block, cleaning up");
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_final_t)
        {
            try
            {
                throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException iae)
            {
                IO.writeLine("preventing incidental issues");
            }
            finally
            {
                /* FIX: cleanup code here and continue */
                IO.writeLine("In finally block, cleaning up");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            try
            {
                throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException iae)
            {
                IO.writeLine("preventing incidental issues");
            }
            finally
            {
                if(true) return; /* FLAW: will always return and prevent finally from completing normally */
                /* INCIDENTAL: 571 Always returns true */
                /* We need the "if(true)" above because the Java Language Spec requires that unreachable code generate a compiler error */
            }

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
