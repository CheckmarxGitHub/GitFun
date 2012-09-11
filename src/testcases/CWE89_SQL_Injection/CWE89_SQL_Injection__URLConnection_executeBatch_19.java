/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__URLConnection_executeBatch_19.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-19.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: URLConnection Read a string from a web server with URLConnection
* GoodSource: A hardcoded string
* Sinks: executeBatch
*    GoodSink: prepared sqlstatement, batch
*    BadSink : untrusted input to raw update batch
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.Logger;

public class CWE89_SQL_Injection__URLConnection_executeBatch_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        URLConnection conn = (new URL("http://www.example.org/")).openConnection();
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* read input from URLConnection */
            instrread = new InputStreamReader(conn.getInputStream());
            buffread = new BufferedReader(instrread);

            data = buffread.readLine(); // This will be reading the first "line" of the response body,
            // which could be very long if there are no newlines in the HTML
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing instrread");
                }
            }
        }

        {

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

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

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
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B() throws Throwable
    {
        String data;
        {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

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

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            Logger log_bad = Logger.getLogger("local-logger");

            data = ""; /* init data */

            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try {
                /* read input from URLConnection */
                instrread = new InputStreamReader(conn.getInputStream());
                buffread = new BufferedReader(instrread);

                data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error with stream reading");
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( buffread != null )
                    {
                        buffread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing buffread");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing instrread");
                    }
                }
            }

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
    }

    /* goodB2G() - use badsource and goodsink by switching statements around return */
    private void goodB2G() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        URLConnection conn = (new URL("http://www.example.org/")).openConnection();
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* read input from URLConnection */
            instrread = new InputStreamReader(conn.getInputStream());
            buffread = new BufferedReader(instrread);

            data = buffread.readLine(); // This will be reading the first "line" of the response body,
            // which could be very long if there are no newlines in the HTML
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing instrread");
                }
            }
        }

        {

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

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

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
