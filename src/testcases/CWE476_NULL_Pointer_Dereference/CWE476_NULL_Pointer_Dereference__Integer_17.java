/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__Integer_17.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 476 Null Pointer Dereference
* BadSource:  Set data to null
* GoodSource: Set data to a non-null value
* Sinks:
*    GoodSink: add check to prevent possibility of null dereference
*    BadSink : possibility of null dereference
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

public class CWE476_NULL_Pointer_Dereference__Integer_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        Integer data;

        /* We need to have one source outside of a for loop in order
           to prevent the Java compiler from generating an error because
           data is uninitialized */

        /* POTENTIAL FLAW: string is null */
        data = null;

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: hardcode string to non-null */
            data = new Integer(5);
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.toString());
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: validate that data is non-null */
            if( data != null )
            {
                IO.writeLine("" + data.toString());
            }
            else
            {
                IO.writeLine("data is null");
            }
        }
    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
       for statements with the one in the first for statement */
    private void goodG2B() throws Throwable
    {
        Integer data;

        /* FIX: hardcode string to non-null */
        data = new Integer(5);

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: string is null */
            data = null;
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.toString());
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: validate that data is non-null */
            if( data != null )
            {
                IO.writeLine("" + data.toString());
            }
            else
            {
                IO.writeLine("data is null");
            }
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on
       the second and third for statements */
    private void goodB2G() throws Throwable
    {
        Integer data;

        /* POTENTIAL FLAW: string is null */
        data = null;

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: hardcode string to non-null */
            data = new Integer(5);
        }

        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.toString());
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            /* FIX: validate that data is non-null */
            if( data != null )
            {
                IO.writeLine("" + data.toString());
            }
            else
            {
                IO.writeLine("data is null");
            }
        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
