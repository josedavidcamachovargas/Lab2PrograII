/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import SingletonPattern.ProcessingPurchasesList;
import SingletonPattern.DeliveredPurchasesList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.jca.GetInstance;


/**
 *
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class Test {
    
    public static DeliveredPurchasesList deliveredPurchasesList;
    public static ProcessingPurchasesList processingPurchasesList;
    
    public static void main(String[] args) {
        deliveredPurchasesList = new DeliveredPurchasesList();
        processingPurchasesList =  getInstance();
        Purchase purchase;
        for (int i = 0; i < 16; i++) {
            
            // El waitTime() lo utilizaré para que las fechas de cambio de estados no me quedaran tan seguidas
            waitTime();
            processingPurchasesList.addPurchase(generatePurchase());
        }
        
        // Prueba ProcessingPurchasesList purchasesByStatus
        
        System.out.println("Lista de compras actuales ordenada por estado: \n\n"
                         + processingPurchasesList.purchasesByStatus());
        
        // Prueba ProcessingPurchasesList purchasesByDate
        
        System.out.println("Lista de compras actuales ordenada por código: \n\n"
                         + processingPurchasesList.purchasesByCode());
        
        // Prueba ProcessingPurchasesList updateStatus
        
        processingPurchasesList.updateStatus(14);
        waitTime();
        processingPurchasesList.updateStatus(3);
        processingPurchasesList.updateStatus(3);
        waitTime();
        processingPurchasesList.updateStatus(15);
        processingPurchasesList.updateStatus(15);
        waitTime();
        processingPurchasesList.updateStatus(11);
        processingPurchasesList.updateStatus(11);
        
        System.out.println("Lista de compras actuales ordenada por estado: \n\n"
                         + processingPurchasesList.purchasesByStatus());
        
        processingPurchasesList.updateStatus(3);
        waitTime();
        processingPurchasesList.updateStatus(15);
        waitTime();
        processingPurchasesList.updateStatus(11);
        processingPurchasesList.updateStatus(11);
        waitTime();
        
        System.out.println("Lista de compras actuales ordenada por estado: \n\n"
                         + processingPurchasesList.purchasesByStatus());
        
        System.out.println("Lista de compras actuales ordenada por código: \n\n"
                         + processingPurchasesList.purchasesByCode());
        
        // Los siguientes consecutivos y el 11 ya alcanzaron el estado Entregado, por lo que pasan a deliveredPurchasesList
        // Así que realizamos la prueba del método purchasesByStatusDate()
        
        processingPurchasesList.updateStatus(3);
        waitTime();
        processingPurchasesList.updateStatus(15);
        waitTime();
        
        System.out.println("Lista de compras entregadas ordenada por fecha de estado: \n\n"
                         + deliveredPurchasesList.purchasesByStatusDate());
        
        // Prueba del caso de que se agrega un producto repetido, para ver el aumento de la cantidad de producto
        System.out.println("Prueba del caso de que se agrega un producto repetido\n\n");
        Purchase purchase1 = generatePurchase();
        Product product1 = generateProduct();
        int quantity1 = product1.getQuantity();
        
        product1.setCode("Frijoles");
        Product product2;
        product2 = product1;
        purchase1.addProduct(product1);
        purchase1.addProduct(product2);
        processingPurchasesList.addPurchase(purchase1);
        
        // Aquí uso el purchasesByCode para revisar los datos previos del producto repetido, y ver
        // si aumentó la cantidad al agregar el repetido
        System.out.println("Listas de compras: \n\n"
                         + processingPurchasesList.purchasesByCode());
        // Cantidad del producto original de la variable de más arriba
        System.out.println("Cantidad producto repetido:\n\n" + quantity1 + "\n\n");
        
        
        // Prueba eliminar
        
        
        
        purchase1.removeProduct("Frijoles");
        
        // Se imprime de nuevo para ver que ya no contiene el producto de código Frijoles
        
        System.out.println("Listas de compras: \n\n"
                         + processingPurchasesList.purchasesByCode());
        
        
        // Los demás métodos que no aparecen en el main, se encuentra dentro de los métodos imprimir
        // y los de creación de objetos random, como el generalWeight o el addPurchase,
        // por lo que se puede ver su implementación en la prueba de los métodos anteriores
    }
    
    private static Purchase generatePurchase() {
        Purchase purchase = new Purchase();
        for (int i = 0; i < 8; i++) {
            purchase.addProduct(generateProduct());
        }
        return purchase;
    }
    
    private static Product generateProduct() {
        return new Product(generateProductCode(), generateProductQuantity(), generateProductWeight());
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
