package net.ligent.students.sleeptalk;

import static org.junit.Assert.*;

import org.junit.Test;

public class SleepTalkUserTest {

	@Test
	public void testNoArgumentConstructor() {
		SleepTalkUser u1 = new SleepTalkUser();
		assertNotNull(u1);
	}
	
	@Test
	public void testFullyOverloadedConstructor() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 360;
		int expectedMinutesMoving = 300;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		assertEquals(expectedClientID, u1.getClientID());
		assertEquals(expectedDate, u1.getDate());
		assertEquals(expectedSleep, u1.isMainSleep());
		assertEquals(expectedMinutesStill, u1.getMinutesStill());
		assertEquals(expectedMinutesMoving, u1.getMinutesMoving());
	}
	
	@Test
	public void testToString() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 360;
		int expectedMinutesMoving = 300;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		String expected = "SleepTalkUser [clientID=12345, date=2016-07-22, mainSleep=true, minutesStill=360, minutesMoving=300]";
		String actual = u1.toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEqualsAllSame() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 360;
		int expectedMinutesMoving = 300;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		SleepTalkUser u2 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		assertEquals(u1, u2);
	}
	
	@Test
	public void testEqualsClientIDDifferent() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 360;
		int expectedMinutesMoving = 300;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		SleepTalkUser u2 = new SleepTalkUser("123456", expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		assertFalse(u1.equals(u2));
	}
	
	@Test
	public void testEqualsDateDifferent() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 360;
		int expectedMinutesMoving = 300;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		SleepTalkUser u2 = new SleepTalkUser(expectedClientID, "2016-07-23", expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		assertFalse(u1.equals(u2));
	}
	
	@Test
	public void testEqualsMainSleepDifferent() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 360;
		int expectedMinutesMoving = 300;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		SleepTalkUser u2 = new SleepTalkUser(expectedClientID, expectedDate, false, expectedMinutesStill,
				expectedMinutesMoving);
		assertFalse(u1.equals(u2));
	}
	
	
	@Test
	public void testEqualsMinutesStillDifferent() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 360;
		int expectedMinutesMoving = 300;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		SleepTalkUser u2 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, 400,
				expectedMinutesMoving);
		assertFalse(u1.equals(u2));
	}
	
	
	@Test
	public void testEqualsMinutesMovingDifferent() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 360;
		int expectedMinutesMoving = 300;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		SleepTalkUser u2 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				200);
		assertFalse(u1.equals(u2));
	}
	
	@Test
	public void testGetHoursStill() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 360;
		int expectedMinutesMoving = 300;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		int expected = 6;
		int actual = u1.getHoursStill();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetHoursMoving() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 360;
		int expectedMinutesMoving = 300;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		int expected = 5;
		int actual = u1.getHoursMoving();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetTotalHours() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 360;
		int expectedMinutesMoving = 300;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		int expected = 11;
		int actual = u1.getTotalHours();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetScannedMessageStringNoSleep() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 0;
		int expectedMinutesMoving = 0;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		String expected = "Error: please sleep to get a sleep sentence.\n" + 
				"You can start right now, if you'd like.\n";
		String actual = u1.getScannedMessageString("needSleep.txt");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetScannedMessageStringRestlessSleep() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 0;
		int expectedMinutesMoving = 0;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		String expected = "Error: please sleep longer than 3 hours to get a sleep sentence.\n" + 
				"You can start right now, if you'd like.\n";
		String actual = u1.getScannedMessageString("restless.txt");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetNoSleepMessage59() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 59;
		int expectedMinutesMoving = 0;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		String expected = "Error: please sleep to get a sleep sentence.\n" + 
				"You can start right now, if you'd like.\n";
		String actual = u1.getSleepSentence();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetNoSleepMessage60() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 60;
		int expectedMinutesMoving = 0;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		String expected = "Error: please sleep longer than 3 hours to get a sleep sentence.\n" + 
				"You can start right now, if you'd like.\n";
		String actual = u1.getSleepSentence();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetRestlessMessage239() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 239;
		int expectedMinutesMoving = 0;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		String expected = "Error: please sleep longer than 3 hours to get a sleep sentence.\n" + 
				"You can start right now, if you'd like.\n";
		String actual = u1.getSleepSentence();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetRestlessMessage240() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 240;
		int expectedMinutesMoving = 0;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		String expected = "";  //generate random sleepParalysis sentence
		String actual = u1.getSleepSentence();
		assertNotEquals(expected, actual);
	}
	
	@Test
	public void testGetSleepParalysisSentence241() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 241;
		int expectedMinutesMoving = 0;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		String expected = "";  //generate random sleepParalysis sentence
		String actual = u1.getSleepSentence();
		assertNotEquals(expected, actual);
	}
	
	@Test
	public void testGetSleepParalysisSentenceMoving59() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 241;
		int expectedMinutesMoving = 59;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		String expected = "";  //generate random sleepParalysis sentence
		String actual = u1.getSleepSentence();
		assertNotEquals(expected, actual);
	}

	@Test
	public void testGetSleepParalysisSentenceMoving60() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 241;
		int expectedMinutesMoving = 60;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		String expected = "";  //generate random sentence of one word
		String actual = u1.getSleepSentence();
		assertNotEquals(expected, actual);
	}
	
	@Test
	public void testGetSleepSentenceStill240Moving240() {
		String expectedClientID = "12345";
		String expectedDate = "2016-07-22";
		boolean expectedSleep = true;
		int expectedMinutesStill = 240;
		int expectedMinutesMoving = 240;
		SleepTalkUser u1 = new SleepTalkUser(expectedClientID, expectedDate, expectedSleep, expectedMinutesStill,
				expectedMinutesMoving);
		String expected = "";  //generate random sentence of four words
		String actual = u1.getSleepSentence();
		assertNotEquals(expected, actual);
	}
}

