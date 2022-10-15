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


    
    /** Displays Rounds with groups and city.
     * @return void
     */
    public void display()
    {
        ArrayList<ArrayList<SoccerTeam>> teams= generateGroups(this.teamsList);
        int j=1;
        correctGroups(teams);
        System.out.println("teams lenght : "+ this.teamsList.size());
        System.out.println("rounds lenght : "+ teams.size());
        System.out.println(teams.get(0));

        for(ArrayList<SoccerTeam> round: teams)
        {
            System.out.println("#######################");
            System.out.println("Round  "+ (j)+" : ");

            for(int i=0;i<round.size()-1;i+=2)
            {
                System.out.print(round.get(i).getName());
                System.out.print(" vs ");
                System.out.print(round.get(i+1).getName());
                System.out.print(" In the City of "+round.get(i).getLocation()+"\n");
                
                
            }
            System.out.println();
            j++;
        }
    


    }

    /**
     * correctes generated groups 
     * @param teams
    */

    public void correctGroups(ArrayList<ArrayList<SoccerTeam>> teams)
    {
        for(int i=0;i<teams.size();i++)
        {
            
            for(int j=0;j<teams.get(i).size()-1;j+=2)
            {
                for(int k=j+2;k<teams.get(i).size()-1;k+=2)
                {
                    if(teams.get(i).get(j).getLocation()==teams.get(i).get(k).getLocation())
                    {
                       SoccerTeam tmp=teams.get(i).get(k);
                       teams.get(i).set(k, teams.get(i).get(k+1));
                       teams.get(i).set(k+1,tmp);
                        break;
                    }
                }

            }
        }
        

    }

   /**
    * 
    * 
    * 
    * @param year The year of the date
    */
    public void setYear(Date year) {
        this.year = year;
    }

    /**
     * 
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
    * @param teams
    * @return String
    */   
    public static ArrayList<ArrayList<SoccerTeam>> generateGroups(ArrayList<SoccerTeam> teams)
    {
        //recursive function
        if(teams.size()==2){
            ArrayList<ArrayList<SoccerTeam>> answer = new ArrayList<>();
            ArrayList<SoccerTeam> mn3rf1 = new ArrayList<>();
            mn3rf1.add(teams.get(0));
            mn3rf1.add(teams.get(1));
            ArrayList<SoccerTeam> mn3rf2 = new ArrayList<>();
            mn3rf2.add(teams.get(1));
            mn3rf2.add(teams.get(0));
            answer.add(mn3rf1);
            answer.add(mn3rf2);
            return answer;
        }
        ArrayList<SoccerTeam> le=new ArrayList<>();
        ArrayList<SoccerTeam> ri=new ArrayList<>();
        le.addAll(teams.subList( 0, teams.size()/2));
        ri.addAll(teams.subList(teams.size()/2, teams.size()));
        ArrayList<ArrayList<SoccerTeam>> left=generateGroups(le);//left recursive call
        ArrayList<ArrayList<SoccerTeam>> right=generateGroups(ri);//left recursive call
        ArrayList<ArrayList<SoccerTeam>> s=new ArrayList<>();//Combiner between left and right
        //generating the new generateGroups involving both sets
        for(int i=0;i<left.size();i++)
        {
            left.get(i).addAll(right.get(i));
        }
        s=left;
        ArrayList<SoccerTeam> s1=new ArrayList<>();
        ArrayList<SoccerTeam> s2=new ArrayList<>();
   
        for(int i=0;i<teams.size()/2;i++)
        {
            for(int j=0;j<teams.size()/2;j++)
            {
                SoccerTeam[] r1={teams.get(j),teams.get((i+j)%(teams.size()/2) + teams.size()/2)};
                s1.addAll(Arrays.asList(r1));
                SoccerTeam[] r2={teams.get((i+j)%(teams.size()/2)+teams.size()/2),teams.get(j)};
                s2.addAll(Arrays.asList(r2));
            }
            s.add(s1);
            s.add(s2);
            s1=new ArrayList<>();
            s2=new ArrayList<>();
        }
        return s;
    }
}


