/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.commands.DriveArcade;
import frc.robot.commands.DriveCheesy;
import frc.robot.commands.DriveTank;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */

   /**TODO
   * Intake: sensor (ignore for now)
   * Indexer: 1 wheelMotor (VictorSP) w/ encoder (ignore for now)
   * Shooter: leftSpinMotor and rightSpinMotor (WPI_VictorSPX) w/ encoder (ignore for now), 1 yawMotor(VictorSP)encoder, 1 pitchMotor (VictorSP) w/ encoder (ignore for now)
   */

  /// SUBSYSTEMS ///
  private final Drivetrain m_drivetrain = new Drivetrain();
  //private final Intake m_intake = new Intake();
  //private final Indexer m_indexer = new Indexer();
  //private final Shooter m_shooter = new Shooter();
  //private final Spinner m_spinner = new Spinner();
  //private final Climber m_climber = new Climber();
  
  /// CONTROLLERS & BUTTONS ///
  private final XboxController m_xbox = new XboxController(0);

  /// COMMANDS ///
  private final DriveTank m_driveTank = new DriveTank(m_drivetrain, () -> -m_xbox.getY(Hand.kLeft), () -> -m_xbox.getY(Hand.kRight));

  private final DriveCheesy m_driveCheesySticks = new DriveCheesy(m_drivetrain, () -> -m_xbox.getY(Hand.kRight), () -> m_xbox.getX(Hand.kLeft));
  private final DriveCheesy m_driveCheesyTriggers = new DriveCheesy(m_drivetrain, () -> m_xbox.getTriggerAxis(Hand.kRight) - m_xbox.getTriggerAxis(Hand.kLeft) , () -> m_xbox.getX(Hand.kLeft));

  private final DriveArcade m_driveArcadeSticks = new DriveArcade(m_drivetrain, () -> -m_xbox.getY(Hand.kRight), () -> m_xbox.getX(Hand.kLeft));
  private final DriveArcade m_driveArcadeTriggers = new DriveArcade(m_drivetrain, () -> m_xbox.getTriggerAxis(Hand.kRight) - m_xbox.getTriggerAxis(Hand.kLeft) , () -> m_xbox.getX(Hand.kLeft));

  public RobotContainer() {
    // Configure the initial default commands
    configureInitialDefaultCommands();
    // Configure the button bindings
    configureButtonBindings();
    // Configure the Shuffleboard Command Buttons
    configureShuffleboardCommandButtons();
  }
  
    private void configureShuffleboardCommandButtons() {
      SmartDashboard.putData("Tank Drive", new InstantCommand(() -> m_drivetrain.setDefaultCommand(m_driveTank), m_drivetrain));
      SmartDashboard.putData("Cheesy Drive with Sticks", new InstantCommand(() -> m_drivetrain.setDefaultCommand(m_driveCheesySticks), m_drivetrain));
      SmartDashboard.putData("Cheesy Drive with Triggers", new InstantCommand(() -> m_drivetrain.setDefaultCommand(m_driveCheesyTriggers), m_drivetrain));
      SmartDashboard.putData("Arcade Drive with Sticks", new InstantCommand(() -> m_drivetrain.setDefaultCommand(m_driveArcadeSticks), m_drivetrain));
      SmartDashboard.putData("Arcade Drive with Triggers", new InstantCommand(() -> m_drivetrain.setDefaultCommand(m_driveArcadeTriggers), m_drivetrain));
    }
  
  private void configureInitialDefaultCommands() {
    m_drivetrain.setDefaultCommand(m_driveCheesyTriggers);
  }
  
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }
  
  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }

  public void displayValues() {
    SmartDashboard.putNumber("left x", m_xbox.getX(Hand.kLeft));     
    SmartDashboard.putNumber("left y", -m_xbox.getY(Hand.kLeft));     
    SmartDashboard.putNumber("left trigger", m_xbox.getTriggerAxis(Hand.kRight));
    SmartDashboard.putNumber("right x", m_xbox.getX(Hand.kRight));     
    SmartDashboard.putNumber("right y", -m_xbox.getY(Hand.kRight));
    SmartDashboard.putNumber("right trigger", m_xbox.getTriggerAxis(Hand.kRight));     
  }
}
