/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__connect_tcp_divide_66a.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-66a.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Logger;

public class CWE369_Divide_By_Zero__connect_tcp_divide_66a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            // Read data using an outbound tcp connection
            sock = new Socket("host.example.org", 39544);

            /* read input from socket */
            instrread = new InputStreamReader(sock.getInputStream());
            buffread = new BufferedReader(instrread);

            String s_data = buffread.readLine();
            data = Integer.parseInt(s_data.trim());
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
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
        }

        int[] data_array = new int[5];
        data_array[2] = data;
        (new CWE369_Divide_By_Zero__connect_tcp_divide_66b()).bad_sink(data_array  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        int[] data_array = new int[5];
        data_array[2] = data;
        (new CWE369_Divide_By_Zero__connect_tcp_divide_66b()).goodG2B_sink(data_array  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            // Read data using an outbound tcp connection
            sock = new Socket("host.example.org", 39544);

            /* read input from socket */
            instrread = new InputStreamReader(sock.getInputStream());
            buffread = new BufferedReader(instrread);

            String s_data = buffread.readLine();
            data = Integer.parseInt(s_data.trim());
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
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
        }

        int[] data_array = new int[5];
        data_array[2] = data;
        (new CWE369_Divide_By_Zero__connect_tcp_divide_66b()).goodB2G_sink(data_array  );
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
