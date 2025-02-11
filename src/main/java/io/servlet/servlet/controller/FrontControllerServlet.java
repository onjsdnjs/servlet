package io.servlet.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServlet", urlPatterns = "/front-controller/*")
public class FrontControllerServlet extends HttpServlet {

    // 요청 URL -> Controller 매핑정보
    private Map<String, Controller> controllerMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        // 매핑 등록
        controllerMap.put("/front-controller/members/new-form", new MemberFormController());
        controllerMap.put("/front-controller/members/save", new MemberSaveController());
        controllerMap.put("/front-controller/members/list", new MemberListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        Controller controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 해당 컨트롤러(핸들러) 실행
        String viewPath = controller.process(request, response);

        // 단순 forward 처리 (redirect가 필요한 경우는 return 값에 "redirect:" prefix 등을 붙이는 등 별도 로직 가능)
        request.getRequestDispatcher(viewPath).forward(request, response);
    }
}