package io.servlet.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

@RestController
public class MemberController {

    @GetMapping("/home")
    public String home(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }

    @GetMapping("/info")
    public void handleRequest(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {

        // ServletWebRequest 생성
        ServletWebRequest webRequest = new ServletWebRequest(httpRequest, httpResponse);

        // 요청 헤더 가져오기
        String headerValue = webRequest.getHeader("User-Agent");

        // 요청 파라미터 가져오기
        String paramValue = webRequest.getParameter("name");

        // 네이티브 HttpServletRequest 활용
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String requestURI = request.getRequestURI();
        System.out.println("Native Request URI: " + requestURI);

        // 네이티브 HttpServletResponse 활용하여 응답 작성
        webRequest.getResponse().setStatus(HttpServletResponse.SC_OK);
        webRequest.getResponse().getWriter().write("successful");
    }

}
