/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__passwordAuth_61a.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-61a.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Hardcoded password in String
 * GoodSource: Password is read from stdin
 * Sinks: passwordAuth
 *    BadSink : password used in PasswordAuthentication
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

import java.net.PasswordAuthentication;

public class CWE259_Hard_Coded_Password__passwordAuth_61a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data = (new CWE259_Hard_Coded_Password__passwordAuth_61b()).bad_source();

        /* POTENTIAL FLAW: Hard-coded password */
        PasswordAuthentication pa = new PasswordAuthentication("user", data.toCharArray());

        IO.writeLine(pa.toString());

    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data = (new CWE259_Hard_Coded_Password__passwordAuth_61b()).goodG2B_source();

        /* POTENTIAL FLAW: Hard-coded password */
        PasswordAuthentication pa = new PasswordAuthentication("user", data.toCharArray());

        IO.writeLine(pa.toString());

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
