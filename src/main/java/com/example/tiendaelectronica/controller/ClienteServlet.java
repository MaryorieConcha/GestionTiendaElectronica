package com.example.tiendaelectronica.controller;

import com.example.tiendaelectronica.model.Cliente;
import com.example.tiendaelectronica.model.data.DBGenerator;
import com.example.tiendaelectronica.model.data.dao.ClienteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "clienteServlet", value = "/cliente")
public class ClienteServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("ClientesBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarClientes.jsp");
        respuesta.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        RequestDispatcher respuesta = req.getRequestDispatcher("/agregarClientes.jsp");
        if (req.getParameter("nombre_cliente").length()!=0 && req.getParameter("rut").length()!=0 && req.getParameter("mail").length()!=0){
            String nombre = req.getParameter("nombre_cliente");
            String rut = req.getParameter("mail");
            String mail = req.getParameter("mail");
            Cliente cliente = new Cliente(nombre,rut,mail);
            try {
                if (agregarCliente(cliente)){
                    req.setAttribute("cliente",cliente);
                    respuesta = req.getRequestDispatcher("/index.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }

    private boolean agregarCliente(Cliente cliente) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("ClientesBD");
        List<Cliente> clientes = ClienteDAO.obtenerCliente(query,"nombre_cliente",cliente.getNombre_cliente());
        if (clientes.size()!=0){
            return false;
        }
        else {
            ClienteDAO.agregarCliente(query,cliente);
            return true;
        }
    }
}
