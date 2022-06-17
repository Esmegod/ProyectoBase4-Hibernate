/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;


@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria implements Serializable{
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="idCategoria")
    private int idCategoria;
    
    @Column(name="nombreCategoria", length=50, nullable=false)
    private String nombreCategoria;
    
    @Column(name="descripcionCategoria", length=50, nullable=false)
    private String descripcionCategoria;

    
}
