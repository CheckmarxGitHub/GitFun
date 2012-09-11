/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE584_Return_in_Finally__basic_19.java
Label Definition File: CWE584_Return_in_Finally__basic.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 584 Return in finally
* Sinks:
*    GoodSink: no return in finally block
*    BadSink : return in finally
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE584_Return_in_Finally;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE584_Return_in_Finally__basic_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
    }

    public void good() throws Throwable
    {
        good1();
    }

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

