package org.example.controller;

import org.example.model.Product;
import org.example.model.Store;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class addProduct extends HttpServlet {
    static Store store = new Store();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        response.setContentType("text/html");
        store.addProduct(name, price);
        Product product = store.getProduct("name");
        response.getWriter().println("<h1>Added Product</h1>");
        response.getWriter().println(product + "<br>");
        response.getWriter().println("<a href=\"index.html\">Back to Home</a>");
    }
}
