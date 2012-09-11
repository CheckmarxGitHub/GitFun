/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE193_Off_by_One_Error__basic_12.java
Label Definition File: CWE193_Off_by_One_Error__basic.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 193 An array index is 1 off from the max array index
* Sinks:
*    GoodSink: restrict max index value
*    BadSink : access array index outside array max
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE193_Off_by_One_Error;

import testcasesupport.*;

public class CWE193_Off_by_One_Error__basic_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
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

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            int[] iarr = new int[10];
            for( int i = 0; i < iarr.length; ++i )   /* FIX: use iarr.length */
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
