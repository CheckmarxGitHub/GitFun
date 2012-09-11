/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__driverManager_53c.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-53c.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Hardcoded password in String
 * GoodSource: Password is read from stdin
 * Sinks: driverManager
 *    BadSink : password used in database connection
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

public class CWE259_Hard_Coded_Password__driverManager_53c
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE259_Hard_Coded_Password__driverManager_53d()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE259_Hard_Coded_Password__driverManager_53d()).goodG2B_sink(data );
    }

}
