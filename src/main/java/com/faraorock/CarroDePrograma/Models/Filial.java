package com.faraorock.CarroDePrograma.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Filial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private int cep;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="filial")
    private List<Carro> carros;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
    		name = "filiais_mecanicas",
    		joinColumns = @JoinColumn(name="filial_id", referencedColumnName ="id"),
    		inverseJoinColumns = @JoinColumn(name="mecanica_id", referencedColumnName ="id")
    )
    private List<MecanicaParceira> mecanicasParceiras;

    public Filial(Integer id, int cep, String cidade, String estado, List<Carro> carros, List<MecanicaParceira> mecanicasParceiras) {
        this.id = id;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.carros = carros;
        this.mecanicasParceiras = mecanicasParceiras;
    }

    public Filial() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public List<MecanicaParceira> getMecanicasParceiras() {
        return mecanicasParceiras;
    }

    public void setMecanicasParceiras(List<MecanicaParceira> mecanicasParceiras) {
        this.mecanicasParceiras = mecanicasParceiras;
    }

    
}
