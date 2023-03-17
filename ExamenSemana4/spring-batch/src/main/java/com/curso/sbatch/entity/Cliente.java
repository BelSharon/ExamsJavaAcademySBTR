package com.curso.sbatch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @Column(name = "CLIENTE_ID")
    private int id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "SEXO")
    private String sexo;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "PAIS")
    private String pais;
    @Column(name = "DIA_NACIMIENTO")
    private String diaNacimiento;
    
}
