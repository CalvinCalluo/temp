// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import java.util.function.Supplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.motorSubsystem;
public class ArcadeDriveCmd extends CommandBase {

  motorSubsystem driveSub; 
  Supplier<Double> driveSpeed, driveRotation;
  /** Creates a new ArcadeDriveCmd. */
  public ArcadeDriveCmd(motorSubsystem mtrSub, Supplier<Double> driveSpeed, Supplier<Double> driveRotation) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveSub = mtrSub;
    this.driveSpeed = driveSpeed;
    this.driveRotation = driveRotation;
    addRequirements(driveSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftSpeed,rotateSpeed;
    leftSpeed = this.driveSpeed.get();
    rotateSpeed = this.driveRotation.get();
    /*
    double left, right;
    left = leftSpeed + rotateSpeed;
    right = leftSpeed - rotateSpeed;
    driveSub.setMotor(-Math.pow(left, 5), -Math.pow(right, 5));
    */
    driveSub.arcadeDrive(leftSpeed, rotateSpeed);
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
