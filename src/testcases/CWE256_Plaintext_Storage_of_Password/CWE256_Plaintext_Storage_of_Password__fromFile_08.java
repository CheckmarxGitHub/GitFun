/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE256_Plaintext_Storage_of_Password__fromFile_08.java
Label Definition File: CWE256_Plaintext_Storage_of_Password.label.xml
Template File: sources-sinks-08.tmpl.java
*/
/*
* @description
* CWE: 256 Plaintext Storage of a Password.  Read the password from a Properties file or a regular file.  In the good case, read the file from the console.
* BadSource: fromFile Read data from a file (named C:\data.txt)
* GoodSource: Read data from the console using readLine
* Sinks: basic
*    GoodSink: Use decrypted data as password to connect to DB
*    BadSink : Use data as password to connect to DB
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE256_Plaintext_Storage_of_Password;

import testcasesupport.*;

import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.sql.SQLException;

public class CWE256_Plaintext_Storage_of_Password__fromFile_08 extends AbstractTestCase
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

    public void bad() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            File f = new File("C:\\data.txt");
            BufferedReader buffread = null;
            FileReader fread = null;
            try
            {
                /* read string from file into data */
                char[] readIn = new char[(new Long(f.length())).intValue()];
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log_good = Logger.getLogger("local-logger");

            data = ""; /* init data */

            /* read user input from console with readLine*/
            BufferedReader buffread_g = null;
            InputStreamReader instrread = null;
            try {
                instrread = new InputStreamReader(System.in);
                buffread_g = new BufferedReader(instrread);
                data = buffread_g.readLine();
            }
            catch( IOException ioe )
            {
                log_good.warning("Error with stream reading");
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( buffread_g != null )
                    {
                        buffread_g.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_good.warning("Error closing buffread_g");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_good.warning("Error closing instrread");
                    }
                }
            }

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            /* POTENTIAL FLAW: direct retrieval of plaintext password */
            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", data);
            }
            catch(SQLException se)
            {
                log2.warning("error getting database connection");
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
                catch( SQLException se )
                {
                    log2.warning("error closing conn2");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

            InputStreamReader inread2 = null;
            BufferedReader bufread2 = null;
            Connection conn2 = null;

            try
            {
                /* Get encrypted password and decrypt it using key read from the console */
                /* Assume pw was encrypted using a secret passphrase and AES */
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String sKey = bufread2.readLine();
                SecretKeySpec key = new SecretKeySpec(sKey.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");

                cipher.init(Cipher.DECRYPT_MODE, key);

                /* FIX: password is stored encrypted */
                String pw = new String(cipher.doFinal(data.getBytes()));

                try
                {
                    conn2 = DriverManager.getConnection("192.168.105.23", "sa", pw);
                }
                catch(SQLException se)
                {
                    log2.warning("error getting database connection");
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
                    catch( SQLException se )
                    {
                        log2.warning("error closing conn2");
                    }
                }
            }
            catch( IOException e )
            {
                log2.warning("Error reading streams");
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
                    log2.warning("Error closing bufread2");
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
                        log2.warning("Error closing inread2");
                    }
                }
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_returns_t() to private_returns_f() */
    private void goodG2B1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_returns_f())
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
                char[] readIn = new char[(new Long(f.length())).intValue()];
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
        }
        else {

            Logger log_good = Logger.getLogger("local-logger");

            data = ""; /* init data */

            /* read user input from console with readLine*/
            BufferedReader buffread_g = null;
            InputStreamReader instrread = null;
            try {
                instrread = new InputStreamReader(System.in);
                buffread_g = new BufferedReader(instrread);
                data = buffread_g.readLine();
            }
            catch( IOException ioe )
            {
                log_good.warning("Error with stream reading");
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( buffread_g != null )
                    {
                        buffread_g.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_good.warning("Error closing buffread_g");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_good.warning("Error closing instrread");
                    }
                }
            }

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            /* POTENTIAL FLAW: direct retrieval of plaintext password */
            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", data);
            }
            catch(SQLException se)
            {
                log2.warning("error getting database connection");
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
                catch( SQLException se )
                {
                    log2.warning("error closing conn2");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

            InputStreamReader inread2 = null;
            BufferedReader bufread2 = null;
            Connection conn2 = null;

            try
            {
                /* Get encrypted password and decrypt it using key read from the console */
                /* Assume pw was encrypted using a secret passphrase and AES */
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String sKey = bufread2.readLine();
                SecretKeySpec key = new SecretKeySpec(sKey.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");

                cipher.init(Cipher.DECRYPT_MODE, key);

                /* FIX: password is stored encrypted */
                String pw = new String(cipher.doFinal(data.getBytes()));

                try
                {
                    conn2 = DriverManager.getConnection("192.168.105.23", "sa", pw);
                }
                catch(SQLException se)
                {
                    log2.warning("error getting database connection");
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
                    catch( SQLException se )
                    {
                        log2.warning("error closing conn2");
                    }
                }
            }
            catch( IOException e )
            {
                log2.warning("Error reading streams");
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
                    log2.warning("Error closing bufread2");
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
                        log2.warning("Error closing inread2");
                    }
                }
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log_good = Logger.getLogger("local-logger");
            data = ""; /* init data */
            /* read user input from console with readLine*/
            BufferedReader buffread_g = null;
            InputStreamReader instrread = null;
            try
            {
                instrread = new InputStreamReader(System.in);
                buffread_g = new BufferedReader(instrread);
                data = buffread_g.readLine();
            }
            catch( IOException ioe )
            {
                log_good.warning("Error with stream reading");
            }
            finally
            {
                /* clean up stream reading objects */
                try {
                    if( buffread_g != null )
                    {
                        buffread_g.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_good.warning("Error closing buffread_g");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_good.warning("Error closing instrread");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log_bad = Logger.getLogger("local-logger");

            data = ""; /* init data */

            File f = new File("C:\\data.txt");
            BufferedReader buffread = null;
            FileReader fread = null;
            try {
                /* read string from file into data */
                char[] readIn = new char[(new Long(f.length())).intValue()];
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
            finally {
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

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            /* POTENTIAL FLAW: direct retrieval of plaintext password */
            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", data);
            }
            catch(SQLException se)
            {
                log2.warning("error getting database connection");
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
                catch( SQLException se )
                {
                    log2.warning("error closing conn2");
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

            InputStreamReader inread2 = null;
            BufferedReader bufread2 = null;
            Connection conn2 = null;

            try
            {
                /* Get encrypted password and decrypt it using key read from the console */
                /* Assume pw was encrypted using a secret passphrase and AES */
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String sKey = bufread2.readLine();
                SecretKeySpec key = new SecretKeySpec(sKey.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");

                cipher.init(Cipher.DECRYPT_MODE, key);

                /* FIX: password is stored encrypted */
                String pw = new String(cipher.doFinal(data.getBytes()));

                try
                {
                    conn2 = DriverManager.getConnection("192.168.105.23", "sa", pw);
                }
                catch(SQLException se)
                {
                    log2.warning("error getting database connection");
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
                    catch( SQLException se )
                    {
                        log2.warning("error closing conn2");
                    }
                }
            }
            catch( IOException e )
            {
                log2.warning("Error reading streams");
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
                    log2.warning("Error closing bufread2");
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
                        log2.warning("Error closing inread2");
                    }
                }
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_returns_t() to private_returns_f() */
    private void goodB2G1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            File f = new File("C:\\data.txt");
            BufferedReader buffread = null;
            FileReader fread = null;
            try
            {
                /* read string from file into data */
                char[] readIn = new char[(new Long(f.length())).intValue()];
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log_good = Logger.getLogger("local-logger");

            data = ""; /* init data */

            /* read user input from console with readLine*/
            BufferedReader buffread_g = null;
            InputStreamReader instrread = null;
            try {
                instrread = new InputStreamReader(System.in);
                buffread_g = new BufferedReader(instrread);
                data = buffread_g.readLine();
            }
            catch( IOException ioe )
            {
                log_good.warning("Error with stream reading");
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( buffread_g != null )
                    {
                        buffread_g.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_good.warning("Error closing buffread_g");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_good.warning("Error closing instrread");
                    }
                }
            }

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            /* POTENTIAL FLAW: direct retrieval of plaintext password */
            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", data);
            }
            catch(SQLException se)
            {
                log2.warning("error getting database connection");
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
                catch( SQLException se )
                {
                    log2.warning("error closing conn2");
                }
            }
        }
        else {

            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

            InputStreamReader inread2 = null;
            BufferedReader bufread2 = null;
            Connection conn2 = null;

            try
            {
                /* Get encrypted password and decrypt it using key read from the console */
                /* Assume pw was encrypted using a secret passphrase and AES */
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String sKey = bufread2.readLine();
                SecretKeySpec key = new SecretKeySpec(sKey.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");

                cipher.init(Cipher.DECRYPT_MODE, key);

                /* FIX: password is stored encrypted */
                String pw = new String(cipher.doFinal(data.getBytes()));

                try
                {
                    conn2 = DriverManager.getConnection("192.168.105.23", "sa", pw);
                }
                catch(SQLException se)
                {
                    log2.warning("error getting database connection");
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
                    catch( SQLException se )
                    {
                        log2.warning("error closing conn2");
                    }
                }
            }
            catch( IOException e )
            {
                log2.warning("Error reading streams");
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
                    log2.warning("Error closing bufread2");
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
                        log2.warning("Error closing inread2");
                    }
                }
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            Logger log_bad = Logger.getLogger("local-logger");
            data = ""; /* init data */
            File f = new File("C:\\data.txt");
            BufferedReader buffread = null;
            FileReader fread = null;
            try
            {
                /* read string from file into data */
                char[] readIn = new char[(new Long(f.length())).intValue()];
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
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log_good = Logger.getLogger("local-logger");

            data = ""; /* init data */

            /* read user input from console with readLine*/
            BufferedReader buffread_g = null;
            InputStreamReader instrread = null;
            try {
                instrread = new InputStreamReader(System.in);
                buffread_g = new BufferedReader(instrread);
                data = buffread_g.readLine();
            }
            catch( IOException ioe )
            {
                log_good.warning("Error with stream reading");
            }
            finally {
                /* clean up stream reading objects */
                try {
                    if( buffread_g != null )
                    {
                        buffread_g.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_good.warning("Error closing buffread_g");
                }
                finally {
                    try {
                        if( instrread != null )
                        {
                            instrread.close();
                        }
                    }
                    catch( IOException ioe )
                    {
                        log_good.warning("Error closing instrread");
                    }
                }
            }

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            InputStreamReader inread2 = null;
            BufferedReader bufread2 = null;
            Connection conn2 = null;
            try
            {
                /* Get encrypted password and decrypt it using key read from the console */
                /* Assume pw was encrypted using a secret passphrase and AES */
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String sKey = bufread2.readLine();
                SecretKeySpec key = new SecretKeySpec(sKey.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");
                cipher.init(Cipher.DECRYPT_MODE, key);
                /* FIX: password is stored encrypted */
                String pw = new String(cipher.doFinal(data.getBytes()));
                try
                {
                    conn2 = DriverManager.getConnection("192.168.105.23", "sa", pw);
                }
                catch(SQLException se)
                {
                    log2.warning("error getting database connection");
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
                    catch( SQLException se )
                    {
                        log2.warning("error closing conn2");
                    }
                }
            }
            catch( IOException e )
            {
                log2.warning("Error reading streams");
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
                    log2.warning("Error closing bufread2");
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
                        log2.warning("Error closing inread2");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

            /* POTENTIAL FLAW: direct retrieval of plaintext password */
            Connection conn2 = null;
            try
            {
                conn2 = DriverManager.getConnection("192.168.105.23", "sa", data);
            }
            catch(SQLException se)
            {
                log2.warning("error getting database connection");
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
                catch( SQLException se )
                {
                    log2.warning("error closing conn2");
                }
            }

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
