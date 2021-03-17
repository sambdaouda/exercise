package fr.open.exercise.schedule;

import org.junit.jupiter.api.Test;

public class ScheduledTaskTest {
	
	@Test
	public void testRun() {
		ScheduledTask scheduledTask = new ScheduledTask();
		scheduledTask.run();
	}

}
