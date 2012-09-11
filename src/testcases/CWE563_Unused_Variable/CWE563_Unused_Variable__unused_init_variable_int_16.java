/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_init_variable_int_16.java
Label Definition File: CWE563_Unused_Variable__unused_init_variable.label.xml
Template File: source-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  Initialize data
* Sinks:
*    GoodSink: Use data
*    BadSink : do nothing
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE563_Unused_Variable__unused_init_variable_int_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        Integer data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        /* POTENTIAL FLAW: Initialize, but do not use data */
        data = 5;

        while(true)
        {
            /* POTENTIAL FLAW: Do not use the variable */
            /* do nothing */
            ; /* empty statement needed for some flow variants */
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use data */
            IO.writeLine("" + data);
            break;
        }
    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the while statements */
    private void goodB2G() throws Throwable
    {
        Integer data;
        boolean local_f = false;

        /* POTENTIAL FLAW: Initialize, but do not use data */
        data = 5;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Do not use the variable */
            /* do nothing */
            ; /* empty statement needed for some flow variants */
            break;
        }

        while(true)
        {
            /* FIX: Use data */
            IO.writeLine("" + data);
            break;
        }
    }

    public void good() throws Throwable
    {
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
