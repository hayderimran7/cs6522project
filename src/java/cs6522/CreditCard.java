/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs6522;
import cs6522.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author imalik
 */
public class CreditCard extends HttpServlet {
 private String table = "credit";
 private String[] columns = { "ccid", "cnum", "ctype", "ccode" };
 	public void new_cc(String cartype, String carnum,String carcode, String uname) throws Exception {
                cs6522.dbconnector con = new dbconnector();
                cs6522.users user = new users();
                int cid = user.get_cid("'"+uname+"'", con.stmt);
		String[] temp = new String[] { String.valueOf(cid), "'"+carnum+"'",
				"'"+cartype+"'", "'"+carcode +"'"};
		util utils = new util();
		utils.new_table_row(temp, table, columns, con.stmt);
                
                
		
		

	}
   
  public void place_order(String uname) throws Exception {
                cs6522.dbconnector con = new dbconnector();
                String query;
                
                cs6522.users user = new users();
                int cid = user.get_cid("'"+uname+"'", con.stmt);
                query = "DELETE FROM orders WHERE cid=" + String.valueOf(cid);

		try {
			con.stmt.executeUpdate(query);
		} catch (Exception e) {
			System.err.println("Unable to execute query:" + query + "\n");
			System.err.println(e.getMessage());
			throw (e);
		}
                
                
		
		

	}
        
        
        
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException {
            
              response.setContentType("text/html;charset=UTF-8");
        
             
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            String cartype = request.getParameter("cartype");
            String carnum = request.getParameter("carnum");
            String carcode = request.getParameter("carcode");
  
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Credit card</title>");   
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();
            String userid = (String) session.getAttribute("userid");
            try {
                if (carnum != null && !carnum.isEmpty()) {
            new_cc(cartype,carnum,carcode,userid);
                }
                place_order(userid);
            }
catch (Exception e) {
			System.err.println("failed\n");
			System.err.println(e.getMessage());
		}

            out.println(cartype + carnum + carcode + "userid is " + userid);
            System.out.println(cartype + carnum + carcode + "userid is " + userid);
            out.println("</body>");
            out.println("</html>");
        
        }
        
    public void doPost(HttpServletRequest req,
            HttpServletResponse resp) throws IOException {
    	doGet(req,resp);
    }
    
}
