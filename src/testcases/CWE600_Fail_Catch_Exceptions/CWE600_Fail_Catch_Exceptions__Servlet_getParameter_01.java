/*
* @description A Servlet fails to catch all exceptions, 
* which may reveal sensitive debugging information.
*
* */

/* note on servlets - when a new Servlet is created, it must be listed in the web.xml
* file in order to run.  The easy way to do this is in Eclipse:
*   - right click on testcases in package explorer
*   - select New->Servlet
*   - Check the box that says use an existing Servlet class or JSP
*   - Click browse and select the new Servlet class you have created
*   - Click OK, Next, then Finish  
*   - You should now be able to test the servlet by clicking Run in eclipse  
*/

package testcases.CWE600_Fail_Catch_Exceptions;

import testcasesupport.*;
import java.io.IOException;
import javax.servlet.http.*;

public class CWE600_Fail_Catch_Exceptions__Servlet_getParameter_01 extends AbstractTestCaseServlet {

    private static final long serialVersionUID = 1L; /* needed since Servlets are serializable */

    public void bad(HttpServletRequest request, HttpServletResponse response)
    throws IOException 
    {
        
        String s = request.getParameter("num");
        if (s != null) 
        {
            /* FLAW: This could throw a NumberFormatException, but a compiler will not force
            * a coder to catch it or declare it to be thrown
            * Note: Uncaught exceptions will propagate to the application server.
            */
            try
            {
                int i = Integer.parseInt(s); 
                if (i > 0)
                {
                    response.getWriter().println("<br>bad(): positive");
                }
                else
                {
                    response.getWriter().println("<br>bad(): 0 or negative");
                }
            }
            catch( IOException ioe )
            {
                response.getWriter().println("<br>bad(): io problem");
            }
        }
    }

    private void good1(HttpServletRequest request, HttpServletResponse response) 
    throws IOException 
    {
        String s = request.getParameter("num");
        if (s != null) 
        {
            try 
            {
                int i = Integer.parseInt(s); 
                if (i > 0)
                {
                    response.getWriter().println("<br>good(): positive");
                }
                else
                {
                    response.getWriter().println("<br>good(): 0 or negative");
                }
            } 
            catch (NumberFormatException nfe) /* FIX: NumberFormatException is caught */
            {
                response.getWriter().println("<br>good(): number not entered");
            }
        }
    }
	
	public void good(HttpServletRequest request, HttpServletResponse response) throws IOException {
        good1(request, response);
    }
}
