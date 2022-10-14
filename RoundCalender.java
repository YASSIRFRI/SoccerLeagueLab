import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class RoundCalender

{
    private Date year;
    private ArrayList<SoccerTeam>teamsList;
    private ArrayList<String> roundsList;

    public RoundCalender(String year, ArrayList<SoccerTeam> teamsList ) throws ParseException{
        SimpleDateFormat sdt= new SimpleDateFormat("dd/mm/yyyy");
        Date date=sdt.parse(year);
        this.year=date;
        this.teamsList=teamsList;
    }


    
    /** 
     * @return String
     */
    public String getGroups()
    {
    ArrayList<String> teams = new ArrayList<>();
    for(var SoccerTeam: this.teamsList)
    {
        teams.add(SoccerTeam.getName());
    }
    String groups=this.generategroups(teams);
    String[] rounds=groups.split(",");


    }
   /**
    * This function returns the year of the movie.
    * 
    * @return The year of the movie.
        return year;
    }

   /**
    * // Java
    * public void setYear(Date year) {
    *         this.year = year;
    *     }
    * 
    * @param year The year of the date
    */
    public void setYear(Date year) {
        this.year = year;
    }

    /**
     * // Java
     * public ArrayList<SoccerTeam> getTeamsList() {
     *         return teamsList;
     *     }
     * 
     * @return The teamsList ArrayList.
     */
    public ArrayList<SoccerTeam> getTeamsList() {
        return teamsList;
    }

  /**
   * This function sets the teamsList variable to the teamsList parameter
   * 
   * @param teamsList An ArrayList of SoccerTeam objects.
   */
    public void setTeamsList(ArrayList<SoccerTeam> teamsList) {
        this.teamsList = teamsList;
    }

    /**
     * This function returns an ArrayList of Strings
     * 
     * @return The roundsList arraylist.
     */
    public ArrayList<String> getRoundsList() {
        return roundsList;
    }

   /**
    * This function sets the roundsList variable to the roundsList parameter
    * 
    * @param roundsList ArrayList of Strings
    */
    public void setRoundsList(ArrayList<String> roundsList) {
        this.roundsList = roundsList;
    }
/**
 * The toString() method returns a string representation of the object
 * 
 * @return The toString() method is being returned.
 */
    @Override
    public String toString() {
        return "RoundCalender [year=" + year + ", teamsList=" + teamsList + ", roundsList=" + roundsList + "]";
    }


   /**
    *Display method 
    */
    public void display()
    {   
    System.out.println("RoundCalender [year=" + year + ", teamsList=" + teamsList + ", roundsList=" + roundsList + "]");
    }
   
   /** 
    * @param teams
    * @return String
    */
   public String generategroups(ArrayList<String> teams )
   {
        //recursive function
        if(teams.size()==2){return teams.get(0)+teams.get(1)+","+teams.get(1)+teams.get(0);}
        ArrayList<String> le=new ArrayList<>();
        ArrayList<String> ri=new ArrayList<>();
        le.addAll(teams.subList( 0, teams.size()/2));
        ri.addAll(teams.subList(teams.size()/2, teams.size()));
        String left=generategroups(le);//left recursive call
        String right=generategroups(ri);//right recursive call
        String s="";
        String[] l= left.split(",");
        String[] r= right.split(",");
        //generating the new generategroups involving both sets
        for(int i=0;i<l.length;i++)
        {
            s+=l[i]+" "+r[i]+",";
        }
        String s1="";
        String s2="";
   
        for(int i=0;i<teams.size()/2;i++)
        {
            for(int j=0;j<teams.size()/2;j++)
            {
                s1+=teams.get(j)+teams.get((i+j)%(teams.size()/2)+teams.size()/2)+" ";
                s2+=teams.get((i+j)%(teams.size()/2)+teams.size()/2)+teams.get(j)+" ";
            }
            s+=s1+",";
            s+=s2+",";
            s1="";
            s2="";
        }
        return s;
    }
}


