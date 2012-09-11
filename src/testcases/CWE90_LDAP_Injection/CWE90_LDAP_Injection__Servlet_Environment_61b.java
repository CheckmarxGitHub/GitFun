/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__Servlet_Environment_61b.java
Label Definition File: CWE90_LDAP_Injection__Servlet.label.xml
Template File: sources-sink-61b.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: Environment Read a string from an environment variable
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : unchecked data leads to LDAP injection
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
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

import java.util.logging.Logger;

public class CWE90_LDAP_Injection__Servlet_Environment_61b
{

    public String bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public String goodG2B_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        return data;
    }

}
