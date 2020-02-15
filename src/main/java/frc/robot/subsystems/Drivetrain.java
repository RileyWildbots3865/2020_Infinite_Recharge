/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.TankDrive;

public class Drivetrain extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  VictorSPX frontRightMotor;
  VictorSPX frontLeftMotor;
  VictorSPX backLeftMotor;
  VictorSPX backRightMotor;

  SpeedControllerGroup leftSpeedGroup;
  SpeedControllerGroup rightSpeedGroup;

  DifferentialDrive drivetrain;

  public Drivetrain(){
    frontRightMotor = new VictorSPX(Constants.FRONT_RIGHT_MOTOR);
    frontLeftMotor = new VictorSPX(Constants.FRONT_LEFT_MOTOR);
    backLeftMotor = new VictorSPX(Constants.BACK_LEFT_MOTOR);
    backRightMotor = new VictorSPX(Constants.BACK_RIGHT_MOTOR);

    // leftSpeedGroup = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);
    // rightSpeedGroup = new SpeedControllerGroup(frontRightMotor, backRightMotor);

    // drivetrain = new DifferentialDrive(leftSpeedGroup, rightSpeedGroup);
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    frontRightMotor.set(ControlMode.PercentOutput, -1 * rightSpeed);
    backRightMotor.set(ControlMode.PercentOutput, -1 * rightSpeed);
    frontLeftMotor.set(ControlMode.PercentOutput, leftSpeed);
    backLeftMotor.set(ControlMode.PercentOutput, leftSpeed);
  }

  // @Override
  // public void initDefaultCommand()  {
  //   // Set the default command for a subsystem here.
  //   setDefaultCommand(new TankDrive());
  // }
}
