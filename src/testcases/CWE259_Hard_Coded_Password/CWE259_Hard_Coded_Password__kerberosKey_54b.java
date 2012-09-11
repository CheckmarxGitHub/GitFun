/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__kerberosKey_54b.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-54b.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Hardcoded password in String
 * GoodSource: Password is read from stdin
 * Sinks: kerberosKey
 *    BadSink : password used in Kerberos exchange
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.KerberosKey;

public class CWE259_Hard_Coded_Password__kerberosKey_54b
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE259_Hard_Coded_Password__kerberosKey_54c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE259_Hard_Coded_Password__kerberosKey_54c()).goodG2B_sink(data );
    }

}
