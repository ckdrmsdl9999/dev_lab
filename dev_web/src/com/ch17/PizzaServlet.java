package com.ch17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PizzaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req
			        , HttpServletResponse res)
	throws ServletException, IOException
	{
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		out.print("<html>                                                                                 ");
		out.print(" <head>                                                                                ");
		out.print("  <title>Break Neck Pizza Delivery</title>                                             ");
		out.print(" </head>                                                                               ");
		out.print(" <body>                                                                                ");
		out.print("  <p><img src='../../images/breakneck-logo.gif' alt='Break Neck Pizza' /></p>          ");
		out.print("   <p>Enter your phone number:                                                         ");
		out.print("    <input type='text' size='14' name='tel' id='i_tel' onChange='getCustomerInfo();'/> ");
		out.print("   </p>                                                                                ");
		out.print("   <p>Type your order in here:</p>                                                     ");
		out.print(" <form id='if_pizza' method='get' action='orderPizza.jsp'>                             ");
		out.print(" 	<input type='hidden' name='h_tel' id='ih_tel'>                                    ");
		out.print("   <p><textarea name='order' id='i_order' rows='6' cols='50'></textarea></p>           ");
		out.print(" </form>                                                                               ");
		out.print("   <p>Your order will be delivered to:</p>                                             ");
		out.print("   <p><textarea name='address' id='i_address' rows='4' cols='50'></textarea></p>       ");
		out.print("   <p><input type='button' id='submit' value='Order Pizza' onClick='send()'/></p>      ");
		out.print(" </body>                                                                               ");
		out.print("</html>                                                                                ");



		
	}
}
