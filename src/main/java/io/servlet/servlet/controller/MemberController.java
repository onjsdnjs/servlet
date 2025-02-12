package io.servlet.servlet.controller;

import io.servlet.servlet.model.Member;
import io.servlet.servlet.model.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/front-controller")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/new-form")
    public String showForm() {
        return "frontcontroller/form";
    }

    // 회원 저장
    @PostMapping("/members/save")
    public String saveMember(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Member member = new Member(username, password);
        memberRepository.save(member);

        model.addAttribute("member", member);

        return "frontcontroller/save-result";
    }

    // 회원 목록
    @GetMapping("/members/list")
    public String listMembers(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);

        return "frontcontroller/list";
    }
}