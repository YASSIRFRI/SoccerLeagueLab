import java.util.ArrayList;
import java.text.ParseException;
import java.util.Arrays;




/**
 * Testing units class
 */
public class Test{
    public static void main(String args[]) throws ParseException
    {
        SoccerTeam wac = new SoccerTeam("Wydad AC","Casablanca","8/5/1934", 28L);
        SoccerTeam kacm = new SoccerTeam("Kawkab Marrakech","Marrakech","20/9/1947", 24L);
        SoccerTeam husa = new SoccerTeam("Hassania Union Sport Agadir","Agadir","22/12/1946", 30L);
        SoccerTeam mas = new SoccerTeam("Maghreb de Fez","Fez", "1/1/1946", 29L);
        SoccerTeam far = new SoccerTeam("AS FAR","Rabat","6/3/1958", 32L);
        SoccerTeam rca = new SoccerTeam("Raja CA","Casablanca","20/3/1949", 31L);
        SoccerTeam fus = new SoccerTeam("Fath Union Sport","Rabat","10/5/1946", 27L);
        SoccerTeam sccm = new SoccerTeam("Chabab Mohammedia","Mohammedia", "13/4/1976", 22L);
        SoccerTeam rbm = new SoccerTeam("Raja Beni Mellal","Beni Mellal","1/1/1956", 19L);
        SoccerTeam ock = new SoccerTeam("Olympique Club of Khouribga","Khouribga","1/1/1979", 31L);
        SoccerTeam uts = new SoccerTeam("Union Touarga Sportif","Rabat","1/1/1969", 28L);
        SoccerTeam mat = new SoccerTeam("Moghreb Atletico Tetouan","Tetouan","1/1/1922", 24L);
        SoccerTeam irt = new SoccerTeam("Ittihad Riadi Tanger","Tanger","1/1/1983", 30L);
        SoccerTeam ocs = new SoccerTeam("Olympic Club de Safi","Safi", "1/1/1918", 29L);
        
        ArrayList<SoccerTeam> teamsList = new ArrayList<>();
        SoccerTeam[] teams= {wac,kacm,husa,mas,far,rca,fus,sccm,rbm,ock,uts,mat,irt,ocs};
        teamsList.addAll(Arrays.asList(teams));

        SoccerLeague Botola_21  = new SoccerLeague("Botola Inwi","1/1/2021", "INWI", 14, teamsList);

        
        ArrayList<SoccerTeam> teamsList_ = new ArrayList<>(teamsList);

        SoccerLeague Botola_22  = new SoccerLeague("Botola Inwi","1/1/2022", "INWI", 16, teamsList_);

        SoccerTeam dhj = new SoccerTeam("Difaa Hassani EL Jadida","Jadida","1/1/1956", 32L);
        SoccerTeam mco = new SoccerTeam("Mouloudia Club d'Oujda","Oujda","1/5/1945", 31L);
        Botola_22.addTeam(mco);
        Botola_22.addTeam(dhj);

        SoccerLeague Botola_23  = new SoccerLeague("Botola Inwi","1/1/2023", "INWI", 16, new ArrayList<>(teamsList_));
        SoccerTeam rsb = new SoccerTeam("Renaissance Sportive de Berkane", "Berkane", "10/5/1938", 27L);
        SoccerTeam cayb = new SoccerTeam("Club Athletic Youssoufia Berrechid", "Berrechid", "1/4/1927", 22L);
        Botola_23.replaceTeam(fus, rsb);
        Botola_23.replaceTeam(dhj, cayb);
        /*
         * Display
        */
        //+Botola_21.display();
        //+Botola_22.display();
        //+Botola_23.display();


        RoundCalender c1 = new RoundCalender("1/1/2023", teamsList_);

        c1.display();
        System.out.println(c1.getGroups());


    }


        
}