/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__fromDB_execute_52c.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-52c.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: fromDB Read a string from a database connection
 * GoodSource: A hardcoded string
 * Sinks: execute
 *    GoodSink: prepared sqlstatement, single
 *    BadSink : untrusted parameter value to raw insert sqlstatement
 * Flow Variant: 53 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__fromDB_execute_52c
{

    public void bad_sink(String data ) throws Throwable
    {

        Logger log2 = Logger.getLogger("local-logger");

        Connection conn_tmp2 = null;
        Statement sqlstatement = null;

        try {
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.createStatement();

            /* POTENTIAL FLAW: value of "name" taken directly from an untrusted source and inserted into a command string executed against a SQL interpreter */
            Boolean bResult = sqlstatement.execute("insert into users (status) values ('updated') where name='"+data+"'");

            if( bResult )
            {
                IO.writeString("Name, " + data + ", updated successfully");
            }
            else
            {
                IO.writeString("Unable to update records for user: " + data);
            }
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
    public void goodG2B_sink(String data ) throws Throwable
    {

        Logger log2 = Logger.getLogger("local-logger");

        Connection conn_tmp2 = null;
        Statement sqlstatement = null;

        try {
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.createStatement();

            /* POTENTIAL FLAW: value of "name" taken directly from an untrusted source and inserted into a command string executed against a SQL interpreter */
            Boolean bResult = sqlstatement.execute("insert into users (status) values ('updated') where name='"+data+"'");

            if( bResult )
            {
                IO.writeString("Name, " + data + ", updated successfully");
            }
            else
            {
                IO.writeString("Unable to update records for user: " + data);
            }
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
    public void goodB2G_sink(String data ) throws Throwable
    {

        Logger log2 = Logger.getLogger("local-logger");

        Connection conn_tmp2 = null;
        PreparedStatement sqlstatement = null;

        try {
            /* FIX: use prepared sqlstatements */
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.prepareStatement("insert into users (status) values ('updated') where name=?");
            sqlstatement.setString(1, data);

            Boolean bResult = sqlstatement.execute();

            if( bResult )
            {
                IO.writeString("Name, " + data + ", updated successfully");
            }
            else
            {
                IO.writeString("Unable to update records for user: " + data);
            }
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
}
