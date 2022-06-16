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
    public static void main(String[] args) {
        CategoriaDAO dao = new CategoriaDAO();
        CategoriaDTO dto = new CategoriaDTO();
        dto.getEntidad().setIdCategoria(1234);
        dto.getEntidad().setNombreCategoria("Perfumería");
        dto.getEntidad().setDescripcionCategoria("En esta seccion hay perfumes");
        System.out.println("Se esta creando una categoria");
        dao.create(dto);
       
        System.out.println("Se creo una categoria");
    }
       
       
}
