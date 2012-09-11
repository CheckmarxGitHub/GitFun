/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__getCookiesServlet_modulo_67b.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_By_Zero__getCookiesServlet_modulo_67b
{

    public void bad_sink(CWE369_Divide_By_Zero__getCookiesServlet_modulo_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = data_container.a;

        /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
        result in an exception.  */
        IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE369_Divide_By_Zero__getCookiesServlet_modulo_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = data_container.a;

        /* POTENTIAL FLAW: Zero modulus will cause an issue.  An integer division will
        result in an exception.  */
        IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(CWE369_Divide_By_Zero__getCookiesServlet_modulo_67a.Container data_container , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = data_container.a;

        /* FIX: test for a zero modulus */
        if( data != 0 )
        {
            IO.writeLine("100%" + String.valueOf(data) + " = " + (100 % data) + "\n");
        }
        else
        {
            IO.writeLine("This would result in a modulo by zero");
        }

    }
}
