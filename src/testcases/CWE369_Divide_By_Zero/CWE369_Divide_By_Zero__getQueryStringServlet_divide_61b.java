/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__getQueryStringServlet_divide_61b.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import javax.servlet.http.*;
import java.util.StringTokenizer;
import java.sql.*;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE369_Divide_By_Zero__getQueryStringServlet_divide_61b
{

    public int bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init Data$ */
        data = -1;

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
                String s_data = rs.toString();
                data = Integer.parseInt(s_data.trim());
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

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public int goodG2B_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public int goodB2G_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init Data$ */
        data = -1;

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
                String s_data = rs.toString();
                data = Integer.parseInt(s_data.trim());
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

        return data;
    }
}
