/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE193_Off_by_One_Error__basic_08.java
Label Definition File: CWE193_Off_by_One_Error__basic.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 193 An array index is 1 off from the max array index
* Sinks:
*    GoodSink: restrict max index value
*    BadSink : access array index outside array max
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE193_Off_by_One_Error;

import testcasesupport.*;

public class CWE193_Off_by_One_Error__basic_08 extends AbstractTestCase
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

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
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
        if(private_returns_t())
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
