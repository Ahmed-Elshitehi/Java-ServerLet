package org.example.controller;

import org.example.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.controller.addProduct.store;

@WebServlet("/get")
public class getProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.setContentType("text/html");

        Product product = store.getProduct(name);
        String msg;
        if (product == null) {
            msg = "Product Not found";
        } else {
            msg = product.getName();
        }
        resp.getWriter().println("<h1>" + msg + "</h1>");
        resp.getWriter().println("<a href=\"index.html\">Back to Home</a>");

    }
}
