/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Shooter: 2 spin motors(x40)encoder, 1 yaw motor()encoder, 1 pitch motor()encoder

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.VictorSP;
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

  public Shooter() {
    m_leftSpinMotor = new WPI_VictorSPX(leftSpinMotorID);
    m_rightSpinMotor = new WPI_VictorSPX(rightSpinMotorID);
    m_yawMotor = new VictorSP(yawMotorID);
    m_pitchMotor = new VictorSP(pitchMotorID);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run  
  }

  public void setLeftSpinMotor(double speed) {
    m_leftSpinMotor.set(speed);
  }

  public void setRightSpinMotor(double speed) {
    m_rightSpinMotor.set(speed);
  }

  public void setYawMotor(double speed) {
    m_yawMotor.set(speed);
  }

  public void setPitchMotor(double speed) {
    m_pitchMotor.set(speed);
  }
}
