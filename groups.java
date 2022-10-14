
import java.util.*;


class Solution {

    /*
     * Description:
     * Approach: Divide and conquer
     *
     */
    public static void main(String[] args)
    {
       
        ArrayList<String> students = new ArrayList<>();
        System.out.println("Enter number of students:");
        Scanner sncr= new Scanner(System.in);
        int n= sncr.nextInt();
        sncr.nextLine();
        String tmp;
        while(n>0)
        {
            tmp=sncr.nextLine();
            students.add(tmp);
            n--;

        }
        System.out.println(students);
        sncr.close();
        String[] answer=groups(students).split(",");
        for(int i=0;i<answer.length;i++)
        {
            System.out.println("Project "+(i+1)+": "+answer[i]);
        }



    }
    public static String groups(ArrayList<String> students)
    {
        //recursive function
        if(students.size()==2){return students.get(0)+students.get(1)+","+students.get(1)+students.get(0);}
        ArrayList<String> le=new ArrayList<>();
        ArrayList<String> ri=new ArrayList<>();
        le.addAll(students.subList( 0, students.size()/2));
        ri.addAll(students.subList(students.size()/2, students.size()));
        String left=groups(le);//left recursive call
        String right=groups(ri);//right recursive call
        String s="";
        String[] l= left.split(",");
        String[] r= right.split(",");
        //generating the new groups involving both sets
        for(int i=0;i<l.length;i++)
        {
            s+=l[i]+" "+r[i]+",";
        }
        String s1="";
        String s2="";
   
        for(int i=0;i<students.size()/2;i++)
        {
            for(int j=0;j<students.size()/2;j++)
            {
                s1+=students.get(j)+students.get((i+j)%(students.size()/2)+students.size()/2)+" ";
                s2+=students.get((i+j)%(students.size()/2)+students.size()/2)+students.get(j)+" ";
            }
            s+=s1+",";
            s+=s2+",";
            s1="";
            s2="";
        }
        return s;
    }
}
