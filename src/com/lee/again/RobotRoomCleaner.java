package com.lee.again;

public class RobotRoomCleaner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void cleanRoom(Robot robot) {
        
    }

}



  // This is the robot's control interface.
  // You should not implement it, or speculate about its implementation
  interface Robot {
      // Returns true if the cell in front is open and robot moves into the cell.
      // Returns false if the cell in front is blocked and robot stays in the current cell.
      public boolean move();
 
      // Robot will stay in the same cell after calling turnLeft/turnRight.
      // Each turn will be 90 degrees.
      public void turnLeft();
      
      void turnRight();
 
      // Clean the current cell.
      public void clean();
  }
 
