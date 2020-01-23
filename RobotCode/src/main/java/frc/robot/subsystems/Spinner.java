/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// 1 motor(), 1 solenoid

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.SpinnerConstants.*;

public class Spinner extends SubsystemBase {
  /**
   * Creates a new Spinner.
   */

  private VictorSP m_motor;
  private DoubleSolenoid m_piston;


  public Spinner() {

    m_motor = new VictorSP(motorID);
    m_piston = new DoubleSolenoid(pistonModuleID, fowardID, reverseID);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setPistonPosition(DoubleSolenoid.Value value){
    m_piston.set(value);
  }
  public void setMotorSpeed(double speed){
    m_motor.set(speed);
  }

}
