package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.Player;
import model.Team;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PlayerHelper ph = new PlayerHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String coachName = request.getParameter("coachName");
		String teamName = request.getParameter("teamName");
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<Player> selectedItemsInList = new ArrayList<Player>();
		if(selectedItems != null && selectedItems.length > 0) {
			for(int i = 0; i < selectedItems.length; ++i) {
				System.out.println(selectedItems[i]);
				Player p = ph.searchForPlayerById(Integer.parseInt(selectedItems[i]));
					selectedItemsInList.add(p);
			}
		}
		
		Team team = new Team(teamName);
		ListDetails pd = new ListDetails(listName, coachName, team);
		
		pd.setListOfPlayers(selectedItemsInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		slh.insertNewListDetails(pd);
		
		System.out.println("Success");
		System.out.println(pd.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
