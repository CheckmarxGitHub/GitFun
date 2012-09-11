/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__kerberosKey_67b.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-67b.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Hardcoded password in String
 * GoodSource: Password is read from stdin
 * Sinks: kerberosKey
 *    BadSink : password used in Kerberos exchange
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
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

public class CWE259_Hard_Coded_Password__kerberosKey_67b
{

    public void bad_sink(CWE259_Hard_Coded_Password__kerberosKey_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        KerberosPrincipal principal = new KerberosPrincipal("test");
        /* The use of null as the 3rd parameter to KerberosKey causes the algorithm to default to "DES" */
        /* POTENTIAL FLAW: Hard-coded password */
        KerberosKey key = new KerberosKey(principal, data.toCharArray(), null);
        IO.writeLine(key.toString());

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(CWE259_Hard_Coded_Password__kerberosKey_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

        KerberosPrincipal principal = new KerberosPrincipal("test");
        /* The use of null as the 3rd parameter to KerberosKey causes the algorithm to default to "DES" */
        /* POTENTIAL FLAW: Hard-coded password */
        KerberosKey key = new KerberosKey(principal, data.toCharArray(), null);
        IO.writeLine(key.toString());

    }

}
