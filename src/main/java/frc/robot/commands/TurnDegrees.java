// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class TurnDegrees extends CommandBase {

  private final DrivetrainSubsystem gyro;
  PIDController pid = new PIDController(0.4, 0, 0);

  /** Creates a new GyroCommand. */
  public TurnDegrees(DrivetrainSubsystem g) {
    // Use addRequirements() here to declare subsystem dependencies.
    gyro = g;
    addRequirements(gyro);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("TurnDegrees command turning");
    gyro.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("Roll:", gyro.getRoll());
    SmartDashboard.putNumber("Yaw:", gyro.getYaw());
    SmartDashboard.putNumber("Pitch:", gyro.getPitch());

    if(gyro.getYaw() < 89.9 || gyro.getYaw() > 90.1) {
      if (gyro.getYaw() > 90.1) {
        gyro.drive(0, 0.6);
      } else {
        gyro.drive(0, -0.6);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    gyro.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(gyro.getYaw() > 89.9 && gyro.getYaw() < 90.1) return true;
    else{
      return false;
    }
  }
}
