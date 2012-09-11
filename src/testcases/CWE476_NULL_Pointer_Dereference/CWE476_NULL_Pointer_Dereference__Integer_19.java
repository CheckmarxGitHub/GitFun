/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__Integer_19.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-19.tmpl.java
*/
/*
* @description
* CWE: 476 Null Pointer Dereference
* BadSource:  Set data to null
* GoodSource: Set data to a non-null value
* Sinks:
*    GoodSink: add check to prevent possibility of null dereference
*    BadSink : possibility of null dereference
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

public class CWE476_NULL_Pointer_Dereference__Integer_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        Integer data;

        /* POTENTIAL FLAW: string is null */
        data = null;

        {

            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.toString());

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B() throws Throwable
    {
        Integer data;
        {

            /* FIX: hardcode string to non-null */
            data = new Integer(5);

            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.toString());

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* POTENTIAL FLAW: string is null */
            data = null;

            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.toString());

        }
    }

    /* goodB2G() - use badsource and goodsink by switching statements around return */
    private void goodB2G() throws Throwable
    {
        Integer data;

        /* POTENTIAL FLAW: string is null */
        data = null;

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

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* POTENTIAL FLAW: null dereference will occur if data is null */
            IO.writeLine("" + data.toString());

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
