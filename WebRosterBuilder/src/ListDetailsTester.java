import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.TeamHelper;
import model.ListDetails;
import model.Player;
import model.Team;

public class ListDetailsTester {

	public static void main(String[] args) {
		
		Team nuggets = new Team("Nuggets");
		TeamHelper th = new TeamHelper();
		th.insertTeam(nuggets);
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		Player murray = new Player("Murray", "27", "G");
		Player jokic = new Player("Jokic", "15", "C");
		List<Player> nuggetsTest = new ArrayList<Player>();
		nuggetsTest.add(murray);
		nuggetsTest.add(jokic);
		
		ListDetails nuggetsTeam = new ListDetails("Team Nuggets",  "Michael Malone", nuggets);
		nuggetsTeam.setListOfPlayers(nuggetsTest);
		
		ldh.insertNewListDetails(nuggetsTeam);
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a : allLists) {
			System.out.println(a.toString());
		}

	}

}
