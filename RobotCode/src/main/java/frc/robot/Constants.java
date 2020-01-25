/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class DrivetrainConstants {
        public static int leftID = 0;
        public static int rightID = 1;

        public static boolean isTankDriveSquared = true;
        public static boolean doesCheesyDrivePivot = true;
    }
    
    public static class IntakeConstants {
        public static int motorID = 0;

        public static int pistonModuleID = 0;
        public static int pistonForwardID = 0;
        public static int pistonReverseID = 0;
    }
    
    public static class IndexerConstants {
        public static int wheelMotorID = 0;

        public static int leftReleaseLatchModuleID = 0;
        public static int leftReleaseLatchForwardID = 0;
        public static int leftReleaseLatchReverseID = 0;

        public static int rightReleaseLatchModuleID = 0;
        public static int rightReleaseLatchForwardID = 0;
        public static int rightReleaseLatchReverseID = 0;

        public static int pullRodModuleID = 0;
        public static int pullRodForwardID = 0;
        public static int pullRodReverseID = 0;
    }
    
    public static class ShooterConstants {
        public static int leftSpinMotorID = 0;
        public static int rightSpinMotorID = 0;
        public static int yawMotorID = 0;
        public static int pitchMotorID = 0;
    }
        
    public static class SpinnerConstants {
        public static int motorID = 0;
        public static int motorSpeed = 1;

        public static int pistonModuleID = 0;
        public static int pistonFowardID = 0;
        public static int pistodReverseID = 0;
    }
    
    public static class ClimberConstants {
        public static int leftWinchID = 0;
        public static int rightWinchID = 0;

        public static int lowerPistonsModuleID = 0;
        public static int lowerPistonsForwardID = 0;
        public static int lowerPistonsReverseID = 0;

        public static int upperPistonsModuleID = 0;
        public static int upperPistonsForwardID = 0;
        public static int upperPistonsReverseID = 0;
    }
}
