package net.ligent.students.sleeptalk;

public class SleepTalkClient {
	
	public static void main(String[] args) {
		
		// test no argument constructor
		SleepTalkUser u1 = new SleepTalkUser();
		System.out.println(u1); //SleepTalkUser [clientID=null, date=null, mainSleep=false, minutesStill=0, minutesMoving=0]

		// test fully overloaded constructor
		SleepTalkUser u2 = new SleepTalkUser("12345","2016-07-22", true, 360, 300);
		System.out.println(u2); //expect SleepTalkUser [clientID=12345, date=2016-07-22, mainSleep=true, minutesStill=360, minutesMoving=300]
		
		// test partially overloaded constructor
		
		// test toString
		SleepTalkUser u3 = new SleepTalkUser("12345","2016-07-22", true, 360, 300);
		System.out.println(u3);
		
		// test equals
		SleepTalkUser u4 = new SleepTalkUser("12345","2016-07-22", true, 360, 300);
		SleepTalkUser u5 = new SleepTalkUser("12345","2016-07-22", true, 360, 300);
		
		System.out.println(u4 == u5); //expect false
		System.out.println(u4.equals(u5)); //expect true
		
		// test worker methods
		SleepTalkUser u6 = new SleepTalkUser();
		u6.setMinutesStill(59); 
		u6.setMinutesMoving(0);
		String message1 = u6.getSleepSentence();
		System.out.println(message1); // expect noSleepMessage
		
		SleepTalkUser u7 = new SleepTalkUser();
		u7.setMinutesStill(60); 
		u7.setMinutesMoving(0);
		String message2 = u7.getSleepSentence();
		System.out.println(message2); // expect restlessMessage
		
		SleepTalkUser u8 = new SleepTalkUser();
		u8.setMinutesStill(239); 
		u8.setMinutesMoving(0);
		String message3 = u8.getSleepSentence();
		System.out.println(message3); // expect restlessMessage
		
		SleepTalkUser u9 = new SleepTalkUser();
		u9.setMinutesStill(240); 
		u9.setMinutesMoving(0);
		String message4 = u9.getSleepSentence();
		System.out.println(message4); // expect sleepParalysis sleepSentence with four words
		
		SleepTalkUser u10 = new SleepTalkUser();
		u10.setMinutesStill(240); 
		u10.setMinutesMoving(240);
		String message5 = u10.getSleepSentence();
		System.out.println(message5); // expect sleepSentence with four words
		
	}
}

