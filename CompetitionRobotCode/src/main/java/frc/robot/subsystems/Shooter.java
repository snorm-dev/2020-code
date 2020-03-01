/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Shooter: 2 spin motors(x40)encoder, 1 yaw motor()encoder, 1 pitch motor()encoder

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.ShooterConstants.*;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */

   private WPI_VictorSPX m_leftSpinMotor;
   private WPI_VictorSPX m_rightSpinMotor;
   private VictorSP m_yawMotor;
   private VictorSP m_pitchMotor;
   private DoubleSolenoid m_trigger;

   private ShuffleboardTab m_tab;

  public Shooter(ShuffleboardTab tab) {
    m_leftSpinMotor = new WPI_VictorSPX(leftSpinMotorID);
    m_rightSpinMotor = new WPI_VictorSPX(rightSpinMotorID);
    m_yawMotor = new VictorSP(yawMotorID);
    m_pitchMotor = new VictorSP(pitchMotorID);
    m_trigger = new DoubleSolenoid(triggerModuleID, triggerForwardID, triggerReverseID);

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

  public void setLeftSpinMotorSpeed(double speed) {
    m_leftSpinMotor.set(speed);
  }

  public void setRightSpinMotorSpeed(double speed) {
    m_rightSpinMotor.set(speed);
  }

  public void setYawMotorSpeed(double speed) {
    m_yawMotor.set(speed);
  }

  public void setPitchMotorSpeed(double speed) {
    m_pitchMotor.set(speed);
  }

  public void setTriggerPosition(DoubleSolenoid.Value value){
    m_trigger.set(value);
  }
}
