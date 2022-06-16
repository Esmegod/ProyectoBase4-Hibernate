/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.entidades.Categoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 *
 * @author darkdestiny
 */
public class CategoriaDAO {
    /*
    private static final String SQL_INSERT="{call spInsertar( ?, ?)}";
    private static final String SQL_UPDATE="{call spActualizar (?, ? ,?)}";
    private static final String SQL_DELETE="{call spEliminar(?)}";
    private static final String SQL_READ="{call spSeleccionarUno(?)}";
    private static final String SQL_READ_ALL="{call spSeleccionarTodo()}";
 
    private Connection conexion;
    
     public Connection obtenerConexion() {
        //obtener conexion
        String usuario = "root";
        String clave = "n0m3l0";
        String url = "jdbc:mysql://localhost:3306/ProyectoBase4?serverTimezone=America/Mexico_City&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false";
        //String url = "jdbc:mysql://localhost:3306/EscuelaWeb?
        //serverTimeZone=America/Mexico_City&allowPublicKeyRetrieval=true&
        //useSSL=false";

        String driverBD = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driverBD);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
*/
   public void create(CategoriaDTO dto){
       Session s = HibernateUtil.getSessionFactory().getCurrentSession();
       Transaction t = s.getTransaction();
       try{
           t.begin();
           s.persist(dto.getEntidad());
           t.commit();
       }catch(HibernateException he){
           if(t!=null && t.isActive()){
               t.rollback();
           }
       }
   }   
   
   public List readAll(){
        Session session  = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        List resultados = new ArrayList();
        try{
            transaction.begin();
            Query q = session.createQuery("from Categoria", Categoria.class);
            resultados = q.list();
            transaction.commit();
        }catch(HibernateException he){
             if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
        }
        return resultados;
    }
   

   public void update(CategoriaDTO dto){
   
   }
   public void delete(CategoriaDTO dto){
   
   }
   private List obtenerResultados(ResultSet rs){
    
       return null;
    
    }
    public CategoriaDTO read(CategoriaDTO dto){
        
       return null;
        
    }
       
       /*obtenerConexion();
       CallableStatement cs = null;
       try{
           cs = conexion.prepareCall(SQL_INSERT);
           cs.setString(1, dto.getEntidad().getNombreCategoria());
           cs.setString(2, dto.getEntidad().getDescripcionCategoria());
           cs.executeUpdate();
       }finally{
           if (cs != null) cs.close();
           if (conexion != null) conexion.close();
       }*/
   /*
   
   
   public void update(CategoriaDTO dto) throws SQLException{
       obtenerConexion();
       CallableStatement cs = null;
       try{
           cs = conexion.prepareCall(SQL_UPDATE);
           cs.setInt(1, dto.getEntidad().getIdCategoria());
           cs.setString(2, dto.getEntidad().getNombreCategoria());
           cs.setString(3, dto.getEntidad().getDescripcionCategoria());
           cs.executeUpdate();
       }finally{
           if (cs != null) cs.close();
           if (conexion != null) conexion.close();
       }
   }
   
   public void delete(CategoriaDTO dto) throws SQLException{
       obtenerConexion();
       CallableStatement cs = null;
               
       try{
           cs = conexion.prepareCall(SQL_DELETE);
           cs.setInt(1, dto.getEntidad().getIdCategoria());
           cs.executeUpdate();
       }finally{
           if (cs != null) cs.close();
           if (conexion != null) conexion.close();
       }
   }
   public CategoriaDTO read(CategoriaDTO dto) throws SQLException{
       obtenerConexion();
       CallableStatement cs = null;
       ResultSet rs = null;
       try{
           cs = conexion.prepareCall(SQL_READ);
           cs.setInt(1, dto.getEntidad().getIdCategoria());
           rs = cs.executeQuery();
           List resultados = obtenerResultados(rs);
           if (resultados.size() > 0){
               return (CategoriaDTO) resultados.get(0);
           }else{
               return null;
           }
       }finally{
           if (cs != null) cs.close();
           if (conexion != null) conexion.close();
       }
   }
   public List readAll() throws SQLException{
       obtenerConexion();
       CallableStatement cs = null;
       ResultSet rs = null;
       try{
           cs = conexion.prepareCall(SQL_READ_ALL);
           rs = cs.executeQuery();
           List resultados = obtenerResultados(rs);
           if (resultados.size() > 0){
               return  resultados;
           }else{
               return null;
           }
       }finally{
           if (cs != null) cs.close();
           if (conexion != null) conexion.close();
       }
   }

    private List obtenerResultados(ResultSet rs) throws SQLException{
        List resultados = new ArrayList();
        while (rs.next()) {     
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
            dto.getEntidad().setNombreCategoria(rs.getString("nombreCategoria"));
            dto.getEntidad().setDescripcionCategoria(rs.getString("descripcionCategoria"));
            resultados.add(dto);
        }
        return resultados;
    }
    
    
    public static void main(String[] args) {
        CategoriaDAO dao = new CategoriaDAO();
        CategoriaDTO dto = new CategoriaDTO();
        //dto.getEntidad().setNombreCategoria("Línea Blanca");
        //dto.getEntidad().setDescripcionCategoria("Artículos de Línea Blanca");
        dto.getEntidad().setIdCategoria(3);
        try {
            //dao.create(dto);
            //dao.update(dto);
            System.out.println(dao.readAll());
            //System.out.println(dao.read(dto));
            //dao.delete(dto);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
*/

}
