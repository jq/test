import java.util.*;

public class Elevator {

   private int maxfloor;
   private int[] currentTask;
   
   public Elevator(int floor) {
	   maxfloor = floor;
	   currentTask = new int[maxfloor];
   }
   
   // assume moving 1 floor cost 1 in time
   public int getTotalWaitTime(Vector<Task> tasks) {
	   // low
	   int floor = 0;
	   int time = 0;
	   int waitTime = 0;
	   int curTask = 0;
	   int totalWaitingTask = 0;
	   int direction = 1;
	   int maxFloor = 0;
	   int minFloor = maxfloor;
	   
	   while (curTask < tasks.size()) {
		   while(tasks.get(curTask).time == time) {
			   Task t = tasks.get(curTask);
			   if (t.floor != floor) {
				   currentTask[t.floor]++;
				   totalWaitingTask++;
			   }
			   curTask++;
		   }
		   
		   if (totalWaitingTask >0) {
			   // move choose direction, 
			   floor += direction;
			   waitTime += totalWaitingTask;
			   if (currentTask[floor] >0) {
				   // serve and no waittime
				   totalWaitingTask -= currentTask[floor];
				   currentTask[curTask] = 0;
			   } 
			   
			   // should we change direction
			   if (direction > 0 && floor ==(maxfloor -1)) { direction = -1;} else {
				   direction = 1;
			   }
		   }
		   
		   time++;
		   
	   }
	   return waitTime;
   }

}
