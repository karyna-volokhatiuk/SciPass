package sci_pass.tickets;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sci_pass.enums.NumLifts;
import sci_pass.enums.TicketType;

@Getter @Setter @ToString
public class NumLiftsTicket extends Ticket{
    public NumLiftsTicket(){}

    public NumLiftsTicket(TicketType ticketType, NumLifts numLifts){
        setTicketType(ticketType);
        setNumLifts(numLifts.getNumLifts());
    }

    public boolean usage(){
        if (!isValid()){
            return false;
        }

        setValidity(getValidity() - 1);
        return true;
    }
}
