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


    /**
     * This class defines the port IDs for all CAN speed controllers privately and
     * in one location so they can be easily updated.
     * 
     * <p>These variables should be used in other constants subclasses related to specific subsystems.
     */
    private static class SpeedControllerCanPortConstants {
        private static int driveLeft = 1;
        private static int driveRight = 2;
        private static int climberLeft = 3;
        private static int climberRight = 4;
        private static int shooterLeft = 5;
        private static int shooterRight = 6;
        private static int shooterYaw = 7;
        private static int shooterPitch = 8;
        private static int intake = 9;
        private static int indexer = 10;
    }

    /**
     * This class defines the port IDs for all solenoids privately and
     * in one location so they can be easily updated.
     * 
     * <p>These variables should be used in other constants subclasses related to specific subsystems.
     */
    private static class PcmPortConstants {
        //PCM 1
        private static int[] climberLower = {1, 0, 1};
        private static int[] climberUpper = {1, 2, 3};
        private static int[] intake = {1, 4, 5};
        private static int[] shooter = {1, 6, 7};
        
        //PCM 2
        private static int[] spinner = {2, 0, 1};
        private static int[] indexerRelease = {2, 2, 3};
        private static int[] indexerPull = {2, 4, 5};
    }


    /**
     * This class defines constants related to the Drivetrain subsystem
     */
    public static class DrivetrainConstants {
        public static int leftID = SpeedControllerCanPortConstants.driveLeft;
        public static int rightID = SpeedControllerCanPortConstants.driveRight;

        public static boolean isTankDriveSquared = true;
        public static boolean isArcadeDriveSquared = true;
        public static boolean doesCheesyDrivePivot = true;

        public static double rotationDeadband = 0.30;
        public static double speedDeadband = 0.17;
    }
    
    /**
     * This class defines constants related to the Intake subsystem
     */
    public static class IntakeConstants {
        public static int motorID = SpeedControllerCanPortConstants.intake;

        public static int pistonModuleID = PcmPortConstants.intake[0];
        public static int pistonForwardID = PcmPortConstants.intake[1];
        public static int pistonReverseID = PcmPortConstants.intake[2];
    }
    
    /**
     * This class defines constants related to the Indexer subsystem
     */
    public static class IndexerConstants {
        public static int wheelMotorID = SpeedControllerCanPortConstants.indexer;

        public static int releaseLatchModuleID = PcmPortConstants.indexerRelease[0];
        public static int releaseLatchForwardID = PcmPortConstants.indexerRelease[1];
        public static int releaseLatchReverseID = PcmPortConstants.indexerRelease[2];

        public static int pullRodModuleID = PcmPortConstants.indexerPull[0];
        public static int pullRodForwardID = PcmPortConstants.indexerPull[1];
        public static int pullRodReverseID = PcmPortConstants.indexerPull[2];
    }
    
    /**
     * This class defines constants related to the Shooter subsystem
     */
    public static class ShooterConstants {
        public static int leftSpinMotorID = SpeedControllerCanPortConstants.shooterLeft;
        public static int rightSpinMotorID = SpeedControllerCanPortConstants.shooterRight;
        public static int yawMotorID = SpeedControllerCanPortConstants.shooterYaw;
        public static int pitchMotorID = SpeedControllerCanPortConstants.shooterPitch;

        public static int triggerModuleID = PcmPortConstants.shooter[0];
        public static int triggerForwardID = PcmPortConstants.shooter[1];
        public static int triggerReverseID = PcmPortConstants.shooter[2];
    }
    
    /**
     * This class defines constants related to the Spinner subsystem
     */
    public static class SpinnerConstants {
        public static int motorID = 0;
        public static int motorSpeed = 1;

        public static int pistonModuleID = PcmPortConstants.spinner[0];
        public static int pistonFowardID = PcmPortConstants.spinner[1];
        public static int pistodReverseID = PcmPortConstants.spinner[2];
    }
    
    /**
     * This class defines constants related to the Climber subsystem
     */
    public static class ClimberConstants {
        public static int leftWinchID = SpeedControllerCanPortConstants.climberLeft;
        public static int rightWinchID = SpeedControllerCanPortConstants.climberRight;

        public static int lowerPistonsModuleID = PcmPortConstants.climberLower[0];
        public static int lowerPistonsForwardID = PcmPortConstants.climberLower[1];
        public static int lowerPistonsReverseID = PcmPortConstants.climberLower[2];

        public static int upperPistonsModuleID = PcmPortConstants.climberUpper[0];
        public static int upperPistonsForwardID = PcmPortConstants.climberUpper[1];
        public static int upperPistonsReverseID = PcmPortConstants.climberUpper[2];
    }
}
