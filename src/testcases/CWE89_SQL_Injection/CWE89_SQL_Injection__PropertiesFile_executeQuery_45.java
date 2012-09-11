/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__PropertiesFile_executeQuery_45.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-45.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: PropertiesFile Read a value from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: executeQuery
 *    GoodSink: prepared sqlstatement, executeQuery
 *    BadSink : raw query used in executeQuery
 * Flow Variant: 45 Data flow: data passed as a private class member variable from one function to another in the same class
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE89_SQL_Injection__PropertiesFile_executeQuery_45 extends AbstractTestCase
{

    private String bad_data;
    private String goodG2B_data;
    private String goodB2G_data;

    private void bad_sink() throws Throwable
    {
        String data = bad_data;

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

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* retrieve the property */
        Properties props = new Properties();
        FileInputStream finstr = null;
        try {
            finstr = new FileInputStream("../common/config.properties");
            props.load(finstr);

            data = props.getProperty("data");
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( finstr != null )
                {
                    finstr.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
        }

        bad_data = data;
        bad_sink();
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    private void goodG2B_sink() throws Throwable
    {
        String data = goodG2B_data;

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

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        goodG2B_data = data;
        goodG2B_sink();
    }

    private void goodB2G_sink() throws Throwable
    {
        String data = goodB2G_data;

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

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* retrieve the property */
        Properties props = new Properties();
        FileInputStream finstr = null;
        try {
            finstr = new FileInputStream("../common/config.properties");
            props.load(finstr);

            data = props.getProperty("data");
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( finstr != null )
                {
                    finstr.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
        }

        goodB2G_data = data;
        goodB2G_sink();
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
