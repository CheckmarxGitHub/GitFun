/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE259_Hard_Coded_Password__passwordAuth_12.java
Label Definition File: CWE259_Hard_Coded_Password.label.xml
Template File: sources-sink-12.tmpl.java
*/
/*
* @description
* CWE: 259 Hard Coded Password
* BadSource: hardcodedPassword Hardcoded password in String
* GoodSource: Password is read from stdin
* BadSink: passwordAuth password used in PasswordAuthentication
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE259_Hard_Coded_Password;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.Properties;
import java.io.*;

import java.net.PasswordAuthentication;

public class CWE259_Hard_Coded_Password__passwordAuth_12 extends AbstractTestCase
{

    /* uses badsource and badsink - see how tools report flaws that don't always occur */
    public void bad() throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
            data = "pass";
        }
        else {

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

        }

        /* POTENTIAL FLAW: Hard-coded password */
        PasswordAuthentication pa = new PasswordAuthentication("user", data.toCharArray());

        IO.writeLine(pa.toString());

    }

    /* goodG2B() - use goodsource and badsink by changing the "if" so that
       both branches use the GoodSource */
    private void goodG2B() throws Throwable
    {
        String data;
        if(IO.static_returns_t_or_f())
        {
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
        }
        else {

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

        }

        /* POTENTIAL FLAW: Hard-coded password */
        PasswordAuthentication pa = new PasswordAuthentication("user", data.toCharArray());

        IO.writeLine(pa.toString());

    }

    public void good() throws Throwable
    {
        goodG2B();
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
