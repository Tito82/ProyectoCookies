/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ferna
 */
@WebServlet(urlPatterns = {"/CookiesServlet"})
public class CookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       boolean nuevoUsuario = true;
       
       Cookie[]cookies = request.getCookies();
       
       if (cookies != null){
           for (Cookie c : cookies){
               if(c.getName().equals("visitanteRecurrente")
                       && c.getValue().equals("si")){
                   nuevoUsuario = false;
                   break;    
               }
           }
       }
       String mensaje= null;
        if (nuevoUsuario) {
            
            Cookie visitanteCookie= new Cookie("visitanteRecurrente", "si");
            response.addCookie(visitanteCookie);
            mensaje = "gracias por visitar nuestro sitio";
        }else{
            mensaje = "gracias por visitar NUEVAMENTE nuestro sitio";
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("mensaje:" + mensaje);
       
    }

     

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
