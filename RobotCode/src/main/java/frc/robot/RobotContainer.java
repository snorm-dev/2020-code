/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveCheesy;
import frc.robot.subsystems.Climber;
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
   * Climber: 2 winches(x40), 2 solenoids - stage 1&2
   * Intake: 1 motor(), 1 solenoid w string
   * Uptake: 1 motor(), 1 solenoid w string?, sensor for knowledge
   * Indexer: 1 wheel motor()encoder, 2 power cell release solenoids, 1 power cell pull rod solenoid
   * Shooter: 2 spin motors(x40)encoder, 1 yaw motor()encoder, 1 pitch motor()encoder
   * Spinner: 1 motor(), 1 solenoid
   */

  //SUBSYSTEMS
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Climber m_climber = new Climber();
  
  //CONTROLLERS & BUTTONS
  private final XboxController m_xbox = new XboxController(0);

  //COMMANDS
  private final DriveCheesy m_driveCheesy = new DriveCheesy(m_drivetrain, m_xbox);

  public RobotContainer() {
    // Configure the button bindings
    configureInitialDefaultCommands();
    configureButtonBindings();
  }

  private void configureInitialDefaultCommands() {
    m_drivetrain.setDefaultCommand(m_driveCheesy);
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
}
