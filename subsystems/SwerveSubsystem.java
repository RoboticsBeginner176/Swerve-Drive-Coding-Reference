package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;
import edu.wpi.first.math.kinematics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.*;

public class SwerveSubsystem extends SubsystemBase {

    private final SwerveModule frontLeft = new SwerveModule(
            new SwerveModuleConstants(1, 2, 3, 0)
    );
    private final SwerveModule frontRight = new SwerveModule(
            new SwerveModuleConstants(4, 5, 6, 0)
    );
    private final SwerveModule backLeft = new SwerveModule(
            new SwerveModuleConstants(7, 8, 9, 0)
    );
    private final SwerveModule backRight = new SwerveModule(
            new SwerveModuleConstants(10, 11, 12, 0)
    );

    private final Pigeon2 gyro = new Pigeon2(13);

    public void drive(double xSpeed, double ySpeed, double rot, boolean fieldRelative) {
        SwerveModuleState[] states =
                Constants.Swerve.KINEMATICS.toSwerveModuleStates(
                        fieldRelative
                                ? ChassisSpeeds.fromFieldRelativeSpeeds(
                                    xSpeed, ySpeed, rot, gyro.getRotation2d())
                                : new ChassisSpeeds(xSpeed, ySpeed, rot)
                );

        SwerveDriveKinematics.desaturateWheelSpeeds(
                states, Constants.Swerve.MAX_SPEED
        );

        frontLeft.setDesiredState(states[0]);
        frontRight.setDesiredState(states[1]);
        backLeft.setDesiredState(states[2]);
        backRight.setDesiredState(states[3]);
    }
}
