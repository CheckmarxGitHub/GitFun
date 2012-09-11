/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__npe_17.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: npe
*    GoodSink: Report and rethrow NullPointerException
*    BadSink : Catch NullPointerException, but don't do anything about it
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE390_Error_Without_Action__npe_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
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

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
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

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
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

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
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
