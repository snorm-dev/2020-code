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
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.IntakeConstants.*;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  private VictorSP m_motor;
  private DoubleSolenoid m_piston;

  private ShuffleboardTab m_tab;

  public Intake(ShuffleboardTab tab) {
    m_motor = new VictorSP(motorID);
    m_piston = new DoubleSolenoid(pistonModuleID, pistonForwardID, pistonReverseID);

    m_tab = tab;

    configureShuffleboardData();
  }

  private void configureShuffleboardData() {
    m_tab.add(this);    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run  
  }

  public void setMotorSpeed(double speed) {
    m_motor.set(speed);
  }

  public void setPistonPosition(DoubleSolenoid.Value value) {
    m_piston.set(value);
  }
}
