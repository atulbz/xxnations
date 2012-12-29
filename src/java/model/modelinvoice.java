/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Shaishav
 */
public class modelinvoice {

    int invoice_id,user_id;
    long invoice_number;
    float amount;
    public modelinvoice() {
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public long getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(long invoice_number) {
        this.invoice_number = invoice_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

 
    
    
    
    
}
