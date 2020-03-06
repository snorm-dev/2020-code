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
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.commands.AutoDriveTimed;
import frc.robot.commands.DriveArcade;
import frc.robot.commands.DriveCheesy;
import frc.robot.commands.DriveTank;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  /// SHUFFEBOARD TAB ///
  // This object is where we will put the data we want to see on the shuffleboard
  // when the robot is running
  private final ShuffleboardTab m_tab = Shuffleboard.getTab("Competition Robot");
  private final SendableChooser<Command> m_chooser = new SendableChooser<Command>();

  /// SUBSYSTEMS ///
  private final Drivetrain m_drivetrain = new Drivetrain(m_tab);
  // private final Intake m_intake = new Intake(m_tab);
  // private final Indexer m_indexer = new Indexer(m_tab);
  // private final Shooter m_shooter = new Shooter(m_tab);
  // private final Spinner m_spinner = new Spinner(m_tab);
  // private final Climber m_climber = new Climber(m_tab);

  /// CONTROLLERS & BUTTONS ///
  private final XboxController m_xbox = new XboxController(0);

  /// COMMANDS ///
  private final AutoDriveTimed m_autoDriveTimedForward = new AutoDriveTimed(m_drivetrain, 0.5, 2);
  private final AutoDriveTimed m_autoDriveTimedReverse = new AutoDriveTimed(m_drivetrain, -0.5, 2);

  private final DriveTank m_driveTank = new DriveTank(m_drivetrain, () -> -m_xbox.getY(Hand.kLeft),
      () -> -m_xbox.getY(Hand.kRight));

  private final DriveCheesy m_driveCheesySticks = new DriveCheesy(m_drivetrain, () -> -m_xbox.getY(Hand.kRight),
      () -> m_xbox.getX(Hand.kLeft));
  private final DriveCheesy m_driveCheesyTriggers = new DriveCheesy(m_drivetrain,
      () -> m_xbox.getTriggerAxis(Hand.kRight) - m_xbox.getTriggerAxis(Hand.kLeft), () -> m_xbox.getX(Hand.kLeft));

  private final DriveArcade m_driveArcadeSticks = new DriveArcade(m_drivetrain, () -> -m_xbox.getY(Hand.kRight),
      () -> m_xbox.getX(Hand.kLeft));
  private final DriveArcade m_driveArcadeTriggers = new DriveArcade(m_drivetrain,
      () -> m_xbox.getTriggerAxis(Hand.kRight) - m_xbox.getTriggerAxis(Hand.kLeft), () -> m_xbox.getX(Hand.kLeft));

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the initial default commands
    configureInitialDefaultCommands();
    // Configure the button bindings
    configureButtonBindings();
    // Configure the Shuffleboard Command Buttons
    configureShuffleboardData();
  }

  /**
   * Use this command to define {@link Shuffleboard} buttons using a
   * {@link ShuffleboardTab} and its add() function. You can put already defined
   * Commands,
   */
  private void configureShuffleboardData() {
    Shuffleboard.selectTab(m_tab.getTitle());

    m_chooser.setDefaultOption("Drive Forward", m_autoDriveTimedForward);
    m_chooser.addOption("Drive Reverse", m_autoDriveTimedReverse);
    m_chooser.addOption("Nothing", new RunCommand(() -> {
    }, m_drivetrain));
    m_tab.add("Auto Chooser", m_chooser);

    m_tab.add("Tank Drive", new InstantCommand(() -> m_drivetrain.setDefaultCommand(m_driveTank), m_drivetrain));
    m_tab.add("Cheesy Drive with Sticks",
        new InstantCommand(() -> m_drivetrain.setDefaultCommand(m_driveCheesySticks), m_drivetrain));
    m_tab.add("Cheesy Drive with Triggers",
        new InstantCommand(() -> m_drivetrain.setDefaultCommand(m_driveCheesyTriggers), m_drivetrain));
    m_tab.add("Arcade Drive with Sticks",
        new InstantCommand(() -> m_drivetrain.setDefaultCommand(m_driveArcadeSticks), m_drivetrain));
    m_tab.add("Arcade Drive with Triggers",
        new InstantCommand(() -> m_drivetrain.setDefaultCommand(m_driveArcadeTriggers), m_drivetrain));

    m_tab.addNumber("left x", () -> m_xbox.getX(Hand.kLeft));
    m_tab.addNumber("left y", () -> -m_xbox.getY(Hand.kLeft));     
    m_tab.addNumber("left trigger", () -> m_xbox.getTriggerAxis(Hand.kRight));
    m_tab.addNumber("right x", () -> m_xbox.getX(Hand.kRight));     
    m_tab.addNumber("right y", () -> -m_xbox.getY(Hand.kRight));
    m_tab.addNumber("right trigger", () -> m_xbox.getTriggerAxis(Hand.kRight));
  }
  
  /**
   * Use this method to define the default commands of subsystems. 
   * Default commands are ran whenever no other commands are using a specific subsystem.
   */
  private void configureInitialDefaultCommands() {
    m_drivetrain.setDefaultCommand(m_driveCheesySticks);
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
    Command autoCommand = m_chooser.getSelected();
    return autoCommand;
  }
}
