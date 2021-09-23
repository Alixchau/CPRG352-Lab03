/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alix
 */
public class AgeCalculatorServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //load up a JSP
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //retrieve the parameter coming from the POST request
        String ageinput = request.getParameter("current_age");
        
        //set attribute in the request object
        //the request object will be passed through to the JSP by the forward() method
        request.setAttribute("ageInput", ageinput);
        
        //Validation user input
        int nextbirthday = 0;
        
        try{
            //condition 1: age input can not be negative
            if(Integer.parseInt(ageinput)<0){
            request.setAttribute("message", "You must give your current age.");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
            }
            //condition 2: age input can not be non-numeric or null or other input that will cause exception
            nextbirthday = Integer.parseInt(ageinput) + 1;
            
        }catch(Exception e){
            request.setAttribute("message", "You must give your current age.");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        }
        
        request.setAttribute("message", "Your age next birthday will be " + nextbirthday);
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
        
    }

}
