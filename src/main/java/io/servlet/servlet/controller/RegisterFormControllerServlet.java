package io.servlet.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "registerFormController", urlPatterns = "/model2/registerForm")
public class RegisterFormControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 뷰(JSP)로 포워딩
        String viewPath = "/WEB-INF/jsp/model2/registerForm.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}
