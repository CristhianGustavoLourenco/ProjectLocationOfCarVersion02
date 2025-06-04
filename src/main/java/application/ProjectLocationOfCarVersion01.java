/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package application;

import entities.CarRental;
import entities.Vehicle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;
import services.BrazilTaxService;
import services.RentalService;

/**
 *
 * @author crist
 */
public class ProjectLocationOfCarVersion01 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel: ");
        System.out.print("\nModelo do Carro: ");
        String carModel = scan.nextLine();
        System.out.print("\nRetirada(dd/MM/yyyy hh:mm): ");
        LocalDateTime checkStart = LocalDateTime.parse(scan.nextLine(), dtf);
        System.out.print("\nRetorno(dd/MM/yyyy hh:mm): ");
        LocalDateTime checkFinish = LocalDateTime.parse(scan.nextLine(), dtf);
        CarRental carRental = new CarRental(checkStart, checkFinish, new Vehicle(carModel));

        System.out.print("\nEntre com o preço por hora: ");
        Double pricePaymentHour = scan.nextDouble();
        System.out.print("\nEntre com o preço por dia: ");
        Double pricePaymentDay = scan.nextDouble();
        
        RentalService rentalService = new RentalService(pricePaymentHour, pricePaymentDay, new BrazilTaxService());
        
        rentalService.processInvoice(carRental);
        
        System.out.println("FATURA: " );
        System.out.println("Pagamento Basico: " + carRental.getInvoice().getBasicPayment());
        System.out.println("Imposto: " + carRental.getInvoice().getTax());
        System.out.println("Pagamento Total: " + carRental.getInvoice().getTotalPayment());

        scan.close();
    }
}
