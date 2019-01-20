package inf101.v17.labyrinth;

import inf101.v17.labyrinth.gui.LabyrinthGUI;

public class GUIMain {
	// Labyrint
	public static char[][] testLabyrint = {//
			{ '*', '*', '*', '*' },//
			{ '*', ' ', ' ', '*' },//
			{ '*', ' ', '*', '*' },//
			{ '*', 's', '*', '*' },//
			{ '*', '*', '*', '*' }, };

	public static void main(String[] args) {
//			LabyrinthGUI.run(() -> new Labyrinth(LabyrinthHelper.loadGrid(testLabyrint)));
			LabyrinthGUI.run(() -> new Labyrinth(LabyrinthHelper.makeRandomGrid(20, 20)));
	}
}
