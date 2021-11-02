package com.ciklum.ciklumweb.servlet;

import com.ciklum.ciklumweb.dao.ProductDao;
import com.ciklum.ciklumweb.domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String PRODUCT = "/product.jsp";
    private static String PRODUCT_LIST = "/product_list.jsp";
    private ProductDao dao;

    public ProductServlet() {
        dao = new ProductDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int productId = Integer.parseInt(request.getParameter("id"));
            dao.deleteProduct(productId);
            forward = PRODUCT_LIST;
            request.setAttribute("products", dao.getAllProducts());
        } else if (action.equalsIgnoreCase("products")){
            forward = PRODUCT_LIST;
            request.setAttribute("products", dao.getAllProducts());
        } else {
            forward = PRODUCT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        product.setName(request.getParameter("name"));
        int price = Integer.parseInt(request.getParameter("price"));
        product.setPrice(price);
        product.setStatus(request.getParameter("status"));
        dao.addProduct(product);

        RequestDispatcher view = request.getRequestDispatcher(PRODUCT_LIST);
        request.setAttribute("products", dao.getAllProducts());
        view.forward(request, response);
    }


}
