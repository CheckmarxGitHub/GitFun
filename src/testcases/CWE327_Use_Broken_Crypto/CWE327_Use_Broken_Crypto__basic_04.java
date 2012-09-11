/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE327_Use_Broken_Crypto__basic_04.java
Label Definition File: CWE327_Use_Broken_Crypto__basic.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 327 Use of Broken or Risky Cryptographic Algorithm
* Sinks:
*    GoodSink: use AES
*    BadSink : use DES
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE327_Use_Broken_Crypto;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CWE327_Use_Broken_Crypto__basic_04 extends AbstractTestCase
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad() throws Throwable
    {
        if (private_final_t)
        {
            java.util.logging.Logger log_bsnk = java.util.logging.Logger.getLogger("local-logger");
            IO.writeLine("Enter string for encryption: ");
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String str = bufread2.readLine();
                /* FLAW: Insecure cryptographic algorithm (DES) */
                Cipher des = Cipher.getInstance("DES");
                SecretKey key = KeyGenerator.getInstance("DES").generateKey();
                des.init(Cipher.ENCRYPT_MODE, key);
                byte[] enc_str = des.doFinal(str.getBytes());
                IO.writeLine(IO.toHex(enc_str));
            }
            catch(IOException e)
            {
                log_bsnk.warning("Error reading from console");
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
                    log_bsnk.warning("Error closing bufread2");
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
                        log_bsnk.warning("Error closing inread2");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_gsnk = java.util.logging.Logger.getLogger("local-logger");

            IO.writeLine("Enter string for encryption: ");

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String str = bufread2.readLine();

                /* FIX: Secure cryptographic algorithm (AES) */
                Cipher aes = Cipher.getInstance("AES");
                KeyGenerator kg = KeyGenerator.getInstance("AES");
                kg.init(128);
                SecretKey key = kg.generateKey();
                aes.init(Cipher.ENCRYPT_MODE, key);

                byte[] enc_str = aes.doFinal(str.getBytes());

                IO.writeLine(IO.toHex(enc_str));
            }
            catch(IOException e)
            {
                log_gsnk.warning("Error reading from console");
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
                    log_gsnk.warning("Error closing bufread2");
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
                        log_gsnk.warning("Error closing inread2");
                    }
                }
            }

        }
    }

    /* good1() changes private_final_t to private_final_f */
    private void good1() throws Throwable
    {
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_bsnk = java.util.logging.Logger.getLogger("local-logger");
            IO.writeLine("Enter string for encryption: ");
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String str = bufread2.readLine();
                /* FLAW: Insecure cryptographic algorithm (DES) */
                Cipher des = Cipher.getInstance("DES");
                SecretKey key = KeyGenerator.getInstance("DES").generateKey();
                des.init(Cipher.ENCRYPT_MODE, key);
                byte[] enc_str = des.doFinal(str.getBytes());
                IO.writeLine(IO.toHex(enc_str));
            }
            catch(IOException e)
            {
                log_bsnk.warning("Error reading from console");
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
                    log_bsnk.warning("Error closing bufread2");
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
                        log_bsnk.warning("Error closing inread2");
                    }
                }
            }
        }
        else {

            java.util.logging.Logger log_gsnk = java.util.logging.Logger.getLogger("local-logger");

            IO.writeLine("Enter string for encryption: ");

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String str = bufread2.readLine();

                /* FIX: Secure cryptographic algorithm (AES) */
                Cipher aes = Cipher.getInstance("AES");
                KeyGenerator kg = KeyGenerator.getInstance("AES");
                kg.init(128);
                SecretKey key = kg.generateKey();
                aes.init(Cipher.ENCRYPT_MODE, key);

                byte[] enc_str = aes.doFinal(str.getBytes());

                IO.writeLine(IO.toHex(enc_str));
            }
            catch(IOException e)
            {
                log_gsnk.warning("Error reading from console");
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
                    log_gsnk.warning("Error closing bufread2");
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
                        log_gsnk.warning("Error closing inread2");
                    }
                }
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_final_t)
        {
            java.util.logging.Logger log_gsnk = java.util.logging.Logger.getLogger("local-logger");
            IO.writeLine("Enter string for encryption: ");
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String str = bufread2.readLine();
                /* FIX: Secure cryptographic algorithm (AES) */
                Cipher aes = Cipher.getInstance("AES");
                KeyGenerator kg = KeyGenerator.getInstance("AES");
                kg.init(128);
                SecretKey key = kg.generateKey();
                aes.init(Cipher.ENCRYPT_MODE, key);
                byte[] enc_str = aes.doFinal(str.getBytes());
                IO.writeLine(IO.toHex(enc_str));
            }
            catch(IOException e)
            {
                log_gsnk.warning("Error reading from console");
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
                    log_gsnk.warning("Error closing bufread2");
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
                        log_gsnk.warning("Error closing inread2");
                    }
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_bsnk = java.util.logging.Logger.getLogger("local-logger");

            IO.writeLine("Enter string for encryption: ");

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String str = bufread2.readLine();

                /* FLAW: Insecure cryptographic algorithm (DES) */
                Cipher des = Cipher.getInstance("DES");
                SecretKey key = KeyGenerator.getInstance("DES").generateKey();
                des.init(Cipher.ENCRYPT_MODE, key);

                byte[] enc_str = des.doFinal(str.getBytes());

                IO.writeLine(IO.toHex(enc_str));
            }
            catch(IOException e)
            {
                log_bsnk.warning("Error reading from console");
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
                    log_bsnk.warning("Error closing bufread2");
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
                        log_bsnk.warning("Error closing inread2");
                    }
                }
            }

        }

    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
