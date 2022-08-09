


import java.util.LinkedList;
import java.util.List;

public class Demo {

	static String dice1="2|2|2|3|3|3|4|4|4|5|5|5|1|3";
	//static String dice1 = "5|5|2|2|2|3|3|3|4|4|4|5|3|4";
	static boolean keepPlaying = true;
	static String natural = "7,11";
	static String craps = "2,3,12";
	static String pointSet = "4,5,6,8,9,10";

	static String[] naturalArray = natural.split("\\,");
	static String[] crapsArray = craps.split("\\,");
	static String[] pointSetArray = pointSet.split("\\,");

	static int indexOne = 0;
	static int indexTwo = 1;

	static String sevenOut = "7";

	public static void main(String[] args) {

		String arr[] = dice1.split("\\|");

		List<Integer> listOfDice = new LinkedList<>();

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			listOfDice.add(Integer.valueOf(arr[i]));

		}
		listOfDice.forEach(d -> System.out.println(d));

		checkFirstRound(listOfDice);

	}

	private static void checkFirstRound(List<Integer> listOfDice) {

		int sumirstRound = listOfDice.get(indexOne) + listOfDice.get(indexTwo);

		for (int i = 0; i < naturalArray.length; i++) {
			if (sumirstRound == Integer.parseInt(naturalArray[i])) {
				System.out.println("first round win come-out phase natural");
				return;
			}
		}
		for (int i = 0; i < crapsArray.length; i++) {
			if (sumirstRound == Integer.parseInt(crapsArray[i])) {
				System.out.println("first round loose come-out phase craps natural");
				return;

			}
		}
		for (int i = 0; i < pointSetArray.length; i++) {
			if (sumirstRound == Integer.parseInt(pointSetArray[i])) {
				//System.out.println("pointSet natural continue second round");

				if (indexTwo < listOfDice.size()) {
					checkSecondRound(listOfDice, sumirstRound);
				}

			}

		}

	}

	private static void checkSecondRound(List<Integer> listOfDice, int sumirstRound) {

		while (keepPlaying) {
			indexOne = indexOne + 2;
			indexTwo = indexTwo + 2;
			int sumSecondRound = listOfDice.get(indexOne) + listOfDice.get(indexTwo);

			if (sumSecondRound == Integer.parseInt(sevenOut)) {
				System.out.println("Seven Out Covered");
				keepPlaying = false;
				
			}
			if (sumSecondRound == sumirstRound) {
				System.out.println("Made Point Covered");
				keepPlaying = false;
				
			}

		}

		

	}

}
