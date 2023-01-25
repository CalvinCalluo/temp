// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import edu.wpi.first.wpilibj.I2C;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivetrainSubsystem extends SubsystemBase {

  private final WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(5);
  private final WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(6);
  private final WPI_VictorSPX backLeftMotor = new WPI_VictorSPX(1);
  private final WPI_VictorSPX backRightMotor = new WPI_VictorSPX(3);

  private final MotorControllerGroup leftMotors = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
  private final MotorControllerGroup rightMotors = new MotorControllerGroup(frontRightMotor, backRightMotor);
  private final DifferentialDrive differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

  private AHRS gyro1 = new AHRS(I2C.Port.kOnboard);

  public void drive(double speedX, double speedY) {
    differentialDrive.arcadeDrive(speedX, speedY);
  }

  public double getYaw() {
    return gyro1.getYaw();
  }

  public double getPitch() {
    return gyro1.getPitch();
  }

  public double getRoll() {
    return gyro1.getRoll();
  }

  public void reset() {
    gyro1.reset();
  }

  public void stopMotors(){
    leftMotors.set(0);
    rightMotors.set(0);
  }

  /** Creates a new DrivetrainSubsystem. */
  public DrivetrainSubsystem() {
    rightMotors.setInverted(true);
    gyro1.calibrate();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
