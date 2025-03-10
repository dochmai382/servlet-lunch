package org.example.ex10.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ex10.model.APIParam;
import org.example.ex10.service.APIService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(name = "APIServlet", value = "/api")
public class APIController extends HttpServlet {
    // 의존성 주입, 싱글턴 패턴을 기반으로 한
    final APIService apiService = APIService.getInstance();
    final Logger logger = Logger.getLogger(APIController.class.getName());

    @Override
    public void init() throws ServletException {
        logger.info("APIController init..");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // ?prompt=점메추
        String prompt = req.getParameter("prompt");
        String model = req.getParameter("model");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        APIParam apiParam = new APIParam(prompt, model);
        out.println(apiService.callAPI(apiParam));
    }
}
