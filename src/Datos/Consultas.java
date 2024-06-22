package Datos;

import Entidades.E_Empleado;
import Entidades.E_Productos;
import Entidades.E_Proveedor;
import Entidades.E_Usuario;
import Entidades.E_Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author JMendez
 */
public class Consultas {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Conexion conexion = new Conexion();

    public List<E_Usuario> ObtengoUsuario() {
        List<E_Usuario> listado = new LinkedList<>();
        try {
            con = conexion.OpenConexion();
            String query = " SELECT ID, Nombre, Apellido, Edad, Direccion, Telefono "
                    + " FROM PERSONAS ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                E_Usuario e = new E_Usuario();
                e.setId(quitaNulo(rs.getString("ID")));
                e.setNombre(quitaNulo(rs.getString("Nombre")));
                e.setApellido(quitaNulo(rs.getString("Apellido")));
                e.setEdad(rs.getInt("Edad"));
                e.setDireccion(quitaNulo(rs.getString("Direccion")));
                e.setTelefono(quitaNulo(rs.getString("Telefono")));
                listado.add(e);
            }

            for (int i = 0; i < listado.size(); i++) {
                E_Usuario get = listado.get(i);
                System.out.println("Lo que llevo en la lista:" + get.getId() + " " + get.getNombre());
            }
        } catch (SQLException e) {
            System.out.println("Error al Obtener los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
        return listado;
    }

    public void InsertoUsuario(String nombre, String apellido, String edad, String direccion, String telefono) {
        try {
            con = conexion.OpenConexion();
            String query = " INSERT INTO PERSONAS (NOMBRE, APELLIDO, EDAD, DIRECCION, TELEFONO) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, edad);
            ps.setString(4, direccion);
            ps.setString(5, telefono);
            ps.executeUpdate();
            System.out.println("Datos Insertados Correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
    }

    public void ActualizarUsuario(String nombre, String apellido, String nuevaEdad, String nuevaDireccion, String nuevoTelefono) {
        try {
            con = conexion.OpenConexion();
            String query = "UPDATE PERSONAS SET EDAD = ?, DIRECCION = ?, TELEFONO = ? WHERE NOMBRE = ? AND APELLIDO = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, nuevaEdad);
            ps.setString(2, nuevaDireccion);
            ps.setString(3, nuevoTelefono);
            ps.setString(4, nombre);
            ps.setString(5, apellido);
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Datos actualizados correctamente");
            } else {
                System.out.println("No se encontraron registros para actualizar");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
    }

    public boolean EliminarUsuario(String idUsuario) {
        boolean eliminado = false;
        try {
            con = conexion.OpenConexion();
            String query = "DELETE FROM PERSONAS WHERE ID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, idUsuario);
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Usuario eliminado correctamente");
                eliminado = true;
            } else {
                System.out.println("No se encontró un usuario con el ID proporcionado");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
        return eliminado;
    }

    public List<E_Proveedor> ObtengoProveedor() {
        List<E_Proveedor> listado = new LinkedList<>();
        try {
            con = conexion.OpenConexion();
            String query = " SELECT ID, NombreProveedores, NitProveedor, Telefono, Direccion, Estado"
                    + " FROM Proveedor ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                E_Proveedor e = new E_Proveedor();
                e.setId(quitaNulo(rs.getString("ID")));
                e.setNombre(quitaNulo(rs.getString("NombreProveedores")));
                e.setNitProveedor(quitaNulo(rs.getString("NitProveedor")));
                e.setTelefono(quitaNulo(rs.getString("Telefono")));
                e.setDireccion(quitaNulo(rs.getString("Direccion")));
                e.setEstado(quitaNulo(rs.getString("Estado")));
                listado.add(e);
            }
            for (int i = 0; i < listado.size(); i++) {
                E_Proveedor get = listado.get(i);
                System.out.println("Lo que llevo en la lista:" + get.getId() + " " + get.getNombre());
            }
        } catch (SQLException e) {
            System.out.println("Error al Obtener los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
        return listado;
    }

    public void InsertoProveedor(String nombre, String nit, String telefono, String direccion, String estado) {
        try {
            con = conexion.OpenConexion();
            String query = " INSERT INTO PROVEEDOR (NOMBREPROVEEDORES, NITPROVEEDOR, TELEFONO, DIRECCION, ESTADO) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, nit);
            ps.setString(3, telefono);
            ps.setString(4, direccion);
            ps.setString(5, estado);
            ps.executeUpdate();
            System.out.println("Datos Insertados Correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
    }

    public void ActualizarProveedor(String nombre, String nit, String telefono, String direccion, String estado) {
        try {
            con = conexion.OpenConexion();
            String query = "UPDATE PROVEEDOR SET TELEFONO = ?, DIRECCION = ?, ESTADO = ? WHERE NOMBREPROVEEDORES = ? AND NITPROVEEDOR = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, telefono);
            ps.setString(2, direccion);
            ps.setString(3, estado);
            ps.setString(4, nombre);
            ps.setString(5, nit);
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Datos actualizados correctamente");
            } else {
                System.out.println("No se encontraron registros para actualizar");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
    }

    public boolean EliminarProveedor(String idProveedor) {
        boolean eliminado = false;
        try {
            con = conexion.OpenConexion();
            String query = "DELETE FROM PROVEEDOR WHERE ID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, idProveedor);
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Proveedor eliminado correctamente");
                eliminado = true;
            } else {
                System.out.println("No se encontró un usuario con el ID proporcionado");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el Proveedor");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
        return eliminado;
    }

    public List<E_Productos> ObtengoProductos() {
        List<E_Productos> listado = new LinkedList<>();
        try {
            con = conexion.OpenConexion();
            String query = " SELECT ID, NombreProducto, Descripcion, Precio, Stock, Categoria"
                    + " FROM Productos ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                E_Productos e = new E_Productos();
                e.setId(quitaNulo(rs.getString("ID")));
                e.setNombre(quitaNulo(rs.getString("NombreProducto")));
                e.setDescripcion(quitaNulo(rs.getString("Descripcion")));
                e.setPrecio(quitaNulo(rs.getString("Precio")));
                e.setStock(quitaNulo(rs.getString("Stock")));
                e.setCategoria(quitaNulo(rs.getString("Categoria")));
                listado.add(e);
            }
            for (int i = 0; i < listado.size(); i++) {
                E_Productos get = listado.get(i);
                System.out.println("Lo que llevo en la lista:" + get.getId() + " " + get.getNombre());
            }
        } catch (SQLException e) {
            System.out.println("Error al Obtener los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
        return listado;
    }

    public void InsertoProducto(String nombre, String descripcion, String precio, String stock, String categoria) {
        try {
            con = conexion.OpenConexion();
            String query = " INSERT INTO Productos (NombreProducto, Descripcion, Precio, Stock, Categoria) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setString(3, precio);
            ps.setString(4, stock);
            ps.setString(5, categoria);
            ps.executeUpdate();
            System.out.println("Datos Insertados Correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
    }

    public void ActualizarProducto(String descripcion, String precio, String stock, String categoria, String nombre) {
        try {
            con = conexion.OpenConexion();
            String query = "UPDATE Productos SET Descripcion = ?, Precio = ?, Stock = ?, Categoria = ? WHERE NombreProducto = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, descripcion);
            ps.setString(2, precio);
            ps.setString(3, stock);
            ps.setString(4, categoria);
            ps.setString(5, nombre);
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Datos actualizados correctamente");
            } else {
                System.out.println("No se encontraron registros para actualizar");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
    }

    public boolean EliminarProducto(String idEmpleado) {
        boolean eliminado = false;
        try {
            con = conexion.OpenConexion();
            String query = "DELETE FROM Productos WHERE ID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, idEmpleado);
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Proveedor eliminado correctamente");
                eliminado = true;
            } else {
                System.out.println("No se encontró un usuario con el ID proporcionado");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el Proveedor");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
        return eliminado;
    }

    public List<E_Empleado> ObtengoEmpleado() {
        List<E_Empleado> listado = new LinkedList<>();
        try {
            con = conexion.OpenConexion();
            String query = " SELECT ID, NombreCompleto, Direccion, FechaNacimiento, FechaContratacion, Salario, Departamento"
                    + " FROM Empleados ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                E_Empleado e = new E_Empleado();
                e.setId(quitaNulo(rs.getString("ID")));
                e.setNombre(quitaNulo(rs.getString("NombreCompleto")));
                e.setDireccion(quitaNulo(rs.getString("Direccion")));
                e.setFechaNacimiento(quitaNulo(rs.getString("FechaNacimiento")));
                e.setFechaContratacion(quitaNulo(rs.getString("FechaContratacion")));
                e.setSalario(quitaNulo(rs.getString("Salario")));
                e.setDepartamento(quitaNulo(rs.getString("Departamento")));
                listado.add(e);
            }
            for (int i = 0; i < listado.size(); i++) {
                E_Empleado get = listado.get(i);
                System.out.println("Lo que llevo en la lista:" + get.getId() + " " + get.getNombre());
            }
        } catch (SQLException e) {
            System.out.println("Error al Obtener los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
        return listado;
    }

    public void InsertoEmpleado(String nombre, String direccion, String fechaContratacion, String fechaNacimiento, String salario, String departamento) {
        try {
            con = conexion.OpenConexion();
            String query = " INSERT INTO Empleados (NombreCompleto, Direccion, FechaNacimiento, FechaContratacion, Salario, Departamento) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, direccion);
            ps.setString(3, fechaNacimiento);
            ps.setString(4, fechaContratacion);
            ps.setString(5, salario);
            ps.setString(6, departamento);
            ps.executeUpdate();
            System.out.println("Datos Insertados Correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
    }

    public void ActualizarEmpleado(String direccion, String fContratacion, String salario, String departamento, String nombre, String fNacimiento) {
        try {
            con = conexion.OpenConexion();
            String query = "UPDATE Empleados SET Direccion = ?, FechaContratacion = ?, Salario = ?, Departamento = ? WHERE NombreCompleto = ? AND FechaNacimiento = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, direccion);
            ps.setString(2, fContratacion);
            ps.setString(3, salario);
            ps.setString(4, departamento);
            ps.setString(5, nombre);
            ps.setString(6, fNacimiento);
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Datos actualizados correctamente");
            } else {
                System.out.println("No se encontraron registros para actualizar");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
    }

    public boolean EliminarEmpleado(String idEmpleado) {
        boolean eliminado = false;
        try {
            con = conexion.OpenConexion();
            String query = "DELETE FROM Empleados WHERE ID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, idEmpleado);
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Proveedor eliminado correctamente");
                eliminado = true;
            } else {
                System.out.println("No se encontró un usuario con el ID proporcionado");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el Proveedor");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
        return eliminado;
    }

    public List<E_Ventas> ObtengoVenta() {
        List<E_Ventas> listado = new LinkedList<>();
        try {
            con = conexion.OpenConexion();
            String query = " SELECT ID, FechaVenta, IdEmpleado, IdProducto, CantidadVendida, PrecioUnitario, TotalVenta"
                    + " FROM Ventas ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                E_Ventas e = new E_Ventas();
                e.setId(quitaNulo(rs.getString("ID")));
                e.setFechaVenta(quitaNulo(rs.getString("FechaVenta")));
                e.setIdEmpleado(quitaNulo(rs.getString("IdEmpleado")));
                e.setIdProducto(quitaNulo(rs.getString("IdProducto")));
                e.setCantidadVendida(quitaNulo(rs.getString("CantidadVendida")));
                e.setPrecioUnitario(quitaNulo(rs.getString("PrecioUnitario")));
                e.setTotalVenta(quitaNulo(rs.getString("TotalVenta")));
                listado.add(e);
            }
            for (int i = 0; i < listado.size(); i++) {
                E_Ventas get = listado.get(i);
                System.out.println("Lo que llevo en la lista:" + get.getId() + " " + get.getIdEmpleado() + " " + get.getIdProducto());
            }
        } catch (SQLException e) {
            System.out.println("Error al Obtener los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
        return listado;
    }

    public void InsertoVenta(String fVenta, String idEmpleado, String idProducto, String cantidadVenta, String precio, String total) {
        try {
            con = conexion.OpenConexion();
            String query = " INSERT INTO Ventas (FechaVenta, IdEmpleado, IdProducto, CantidadVendida, PrecioUnitario, TotalVenta) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, fVenta);
            ps.setString(2, idEmpleado);
            ps.setString(3, idProducto);
            ps.setString(4, cantidadVenta);
            ps.setString(5, precio);
            ps.setString(6, total);
            ps.executeUpdate();
            System.out.println("Datos Insertados Correctamente");
        } catch (SQLException e) {
            System.out.println("Error al insertar los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
    }

    public void ActualizarVenta(String idEmpleado, String idProducto, String cantidadVenta, String precio, String total, String fVenta) {
        try {
            con = conexion.OpenConexion();
            String query = "UPDATE Ventas SET IdEmpleado = ?, IdProducto = ?, CantidadVendida = ?, PrecioUnitario = ?, TotalVenta = ? WHERE FechaVenta = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, idEmpleado);
            ps.setString(2, idProducto);
            ps.setString(3, cantidadVenta);
            ps.setString(4, precio);
            ps.setString(5, total);
            ps.setString(6, fVenta);
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Datos actualizados correctamente");
            } else {
                System.out.println("No se encontraron registros para actualizar");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
    }

    public boolean EliminarVenta(String idEmpleado) {
        boolean eliminado = false;
        try {
            con = conexion.OpenConexion();
            String query = "DELETE FROM Ventas WHERE ID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, idEmpleado);
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Proveedor eliminado correctamente");
                eliminado = true;
            } else {
                System.out.println("No se encontró un usuario con el ID proporcionado");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el Proveedor");
            e.printStackTrace();
        } finally {
            conexion.CloseConexion(rs, ps, con);
        }
        return eliminado;
    }

    public String quitaNulo(String var) {
        String res = "";
        if (var != null && var.trim().length() > 0) {
            res = var.trim();
        } else {
            res = "";
        }
        return res;
    }
}
