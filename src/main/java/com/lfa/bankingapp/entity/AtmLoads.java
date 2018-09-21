/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.bankingapp.entity;

import java.util.Date;

/**
 *
 * @author kamal
 */
public class AtmLoads {

    private int id;
    private Atm atm;
    private Vendor vendor;
    private Date dipositedDate;
    private int dipositedAmount;

    public AtmLoads() {
    }

    public AtmLoads(int id) {
        this.id = id;
    }

    public AtmLoads(int id, Atm atm, Vendor vendor, int dipositedAmount) {
        this.id = id;
        this.atm = atm;
        this.vendor = vendor;
        this.dipositedAmount = dipositedAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Atm getAtm() {
        return atm;
    }

    public void setAtm(Atm atm) {
        this.atm = atm;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Date getDipositedDate() {
        return dipositedDate;
    }

    public void setDipositedDate(Date dipositedDate) {
        this.dipositedDate = dipositedDate;
    }

    public int getDipositedAmount() {
        return dipositedAmount;
    }

    public void setDipositedAmount(int dipositedAmount) {
        this.dipositedAmount = dipositedAmount;
    }

}
