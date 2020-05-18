/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.objects;

import ejercicio1.decoratorpattern.Additional;
import ejercicio1.decoratorpattern.FragileWrap;
import ejercicio1.decoratorpattern.GiftCard;
import ejercicio1.decoratorpattern.GiftWrap;
import ejercicio1.observerpattern.Client;
import ejercicio1.singletonpattern.ProcessingPurchasesList;
import ejercicio1.singletonpattern.DeliveredPurchasesList;
import ejercicio1.strategypattern.PlaneShipping;
import ejercicio1.strategypattern.ShipShipping;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase prueba del ejercicio.
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class Test {
    
    public static DeliveredPurchasesList deliveredPurchasesList;
    public static ProcessingPurchasesList processingPurchasesList;
    
    public static void main(String[] args) {
        deliveredPurchasesList = DeliveredPurchasesList.getInstance();
        processingPurchasesList = ProcessingPurchasesList.getInstance();
        Purchase purchase;
        for (int i = 0; i < 5; i++) {
            
            // El waitTime() lo utilizaré para que las fechas de cambio de estados no me quedaran tan seguidas
            waitTime();
            processingPurchasesList.addPurchase((Purchase)generatePurchase());
            
        }
        
        // Prueba ProcessingPurchasesList purchasesByStatus
        
        System.out.println("Lista de compras actuales ordenada por estado: \n\n"
                         + processingPurchasesList.purchasesByStatus());
        
        // Prueba ProcessingPurchasesList purchasesByDate
        
        System.out.println("Lista de compras actuales ordenada por código: \n\n"
                         + processingPurchasesList.purchasesByCode());
        
        // Prueba ProcessingPurchasesList updateStatus
        
        processingPurchasesList.updateStatus(2);
        waitTime();
        
        // Aquí podemos ver como se actualizan el cliente y el staff de la tienda
        System.out.println("-------------------------------------------");
        System.out.println("\n");
        System.out.println("Actualizacion cliente, staff, observer");
        System.out.println("\n");
        System.out.println("-------------------------------------------");
        processingPurchasesList.updateStatus(3);
        System.out.println(processingPurchasesList.getPurchase(3).getClient().showConsecutiveStatusList());
        
        processingPurchasesList.updateStatus(3);
        System.out.println("-------------------------------------------");
        System.out.println("\n");
        System.out.println("Actualizacion cliente, staff, observer");
        System.out.println("\n");
        System.out.println("-------------------------------------------");
        System.out.println(processingPurchasesList.getPurchase(3).getClient().showConsecutiveStatusList());
        
        
        System.out.println("-------------------------------------------");
        System.out.println("\n");
        System.out.println("Prueba decorator y strategy");
        System.out.println("\n");
        System.out.println("-------------------------------------------");
        
        Additional pruebaDecorator = processingPurchasesList.getPurchase(3);
        ((Purchase)pruebaDecorator).setShippingType(new PlaneShipping());
        System.out.println("Precio más envío por avión");
        System.out.println(pruebaDecorator.calculatePrice());
        ((Purchase)pruebaDecorator).setShippingType(new ShipShipping());
        System.out.println("Precio más envío por barco");
        System.out.println(pruebaDecorator.calculatePrice());
        pruebaDecorator = new GiftCard("Regalía XD", 50, pruebaDecorator);
        System.out.println("Precio más tarjeta de regalo");
        System.out.println(pruebaDecorator.calculatePrice());
        pruebaDecorator = new GiftWrap(pruebaDecorator);
        System.out.println("Precio más envoltura de regalo");
        System.out.println(pruebaDecorator.calculatePrice());
        pruebaDecorator = new FragileWrap(pruebaDecorator);
        System.out.println("Precio más envío por envoltura frágil");
        System.out.println(pruebaDecorator.calculatePrice());
        waitTime();
        processingPurchasesList.updateStatus(1);
        processingPurchasesList.updateStatus(1);
        waitTime();
        processingPurchasesList.updateStatus(4);
        processingPurchasesList.updateStatus(4);
        
        System.out.println("Lista de compras actuales ordenada por estado: \n\n"
                         + processingPurchasesList.purchasesByStatus());
        
        processingPurchasesList.updateStatus(1);
        waitTime();
        processingPurchasesList.updateStatus(1);
        waitTime();
        processingPurchasesList.updateStatus(4);
        processingPurchasesList.updateStatus(4);
        waitTime();
        
        System.out.println("Lista de compras actuales ordenada por estado: \n\n"
                         + processingPurchasesList.purchasesByStatus());
        
        System.out.println("Lista de compras actuales ordenada por código: \n\n"
                         + processingPurchasesList.purchasesByCode());
        
        // Los siguientes consecutivos y el 11 ya alcanzaron el estado Entregado, por lo que pasan a deliveredPurchasesList
        // Así que realizamos la prueba del método purchasesByStatusDate()
        
        processingPurchasesList.updateStatus(3);
        waitTime();
        processingPurchasesList.updateStatus(3);
        waitTime();
        
        System.out.println("Lista de compras entregadas ordenada por fecha de estado: \n\n"
                         + deliveredPurchasesList.purchasesByStatusDate());
        
        // Prueba del caso de que se agrega un producto repetido, para ver el aumento de la cantidad de producto
        System.out.println("Prueba del caso de que se agrega un producto repetido\n\n");
        Additional purchase1 = generatePurchase();
        Product product1 = generateProduct();
        int quantity1 = product1.getQuantity();
        
        product1.setCode("Frijoles");
        Product product2;
        product2 = product1;
        ((Purchase)purchase1).addProduct(product1);
        ((Purchase)purchase1).addProduct(product2);
        processingPurchasesList.addPurchase(((Purchase)purchase1));
        
        // Aquí uso el purchasesByCode para revisar los datos previos del producto repetido, y ver
        // si aumentó la cantidad al agregar el repetido
        System.out.println("Listas de compras: \n\n"
                         + processingPurchasesList.purchasesByCode());
        // Cantidad del producto original de la variable de más arriba
        System.out.println("Cantidad producto repetido:\n\n" + quantity1 + "\n\n");
        
        
        // Prueba eliminar
        
        
        
        ((Purchase)purchase1).removeProduct("Frijoles");
        
        // Se imprime de nuevo para ver que ya no contiene el producto de código Frijoles
        
        System.out.println("Listas de compras: \n\n"
                         + processingPurchasesList.purchasesByCode());
        
        
        // Los demás métodos que no aparecen en el main, se encuentra dentro de los métodos imprimir
        // y los de creación de objetos random, como el generalWeight o el addPurchase,
        // por lo que se puede ver su implementación en la prueba de los métodos anteriores
        
        
        
    }
    
    private static Additional generatePurchase() {
        Additional purchase = new Purchase();
        
        for (int i = 0; i < 4; i++) {
            ((Purchase)purchase).addProduct(generateProduct());
            
        }
        ((Purchase)purchase).setClient(generateClient());
        
        return purchase;
    }
    
    private static Product generateProduct() {
        return new Product(generateProductCode(), generateProductQuantity(), generateProductWeight());
    }
    
    private static Client generateClient() {
        return new Client(generateClientId(), generateClientEmail());
    }
    
    private static String generateClientId() {
        return randomInt(1, 7) + "-" + randomInt(0, 9) + "" + randomInt(0, 9)+ ""
             + randomInt(0, 9) + "-" + randomInt(0, 9) + "" + randomInt(0, 9) + "" + randomInt(0, 9);
    }
    
    private static String generateClientEmail() {
        return randomInt(1, 7) + "-" + randomInt(0, 9) + "" + randomInt(0, 9)+ "@gmail.com";
    }
    
    private static String generateProductCode() {
        return randomInt(0, 9) + "" + randomInt(0, 9)+ "" + randomInt(0, 9)+ ""
             + randomInt(0, 9)+ "" + randomInt(0, 9);
    }
    
    private static int generateProductQuantity() {
        return randomInt(1, 10);
    }
    
    private static double generateProductWeight() {
        return randomDouble(0, 50);
    }
    
    private static int randomInt(int first, int last) {
        return (int) (Math.random() * (last - first + 1) + first);
    }
    
    private static double randomDouble(int first, int last) {
        return Math.random() * (last - first + 1) + first;
    }
    
    private static void waitTime() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
