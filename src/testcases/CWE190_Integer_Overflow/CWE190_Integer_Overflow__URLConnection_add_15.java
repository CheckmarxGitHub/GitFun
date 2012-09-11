/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__URLConnection_add_15.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: URLConnection Read data from a web server with URLConnection
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: add
*    GoodSink: Ensure there will not be an overflow before performing the addition
*    BadSink : Unchecked addition, which can lead to overflow
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import java.util.logging.Logger;

import java.security.SecureRandom;

public class CWE190_Integer_Overflow__URLConnection_add_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;
        switch(6)
        {
        case 6:
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* init data */
            data = -1;
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* read input from URLConnection */
                instrread = new InputStreamReader(conn.getInputStream());
                buffread = new BufferedReader(instrread);
                String s_data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
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
            finally
            {
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
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
            int result = (data + valueToAdd);
            IO.writeLine("result: " + result);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            int result = 0;
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data <= (Integer.MAX_VALUE-valueToAdd))
            {
                result = (data + valueToAdd);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too large to perform addition.");
            }
        }
        break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1() throws Throwable
    {
        int data;
        switch(5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* init data */
            data = -1;
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* read input from URLConnection */
                instrread = new InputStreamReader(conn.getInputStream());
                buffread = new BufferedReader(instrread);
                String s_data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
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
            finally
            {
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
        }
        break;
        default:
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
            int result = (data + valueToAdd);
            IO.writeLine("result: " + result);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            int result = 0;
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data <= (Integer.MAX_VALUE-valueToAdd))
            {
                result = (data + valueToAdd);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too large to perform addition.");
            }
        }
        break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2() throws Throwable
    {
        int data;
        switch(6)
        {
        case 6:
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* init data */
            data = -1;
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* read input from URLConnection */
                instrread = new InputStreamReader(conn.getInputStream());
                buffread = new BufferedReader(instrread);
                String s_data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
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
            finally
            {
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
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
            int result = (data + valueToAdd);
            IO.writeLine("result: " + result);
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            int result = 0;
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data <= (Integer.MAX_VALUE-valueToAdd))
            {
                result = (data + valueToAdd);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too large to perform addition.");
            }
        }
        break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1() throws Throwable
    {
        int data;
        switch(6)
        {
        case 6:
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* init data */
            data = -1;
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* read input from URLConnection */
                instrread = new InputStreamReader(conn.getInputStream());
                buffread = new BufferedReader(instrread);
                String s_data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
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
            finally
            {
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
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
        }
        break;
        }

        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
            int result = (data + valueToAdd);
            IO.writeLine("result: " + result);
        }
        break;
        default:
        {
            int result = 0;
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data <= (Integer.MAX_VALUE-valueToAdd))
            {
                result = (data + valueToAdd);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too large to perform addition.");
            }
        }
        break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2() throws Throwable
    {
        int data;
        switch(6)
        {
        case 6:
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* init data */
            data = -1;
            URLConnection conn = (new URL("http://www.example.org/")).openConnection();
            BufferedReader buffread = null;
            InputStreamReader instrread = null;
            try
            {
                /* read input from URLConnection */
                instrread = new InputStreamReader(conn.getInputStream());
                buffread = new BufferedReader(instrread);
                String s_data = buffread.readLine(); // This will be reading the first "line" of the response body,
                // which could be very long if there are no newlines in the HTML
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
            finally
            {
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
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
        }
        break;
        }

        switch(7)
        {
        case 7:
        {
            int result = 0;
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* FIX: Add a check to prevent an overflow from occurring */
            if (data <= (Integer.MAX_VALUE-valueToAdd))
            {
                result = (data + valueToAdd);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("Input value is too large to perform addition.");
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            int valueToAdd = (new SecureRandom()).nextInt(99)+1; /* adding at least 1 */
            /* POTENTIAL FLAW: if (data+valueToAdd) > MAX_VALUE, this will overflow */
            int result = (data + valueToAdd);
            IO.writeLine("result: " + result);
        }
        break;
        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
