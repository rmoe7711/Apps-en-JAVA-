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
public class persona {
     String nombre; 
    String edad;
    
    public persona(String nombre, String edad){
    this.nombre=nombre;
    this.edad=edad;
}
    public String mostrar(){
       return "\nEl nombre es:  "+nombre+"\n La edad es:  "+edad; 
    }
    
}
