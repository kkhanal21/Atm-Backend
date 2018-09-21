/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.bankingapp.entity;

/**
 *
 * @author kamal
 */
public class BillLoad {
    private int id;
    private AtmLoads atmLoad;
    private Bill bill;
    private int total;

    public BillLoad() {
    }

    public BillLoad(int id, AtmLoads atmLoad, Bill bill, int total) {
        this.id = id;
        this.atmLoad = atmLoad;
        this.bill = bill;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AtmLoads getAtmLoad() {
        return atmLoad;
    }

    public void setAtmLoad(AtmLoads atmLoad) {
        this.atmLoad = atmLoad;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
