package sci_pass.tickets;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sci_pass.enums.Season;
import sci_pass.enums.TicketType;

import java.util.Calendar;

@Getter @Setter @ToString
public class SeasonTicket extends Ticket{
    private Season season;

    public SeasonTicket(){}

    public SeasonTicket(TicketType ticketType, Season season){
        setTicketType(ticketType);
        setSeason(season);
    }

    public boolean usage(){

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);

        if (Season.WINTER.getMonths().contains(month+1) && season == Season.WINTER){
            return true;
        }
        if (Season.SPRING.getMonths().contains(month+1) && season == Season.SPRING){
            return true;
        }
        if (Season.SUMMER.getMonths().contains(month+1) && season == Season.SUMMER){
            return true;
        }
        if (Season.AUTUMN.getMonths().contains(month+1) && season == Season.AUTUMN){
            return true;
        }

        return false;


    }


}
