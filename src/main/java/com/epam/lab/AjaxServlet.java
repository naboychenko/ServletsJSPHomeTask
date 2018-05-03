package com.epam.lab;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class AjaxServlet extends HttpServlet {
  private String servletInnerState;

  private void sendResponse(HttpServletResponse response) throws IOException {

    JsonObject json = new JsonObject();
    json.add("servletInnerState", new Gson().toJsonTree(servletInnerState));

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json.toString());
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    servletInnerState = "GET";
    sendResponse(response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    servletInnerState = "POST";
    sendResponse(response);
  }

  @Override
  protected void doPut(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    servletInnerState = "PUT";
    sendResponse(response);
  }

  @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    servletInnerState = "DELETE";
    sendResponse(response);
  }
}
