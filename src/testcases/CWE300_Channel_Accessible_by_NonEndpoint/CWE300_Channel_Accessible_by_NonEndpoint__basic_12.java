/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE300_Channel_Accessible_by_NonEndpoint__basic_12.java
Label Definition File: CWE300_Channel_Accessible_by_NonEndpoint__basic.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 300 Channel Accessible by Non-Endpoint
* Sinks:
*    GoodSink: encrypted channel
*    BadSink : unencrypted channel
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE300_Channel_Accessible_by_NonEndpoint;

import testcasesupport.*;

import java.net.*;
import java.io.*;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;

public class CWE300_Channel_Accessible_by_NonEndpoint__basic_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
            java.util.logging.Logger log_bs = java.util.logging.Logger.getLogger("local-logger");
            Socket sock = null;
            PrintWriter out = null;
            try
            {
                sock = new Socket("remote_host", 1337);
                out = new PrintWriter(sock.getOutputStream(), true);
                /* FLAW: sending over an unencrypted (non-SSL) channel */
                out.println("plaintext send");
            }
            catch(Exception ex)
            {
                IO.writeLine("Error writing to the socket");
            }
            finally
            {
                try
                {
                    if( out != null )
                    {
                        out.close();
                    }
                }
                catch(Exception e)
                {
                    log_bs.warning("Error closing out");
                }

                try
                {
                    if( sock != null )
                    {
                        sock.close();
                    }
                }
                catch(Exception e)
                {
                    log_bs.warning("Error closing sock");
                }
            }
        }
        else {

            java.util.logging.Logger log_gs = java.util.logging.Logger.getLogger("local-logger");

            OutputStream outStream = null;
            BufferedWriter bWriter = null;
            OutputStreamWriter outStreamWriter = null;
            SSLSocketFactory sslssocketfactory = null;
            SSLSocket sslsocket = null;
            try
            {
                sslssocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                sslsocket = (SSLSocket) sslssocketfactory.createSocket("remote_host", 1337);

                outStream = sslsocket.getOutputStream();
                outStreamWriter = new OutputStreamWriter(outStream);
                bWriter = new BufferedWriter(outStreamWriter);

                /* FIX: sending over an SSL encrypted channel */
                bWriter.write("encrypted send");
                bWriter.flush();
            }
            catch(Exception ex)
            {
                IO.writeLine("Error writing to the socket");
            }
            finally
            {
                try
                {
                    if( bWriter != null )
                    {
                        bWriter.close();
                    }
                }
                catch( IOException e )
                {
                    log_gs.warning("Error closing bWriter");
                }
                finally
                {
                    try
                    {
                        if( outStreamWriter != null )
                        {
                            outStreamWriter.close();
                        }
                    }
                    catch( IOException e )
                    {
                        log_gs.warning("Error closing outStreamWriter");
                    }
                }
                try
                {
                    if( sslsocket != null )
                    {
                        sslsocket.close();
                    }
                }
                catch(Exception e)
                {
                    log_gs.warning("Error closing sslsocket");
                }
            }

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            java.util.logging.Logger log_gs = java.util.logging.Logger.getLogger("local-logger");
            OutputStream outStream = null;
            BufferedWriter bWriter = null;
            OutputStreamWriter outStreamWriter = null;
            SSLSocketFactory sslssocketfactory = null;
            SSLSocket sslsocket = null;
            try
            {
                sslssocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                sslsocket = (SSLSocket) sslssocketfactory.createSocket("remote_host", 1337);
                outStream = sslsocket.getOutputStream();
                outStreamWriter = new OutputStreamWriter(outStream);
                bWriter = new BufferedWriter(outStreamWriter);
                /* FIX: sending over an SSL encrypted channel */
                bWriter.write("encrypted send");
                bWriter.flush();
            }
            catch(Exception ex)
            {
                IO.writeLine("Error writing to the socket");
            }
            finally
            {
                try
                {
                    if( bWriter != null )
                    {
                        bWriter.close();
                    }
                }
                catch( IOException e )
                {
                    log_gs.warning("Error closing bWriter");
                }
                finally
                {
                    try
                    {
                        if( outStreamWriter != null )
                        {
                            outStreamWriter.close();
                        }
                    }
                    catch( IOException e )
                    {
                        log_gs.warning("Error closing outStreamWriter");
                    }
                }
                try
                {
                    if( sslsocket != null )
                    {
                        sslsocket.close();
                    }
                }
                catch(Exception e)
                {
                    log_gs.warning("Error closing sslsocket");
                }
            }
        }
        else {

            java.util.logging.Logger log_gs = java.util.logging.Logger.getLogger("local-logger");

            OutputStream outStream = null;
            BufferedWriter bWriter = null;
            OutputStreamWriter outStreamWriter = null;
            SSLSocketFactory sslssocketfactory = null;
            SSLSocket sslsocket = null;
            try
            {
                sslssocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                sslsocket = (SSLSocket) sslssocketfactory.createSocket("remote_host", 1337);

                outStream = sslsocket.getOutputStream();
                outStreamWriter = new OutputStreamWriter(outStream);
                bWriter = new BufferedWriter(outStreamWriter);

                /* FIX: sending over an SSL encrypted channel */
                bWriter.write("encrypted send");
                bWriter.flush();
            }
            catch(Exception ex)
            {
                IO.writeLine("Error writing to the socket");
            }
            finally
            {
                try
                {
                    if( bWriter != null )
                    {
                        bWriter.close();
                    }
                }
                catch( IOException e )
                {
                    log_gs.warning("Error closing bWriter");
                }
                finally
                {
                    try
                    {
                        if( outStreamWriter != null )
                        {
                            outStreamWriter.close();
                        }
                    }
                    catch( IOException e )
                    {
                        log_gs.warning("Error closing outStreamWriter");
                    }
                }
                try
                {
                    if( sslsocket != null )
                    {
                        sslsocket.close();
                    }
                }
                catch(Exception e)
                {
                    log_gs.warning("Error closing sslsocket");
                }
            }

        }
    }

    public void good() throws Throwable
    {
        good1();
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
