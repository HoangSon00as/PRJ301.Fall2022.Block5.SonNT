/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author dell
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //get username, email, confirm email
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String confirm_email = req.getParameter("confirm");
        
        //validate
        boolean isPassed = true;
        
        //validate username
        if (username.matches("^[a-zA-Z0-9]{6,32}$")){
            resp.getWriter().println(username);            
        }else{
            resp.getWriter().println("Username is invalid (must be 6 to 32 character and not contain special character)!");
            isPassed = false;
        }
        
        //validate email
        if (email.matches("^\\S+@\\S+\\.\\S+$")){
            resp.getWriter().println(email);
        }else{
            resp.getWriter().println("Email is invalid");
            isPassed = false;
        }
        
        //validate confirm email
        if (confirm_email.matches("^\\S+@\\S+\\.\\S+$") && confirm_email.equals(email)){
            resp.getWriter().println(email);
        }else{
            resp.getWriter().println("Confirm email is invalid OR not equal to email");
            isPassed = false;
        }
        
        //print to screen if isPassed = true
        if (isPassed){
            resp.getWriter().println("Passed");
        }
        
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("index.html").forward(req, resp);
    }
    
}
