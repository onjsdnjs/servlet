package io.servlet.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jsonResponse")
public class JsonResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // JSON 응답을 위해 Content-Type 설정
        response.setContentType("application/json;charset=UTF-8");

        // Jackson ObjectMapper 인스턴스 생성
        ObjectMapper objectMapper = new ObjectMapper();

        // 예시 데이터 준비(임의 생성)
        Message message = new Message("JSON Title", "Hello, JSON Response!", 123);

        // 자바 객체 -> JSON 문자열 변환
        String jsonString = objectMapper.writeValueAsString(message);

        // PrintWriter 로 응답 전송
        PrintWriter out = response.getWriter();
        out.print(jsonString);
        out.close();
    }

    public static class Message {
        private String title;
        private String content;
        private int count;

        // 기본 생성자
        public Message() {}

        // 필드를 모두 받는 생성자
        public Message(String title, String content, int count) {
            this.title = title;
            this.content = content;
            this.count = count;
        }

        // Getter/Setter 메서드
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }
        public void setContent(String content) {
            this.content = content;
        }

        public int getCount() {
            return count;
        }
        public void setCount(int count) {
            this.count = count;
        }
    }
}
