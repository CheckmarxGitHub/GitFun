/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__Environment_executeQuery_15.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-15.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: Environment Read a string from an environment variable
* GoodSource: A hardcoded string
* Sinks: executeQuery
*    GoodSink: prepared sqlstatement, executeQuery
*    BadSink : raw query used in executeQuery
* Flow Variant: 15 Control flow: switch(6) and switch(7)
*
* */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

import java.util.logging.Logger;

public class CWE89_SQL_Injection__Environment_executeQuery_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* get environment variable ADD */
            data = System.getenv("ADD");
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        switch(7)
        {
        case 7:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        }
    }

    /* goodG2B1() - use goodsource and badsink by changing the first switch to switch(5) */
    private void goodG2B1() throws Throwable
    {
        String data;
        switch(5)
        {
        case 6:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* get environment variable ADD */
            data = System.getenv("ADD");
        }
        break;
        default:
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        switch(7)
        {
        case 7:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing the blocks in the first switch  */
    private void goodG2B2() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* get environment variable ADD */
            data = System.getenv("ADD");
        }
        break;
        }

        switch(7)
        {
        case 7:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        }
    }

    /* goodB2G1() - use badsource and goodsink by changing the second switch to switch(8) */
    private void goodB2G1() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* get environment variable ADD */
            data = System.getenv("ADD");
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        default:
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
        break;
        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing the blocks in the second switch  */
    private void goodB2G2() throws Throwable
    {
        String data;
        switch(6)
        {
        case 6:
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* get environment variable ADD */
            data = System.getenv("ADD");
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        break;
        }

        switch(7)
        {
        case 7:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
