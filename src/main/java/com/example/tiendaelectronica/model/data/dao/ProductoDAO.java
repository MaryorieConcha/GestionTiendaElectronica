package com.example.tiendaelectronica.model.data.dao;

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

public class ProductoDAO {
    public static void agregarProducto(DSLContext query, Producto producto){
        Table tablaProducto = table(name("Producto"));
        Field[] columnas = tablaProducto.fields("nombre_producto","tipo","peso","precio");
        query.insertInto(tablaProducto, columnas[0], columnas[1],columnas[2],columnas[3])
                .values(producto.getNombre_producto(),producto.getTipo(),
                        producto.getPeso(),producto.getPrecio())
                .execute();
    }

    public static List obtenerProducto(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Producto")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaProductos(resultados);
    }

    private static List obtenerListaProductos(Result resultados){
        List<Producto> productos= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String nombre_producto = (String) resultados.getValue(fila,"nombre_producto");
            String tipo = (String) resultados.getValue(fila,"tipo");
            int peso = (int) resultados.getValue(fila,"peso");
            int precio = (int) resultados.getValue(fila,"precio");
            productos.add(new Producto(nombre_producto,tipo,peso,precio));
        }
        return productos;
    }

}
