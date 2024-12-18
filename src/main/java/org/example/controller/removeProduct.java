package org.example.controller;

import org.example.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.controller.addProduct.store;

@WebServlet("/delete")
public class removeProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        resp.setContentType("text/html");

        Product product = store.getProduct(name);
        if (product == null) {
            resp.getWriter().println("<h1> Product Not Found</h1>");
        }else {
            store.removeProduct(name);
            resp.getWriter().println("<h1>Product: " + name + " Deleted" + "</h1>");
        }
        resp.getWriter().println("<a href=\"index.html\">Back to Home</a>");

    }
}
