/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__driverManager_52b.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-52b.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Hardcoded password in String
 * GoodSource: Password is read from stdin
 * Sinks: driverManager
 *    BadSink : password used in database connection
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

public class CWE259_Hard_Coded_Password__driverManager_52b
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE259_Hard_Coded_Password__driverManager_52c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE259_Hard_Coded_Password__driverManager_52c()).goodG2B_sink(data );
    }

}
