/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__driverManager_01.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-01.tmpl.java
*/
/*
* @description
* CWE: 259 Hard Coded Password
* BadSource: hardcodedPassword Hardcoded password in String
* GoodSource: Password is read from stdin
* BadSink: driverManager password used in database connection
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

public class CWE259_Hard_Coded_Password__driverManager_01 extends AbstractTestCase
{

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String data;

        data = "pass";

        java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

        Connection conn2 = null;
        PreparedStatement st = null;
        ResultSet rs2 = null;
        String pw = data;
        try
        {
            /* POTENTIAL FLAW: use of hard-coded password */
            conn2 = DriverManager.getConnection("data-url", "root", pw);
            st = conn2.prepareStatement("select * from test_table");
            rs2 = st.executeQuery();
        }
        catch(SQLException e)
        {
            log2.warning("Error with database connection");
        }
        finally
        {
            try
            {
                if( rs2 != null )
                {
                    rs2.close();
                }
            }
            catch( SQLException e )
            {
                log2.warning("Error closing rs2");
            }
            finally
            {
                try
                {
                    if( st != null )
                    {
                        st.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing st");
                }
                finally
                {
                    try
                    {
                        if( conn2 != null )
                        {
                            conn2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn2");
                    }
                }
            }
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - uses goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        java.util.logging.Logger log_good_source = java.util.logging.Logger.getLogger("local-logger");

        BufferedReader bufread2 = null;
        InputStreamReader inread2 = null;

        Properties prop = new Properties();
        IO.writeLine("Enter the password: ");

        data = "";

        try
        {
            inread2 = new InputStreamReader(System.in);
            bufread2 = new BufferedReader(inread2);
            /* FIX: password is read from stdin */
            data = bufread2.readLine();
        }
        catch(Exception e)
        {
            log_good_source.warning("Exception in try");
        }
        finally
        {
            try
            {
                if( bufread2 != null )
                {
                    bufread2.close();
                }
            }
            catch( IOException e )
            {
                log_good_source.warning("Error closing bufread2");
            }
            finally
            {
                try
                {
                    if( inread2 != null )
                    {
                        inread2.close();
                    }
                }
                catch( IOException e )
                {
                    log_good_source.warning("Error closing inread2");
                }
            }
        }

        java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

        Connection conn2 = null;
        PreparedStatement st = null;
        ResultSet rs2 = null;
        String pw = data;
        try
        {
            /* POTENTIAL FLAW: use of hard-coded password */
            conn2 = DriverManager.getConnection("data-url", "root", pw);
            st = conn2.prepareStatement("select * from test_table");
            rs2 = st.executeQuery();
        }
        catch(SQLException e)
        {
            log2.warning("Error with database connection");
        }
        finally
        {
            try
            {
                if( rs2 != null )
                {
                    rs2.close();
                }
            }
            catch( SQLException e )
            {
                log2.warning("Error closing rs2");
            }
            finally
            {
                try
                {
                    if( st != null )
                    {
                        st.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing st");
                }
                finally
                {
                    try
                    {
                        if( conn2 != null )
                        {
                            conn2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn2");
                    }
                }
            }
        }

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

