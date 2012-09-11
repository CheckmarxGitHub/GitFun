/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__Class_String_17.java
Label Definition File: CWE690_NULL_Deref_from_Return__Class.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
* BadSource:  Use a custom method which may return null
* GoodSource: Use a custom method that never returns null
* Sinks: trim
*    GoodSink: Check data for null before calling trim()
*    BadSink : Call trim() on possibly null object
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE690_NULL_Deref_from_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_from_Return__Class_String_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        /* We need to have one source outside of a for loop in order
           to prevent the Java compiler from generating an error because
           data is uninitialized */

        /* POTENTIAL FLAW: Call getStringG(), which may return null */
        data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBad();

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: call getStringG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringGood();
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }
        }
    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
       for statements with the one in the first for statement */
    private void goodG2B() throws Throwable
    {
        String data;

        /* FIX: call getStringG(), which will never return null */
        data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringGood();

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Call getStringG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBad();
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
            }
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on
       the second and third for statements */
    private void goodB2G() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Call getStringG(), which may return null */
        data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBad();

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: call getStringG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringGood();
        }

        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.trim();
            IO.writeLine(sOut);
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.trim();
                IO.writeLine(sOut);
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
