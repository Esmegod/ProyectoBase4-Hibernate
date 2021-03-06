/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import Utilerias.HibernateUtil;
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

/**
 *
 * @author darkdestiny
 */

public class CategoriaDAO {
    private Connection conexion;
    public Connection obtenerConexion() {
        //obtener conexion
        String usuario = "nqbwexzkhkyokp";
        String clave = "44e6c9fed0157519e329b0f2449647e087be9004d2fdcdc99a185d390cebe97a";
        String url = "jdbc:postgresql://ec2-34-225-159-178.compute-1.amazonaws.com:5432/dcllhv8me3p40t";
        

        String driverBD = "org.postgresql.Driver";

        try {
            Class.forName(driverBD);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
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
   
   public void update(int idCategoria, Categoria c){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            c.setIdCategoria(idCategoria);
            session.merge(c);
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            he.printStackTrace();
            System.out.println("Error: " + he.getMessage());
        }
    }
   
    public Categoria read(int idCategoria){
        String query = "From Categoria c Where c.idCategoria= :idCategoria";
        Categoria categoria = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Query q = session.createQuery(query, Categoria.class);
            q.setParameter("idCategoria", idCategoria);
            categoria = (Categoria) q.uniqueResult();
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
        return categoria;
    }
    
    public void delete(int idCategoria){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Categoria c = (Categoria) session.find(Categoria.class, idCategoria);
            session.remove(c);
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            he.printStackTrace();
            System.out.println("Error: " + he.getMessage());
        }
    }
    
    public static void main(String[] args) {
        CategoriaDAO dao = new CategoriaDAO();
        System.out.println(dao.readAll());
       
    }
       
}
