/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__listen_tcp_executeUpdate_54d.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-54d.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks: executeUpdate
 *    GoodSink: prepared sqlstatement, executeUpdate
 *    BadSink : raw query used in executeUpdate
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__listen_tcp_executeUpdate_54d
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE89_SQL_Injection__listen_tcp_executeUpdate_54e()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE89_SQL_Injection__listen_tcp_executeUpdate_54e()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {
        (new CWE89_SQL_Injection__listen_tcp_executeUpdate_54e()).goodB2G_sink(data );
    }
}
