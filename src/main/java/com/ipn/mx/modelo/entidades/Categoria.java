/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
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
