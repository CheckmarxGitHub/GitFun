/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__npe_15.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: npe
*    GoodSink: Report and rethrow NullPointerException
*    BadSink : Catch NullPointerException, but don't do anything about it
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE390_Error_Without_Action__npe_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        switch(7)
        {
        case 7:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        }
    }

    /* good1() change the switch to switch(8) */
    private void good1() throws Throwable
    {
        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        default:
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
        break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2() throws Throwable
    {
        switch(7)
        {
        case 7:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
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
