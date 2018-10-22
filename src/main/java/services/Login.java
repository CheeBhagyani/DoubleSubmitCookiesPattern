/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;
/**
 *
 * @author Chee Bhagyani
 */
public class Login extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }
    
     private static String generateCSRF(){
        String CsrfToken = null;
        byte[] bytes = new byte[16];
        try {
            SecureRandom secureRandom = SecureRandom.getInstanceStrong();
            secureRandom.nextBytes(bytes);
            CsrfToken = new String(Base64.getEncoder().encode(bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return CsrfToken;
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            Cookie[] cookies = req.getCookies();
            cookies[0].setPath("/");

            if (username.equals("user") && password.equals("user")) {
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                String csrfToken = generateCSRF();
                
                //cookie with csrf token - double submit
                Cookie c1 = new Cookie(cookies[0].getValue(), csrfToken);
                cookies[0].setValue(csrfToken);
                cookies[0].setPath("/");
                resp.addCookie(c1);
                
                //csrf token in request - double submit
                session.setAttribute("csrfToken", csrfToken);
                resp.sendRedirect("home.jsp");
            } else {
                resp.getWriter().println("Incorrect username/password");
            }
        }finally {
            resp.getWriter().close();
        }

    }
}
