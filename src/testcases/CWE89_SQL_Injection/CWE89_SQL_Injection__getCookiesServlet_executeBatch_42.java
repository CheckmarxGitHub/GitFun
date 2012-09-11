/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__getCookiesServlet_executeBatch_42.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-42.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * Sinks: executeBatch
 *    GoodSink: prepared sqlstatement, batch
 *    BadSink : untrusted input to raw update batch
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__getCookiesServlet_executeBatch_42 extends AbstractTestCaseServlet
{

    private String bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* read parameter from cookie */
        Cookie cookieSources[] = request.getCookies();
        if (cookieSources != null)
        {
            data = cookieSources[0].getValue();
        }
        else
        {
            data = null;
        }

        return data;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = bad_source(request, response);

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

    /* goodG2B() - use goodsource and badsink */
    private String goodG2B_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        return data;
    }

    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodG2B_source(request, response);

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
    private String goodB2G_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* read parameter from cookie */
        Cookie cookieSources[] = request.getCookies();
        if (cookieSources != null)
        {
            data = cookieSources[0].getValue();
        }
        else
        {
            data = null;
        }

        return data;
    }

    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = goodB2G_source(request, response);

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

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
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
