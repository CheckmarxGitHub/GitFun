/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__PropertiesFile_executeBatch_52b.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-52b.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: PropertiesFile Read a value from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: executeBatch
 *    GoodSink: prepared sqlstatement, batch
 *    BadSink : untrusted input to raw update batch
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__PropertiesFile_executeBatch_52b
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE89_SQL_Injection__PropertiesFile_executeBatch_52c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE89_SQL_Injection__PropertiesFile_executeBatch_52c()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {
        (new CWE89_SQL_Injection__PropertiesFile_executeBatch_52c()).goodB2G_sink(data );
    }
}
