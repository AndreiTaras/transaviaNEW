package businessobjects;

public class Flight {


    protected String departure;
    protected String destination;
    protected String date;
    protected String budget;
    protected String bookingNumber;
    protected String lastname;


    public Flight(){
    }

    public Flight(String departure , String destination, String date,String budget,String bookingNumber,String lastname){
        this.departure = departure;
        this.destination = destination;
        this.date = date;
        this.budget = budget;
        this.bookingNumber = bookingNumber;
        this.lastname = lastname;
    }
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                ", budget='" + budget + '\'' +
                ", bookingNumber='" + bookingNumber + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this)
            return true;

        if(obj.getClass() != this.getClass())
            return false;

        Flight flight = (Flight) obj;

        if(getDeparture() != null ?  !getDeparture().equals(flight.getDeparture()) : flight.getDeparture() != null)
            return false;

        if(getDestination() != null ?  !getDestination().equals(flight.getDestination()) : flight.getDestination() != null)
            return false;

        if(getDate() != null ? !getDate().equals(flight.getDate()) : flight.getDate() != null)
            return  false;

        if(getBudget() != null ? !getBudget().equals(flight.getBudget())  : flight.getBudget() != null)
            return false;

        if(getBookingNumber() != null ? !getBookingNumber().equals(flight.getBookingNumber())  : flight.getBookingNumber() != null)
            return false;

        return getLastname() != null ? getLastname().equals(flight.getLastname()) : flight.getLastname() == null;


    }


    @Override
    public int hashCode() {
        int number = 31;

        int result = number + (getDeparture() != null ? getDeparture().hashCode() : 0);
        result = number * result + (getDestination() != null ? getDestination().hashCode() : 0) + (getDate() != null ? getDate().hashCode() : 0) +
                (getBudget() != null ? getBudget().hashCode() : 0) + (getBookingNumber() != null ? getBookingNumber().hashCode() : 0) +
                (getLastname() != null ? getLastname().hashCode() : 0);

        return result;

    }



}
