/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__fromDB_executeBatch_53c.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-53c.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: fromDB Read a string from a database connection
 * GoodSource: A hardcoded string
 * Sinks: executeBatch
 *    GoodSink: prepared sqlstatement, batch
 *    BadSink : untrusted input to raw update batch
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__fromDB_executeBatch_53c
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE89_SQL_Injection__fromDB_executeBatch_53d()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE89_SQL_Injection__fromDB_executeBatch_53d()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {
        (new CWE89_SQL_Injection__fromDB_executeBatch_53d()).goodB2G_sink(data );
    }
}
