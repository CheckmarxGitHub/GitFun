/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE193_Off_by_One_Error__basic_19.java
Label Definition File: CWE193_Off_by_One_Error__basic.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 193 An array index is 1 off from the max array index
* Sinks:
*    GoodSink: restrict max index value
*    BadSink : access array index outside array max
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE193_Off_by_One_Error;

import testcasesupport.*;

public class CWE193_Off_by_One_Error__basic_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            int[] iarr = new int[10];
            for( int i = 0; i <= iarr.length; ++i )   /* FLAW: index outside of array, off by one */
            {
                IO.writeLine("iarr[" + i + "] = " + (iarr[i] = i));
            }

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

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

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
        {

            int[] iarr = new int[10];
            for( int i = 0; i < iarr.length; ++i )   /* FIX: use iarr.length */
            {
                IO.writeLine("iarr[" + i + "] = " + (iarr[i] = i));
            }

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            int[] iarr = new int[10];
            for( int i = 0; i <= iarr.length; ++i )   /* FLAW: index outside of array, off by one */
            {
                IO.writeLine("iarr[" + i + "] = " + (iarr[i] = i));
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

