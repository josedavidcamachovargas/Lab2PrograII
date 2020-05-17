/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1.objects;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Esta clase se esncarga de un status el cual utiliza como atributos la clase
 * StatusEnum y el GregorianCalendar que sera utilizado para la fecha, aparte de 
 * los metodos basicos set y get, un toString que utiliza el calendario y un metodo
 * final que se encarga de actualizar el estado
 * @author Andrés Antonio Gonzalez Orozco B83477
 * @author José David Camacho Vargas B91484
 */
public class Status {
    
    // Attributes
    
    private StatusEnum status;
    private GregorianCalendar date;
    
    
    // Constructors

    public Status(GregorianCalendar date) {
        status = StatusEnum.PROCESS_WAITING;
        this.date = date;
    }
    
    
    // set's and get's

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
    
    
    // toString

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy - mm:ss:S");
        String dateString = formatter.format(date.getTime());
        return "Estado: " + status.getDescription() + ". Fecha = " + dateString + ".";
    }
    
    
    // Methods
    
    public boolean updateStatus() {
        switch (status) {
            case PROCESS_WAITING:
                status = StatusEnum.PROCESSING;
            break;
            case PROCESSING:
                status = StatusEnum.DISPATCH_WAITING;
            break;
            case DISPATCH_WAITING:
                status = StatusEnum.IN_TRANSIT;
            break;
            case IN_TRANSIT:
                status = StatusEnum.DELIVERED;
            break;
            default:
                return false;
        }
        return true;
    }
}
