package sci_pass.tickets;

import java.util.Calendar;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import sci_pass.enums.TicketType;


@Getter @Setter
public abstract class Ticket {

    private int id;
    private int validity;
    private int numLifts;
    private TicketType ticketType;


    public Ticket(int validity, int numLifts){
        id = TicketIDGenerator.generateID();
        this.validity = validity;
        this.numLifts = numLifts;
    }
    public Ticket(){
        id = TicketIDGenerator.generateID();
    }

    public static class TicketIDGenerator {
        private static int counter = 0;

        public static int generateID(){
            counter++;
            return counter;
        }
    }

    public boolean isValid(){
        return validity > 0;
    }

    public boolean isDayTypeValid(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == calendar.SATURDAY || day == calendar.SUNDAY){
            if (ticketType == TicketType.WEEKENDS){
                return true;
            } else {
                return false;
            }
        } else {
            if (ticketType == TicketType.WEEKDAYS){
                return true;
            } else {
                return false;
            }
        }

    }

    public abstract boolean usage();

}

