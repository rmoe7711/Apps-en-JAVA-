/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.figuras;

/**
 *
 * @author USUARIO
 */
public class alumno extends persona {
    String grado;
     public alumno(String nombre, String edad, String grado){
         super(nombre, edad);
         this.grado=grado;
     }
     public String mostrar(){
         return super.mostrar()+"\n el grado es:  "+grado;
     }
    
}
