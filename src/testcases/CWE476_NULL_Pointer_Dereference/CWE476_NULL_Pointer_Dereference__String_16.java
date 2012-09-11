/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__String_16.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 476 Null Pointer Dereference
* BadSource:  Set data to null
* GoodSource: Set data to a non-null value
* Sinks:
*    GoodSink: add check to prevent possibility of null dereference
*    BadSink : possibility of null dereference
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

public class CWE476_NULL_Pointer_Dereference__String_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: hardcode string to non-null */
            data = "This is not null";
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: string is null */
            data = null;
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length());
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: validate that data is non-null */
            if( data != null )
            {
                IO.writeLine("" + data.length());
            }
            else
            {
                IO.writeLine("data is null");
            }
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B() throws Throwable
    {
        String data;
        boolean local_f = false;

        while(true)
        {
            /* FIX: hardcode string to non-null */
            data = "This is not null";
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: string is null */
            data = null;
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length());
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: validate that data is non-null */
            if( data != null )
            {
                IO.writeLine("" + data.length());
            }
            else
            {
                IO.writeLine("data is null");
            }
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G() throws Throwable
    {
        String data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: hardcode string to non-null */
            data = "This is not null";
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: string is null */
            data = null;
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.length());
            break;
        }

        while(true)
        {
            /* FIX: validate that data is non-null */
            if( data != null )
            {
                IO.writeLine("" + data.length());
            }
            else
            {
                IO.writeLine("data is null");
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
