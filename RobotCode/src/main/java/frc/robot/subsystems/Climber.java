/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Climber: 2 winches(x40), 2 solenoids - stage 1&2

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.ClimberConstants.*;

public class Climber extends SubsystemBase {
  /**
   * Creates a new Climber.
   */
    private WPI_VictorSPX m_leftWinch;
    private WPI_VictorSPX m_rightWinch;
    private DoubleSolenoid m_lowerPistons;
    private DoubleSolenoid m_upperPistons;
    
    private ShuffleboardTab m_tab;

  public Climber(ShuffleboardTab tab) {

    m_leftWinch = new WPI_VictorSPX(leftWinchID);
    m_rightWinch = new WPI_VictorSPX(rightWinchID);
    m_lowerPistons = new DoubleSolenoid(lowerPistonsModuleID, lowerPistonsForwardID, lowerPistonsReverseID);
    m_upperPistons = new DoubleSolenoid(upperPistonsModuleID, upperPistonsForwardID, upperPistonsReverseID);

    m_tab = tab;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    m_tab.add(this);  
  }
  public void setLowerPistonPosition(DoubleSolenoid.Value value){
    m_lowerPistons.set(value);
  }

  public void setUpperPistonPosition(DoubleSolenoid.Value value){
    m_upperPistons.set(value);
  }

  public void setLeftSpeed(double speed){
    m_leftWinch.set(ControlMode.PercentOutput, speed);
  }

  public void setRightSpeed(double speed){
    m_rightWinch.set(ControlMode.PercentOutput, speed);

  }
}

