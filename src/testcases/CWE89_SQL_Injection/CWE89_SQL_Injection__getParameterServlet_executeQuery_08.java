/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__getParameterServlet_executeQuery_08.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-08.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: getParameterServlet Read data from a querystring using getParameter
* GoodSource: A hardcoded string
* Sinks: executeQuery
*    GoodSink: prepared sqlstatement, executeQuery
*    BadSink : raw query used in executeQuery
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

import java.util.logging.Logger;

public class CWE89_SQL_Injection__getParameterServlet_executeQuery_08 extends AbstractTestCaseServlet
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            ResultSet sqlrs = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                /* POTENTIAL FLAW: take user input and place into dynamic sql query */
                sqlrs = sqlstatement.executeQuery("select * from users where name='"+data+"'");
                IO.writeString(sqlrs.toString());
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlrs != null )
                    {
                        sqlrs.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlrs");
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            ResultSet sqlrs = null;

            try {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("select * from users where name=?");
                sqlstatement.setString(1, data);

                sqlrs = sqlstatement.executeQuery();

                IO.writeString(sqlrs.toString());
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlrs != null )
                    {
                        sqlrs.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlrs");
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

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_returns_t() to private_returns_f() */
    private void goodG2B1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            ResultSet sqlrs = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                /* POTENTIAL FLAW: take user input and place into dynamic sql query */
                sqlrs = sqlstatement.executeQuery("select * from users where name='"+data+"'");
                IO.writeString(sqlrs.toString());
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlrs != null )
                    {
                        sqlrs.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlrs");
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            ResultSet sqlrs = null;

            try {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("select * from users where name=?");
                sqlstatement.setString(1, data);

                sqlrs = sqlstatement.executeQuery();

                IO.writeString(sqlrs.toString());
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlrs != null )
                    {
                        sqlrs.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlrs");
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
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log_bad = Logger.getLogger("local-logger");

            /* read parameter from request */
            data = request.getParameter("name");

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            ResultSet sqlrs = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                /* POTENTIAL FLAW: take user input and place into dynamic sql query */
                sqlrs = sqlstatement.executeQuery("select * from users where name='"+data+"'");
                IO.writeString(sqlrs.toString());
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlrs != null )
                    {
                        sqlrs.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlrs");
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            ResultSet sqlrs = null;

            try {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("select * from users where name=?");
                sqlstatement.setString(1, data);

                sqlrs = sqlstatement.executeQuery();

                IO.writeString(sqlrs.toString());
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlrs != null )
                    {
                        sqlrs.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlrs");
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
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_returns_t() to private_returns_f() */
    private void goodB2G1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            ResultSet sqlrs = null;
            try
            {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();
                /* POTENTIAL FLAW: take user input and place into dynamic sql query */
                sqlrs = sqlstatement.executeQuery("select * from users where name='"+data+"'");
                IO.writeString(sqlrs.toString());
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlrs != null )
                    {
                        sqlrs.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlrs");
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
        else {

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            ResultSet sqlrs = null;

            try {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("select * from users where name=?");
                sqlstatement.setString(1, data);

                sqlrs = sqlstatement.executeQuery();

                IO.writeString(sqlrs.toString());
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlrs != null )
                    {
                        sqlrs.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlrs");
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
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* read parameter from request */
            data = request.getParameter("name");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log2 = Logger.getLogger("local-logger");
            Connection conn_tmp2 = null;
            PreparedStatement sqlstatement = null;
            ResultSet sqlrs = null;
            try
            {
                /* FIX: use prepared sqlstatement */
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.prepareStatement("select * from users where name=?");
                sqlstatement.setString(1, data);
                sqlrs = sqlstatement.executeQuery();
                IO.writeString(sqlrs.toString());
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally
            {
                try {
                    if( sqlrs != null )
                    {
                        sqlrs.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlrs");
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log2 = Logger.getLogger("local-logger");

            Connection conn_tmp2 = null;
            Statement sqlstatement = null;
            ResultSet sqlrs = null;

            try {
                conn_tmp2 = IO.getDBConnection();
                sqlstatement = conn_tmp2.createStatement();

                /* POTENTIAL FLAW: take user input and place into dynamic sql query */
                sqlrs = sqlstatement.executeQuery("select * from users where name='"+data+"'");

                IO.writeString(sqlrs.toString());
            }
            catch( SQLException se )
            {
                log2.warning("Error getting database connection");
            }
            finally {
                try {
                    if( sqlrs != null )
                    {
                        sqlrs.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlrs");
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
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B1(request, response);
        goodG2B2(request, response);
        goodB2G1(request, response);
        goodB2G2(request, response);
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
