package frc.robot;

public record SwerveModuleConstants(
        int driveMotorID,
        int steerMotorID,
        int encoderID,
        double angleOffset
) {}