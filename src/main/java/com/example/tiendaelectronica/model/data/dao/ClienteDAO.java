package com.example.tiendaelectronica.model.data.dao;

import com.example.tiendaelectronica.model.Cliente;
import com.example.tiendaelectronica.model.Producto;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class ClienteDAO {
    public static void agregarCliente(DSLContext query, Cliente cliente){
        Table tablaCliente = table(name("Cliente"));
        Field[] columnas = tablaCliente.fields("nombre_cliente","rut","mail");
        query.insertInto(tablaCliente, columnas[0], columnas[1],columnas[2])
                .values(cliente.getNombre_cliente(),cliente.getRut(),cliente.getMail())
                .execute();
    }

    public static List obtenerCliente(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Cliente")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaClientes(resultados);
    }

    private static List obtenerListaClientes(Result resultados){
        List<Cliente> clientes = new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String nombre_cliente = (String) resultados.getValue(fila,"nombre_cliente");
            String rut = (String) resultados.getValue(fila,"rut");
            String mail = (String) resultados.getValue(fila,"mail");
            clientes.add(new Cliente(nombre_cliente,rut,mail));
        }
        return clientes;
    }
}
