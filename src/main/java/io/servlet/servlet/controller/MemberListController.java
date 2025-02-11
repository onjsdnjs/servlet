package io.servlet.servlet.controller;

import io.servlet.servlet.model.Member;
import io.servlet.servlet.model.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class MemberListController implements Controller {

    private MemberRepository memberRepository = new MemberRepository();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);

        // 목록 화면 JSP로 forward
        return "/WEB-INF/views/list.jsp";
    }
}
