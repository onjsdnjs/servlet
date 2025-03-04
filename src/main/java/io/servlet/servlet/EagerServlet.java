package io.servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EagerServlet", urlPatterns = "/eager-servlet", loadOnStartup = 2)
public class EagerServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("🚀 EagerServlet 초기화됨! (서버 시작 시 실행)");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("EagerServlet 응답!");
    }
}