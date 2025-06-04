/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author crist
 */
public class BrazilTaxService implements TaxService {
    
    public double tax(double amount){
        if(amount <= 100){
            return amount * 0.2;
        }else{
            return amount * 0.15;
        }
        
        
    }
}
