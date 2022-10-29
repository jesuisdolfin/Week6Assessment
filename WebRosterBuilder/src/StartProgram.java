

import java.util.List;
import java.util.Scanner;

import controller.PlayerHelper;
import model.Player;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static PlayerHelper ph = new PlayerHelper();

		private static void addPlayer() {
			System.out.print("Enter a name: ");
			String name = in.nextLine();
			System.out.print("Enter a number: ");
			String number = in.nextLine();
			System.out.print("Enter a position: ");
			String position = in.nextLine();
			
			Player toAdd = new Player(name, number, position);
			ph.insertPlayer(toAdd);

		}

		private static void deleteAPlayer() {
			System.out.print("Enter the name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the number to delete: ");
			String number = in.nextLine();
			System.out.print("Enter the position to delete: ");
			String position = in.nextLine();

			Player toDelete = new Player(name, number, position);
			ph.deletePlayer(toDelete);
		}

		private static void editAPlayer() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Name");
			System.out.println("2 : Search by Number");
			System.out.println("3 : Search by Position");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Player> foundPlayers;
			if (searchBy == 1) {
				System.out.print("Enter the player's name: ");
				String playerName = in.nextLine();
				foundPlayers = ph.searchForPlayerByName(playerName);
			}
			else if (searchBy == 2) {
				System.out.print("Enter the player's number: ");
				String playerNumber = in.nextLine();
				foundPlayers = ph.searchForPlayerByNumber(playerNumber);
			}
			else {
				System.out.print("Enter the player's position: ");
				String playerPosition = in.nextLine();
				foundPlayers = ph.searchForPlayerByPosition(playerPosition);
			}

			if (!foundPlayers.isEmpty()) {
				System.out.println("Found Results.");
				for (Player l : foundPlayers) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Player toEdit = ph.searchForPlayerById(idToEdit);
				System.out.println("Retrieved: " + toEdit.getName() + ", #" + toEdit.getNumber() + ", " + toEdit.getPosition());
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Number");
				System.out.println("3 : Update Position");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} 
				else if (update == 2) {
					System.out.print("New Number: ");
					String newNumber = in.nextLine();
					toEdit.setNumber(newNumber);
				}
				else if (update == 3) {
					System.out.print("New Position: ");
					String newPosition = in.nextLine();
					toEdit.setPosition(newPosition);
				}

				ph.updatePlayer(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println(" ----- Roster Builder ----- ");
			while (goAgain) {
				System.out.println("*  Select an option:");
				System.out.println("*  1 -- Add a Player");
				System.out.println("*  2 -- Edit an existing Player");
				System.out.println("*  3 -- Delete a player");
				System.out.println("*  4 -- View the roster");
				System.out.println("*  5 -- Exit");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addPlayer();
				} else if (selection == 2) {
					editAPlayer();
				} else if (selection == 3) {
					deleteAPlayer();
				} else if (selection == 4) {
					viewTheList();
				} else {
					ph.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<Player> allPlayers = ph.showAllPlayers();
			
			for(Player singlePlayer: allPlayers) {
				System.out.println(singlePlayer.returnPlayerDetails());
			}
		}

	}
