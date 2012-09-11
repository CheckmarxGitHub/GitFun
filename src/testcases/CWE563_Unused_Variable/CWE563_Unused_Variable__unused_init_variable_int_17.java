/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_init_variable_int_17.java
Label Definition File: CWE563_Unused_Variable__unused_init_variable.label.xml
Template File: source-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  Initialize data
* Sinks:
*    GoodSink: Use data
*    BadSink : do nothing
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE563_Unused_Variable__unused_init_variable_int_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        Integer data;

        /* POTENTIAL FLAW: Initialize, but do not use data */
        data = 5;

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            /* POTENTIAL FLAW: Do not use the variable */
            /* do nothing */
            ; /* empty statement needed for some flow variants */
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: Use data */
            IO.writeLine("" + data);
        }
    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on
       the for statements */
    private void goodB2G() throws Throwable
    {
        Integer data;

        /* POTENTIAL FLAW: Initialize, but do not use data */
        data = 5;

        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Do not use the variable */
            /* do nothing */
            ; /* empty statement needed for some flow variants */
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            /* FIX: Use data */
            IO.writeLine("" + data);
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
