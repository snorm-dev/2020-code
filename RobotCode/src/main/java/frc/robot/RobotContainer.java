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
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveCheesy;
import frc.robot.subsystems.Climber;
import frc.robot.commands.SpinWheel;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Spinner;

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
   * Intake: 1 motor (VictorSP), 1 piston (DoubleSolenoid), sensor (ignore for now)
   * Indexer: 1 wheelMotor (VictorSP) w/ encoder (ignore for now), leftReleaseLatch & rightReleaseLatch (DoubleSolenoid), 1 pullRod (DoubleSolenoid)
   * Shooter: leftSpinMotor and rightSpinMotor (WPI_VictorSPX) w/ encoder (ignore for now), 1 yawMotor(VictorSP)encoder, 1 pitchMotor (VictorSP) w/ encoder (ignore for now)
   */
  /**on January 24 doooo: create a subsystem for each of the lines above^
   * declare and instantiate each variable (the class names for each are in parentheses)
   * don't create any functions yet, we will do that later, just create the variables for now..
   * don't worry about making a "subsystem"Constants class either, just put in 0 for now.., unless you want to (following your other subsystems as templates..)
   * if you have any questions message me on discord, good luck!
   */

  //SUBSYSTEMS
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Climber m_climber = new Climber();
  private final Spinner m_spinner = new Spinner();
  
  //CONTROLLERS & BUTTONS
  private final XboxController m_xbox = new XboxController(0);
  //Not Final
  private final JoystickButton m_aButton = new JoystickButton(m_xbox, 0);

  //COMMANDS
  private final DriveCheesy m_driveCheesy = new DriveCheesy(m_drivetrain, m_xbox);
  private final SpinWheel m_spinWheel = new SpinWheel(m_spinner);

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
    m_aButton.toggleWhenPressed(m_spinWheel);
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
