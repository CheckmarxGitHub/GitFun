/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE193_Off_by_One_Error__basic_05.java
Label Definition File: CWE193_Off_by_One_Error__basic.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 193 An array index is 1 off from the max array index
* Sinks:
*    GoodSink: restrict max index value
*    BadSink : access array index outside array max
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE193_Off_by_One_Error;

import testcasesupport.*;

public class CWE193_Off_by_One_Error__basic_05 extends AbstractTestCase
{

    /* The two variables below are not defined as "final", but are never
       assigned any other value, so a tool should be able to identify that
       reads of these will always return their initialized values. */
    private boolean private_t = true;
    private boolean private_f = false;

    public void bad() throws Throwable
    {
        if (private_t)
        {
            int[] iarr = new int[10];
            for( int i = 0; i <= iarr.length; ++i )   /* FLAW: index outside of array, off by one */
            {
                IO.writeLine("iarr[" + i + "] = " + (iarr[i] = i));
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int[] iarr = new int[10];
            for( int i = 0; i < iarr.length; ++i )   /* FIX: use iarr.length */
            {
                IO.writeLine("iarr[" + i + "] = " + (iarr[i] = i));
            }

        }
    }

    /* good1() changes private_t to private_f */
    private void good1() throws Throwable
    {
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int[] iarr = new int[10];
            for( int i = 0; i <= iarr.length; ++i )   /* FLAW: index outside of array, off by one */
            {
                IO.writeLine("iarr[" + i + "] = " + (iarr[i] = i));
            }
        }
        else {

            int[] iarr = new int[10];
            for( int i = 0; i < iarr.length; ++i )   /* FIX: use iarr.length */
            {
                IO.writeLine("iarr[" + i + "] = " + (iarr[i] = i));
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_t)
        {
            int[] iarr = new int[10];
            for( int i = 0; i < iarr.length; ++i )   /* FIX: use iarr.length */
            {
                IO.writeLine("iarr[" + i + "] = " + (iarr[i] = i));
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            int[] iarr = new int[10];
            for( int i = 0; i <= iarr.length; ++i )   /* FLAW: index outside of array, off by one */
            {
                IO.writeLine("iarr[" + i + "] = " + (iarr[i] = i));
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
