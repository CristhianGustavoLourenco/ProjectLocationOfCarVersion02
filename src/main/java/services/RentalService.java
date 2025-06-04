/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.CarRental;
import entities.Invoice;
import java.time.Duration;

/**
 *
 * @author crist
 */
public class RentalService {
    
    private Double pricePerHour, pricePaerDay;
    private TaxService taxService;
    
    public RentalService(Double pricePerHour, Double pricePaerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePaerDay = pricePaerDay;
        this.taxService = taxService;
    }
    
    public void processInvoice(CarRental carRental){
     
        double minutos = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutos / 60.0;
        
        double basicPayment;
        if(hours <= 12.0){
            basicPayment = pricePerHour * Math.ceil(hours);
        }else{
            basicPayment = pricePaerDay * Math.ceil(hours/24.0);
        }
        
        double tax = taxService.tax(basicPayment);
        
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
