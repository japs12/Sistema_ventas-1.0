/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhona
 */
public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Cliente buscar(String dni){
        Cliente c=new Cliente();
        String sql="select * from cliente where Dni="+dni;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return c;
    }
    
    //OPERACIONES CRUD
    public List listar() {
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEstado(rs.getString(5));
                lista.add(c);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Cliente c) {
        String sql = "insert into cliente(Dni,Nombres,Direccion,Estado)values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getDir());
            ps.setString(4, c.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public Cliente listarId(int id) {
        Cliente clt = new Cliente();
        String sql = "select * from cliente where IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                clt.setDni(rs.getString(2));
                clt.setNom(rs.getString(3));
                clt.setDir(rs.getString(4));
                clt.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return clt;
    }

    public int actualizar(Cliente c) {
        String sql = "update cliente set Dni=?,Nombres=?,Direccion=?,Estado=? where IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getDir());
            ps.setString(4, c.getEstado());
            ps.setInt(5, c.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public void delete(int id) {
        String sql = "delete from cliente where IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
