package businessobjects;

public class StaticFactory {

    public static Flight createFlightfromAirportsAndDate(String departure, String destination, String date){
        Flight flight = new Flight();
        flight.setDeparture(departure);
        flight.setDestination(destination);
        flight.setDate(date);

        return flight;
    }

    public static Flight createFlightFromBudget(String budget){
        Flight flight = new Flight();
        flight.setBudget(budget);

        return flight;
    }

    public static Flight createFlightFromBookingData(String number, String lastname , String date){
        Flight flight = new Flight();
        flight.setBookingNumber(number);
        flight.setLastname(lastname);
        flight.setDate(date);

        return flight;
    }
}
