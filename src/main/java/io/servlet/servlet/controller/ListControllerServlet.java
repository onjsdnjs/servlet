package io.servlet.servlet.controller;

import io.servlet.servlet.model.Member;
import io.servlet.servlet.model.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "listController", urlPatterns = "/model2/list")
public class ListControllerServlet extends HttpServlet {

    private MemberRepository memberRepository = new MemberRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);

        String viewPath = "/WEB-INF/jsp/list.jsp";
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}