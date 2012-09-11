/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__passwordAuth_68b.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-68b.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Hardcoded password in String
 * GoodSource: Password is read from stdin
 * BadSink: passwordAuth password used in PasswordAuthentication
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

//!! other imports come from the label definitions

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

import java.net.PasswordAuthentication;

public class CWE259_Hard_Coded_Password__passwordAuth_68b
{

    public void bad_sink() throws Throwable
    {
        String data = CWE259_Hard_Coded_Password__passwordAuth_68a.data;

        /* POTENTIAL FLAW: Hard-coded password */
        PasswordAuthentication pa = new PasswordAuthentication("user", data.toCharArray());

        IO.writeLine(pa.toString());

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink() throws Throwable
    {
        String data = CWE259_Hard_Coded_Password__passwordAuth_68a.data;

        /* POTENTIAL FLAW: Hard-coded password */
        PasswordAuthentication pa = new PasswordAuthentication("user", data.toCharArray());

        IO.writeLine(pa.toString());

    }
}
