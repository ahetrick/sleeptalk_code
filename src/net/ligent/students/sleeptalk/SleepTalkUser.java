package net.ligent.students.sleeptalk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SleepTalkUser {

	// instance variables
	private String clientID;
	private String date;
	private boolean mainSleep;
	private int minutesStill;
	private int minutesMoving;
	
	// constants
	
	// constructors 
	public SleepTalkUser() {
		// no argument constructor
	}
	
	public SleepTalkUser(String clientID, String date, boolean mainSleep, int minutesStill, int minutesMoving) {
		// fully overloaded constructor
		setClientID(clientID);
		setDate(date);
		setMainSleep(mainSleep);
		setMinutesStill(minutesStill);
		setMinutesMoving(minutesMoving);
	}
	
	// getters and setters
	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isMainSleep() {
		return mainSleep;
	}

	public void setMainSleep(boolean mainSleep) {
		this.mainSleep = mainSleep;
	}

	public int getMinutesStill() {
		return minutesStill;
	}

	public void setMinutesStill(int minutesStill) {
		this.minutesStill = minutesStill;
	}

	public int getMinutesMoving() {
		return minutesMoving;
	}

	public void setMinutesMoving(int minutesMoving) {
		this.minutesMoving = minutesMoving;
	}

	// other methods
	@Override
	public String toString() {
		return "SleepTalkUser [clientID=" + clientID + ", date=" + date + ", mainSleep=" + mainSleep
				+ ", minutesStill=" + minutesStill + ", minutesMoving=" + minutesMoving + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientID == null) ? 0 : clientID.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (mainSleep ? 1231 : 1237);
		result = prime * result + minutesStill;
		result = prime * result + minutesMoving;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SleepTalkUser other = (SleepTalkUser) obj;
		if (clientID == null) {
			if (other.clientID != null)
				return false;
		} else if (!clientID.equals(other.clientID))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (mainSleep != other.mainSleep)
			return false;
		if (minutesStill != other.minutesStill)
			return false;
		if (minutesMoving != other.minutesMoving)
			return false;
		return true;
	}

	// worker methods
	public int getHoursStill() {
		return (int) getMinutesStill() / 60;
	}
	
	public int getHoursMoving() {
		return (int) getMinutesMoving() / 60;
	}
	
	public int getTotalHours() {
		return (int) getHoursStill() + getHoursMoving();
	}

	public String getSleepSentence() {
		String sleepSentence = "";
		try {
			if (getTotalHours() == 0) {
				sleepSentence = noSleepMessage();
			} else if (getTotalHours() < 4) {
				sleepSentence = restlessMessage();
			} else {
				Scanner input = new Scanner(new File("words.txt"));
				ArrayList<String> allWordsArray = getAllWords(input);
				ArrayList<String> sleepArray = makeRandomArrayList(allWordsArray);
				String sleepString = makeRandomString(sleepArray);
				sleepSentence = sleepString;
				input.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return sleepSentence;
	}
	
	public String getScannedMessageString(String f) {
		String sleepMessage = "";
		try {
			Scanner input = new Scanner(new File(f));
			while (input.hasNextLine()) {
				String next = input.nextLine();
				sleepMessage += next + "\n";
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return sleepMessage;
	}
	
	public String noSleepMessage() {
		String noSleep = getScannedMessageString("needSleep.txt");
		return noSleep;
	}

	public String restlessMessage() {
		String restlessSleep = getScannedMessageString("restless.txt");
		return restlessSleep;
	}
	
	public ArrayList<String> getSleepParalysisArrayList() {
		ArrayList<String> sleepParalysisArrayList = new ArrayList<String>();
		try {
			Scanner inputParalysis = new Scanner(new File("paralysis.txt"));
			while(inputParalysis.hasNext()) {
				String next = inputParalysis.next();
				sleepParalysisArrayList.add(next);
			}
			inputParalysis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return sleepParalysisArrayList;
	}

	public ArrayList<String> getAllWords(Scanner sc) {
		ArrayList<String> words = new ArrayList<String>();
		while (sc.hasNext()) {
			String nextWord = sc.next();
			words.add(nextWord);
		}
		return words;
	}

	public ArrayList<String> makeRandomArrayList(ArrayList<String> allWordsArray) {
		ArrayList<String> sleepSentenceArray = new ArrayList<String>();
			if (getHoursMoving() > 0) {
				sleepSentenceArray = getRandomArrayList(allWordsArray, getHoursMoving());
			} else {
				ArrayList<String> allSleepParalysisArrayListWords = getSleepParalysisArrayList();
				sleepSentenceArray = getRandomArrayList(allSleepParalysisArrayListWords, getHoursStill());
			}
		return sleepSentenceArray;
	}
	
	public ArrayList<String> getRandomArrayList(ArrayList<String> listToBeRandomized, int n) {
		ArrayList<String>sleepSentenceArray = new ArrayList<String>();
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			int randWord = r.nextInt(listToBeRandomized.size());
			while (sleepSentenceArray.contains(listToBeRandomized.get(randWord))) {
				int tryAgain = r.nextInt(listToBeRandomized.size());
				if (tryAgain != randWord) {
					randWord = tryAgain;
				}
			}
			sleepSentenceArray.add(listToBeRandomized.get(randWord));
		}
		return sleepSentenceArray;
	}
	
	public String makeRandomString(ArrayList<String> randomArrayList) {
		String getFirstWord = randomArrayList.get(0);
		String firstWordCap = getFirstWord.substring(0, 1).toUpperCase() + getFirstWord.substring(1);
		String sleepSentenceString = firstWordCap;
		for (int i = 1; i < randomArrayList.size(); i++) {
			sleepSentenceString += " ";
			String next = randomArrayList.get(i);
			if (next.equalsIgnoreCase("i")) {
				sleepSentenceString += next.toUpperCase();
			} else if (next.equalsIgnoreCase("i'm")) {
				sleepSentenceString += next.substring(0, 1).toUpperCase() + next.substring(1);
			} else {
				sleepSentenceString += next.toLowerCase();
			}
		}
		return sleepSentenceString + ".";
	}
}


