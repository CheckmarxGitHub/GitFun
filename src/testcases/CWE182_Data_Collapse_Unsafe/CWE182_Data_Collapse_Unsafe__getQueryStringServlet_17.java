/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE182_Data_Collapse_Unsafe__getQueryStringServlet_17.java
Label Definition File: CWE182_Data_Collapse_Unsafe.label.xml
Template File: sources-sink-17.tmpl.java
*/
/*
* @description
* CWE: 182 Attempt to sanitize user input collapses data into an unsafe expression
* BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
* GoodSource: A hardcoded string
* BadSink: badSanitization String.replaceAll sanitization
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE182_Data_Collapse_Unsafe;

import testcasesupport.*;

import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.StringTokenizer;
import java.sql.*;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE182_Data_Collapse_Unsafe__getQueryStringServlet_17 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink */
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
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }

        /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
        response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
       for statement with the one in the for statement */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

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

        /* POTENTIAL FLAW: bad attempt at sanitizing user input since <scr<script>ipt> will get through */
        response.getWriter().println("<br>bad() - <img src=\"" + data.replaceAll("(<script>)", "") + "\">");

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
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
