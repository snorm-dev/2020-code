/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Intake: 1 motor(), 1 solenoid w string
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Intake extends CommandBase {
  /**
   * Creates a new Intake.
   */
  private VictorSP m_motor;
  private DoubleSolenoid m_piston;

  public Intake() {
    // Use addRequirements() here to declare subsystem dependencies.
    m_motor = new VictorSP(0);
    m_piston = new DoubleSolenoid(0, 0, 0);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public void setMotor() {
    m_motor.set(0);

  }

  public void setPistonPosition(DoubleSolenoid.Value value) {
    m_piston.set(0);

  }
}
