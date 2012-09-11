/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__console_readLine_executeBatch_61a.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded string
 * Sinks: executeBatch
 *    GoodSink: prepared sqlstatement, batch
 *    BadSink : untrusted input to raw update batch
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__console_readLine_executeBatch_61a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data = (new CWE89_SQL_Injection__console_readLine_executeBatch_61b()).bad_source();

        String names[] = data.split("-");
        int iSuccess = 0;

        Logger log2 = Logger.getLogger("local-logger");

        Connection conn_tmp2 = null;
        Statement sqlstatement = null;

        try {
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.createStatement();

            for(int i = 0; i < names.length; ++i)
            {
                /* POTENTIAL FLAW: take user input and place into dynamic sql query */
                sqlstatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
            }

            int dbResults[] = sqlstatement.executeBatch();

            for( int i = 0; i < names.length; ++i )
            {
                if( dbResults[i] > 0 )
                {
                    iSuccess++;
                }
            }

            IO.writeString("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
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

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data = (new CWE89_SQL_Injection__console_readLine_executeBatch_61b()).goodG2B_source();

        String names[] = data.split("-");
        int iSuccess = 0;

        Logger log2 = Logger.getLogger("local-logger");

        Connection conn_tmp2 = null;
        Statement sqlstatement = null;

        try {
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.createStatement();

            for(int i = 0; i < names.length; ++i)
            {
                /* POTENTIAL FLAW: take user input and place into dynamic sql query */
                sqlstatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
            }

            int dbResults[] = sqlstatement.executeBatch();

            for( int i = 0; i < names.length; ++i )
            {
                if( dbResults[i] > 0 )
                {
                    iSuccess++;
                }
            }

            IO.writeString("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
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
    private void goodB2G() throws Throwable
    {
        String data = (new CWE89_SQL_Injection__console_readLine_executeBatch_61b()).goodB2G_source();

        String names[] = data.split("-");
        int iSuccess = 0;

        Logger log2 = Logger.getLogger("local-logger");

        Connection conn_tmp2 = null;
        PreparedStatement sqlstatement = null;

        try {
            /* FIX: use prepared sqlstatement */
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.prepareStatement("update users set hitcount=hitcount+1 where name=?");

            for(int i = 0; i < names.length; ++i)
            {
                sqlstatement.setString(1, names[i]);
                sqlstatement.addBatch();
            }

            int dbResults[] = sqlstatement.executeBatch();

            for( int i = 0; i < names.length; ++i )
            {
                if( dbResults[i] > 0 )
                {
                    iSuccess++;
                }
            }

            IO.writeString("Succeeded in " + iSuccess + " out of " + names.length + " queries.");
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
