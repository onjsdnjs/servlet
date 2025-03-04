package io.servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LazyServlet", urlPatterns = "/lazy-servlet")
public class LazyServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("🔥 LazyServlet 초기화됨! (첫 요청 시 실행)");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("LazyServlet 응답!");
    }
}
