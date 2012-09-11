/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__Class_StringBuilder_16.java
Label Definition File: CWE690_NULL_Deref_from_Return__Class.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
* BadSource:  Use a custom method which may return null
* GoodSource: Use a custom method that never returns null
* Sinks: trim
*    GoodSink: Check data for null before calling trim()
*    BadSink : Call trim() on possibly null object
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE690_NULL_Deref_from_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_from_Return__Class_StringBuilder_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        StringBuilder data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: call getStringBuilderG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderGood();
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: Call getStringBuilderG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderBad();
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.toString().trim();
            IO.writeLine(sOut);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.toString().trim();
                IO.writeLine(sOut);
            }
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B() throws Throwable
    {
        StringBuilder data;
        boolean local_f = false;

        while(true)
        {
            /* FIX: call getStringBuilderG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderGood();
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Call getStringBuilderG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderBad();
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.toString().trim();
            IO.writeLine(sOut);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.toString().trim();
                IO.writeLine(sOut);
            }
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G() throws Throwable
    {
        StringBuilder data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: call getStringBuilderG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderGood();
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: Call getStringBuilderG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderBad();
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.toString().trim();
            IO.writeLine(sOut);
            break;
        }

        while(true)
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.toString().trim();
                IO.writeLine(sOut);
            }
            break;
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
