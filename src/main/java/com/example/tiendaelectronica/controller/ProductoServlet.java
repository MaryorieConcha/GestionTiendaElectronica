package com.example.tiendaelectronica.controller;

import com.example.tiendaelectronica.model.Producto;
import com.example.tiendaelectronica.model.data.DBGenerator;
import com.example.tiendaelectronica.model.data.dao.ProductoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "productoServlet", value = "/producto")
public class ProductoServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("ProductoBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarArticulos.jsp");
        respuesta.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarArticulos.jsp");
        if (req.getParameter("nombre_producto").length()!=0 && req.getParameter("tipo").length()!=0 && req.getParameter("peso").length()!=0
                && req.getParameter("precio").length()!=0){
            String nombre = req.getParameter("nombre_producto");
            String tipo = req.getParameter("tipo");
            int peso = Integer.parseInt(req.getParameter("peso"));
            int precio = Integer.parseInt(req.getParameter("precio"));
            Producto producto = new Producto(nombre,tipo,peso,precio);
            try {
                if (agregarProducto(producto)){
                    req.setAttribute("producto",producto);
                    respuesta = req.getRequestDispatcher("/index.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }

    private boolean agregarProducto(Producto producto) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("ProductoBD");
        List<Producto> productos = ProductoDAO.obtenerProducto(query,"nombre_producto",producto.getNombre_producto());
        if (productos.size()!=0){
            return false;
        }
        else {
            ProductoDAO.agregarProducto(query,producto);
            return true;
        }
    }
}
