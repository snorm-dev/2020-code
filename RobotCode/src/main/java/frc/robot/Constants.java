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
    /// PORTS /// not final
    /**TalonSRX
     * 1 - drive left motor
     * 2 - drive right motor
     */ 

    /**VictorSPX
     * 1 - drive left motor
     * 2 - drive right motor
     * 3 - shooter left motor
     * 4 - shooter right motor
     * 5 - climber left motor
     * 6 - climber right motor
     * 7 - intake motor
     * 8 - wheel motor
     */

    /**VictorSP
     * 0 - shooter yaw motor
     * 1 - shooter pitch motor
     * 2 - spinner motor
     */

    /**PCM 1
     * 01 - intake piston
     * 23 - indexer release latch
     * 45 - indexer pull rod
     * 67 - shooter trigger solenoid
     */

    /**PCM 2 
     * 01 - spinner piston
     * 23 - climber lower pistons
     * 45 - climber upper pistons
     */

    public static class DrivetrainConstants {
        public static int leftID = 1;
        public static int rightID = 2;

        public static boolean isTankDriveSquared = true;
        public static boolean isArcadeDriveSquared = true;
        public static boolean doesCheesyDrivePivot = true;

        public static double rotationDeadband = 0.30;
        public static double speedDeadband = 0.17;
    }
    
    public static class IntakeConstants {
        public static int motorID = 0;

        public static int pistonModuleID = 0;
        public static int pistonForwardID = 0;
        public static int pistonReverseID = 0;
    }
    
    public static class IndexerConstants {
        public static int wheelMotorID = 0;

        public static int releaseLatchModuleID = 0;
        public static int releaseLatchForwardID = 0;
        public static int releaseLatchReverseID = 0;

        public static int pullRodModuleID = 0;
        public static int pullRodForwardID = 0;
        public static int pullRodReverseID = 0;
    }
    
    public static class ShooterConstants {
        public static int leftSpinMotorID = 0;
        public static int rightSpinMotorID = 0;
        public static int yawMotorID = 0;
        public static int pitchMotorID = 0;

        public static int triggerModuleID = 0;
        public static int triggerForwardID = 0;
        public static int triggerReverseID = 0;
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
