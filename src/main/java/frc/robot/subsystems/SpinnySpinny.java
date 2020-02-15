/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3.RawColor;

import edu.wpi.first.hal.sim.DriverStationSim;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.util.Color;
/**
 * Add your docs here.
 */
public class SpinnySpinny extends SubsystemBase {
  VictorSP armWheel;
  int spinCount = 1;
  Boolean spinChecked = false;
  int totalColorNumber = 0;
  String givenColor = "";
  String firstColor = "";
  
  public SpinnySpinny(){
    // armWheel = new VictorSP(Constants.COLOR_MOTOR);
  }

  public void killMotor(){
    armWheel.set(0);;
  }

  public void spin(){
    armWheel.set(.5);
    ColorMatchResult match = Robot.colorMatch.matchClosestColor(Robot.colorSensor.getColor());

    if (match.color == Robot.kBlueTarget) {
      firstColor = "Blue";
    } else if (match.color == Robot.kRedTarget) {
      firstColor = "Red";
    } else if (match.color == Robot.kGreenTarget) {
      firstColor = "Green";
    } else if (match.color == Robot.kYellowTarget) {
      firstColor = "Yellow";
    } else {
      firstColor = "Unknown";
    }

    SmartDashboard.putString("Color", firstColor);

    // while(spinCount < 5){
    //   armWheel.set(.5);

      // if(firstColor == colorString){
      //   spinCount++;
      //   seen = true;
      // }else{
      //   seen = false;
      // }
    // }
  }

  public void position(){
    String gamedata = DriverStation.getInstance().getGameSpecificMessage();
    givenColor = Character.toString(gamedata.charAt(0));
    Boolean inPosition = false;

    while(inPosition == false){
      if(givenColor == "B"){

      }else if(givenColor == "Y"){

      }else if(givenColor == "G"){

      }else{
        
      }
    }
    
  }

  // @Override
  // public void initDefaultCommand() {
  //   // Set the default command for a subsystem here.
  //   // setDefaultCommand(new MySpecialCommand());
  // }
}
