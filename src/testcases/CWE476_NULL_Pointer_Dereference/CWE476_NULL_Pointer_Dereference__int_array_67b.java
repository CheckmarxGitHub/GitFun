/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__int_array_67b.java
Label Definition File: CWE476_NULL_Pointer_Dereference.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 476 Null Pointer Dereference
 * BadSource:  Set data to null
 * GoodSource: Set data to a non-null value
 * Sinks:
 *    GoodSink: add check to prevent possibility of null dereference
 *    BadSink : possibility of null dereference
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

public class CWE476_NULL_Pointer_Dereference__int_array_67b
{

    public void bad_sink(CWE476_NULL_Pointer_Dereference__int_array_67a.Container data_container ) throws Throwable
    {
        int [] data = data_container.a;

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE476_NULL_Pointer_Dereference__int_array_67a.Container data_container ) throws Throwable
    {
        int [] data = data_container.a;

        /* POTENTIAL FLAW: null dereference will occur if data is null */
        IO.writeLine("" + data.length);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE476_NULL_Pointer_Dereference__int_array_67a.Container data_container ) throws Throwable
    {
        int [] data = data_container.a;

        /* FIX: validate that data is non-null */
        if( data != null )
        {
            IO.writeLine("" + data.length);
        }
        else
        {
            IO.writeLine("data is null");
        }

    }
}
