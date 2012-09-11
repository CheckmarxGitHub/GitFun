/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE584_Return_in_Finally__basic_08.java
Label Definition File: CWE584_Return_in_Finally__basic.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 584 Return in finally
* Sinks:
*    GoodSink: no return in finally block
*    BadSink : return in finally
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE584_Return_in_Finally;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE584_Return_in_Finally__basic_08 extends AbstractTestCase
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

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
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
        if(private_returns_t())
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
