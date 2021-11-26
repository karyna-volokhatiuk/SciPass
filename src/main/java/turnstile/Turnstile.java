package turnstile;

import sci_pass.RegisterSystem;
import sci_pass.tickets.Ticket;

import java.util.Date;

public class Turnstile {
    private RegisterSystem registerSystem;

    public Turnstile(RegisterSystem registerSystem){
        this.registerSystem = registerSystem;
    }

    public boolean checkTicket(Ticket ticket){
        registerSystem.register("Ticket: " + ticket.toString());

        if (!ticket.isDayTypeValid(new Date())){
            registerSystem.register("DayType is incorrect.");
            registerSystem.blockSciPass(ticket);
            registerSystem.register("With this ticket entrance is blocked.");
            return false;
        }

        if (!ticket.usage()){
            registerSystem.register("Your ticket is not valid anymore.");
            registerSystem.blockSciPass(ticket);
            registerSystem.register("With this ticket entrance is blocked.");
            return false;
        }

        registerSystem.register("Have a nice lift.");
        return true;
    }
}
