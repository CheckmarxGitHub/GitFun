/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE566_Access_Through_SQL_Primary__Servlet_68b.java
Label Definition File: CWE566_Access_Through_SQL_Primary__Servlet.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 566 Access through SQL primary
 * BadSource:  user id taken from url parameter
 * GoodSource: hardcoded user id
 * Sinks: writeConsole
 *    GoodSink: user permissions checked
 *    BadSink : user authorization not checked
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE566_Access_Through_SQL_Primary;

import testcasesupport.*;

//!! other imports come from the label definitions

import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import java.security.*;

public class CWE566_Access_Through_SQL_Primary__Servlet_68b
{

    public void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE566_Access_Through_SQL_Primary__Servlet_68a.data;

        Connection conn2 = IO.getDBConnection();
        PreparedStatement statement = conn2.prepareStatement("select * from invoices where uid=?");
        int id = 0;
        try
        {
            id = Integer.parseInt(data);
        }
        catch( NumberFormatException nfx )
        {
            id = -1; /* Assuming this id does not exist */
        }
        statement.setInt(1, id);
        try
        {
            ResultSet rs = statement.executeQuery();

            /* FLAW: no check to see whether the user has privileges to view the data */
            IO.writeString("bad() - result requested: " + data +"\n");
        }
        catch( SQLException sx )
        {
            IO.writeLine("Error executing query()");
        }

        statement.close();
        conn2.close();

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE566_Access_Through_SQL_Primary__Servlet_68a.data;

        Connection conn2 = IO.getDBConnection();
        PreparedStatement statement = conn2.prepareStatement("select * from invoices where uid=?");
        int id = 0;
        try
        {
            id = Integer.parseInt(data);
        }
        catch( NumberFormatException nfx )
        {
            id = -1; /* Assuming this id does not exist */
        }
        statement.setInt(1, id);
        try
        {
            ResultSet rs = statement.executeQuery();

            /* FLAW: no check to see whether the user has privileges to view the data */
            IO.writeString("bad() - result requested: " + data +"\n");
        }
        catch( SQLException sx )
        {
            IO.writeLine("Error executing query()");
        }

        statement.close();
        conn2.close();

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data = CWE566_Access_Through_SQL_Primary__Servlet_68a.data;

        Connection conn2 = IO.getDBConnection();
        Permissions perms = new Permissions();
        /* setup permissions for all users */
        int allowed_invoices[] = new int[] {1, 2, 3, 10, 15, 100};

        int id = 0;
        try
        {
            id = Integer.parseInt(data);
        }
        catch( NumberFormatException nfx )
        {
            id = -1; /* Assuming this id does not exist */
        }

        try
        {
            boolean hasPriv = false;
            for( int i = 0; i < allowed_invoices.length; ++i )
            {
                if( allowed_invoices[i] == id )
                {
                    hasPriv = true;
                }
            }

            /* FIX: check to see whether the user has privileges to view the data */
            if( !hasPriv )
            {
                IO.writeString("good() - you are not privileged to see that invoice");
                return;
            }
            PreparedStatement statement = conn2.prepareStatement("select * from invoices where uid=?");
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            statement.close();
            conn2.close();
        }
        catch( SQLException sx )
        {
            IO.writeLine("Error executing query()");
            return;
        }

        IO.writeString("good() - result requested: " + data +"\n");

    }
}
