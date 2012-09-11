/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__Servlet_getCookiesServlet_31.java
Label Definition File: CWE90_LDAP_Injection__Servlet.label.xml
Template File: sources-sink-31.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : unchecked data leads to LDAP injection
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

import javax.naming.*;
import javax.naming.directory.*;
import javax.servlet.http.*;

import java.util.Hashtable;
import java.io.IOException;

import org.apache.commons.lang.StringEscapeUtils;

import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE90_LDAP_Injection__Servlet_getCookiesServlet_31 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data_copy;
        {
            String data;

            Logger log_bad = Logger.getLogger("local-logger");

            /* read parameter from cookie */
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                data = cookieSources[0].getValue();
            }
            else
            {
                data = null;
            }

            data_copy = data;
        }
        {
            String data = data_copy;

            Hashtable<String, String> env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:389");
            DirContext ctx = new InitialDirContext(env);

            String search = "(cn=" + data + ")"; /* POTENTIAL FLAW: unsanitized data from untrusted source */

            NamingEnumeration<SearchResult> answer = ctx.search("", search, null);
            while (answer.hasMore())
            {
                SearchResult sr = answer.next();
                Attributes a = sr.getAttributes();
                NamingEnumeration<?> attrs = a.getAll();
                while (attrs.hasMore())
                {
                    Attribute attr = (Attribute) attrs.next();
                    NamingEnumeration<?> values = attr.getAll();
                    while(values.hasMore())
                    {
                        response.getWriter().println(" Value: " + values.next().toString());
                    }
                }
            }

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data_copy;
        {
            String data;

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

            data_copy = data;
        }
        {
            String data = data_copy;

            Hashtable<String, String> env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:389");
            DirContext ctx = new InitialDirContext(env);

            String search = "(cn=" + data + ")"; /* POTENTIAL FLAW: unsanitized data from untrusted source */

            NamingEnumeration<SearchResult> answer = ctx.search("", search, null);
            while (answer.hasMore())
            {
                SearchResult sr = answer.next();
                Attributes a = sr.getAttributes();
                NamingEnumeration<?> attrs = a.getAll();
                while (attrs.hasMore())
                {
                    Attribute attr = (Attribute) attrs.next();
                    NamingEnumeration<?> values = attr.getAll();
                    while(values.hasMore())
                    {
                        response.getWriter().println(" Value: " + values.next().toString());
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
