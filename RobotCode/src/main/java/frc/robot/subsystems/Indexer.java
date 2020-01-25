/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Indexer extends CommandBase {
  /**
   * Creates a new Indexer.
   */

  private VictorSP m_wheelMotor;
  private DoubleSolenoid m_leftReleaseLatch;
  private DoubleSolenoid m_rightReleaseLatch;
  private DoubleSolenoid m_pullRod;

  public Indexer() {
    // Use addRequirements() here to declare subsystem dependencies.

    m_wheelMotor = new VictorSP(0);
    m_leftReleaseLatch = new DoubleSolenoid(0,0);
    m_rightReleaseLatch = new DoubleSolenoid(0,0);
    m_pullRod = new DoubleSolenoid(0,0);

  }

  /*
  I don't know if this code is necessary or if we did something wrong
  
  Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  */
  public void setWheelMotorSpeed(double speed){
    m_wheelMotor.set(speed);
  }

  public void setLeftReleaseLatchPosition(DoubleSolenoid.Value value){
    m_leftReleaseLatch.set(value);
  }

  public void setRightReleaseLatchPosition(DoubleSolenoid.Value value){
    m_rightReleaseLatch.set(value);
  }

  public void setPullRodPosition(DoubleSolenoid.Value value){
    m_pullRod.set(value);
  }
}
