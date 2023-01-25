// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
public class motorSubsystem extends SubsystemBase {
  WPI_VictorSPX frontRight=new WPI_VictorSPX(3);
  WPI_VictorSPX frontLeft = new WPI_VictorSPX(1);
  WPI_VictorSPX backRight = new WPI_VictorSPX(2);
  WPI_VictorSPX backLeft = new WPI_VictorSPX(0);
  MotorControllerGroup leftGroup = new MotorControllerGroup(frontLeft, backLeft);
  MotorControllerGroup rightGroup = new MotorControllerGroup(frontRight, backRight);
  DifferentialDrive drivebase = new DifferentialDrive(leftGroup, rightGroup);
  /** Creates a new ExampleSubsystem. */
  public motorSubsystem() {}

  public void setMotor(double left, double right) {
    frontLeft.set(left);
    frontRight.set(-right);
    backLeft.set(left);
    backRight.set(-right);

  }

  public void arcadeDrive(double fwdSpeed, double rotSpeed){
    drivebase.arcadeDrive(fwdSpeed, rotSpeed);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
