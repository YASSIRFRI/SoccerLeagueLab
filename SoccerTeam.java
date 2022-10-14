import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Soccer Team class.
 * A SoccerTeam has a name, location, yearCreated, and numberOfPlayers.
 * @methods getters/setters toString()
 */

public class SoccerTeam {
    private  String name;
    private String location;
    private Date yearCreated;
    private Long numberOfPlayers;

    public SoccerTeam() {
        //Default constructor
    };

   // A constructor that takes in 4 parameters and sets the values of the instance variables to the
   // values of the parameters.
    public SoccerTeam(String name,String location, String yearCreate, Long numberOfPlayers) throws ParseException
    {
        this.name=name;
        this.location=location;
        SimpleDateFormat sdt= new SimpleDateFormat("dd/mm/yyyy");
        Date date=sdt.parse(yearCreate);
        this.yearCreated=date;
        if(numberOfPlayers<18)
        {
            throw new IllegalArgumentException("Number of players shoud be greater than 18.", null);
        }
        this.numberOfPlayers=numberOfPlayers;

        
    }
    /**
     * returns location of the given soccer team
     * @return location of team
     */
    public String getLocation() {
        return location;
    }

    /**
     * returns the name of a given soccer team
     * 
     * @return name of the team
     */
    public String getName() {
        return name;
    }

    /**
     * returns number of players of the given soccer team
     * @return 
     *  
     */
    public Long getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     * This function sets the location of the user
     * 
     * @param location The location of the file.
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * This function sets the name of the object to the name passed in as a parameter
     * 
     * @param name The name of the parameter.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
        sets the number of players
     * @param numberOfPlayers long
     */
    public void setNumberOfPlayers(Long numberOfPlayers) {
        if(numberOfPlayers<18){
            throw new IllegalArgumentException("Number of players should be greater than 18.");
        }
        this.numberOfPlayers = numberOfPlayers;
    }

/**
 * This function sets the yearCreated variable to the yearCreated parameter
 * 
 * @param yearCreated The year the movie was created
 */
    public void setYearCreated(Date yearCreated) {
        this.yearCreated = yearCreated;
    }
    @Override
    public String toString()
    {

        return "Team Name : "+this.name+"\n"+"Number of players : "+this.numberOfPlayers+"\n"+
        "Year of Creation : "+ this.yearCreated+"\n"+"Location : "+this.location+"\n";
    }

    /**
     * This function displays the name, number of players, year of creation and location of the team
     */
    public void display()
    {
        System.out.println("Team Name : "+this.name+"\n"+"Number of players : "+this.numberOfPlayers+"\n"+
        "Year of Creation : "+ this.yearCreated+"\n"+"Location : "+this.location+"\n");
        
    }
}










