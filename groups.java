
import java.util.*;


class Solution {

    /*
     * Description:
     * Approach: Divide and conquer
     *
     */
    public static void main(String[] args)
    {
       
        ArrayList<String> teams = new ArrayList<>();
        System.out.println("Enter number of teams:");
        Scanner sncr= new Scanner(System.in);
        int n= sncr.nextInt();
        sncr.nextLine();
        String tmp;
        while(n>0)
        {
            tmp=sncr.nextLine();
            teams.add(tmp);
            n--;

        }
        System.out.println(teams);
        sncr.close();


    }
    public static ArrayList<ArrayList<SoccerTeam>> generateGroups(ArrayList<SoccerTeam> teams)
    {
        //recursive function
        if(teams.size()==2){
            ArrayList<ArrayList<SoccerTeam>> answer = new ArrayList<>();
            ArrayList<SoccerTeam> mn3rf = new ArrayList<>();
            mn3rf.add(teams.get(0));
            mn3rf.add(teams.get(1));
            answer.add(mn3rf);
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
            s1.clear();
            s2.clear();;
        }
        return s;
    }
}
