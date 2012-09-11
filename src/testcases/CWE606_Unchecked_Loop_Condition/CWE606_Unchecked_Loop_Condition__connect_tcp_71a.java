/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__connect_tcp_71a.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-71a.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Logger;

public class CWE606_Unchecked_Loop_Condition__connect_tcp_71a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* Read data using an outbound tcp connection */
            sock = new Socket("host.example.org", 39544);

            /* read input from socket */
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
        }

        (new CWE606_Unchecked_Loop_Condition__connect_tcp_71b()).bad_sink((Object)data  );
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

        data = "5";

        (new CWE606_Unchecked_Loop_Condition__connect_tcp_71b()).goodG2B_sink((Object)data  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* Read data using an outbound tcp connection */
            sock = new Socket("host.example.org", 39544);

            /* read input from socket */
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
        }

        (new CWE606_Unchecked_Loop_Condition__connect_tcp_71b()).goodB2G_sink((Object)data  );
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
