package com.faraorock.CarroDePrograma.Models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String placa;
    @Column(nullable = false)
    private String cor;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = true)
    private Date dataInicio;
    @Column(nullable = true)
    private Date dataFinal;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="mecanica_id", referencedColumnName="id")
    private MecanicaParceira mecanicasParceiras;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="filial_id", referencedColumnName="id")
    private Filial filial;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="contratante_id", referencedColumnName="id")
    private Contratante contratante;

    public Carro(Integer id, String placa, String cor, String modelo, String marca, Date dataInicio, Date dataFinal, MecanicaParceira mecanicasParceiras, Filial filial, Contratante contratante) {
        this.id = id;
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.marca = marca;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.mecanicasParceiras = mecanicasParceiras;
        this.filial = filial;
        this.contratante = contratante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public MecanicaParceira getMecanicasParceiras() {
        return mecanicasParceiras;
    }

    public void setMecanicasParceiras(MecanicaParceira mecanicasParceiras) {
        this.mecanicasParceiras = mecanicasParceiras;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public Contratante getContratante() {
        return contratante;
    }

    public void setContratante(Contratante contratante) {
        this.contratante = contratante;
    }
            
    
}
