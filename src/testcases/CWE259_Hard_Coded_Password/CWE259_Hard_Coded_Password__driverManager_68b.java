/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__driverManager_68b.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-68b.tmpl.java
*/
/*
 * @description
 * CWE: 259 Hard Coded Password
 * BadSource: hardcodedPassword Hardcoded password in String
 * GoodSource: Password is read from stdin
 * BadSink: driverManager password used in database connection
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

//!! other imports come from the label definitions

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

public class CWE259_Hard_Coded_Password__driverManager_68b
{

    public void bad_sink() throws Throwable
    {
        String data = CWE259_Hard_Coded_Password__driverManager_68a.data;

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

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink() throws Throwable
    {
        String data = CWE259_Hard_Coded_Password__driverManager_68a.data;

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
}
