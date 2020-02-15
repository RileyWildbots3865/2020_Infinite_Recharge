/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.ColorPosition;
import frc.robot.commands.ColorSpin;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.SpinnySpinny;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public static RobotContainer m_robotContainer;
  public static Drivetrain drivetrain;
  public static SpinnySpinny spinny;

  Command TankDriveCommand;
  Command ColorSpinCommand;
  Command ColorPositionCommand;

  private static I2C.Port colorPort = I2C.Port.kOnboard;
  public static ColorSensorV3 colorSensor = new ColorSensorV3(colorPort);
  public static ColorMatch colorMatch = new ColorMatch();

  public static final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  public static final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  public static final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  public static final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  public static Spark m1 = new Spark(Constants.M1);
  public static Spark m2 = new Spark(Constants.M2);
  public static Spark m3 = new Spark(Constants.M3);
  public static Spark m4 = new Spark(Constants.M4);
  public static Spark m5 = new Spark(Constants.M5);
  public static Spark m6 = new Spark(Constants.M6);
  public static Spark m7 = new Spark(Constants.M7);
  public static Spark m8 = new Spark(Constants.M8);
  public static Spark m9 = new Spark(Constants.M9);
  public static Spark m10 = new Spark(Constants.M10);

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    drivetrain = new Drivetrain();
    spinny = new SpinnySpinny();

    TankDriveCommand = new TankDrive();
    ColorSpinCommand = new ColorSpin();
    ColorPositionCommand = new ColorPosition();

    colorMatch.addColorMatch(kBlueTarget);
    colorMatch.addColorMatch(kGreenTarget);
    colorMatch.addColorMatch(kRedTarget);
    colorMatch.addColorMatch(kYellowTarget);  
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    TankDriveCommand.execute();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    TankDriveCommand.execute();
    // colorSpin.execute();
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    m1.set(1);
    m2.set(1);
    m3.set(1);
    m4.set(1);
    m5.set(1);
    m6.set(1);
    m7.set(1);
    m8.set(1);
    m9.set(1);
    m10.set(1);
  }
}
