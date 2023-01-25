// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;
import java.util.function.Supplier;

public class DrivetrainCommand extends CommandBase {

  DrivetrainSubsystem driveSubsystem;
  Supplier<Double> a;
  Supplier<Double> b;

  /** Creates a new DrivetrainCommand. */
  public DrivetrainCommand(DrivetrainSubsystem d, Supplier<Double> x, Supplier<Double> y) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveSubsystem = d;
    a = x;
    b = y;
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubsystem.drive(a.get() * 0.5, b.get() / 2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
