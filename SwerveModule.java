package frc.robot;

import static edu.wpi.first.units.Units.Degree;

import com.ctre.phoenix6.controls.*;
import com.ctre.phoenix6.hardware.*;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public class SwerveModule {

    private final TalonFX driveMotor;
    private final TalonFX angleMotor;
    private final CANcoder angleEncoder;

    public SwerveModule(SwerveModuleConstants constants) {
        driveMotor = new TalonFX(constants.driveMotorID());
        angleMotor = new TalonFX(constants.steerMotorID());
        angleEncoder = new CANcoder(constants.encoderID());

        angleMotor.setPosition(0);
    }

    public void setDesiredState(SwerveModuleState state) {
        state = SwerveModuleState.optimize(
                state,
                getRotation()
        );

        driveMotor.setControl(
                new VelocityVoltage(state.speedMetersPerSecond)
        );

        angleMotor.setControl(
                new PositionVoltage(
                        state.angle.getRotations()
                )
        );
    }
    /* 
    public Rotation2d getRotation() {
        return Rotation2d.fromRotations(angleEncoder.getAbsolutePosition().getValue());
    }
    */
    public Rotation2d getRotation() {
    return new Rotation2d(angleEncoder.getAbsolutePosition().getValue());
}
    
}
