import java.util.List;

import controller.TeamHelper;
import model.Team;

public class RosterTester {

	public static void main(String[] args) {
		
		Team nuggets = new Team("Nuggets");
		TeamHelper th = new TeamHelper();
		
		th.insertTeam(nuggets);
		
		List<Team> allTeams = th.showAllTeams();
		for(Team a: allTeams) {
			System.out.println(a.toString());
		}
		
	}

}
