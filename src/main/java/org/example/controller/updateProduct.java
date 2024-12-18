package org.example.controller;

import org.example.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.controller.addProduct.store;

@WebServlet("/update")
public class updateProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double newPrice = Double.parseDouble(req.getParameter("newprice"));
        resp.setContentType("text/html");
        resp.getWriter().println(name + " -- " + newPrice);

        Product product = store.getProduct(name);
        if (product == null) {
            resp.getWriter().println("<h1>Product Not Found</h1>");
        } else {
            store.updateProduct(name, newPrice);
            product = store.getProduct(name);
            resp.getWriter().println("<h1>Updated Product</h1>");
            resp.getWriter().println(product + "<br>");
        }
        resp.getWriter().println("<a href=\"index.html\">Back to Home</a>");
    }
}
