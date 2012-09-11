/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__listen_tcp_executeQuery_66a.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-66a.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks: executeQuery
 *    GoodSink: prepared sqlstatement, executeQuery
 *    BadSink : raw query used in executeQuery
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
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
import java.net.Socket;
import java.net.ServerSocket;

import java.util.logging.Logger;

public class CWE89_SQL_Injection__listen_tcp_executeQuery_66a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* Read data using a listening tcp connection */

        ServerSocket listener = null;
        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* read input from socket */
            listener = new ServerSocket(39543);
            sock = listener.accept();

            instrread = new InputStreamReader(sock.getInputStream());
            buffread = new BufferedReader(instrread);
            data = buffread.readLine();
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

            /* clean up socket objects */
            try {
                if( sock != null )
                {
                    sock.close();
                }
            }
            catch( IOException e )
            {
                log_bad.warning("Error closing sock");
            }
            finally {
                try {
                    if( listener != null )
                    {
                        listener.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing listener");
                }
            }
        }

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE89_SQL_Injection__listen_tcp_executeQuery_66b()).bad_sink(data_array  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE89_SQL_Injection__listen_tcp_executeQuery_66b()).goodG2B_sink(data_array  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* Read data using a listening tcp connection */

        ServerSocket listener = null;
        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* read input from socket */
            listener = new ServerSocket(39543);
            sock = listener.accept();

            instrread = new InputStreamReader(sock.getInputStream());
            buffread = new BufferedReader(instrread);
            data = buffread.readLine();
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

            /* clean up socket objects */
            try {
                if( sock != null )
                {
                    sock.close();
                }
            }
            catch( IOException e )
            {
                log_bad.warning("Error closing sock");
            }
            finally {
                try {
                    if( listener != null )
                    {
                        listener.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing listener");
                }
            }
        }

        String[] data_array = new String[5];
        data_array[2] = data;
        (new CWE89_SQL_Injection__listen_tcp_executeQuery_66b()).goodB2G_sink(data_array  );
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
