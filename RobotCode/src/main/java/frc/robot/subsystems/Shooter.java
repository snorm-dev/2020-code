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
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shooter extends CommandBase {
  /**
   * Creates a new Shooter.
   */

   private WPI_VictorSPX m_leftSpinMotor;
   private WPI_VictorSPX m_rightSpinMotor;
   private VictorSP m_yawMotor;
   private VictorSP m_pitchMotor;

  public Shooter() {
    // Use addRequirements() here to declare subsystem dependencies.
    m_leftSpinMotor = new WPI_VictorSPX(0);
    m_rightSpinMotor = new WPI_VictorSPX(0);
    m_yawMotor = new VictorSP(0);
    m_pitchMotor = new VictorSP(0);

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
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public void setLeftSpinMotor(0) {
    m_leftSpinMotor.set();
  }

  public void setRightSpinMotor(0) {
    m_rightSpinMotor.set(0);
  }

  public void setYawMotor(0) {
    m_yawMotor.set(0);
  }

  public void setPitchMotor(0) {
    m_pitchMotor.set(0);
  }
}
