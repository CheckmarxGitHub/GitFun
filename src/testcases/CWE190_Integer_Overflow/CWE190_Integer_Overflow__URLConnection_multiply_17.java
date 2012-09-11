/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__URLConnection_multiply_17.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 190 Integer Overflow
* BadSource: URLConnection Read data from a web server with URLConnection
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* Sinks: multiply
*    GoodSink: Ensure there will not be an overflow before performing the multiplication
*    BadSink : Unchecked multiplication, which can lead to overflow
* Flow Variant: 17 Control flow: for loops
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

public class CWE190_Integer_Overflow__URLConnection_multiply_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        int data;

        /* We need to have one source outside of a for loop in order
           to prevent the Java compiler from generating an error because
           data is uninitialized */

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        URLConnection conn = (new URL("http://www.example.org/")).openConnection();
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
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

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */
            if(data > 0)   /* ensure we don't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*valueToMult) > MAX_VALUE, this will overflow */
                int result = (data * valueToMult);
                IO.writeLine("result: " + result);
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */
            if(data > 0)   /* ensure we don't have an underflow */
            {
                int result = 0;
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data <= (Integer.MAX_VALUE/valueToMult))
                {
                    result = (data * valueToMult);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("Input value is too large to perform multiplication.");
                }
            }
        }
    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
       for statements with the one in the first for statement */
    private void goodG2B() throws Throwable
    {
        int data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */
            if(data > 0)   /* ensure we don't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*valueToMult) > MAX_VALUE, this will overflow */
                int result = (data * valueToMult);
                IO.writeLine("result: " + result);
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */
            if(data > 0)   /* ensure we don't have an underflow */
            {
                int result = 0;
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data <= (Integer.MAX_VALUE/valueToMult))
                {
                    result = (data * valueToMult);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("Input value is too large to perform multiplication.");
                }
            }
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on
       the second and third for statements */
    private void goodB2G() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        URLConnection conn = (new URL("http://www.example.org/")).openConnection();
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
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

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
        }

        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */
            if(data > 0)   /* ensure we don't have an underflow */
            {
                /* POTENTIAL FLAW: if (data*valueToMult) > MAX_VALUE, this will overflow */
                int result = (data * valueToMult);
                IO.writeLine("result: " + result);
            }
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            int valueToMult = (new SecureRandom()).nextInt(98) + 2; /* multiply by at least 2 */
            if(data > 0)   /* ensure we don't have an underflow */
            {
                int result = 0;
                /* FIX: Add a check to prevent an overflow from occurring */
                if (data <= (Integer.MAX_VALUE/valueToMult))
                {
                    result = (data * valueToMult);
                    IO.writeLine("result: " + result);
                }
                else
                {
                    IO.writeLine("Input value is too large to perform multiplication.");
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
