package sci_pass.tickets;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sci_pass.enums.NumDays;
import sci_pass.enums.TicketType;

import java.util.Date;

@Getter @Setter @ToString
public class NumDaysTicket extends Ticket{
    private Date lastVisitedDate;

    public NumDaysTicket(){}
    public NumDaysTicket(TicketType ticketType, NumDays numDays){
        setTicketType(ticketType);
        setValidity(numDays.getNumDays());
    }

    public boolean usage(){
        Date currentDateUsage = new Date();
        if (!isValid()){
            return false;
        }

        if ((lastVisitedDate == null) || (currentDateUsage.getTime() - lastVisitedDate.getTime() >= 24*60*60*1000)){
            setValidity(getValidity() - 1);
            lastVisitedDate = currentDateUsage;
        }
        return true;
    }
}
