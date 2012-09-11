/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__fromDB_modulo_52b.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: fromDB Read data from a database connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_By_Zero__fromDB_modulo_52b
{

    public void bad_sink(int data ) throws Throwable
    {
        (new CWE369_Divide_By_Zero__fromDB_modulo_52c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data ) throws Throwable
    {
        (new CWE369_Divide_By_Zero__fromDB_modulo_52c()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data ) throws Throwable
    {
        (new CWE369_Divide_By_Zero__fromDB_modulo_52c()).goodB2G_sink(data );
    }
}
