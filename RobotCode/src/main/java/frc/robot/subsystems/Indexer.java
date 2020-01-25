/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.IndexerConstants.*;

public class Indexer extends SubsystemBase {
  /**
   * Creates a new Indexer.
   */

  private VictorSP m_wheelMotor;
  private DoubleSolenoid m_leftReleaseLatch;
  private DoubleSolenoid m_rightReleaseLatch;
  private DoubleSolenoid m_pullRod;

  public Indexer() {
    m_wheelMotor = new VictorSP(wheelMotorID);
    m_leftReleaseLatch = new DoubleSolenoid(leftReleaseLatchModuleID, leftReleaseLatchForwardID, leftReleaseLatchReverseID);
    m_rightReleaseLatch = new DoubleSolenoid(rightReleaseLatchModuleID, rightReleaseLatchForwardID, rightReleaseLatchReverseID);
    m_pullRod = new DoubleSolenoid(pullRodModuleID, pullRodForwardID, pullRodReverseID);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run  
  }

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
