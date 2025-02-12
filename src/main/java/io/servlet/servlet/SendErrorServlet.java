package io.servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sendErrorServlet", urlPatterns = "/sendError")
public class SendErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 404 Not Found 에러를 보낸다.
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "해당 페이지를 찾을 수 없습니다.");
    }
}
