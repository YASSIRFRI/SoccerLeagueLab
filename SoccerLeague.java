import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SoccerLeague {
    private String name;
    private Date year;
    private String Sponsored;
    private int numberOfTeams;
    private ArrayList<SoccerTeam> teams= new ArrayList<>();

    /**
     * The default Constructor 
     */
    public SoccerLeague(){
    }

/**
 * Main Constructor
 * 
 * @param name String
 * @param year Date
 * @param Sponsore String
 * @param numteams int
 * @param teams Arraylist<SoccerTeam>
 * 
 * @exception IllegalArgumentException when number of teams is odd
 */
    public SoccerLeague(String name, String year, String Sponsore, int numteams, ArrayList<SoccerTeam> teams)
    throws ParseException {
      
        if(numteams%2==1){
            throw new IllegalArgumentException("number of tems has to be even number");

        }
        SimpleDateFormat sdt= new SimpleDateFormat("dd/mm/yyyy");
        Date date=sdt.parse(year);
        this.year=date;
        this.name=name;
        this.Sponsored=Sponsore;
        this.numberOfTeams=numteams;
        this.teams=teams;
        
    }
    
    /** 
     * @return String the name of the League
     */
    public String getName() {
        return name;
    }

    
    /** 
     * @return Date the year of the league
     */
    public Date getYear() {
        return year;
    }

    
    /** 
     * @return String the Sponsor of the league
     */
    public String getSponsored() {
        return Sponsored;
    }

    /**
     * This function returns the number of teams in the league
     * 
     * @return The number of teams.
     */
    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    /**
     * This function returns an ArrayList of SoccerTeam objects
     * 
     * @return The teams arraylist
     */
    public ArrayList<SoccerTeam> getTeams() {
        return teams;
    }

    
    
    /** Sets the name of the League
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** Sets the year of a the League
     * @param year
     */
    public void setYear(Date year) {
        this.year = year;
    }

    
    /** Sets the sponsore of the League
     * @param sponsored
     */

    public void setSponsored(String sponsored) {
        Sponsored = sponsored;
    }

    /**
     * sets the number of teams in the league
     * @param numberOfTeams
     */
    
    public void setNumberOfTeams(int numberOfTeams) {
        if(!(numberOfTeams%2==0)){
            throw new IllegalArgumentException("Number of  teams must be even.");
        }
        this.numberOfTeams = numberOfTeams;
    }

  /**
   * This function sets the teams variable to the teams parameter
   * 
   * @param teams An ArrayList of SoccerTeam objects.
   */
    public void setTeams(ArrayList<SoccerTeam> teams) {
        this.teams = teams;
    }
   /**
    * Display method for a League
     */ 
    @Override
    public String toString() {
        return "SoccerLeague [name=" + name + ", year=" + year + ", Sponsored=" + Sponsored + ", numberOfTeams="
                + numberOfTeams + ", teams=" + teams.toString()+  "]";
    }



    /**
    * Adds a team to the league
    * 
    * @param   team A team to be added to the league
    * 
    */
    public void addTeam(SoccerTeam team)
    {
        
        if(!SoccerTeam.class.isInstance(team))
        {
            throw new IllegalArgumentException("Team must be of type SoccerTeam.");

        }
        this.teams.add(team);
        this.numberOfTeams++;


    }
   
/**
 * This function replaces a team in the league with another team
 * 
 * @param team1 The team to be replaced.
 * @param team2 The team to replace team1 with.
 * @exception if team2 already exists or if team1 dosn't exist in the league.
 */

    public void replaceTeam(SoccerTeam team1, SoccerTeam team2)
    {
        if(!SoccerTeam.class.isInstance(team1)||!SoccerTeam.class.isInstance(team2))
        {
            throw new IllegalArgumentException("Team must be of type SoccerTeam.");

        }
        if(!this.teams.contains(team1))
        {
            throw new IllegalArgumentException(team1.getName()+" dosn't exist.", null);
        }
        if(this.teams.contains(team2)){
            throw new IllegalArgumentException(team2.getName()+" already exists in the League.", null);
        }
        else{
            for(int i=0;i<this.teams.size();i++)
            {
                if(this.teams.get(i)==team1){this.teams.set(i,team2);}
            }
        }
    }

    /**
     * This function removes a team from the league
     * 
     * @param team The team to be deleted
     */
    public void deleteTeam(SoccerTeam team)
    {
        if(!SoccerTeam.class.isInstance(team)){
            throw new IllegalArgumentException("Team must be of type SoccerTeam");
        }
        this.teams.remove(team);
        this.numberOfTeams--;
    }

    /**
     * This function displays the name, year, sponsored, number of teams, and the teams in the league
     */
    public void display(){
        System.out.println( "SoccerLeague [name=" + name + ", year=" + year + ", Sponsored=" + Sponsored + ", numberOfTeams="
                + numberOfTeams + ", teams=" + teams.toString()+  "]");

    }
    
}
