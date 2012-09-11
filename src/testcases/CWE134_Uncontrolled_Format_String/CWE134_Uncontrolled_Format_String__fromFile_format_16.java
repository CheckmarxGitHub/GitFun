/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__fromFile_format_16.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 134 Uncontrolled Format String
* BadSource: fromFile Read data from file (named c:\data.txt)
* GoodSource: A hardcoded string
* Sinks: format
*    GoodSink: dynamic formatted stdout with string defined
*    BadSink : dynamic formatted stdout without validation
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE134_Uncontrolled_Format_String;

import testcasesupport.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE134_Uncontrolled_Format_String__fromFile_format_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;
        boolean local_f = false; /* This local variable is used becuase the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        while(true)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            File f = new File("C:\\data.txt");
            BufferedReader buffread = null;
            FileReader fread = null;
            try
            {
                /* read string from file into data */
                fread = new FileReader(f);
                buffread = new BufferedReader(fread);
                data = buffread.readLine(); // This will be reading the first "line" of the file, which
                // could be very long if there are little or no newlines in the file\
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
                        if( fread != null )
                        {
                            fread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing fread");
                    }
                }
            }
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: explicitly defined string formatting */
            System.out.format("%s\n", data);
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink by changing the conditions on the first and second while statements */
    private void goodG2B() throws Throwable
    {
        String data;
        boolean local_f = false;

        while(true)
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            File f = new File("C:\\data.txt");
            BufferedReader buffread = null;
            FileReader fread = null;
            try
            {
                /* read string from file into data */
                fread = new FileReader(f);
                buffread = new BufferedReader(fread);
                data = buffread.readLine(); // This will be reading the first "line" of the file, which
                // could be very long if there are little or no newlines in the file\
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
                        if( fread != null )
                        {
                            fread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing fread");
                    }
                }
            }
            break;
        }

        while(true)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: explicitly defined string formatting */
            System.out.format("%s\n", data);
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink by changing the conditions on the third and fourth while statements */
    private void goodB2G() throws Throwable
    {
        String data;
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        while(true)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            File f = new File("C:\\data.txt");
            BufferedReader buffread = null;
            FileReader fread = null;
            try
            {
                /* read string from file into data */
                fread = new FileReader(f);
                buffread = new BufferedReader(fread);
                data = buffread.readLine(); // This will be reading the first "line" of the file, which
                // could be very long if there are little or no newlines in the file\
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
                        if( fread != null )
                        {
                            fread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_bad.warning("Error closing fread");
                    }
                }
            }
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
            break;
        }

        while(true)
        {
            /* FIX: explicitly defined string formatting */
            System.out.format("%s\n", data);
            break;
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
