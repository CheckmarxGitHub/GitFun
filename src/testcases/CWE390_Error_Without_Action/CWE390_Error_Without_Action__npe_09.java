/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__npe_09.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-09.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: npe
*    GoodSink: Report and rethrow NullPointerException
*    BadSink : Catch NullPointerException, but don't do anything about it
* Flow Variant: 09 Control flow: if(IO.static_final_t) and if(IO.static_final_f)
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE390_Error_Without_Action__npe_09 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_final_t)
        {
            String sNull = null;
            try
            {
                String tmp = sNull.trim();
            }
            catch( NullPointerException e )
            {
                /*  FLAW: catch NullPointerException but without an action */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String sNull = null;
            try
            {
                String tmp = sNull.trim();
            }
            catch( NullPointerException e )
            {
                /* FIX: report NPE and rethrow */
                IO.writeLine("Error: " + e.getMessage());
                throw e;
            }

        }
    }

    /* good1() changes IO.static_final_t to IO.static_final_f */
    private void good1() throws Throwable
    {
        if(IO.static_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String sNull = null;
            try
            {
                String tmp = sNull.trim();
            }
            catch( NullPointerException e )
            {
                /*  FLAW: catch NullPointerException but without an action */
            }
        }
        else {

            String sNull = null;
            try
            {
                String tmp = sNull.trim();
            }
            catch( NullPointerException e )
            {
                /* FIX: report NPE and rethrow */
                IO.writeLine("Error: " + e.getMessage());
                throw e;
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(IO.static_final_t)
        {
            String sNull = null;
            try
            {
                String tmp = sNull.trim();
            }
            catch( NullPointerException e )
            {
                /* FIX: report NPE and rethrow */
                IO.writeLine("Error: " + e.getMessage());
                throw e;
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String sNull = null;
            try
            {
                String tmp = sNull.trim();
            }
            catch( NullPointerException e )
            {
                /*  FLAW: catch NullPointerException but without an action */
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
