/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__Environment_executeUpdate_42.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-42.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: Environment Read a string from an environment variable
 * GoodSource: A hardcoded string
 * Sinks: executeUpdate
 *    GoodSink: prepared sqlstatement, executeUpdate
 *    BadSink : raw query used in executeUpdate
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

import java.util.logging.Logger;

public class CWE89_SQL_Injection__Environment_executeUpdate_42 extends AbstractTestCase
{

    private String bad_source() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        return data;
    }

    public void bad() throws Throwable
    {
        String data = bad_source();

        Logger log2 = Logger.getLogger("local-logger");

        Connection conn_tmp2 = null;
        Statement sqlstatement = null;

        try {
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.createStatement();

            /* POTENTIAL FLAW: place user input into dynamic sql query */
            int iResult = sqlstatement.executeUpdate("insert into users (status) values ('updated') where name='"+data+"'");

            IO.writeString("Updated " + iResult + " rows successfully.");
        }
        catch( SQLException se )
        {
            log2.warning("Error getting database connection");
        }
        finally {
            try {
                if( sqlstatement != null )
                {
                    sqlstatement.close();
                }
            }
            catch( SQLException e )
            {
                log2.warning("Error closing sqlstatement");
            }
            finally {
                try {
                    if( conn_tmp2 != null )
                    {
                        conn_tmp2.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing conn_tmp2");
                }
            }
        }

    }

    /* goodG2B() - use goodsource and badsink */
    private String goodG2B_source() throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        return data;
    }

    private void goodG2B() throws Throwable
    {
        String data = goodG2B_source();

        Logger log2 = Logger.getLogger("local-logger");

        Connection conn_tmp2 = null;
        Statement sqlstatement = null;

        try {
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.createStatement();

            /* POTENTIAL FLAW: place user input into dynamic sql query */
            int iResult = sqlstatement.executeUpdate("insert into users (status) values ('updated') where name='"+data+"'");

            IO.writeString("Updated " + iResult + " rows successfully.");
        }
        catch( SQLException se )
        {
            log2.warning("Error getting database connection");
        }
        finally {
            try {
                if( sqlstatement != null )
                {
                    sqlstatement.close();
                }
            }
            catch( SQLException e )
            {
                log2.warning("Error closing sqlstatement");
            }
            finally {
                try {
                    if( conn_tmp2 != null )
                    {
                        conn_tmp2.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing conn_tmp2");
                }
            }
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private String goodB2G_source() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        return data;
    }

    private void goodB2G() throws Throwable
    {
        String data = goodB2G_source();

        Logger log2 = Logger.getLogger("local-logger");

        Connection conn_tmp2 = null;
        PreparedStatement sqlstatement = null;

        try {
            /* FIX: use prepared sqlstatement */
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.prepareStatement("insert into users (status) values ('updated') where name=?");
            sqlstatement.setString(1, data);

            int iResult = sqlstatement.executeUpdate();

            IO.writeString("Updated " + iResult + " rows successfully.");
        }
        catch( SQLException se )
        {
            log2.warning("Error getting database connection");
        }
        finally {
            try {
                if( sqlstatement != null )
                {
                    sqlstatement.close();
                }
            }
            catch( SQLException e )
            {
                log2.warning("Error closing sqlstatement");
            }
            finally {
                try {
                    if( conn_tmp2 != null )
                    {
                        conn_tmp2.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing conn_tmp2");
                }
            }
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
