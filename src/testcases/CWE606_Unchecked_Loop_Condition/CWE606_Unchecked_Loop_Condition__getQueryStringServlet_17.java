/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__getQueryStringServlet_17.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-17.tmpl.java
*/
/*
* @description
* CWE: 606 Unchecked Input for Loop Condition
* BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
* GoodSource: hardcoded int in string form
* Sinks:
*    GoodSink: validate loop variable
*    BadSink : loop variable not validated
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.StringTokenizer;
import java.sql.*;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE606_Unchecked_Loop_Condition__getQueryStringServlet_17 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* We need to have one source outside of a for loop in order
           to prevent the Java compiler from generating an error because
           data is uninitialized */

        Logger log_bad = Logger.getLogger("local-logger");
        data = "";

        /* parse the query string for value of 'id' */
        String id_str = null;
        StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
        while (st.hasMoreTokens())
        {
            String token = st.nextToken();
            int i = token.indexOf("=");
            if ((i > 0) && (i < (token.length() - 1)) && (token.substring(0, i).equals("id")))
            {
                id_str = token.substring(i + 1);
                break;
            }
        }

        if (id_str != null)
        {
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            try
            {
                int id = Integer.parseInt(id_str);
                conn = IO.getDBConnection();
                statement = conn.prepareStatement("select * from pages where id=?");
                /* FLAW: no check to see whether the user has privileges to view the data */
                statement.setInt(1, id);
                rs = statement.executeQuery();
                data = rs.toString();
            }
            catch( SQLException se )
            {
                log_bad.warning("Error");
            }
            finally
            {
                /* clean up database objects */
                try {
                    if( rs != null )
                    {
                        rs.close();
                    }
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error closing rs");
                }
                finally {
                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        log_bad.warning("Error closing statement");
                    }
                    finally {
                        try {
                            if( conn != null )
                            {
                                conn.close();
                            }
                        }
                        catch( SQLException se)
                        {
                            log_bad.warning("Error closing conn");
                        }
                    }
                }
            }
        }

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = "5";
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            /* FIX: loop number thresholds validated */
            if (loopNum >= 0 && loopNum <= 5)
            {
                for(int i=0; i < loopNum; i++)
                {
                    IO.writeLine("hello world");
                }
            }
        }
    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
       for statements with the one in the first for statement */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = "5";

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            data = "";
            /* parse the query string for value of 'id' */
            String id_str = null;
            StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken();
                int i = token.indexOf("=");
                if ((i > 0) && (i < (token.length() - 1)) && (token.substring(0, i).equals("id")))
                {
                    id_str = token.substring(i + 1);
                    break;
                }
            }
            if (id_str != null)
            {
                Connection conn = null;
                PreparedStatement statement = null;
                ResultSet rs = null;
                try
                {
                    int id = Integer.parseInt(id_str);
                    conn = IO.getDBConnection();
                    statement = conn.prepareStatement("select * from pages where id=?");
                    /* FLAW: no check to see whether the user has privileges to view the data */
                    statement.setInt(1, id);
                    rs = statement.executeQuery();
                    data = rs.toString();
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error");
                }
                finally
                {
                    /* clean up database objects */
                    try {
                        if( rs != null )
                        {
                            rs.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        log_bad.warning("Error closing rs");
                    }
                    finally {
                        try {
                            if( statement != null )
                            {
                                statement.close();
                            }
                        }
                        catch( SQLException se )
                        {
                            log_bad.warning("Error closing statement");
                        }
                        finally {
                            try {
                                if( conn != null )
                                {
                                    conn.close();
                                }
                            }
                            catch( SQLException se)
                            {
                                log_bad.warning("Error closing conn");
                            }
                        }
                    }
                }
            }
        }

        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            /* FIX: loop number thresholds validated */
            if (loopNum >= 0 && loopNum <= 5)
            {
                for(int i=0; i < loopNum; i++)
                {
                    IO.writeLine("hello world");
                }
            }
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on
       the second and third for statements */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");
        data = "";

        /* parse the query string for value of 'id' */
        String id_str = null;
        StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
        while (st.hasMoreTokens())
        {
            String token = st.nextToken();
            int i = token.indexOf("=");
            if ((i > 0) && (i < (token.length() - 1)) && (token.substring(0, i).equals("id")))
            {
                id_str = token.substring(i + 1);
                break;
            }
        }

        if (id_str != null)
        {
            Connection conn = null;
            PreparedStatement statement = null;
            ResultSet rs = null;
            try
            {
                int id = Integer.parseInt(id_str);
                conn = IO.getDBConnection();
                statement = conn.prepareStatement("select * from pages where id=?");
                /* FLAW: no check to see whether the user has privileges to view the data */
                statement.setInt(1, id);
                rs = statement.executeQuery();
                data = rs.toString();
            }
            catch( SQLException se )
            {
                log_bad.warning("Error");
            }
            finally
            {
                /* clean up database objects */
                try {
                    if( rs != null )
                    {
                        rs.close();
                    }
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error closing rs");
                }
                finally {
                    try {
                        if( statement != null )
                        {
                            statement.close();
                        }
                    }
                    catch( SQLException se )
                    {
                        log_bad.warning("Error closing statement");
                    }
                    finally {
                        try {
                            if( conn != null )
                            {
                                conn.close();
                            }
                        }
                        catch( SQLException se)
                        {
                            log_bad.warning("Error closing conn");
                        }
                    }
                }
            }
        }

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            data = "5";
        }

        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }
            /* FIX: loop number thresholds validated */
            if (loopNum >= 0 && loopNum <= 5)
            {
                for(int i=0; i < loopNum; i++)
                {
                    IO.writeLine("hello world");
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
