/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infraestructura.Modelo;

import java.util.Date;

/**
 *
 * @author hp
 */
public class CuentaModelo {
    public int IdCuenta;
    public int IdCliente;
    public String TipoCuenta;
    public String Estado;
    public float Saldo;
    public String NroCuenta;
    public String NroContrato;
    public float CostoMantenimiento;
    public String PromedioAcreditacion;
    public String Moneda;
    public Date FechaAlta;
    

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getTipoCuenta() {
        return TipoCuenta;
    }

    public void setTipoCuenta(String TipoCuenta) {
        this.TipoCuenta = TipoCuenta;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }

    public String getNroCuenta() {
        return NroCuenta;
    }

    public void setNroCuenta(String NroCuenta) {
        this.NroCuenta = NroCuenta;
    }

    public String getNroContrato() {
        return NroContrato;
    }

    public void setNroContrato(String NroContrato) {
        this.NroContrato = NroContrato;
    }

    public float getCostoMantenimiento() {
        return CostoMantenimiento;
    }

    public void setCostoMantenimiento(float CostoMantenimiento) {
        this.CostoMantenimiento = CostoMantenimiento;
    }

    public String getPromedioAcreditacion() {
        return PromedioAcreditacion;
    }

    public void setPromedioAcreditacion(String PromedioAcreditacion) {
        this.PromedioAcreditacion = PromedioAcreditacion;
    }

    public String getMoneda() {
        return Moneda;
    }

    public void setMoneda(String Moneda) {
        this.Moneda = Moneda;
    }

    public Date getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(Date FechaAlta) {
        this.FechaAlta = FechaAlta;
    }
    
    
}
