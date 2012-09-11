/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__Servlet_fromFile_53c.java
Label Definition File: CWE90_LDAP_Injection__Servlet.label.xml
Template File: sources-sink-53c.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: fromFile Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : unchecked data leads to LDAP injection
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
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

public class CWE90_LDAP_Injection__Servlet_fromFile_53c
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE90_LDAP_Injection__Servlet_fromFile_53d()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE90_LDAP_Injection__Servlet_fromFile_53d()).goodG2B_sink(data , request, response);
    }

}
