package sci_pass;

import sci_pass.enums.NumDays;
import sci_pass.enums.NumLifts;
import sci_pass.enums.Season;
import sci_pass.enums.TicketType;
import sci_pass.tickets.NumDaysTicket;
import sci_pass.tickets.NumLiftsTicket;
import sci_pass.tickets.SeasonTicket;
import sci_pass.tickets.Ticket;

import java.util.ArrayList;

public class RegisterSystem {
    private static RegisterSystem registerSystem;
    private ArrayList<Ticket> tickets;
    private ArrayList<String> registers;

    private RegisterSystem(){
        tickets = new ArrayList<Ticket>();
        registers = new ArrayList<String>();
    }

    public static RegisterSystem getRegisterSystem(){
        if (registerSystem == null){
            registerSystem = new RegisterSystem();
        }
        return registerSystem;
    }

    public void blockSciPass(Ticket ticket){
        ticket.setValidity(0);
    }

    public NumDaysTicket giveTicket(TicketType ticketType, NumDays numDays) throws Exception {
        if ((ticketType == TicketType.WEEKENDS) && (numDays == NumDays.FIVE_DAYS)){
            throw new Exception("Weekends don't have 5 days...");
        }
        NumDaysTicket ticket = new NumDaysTicket(ticketType, numDays);
        tickets.add(ticket);
        return ticket;
    }

    public NumLiftsTicket giveTicket(TicketType ticketType, NumLifts numLifts){
        NumLiftsTicket ticket = new NumLiftsTicket(ticketType, numLifts);
        tickets.add(ticket);
        return ticket;
    }

    public SeasonTicket giveTicket(TicketType ticketType, Season season){
        SeasonTicket ticket = new SeasonTicket(ticketType, season);
        tickets.add(ticket);
        return ticket;
    }

    public void register(String str){
        registers.add(str);
    }
}
