package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

public final class Constants {

    public static final class Swerve {
        public static final double TRACK_WIDTH = 0.57785; // meters
        public static final double WHEEL_BASE = 0.57785;

        public static final double MAX_SPEED = 4.5; // m/s
        public static final double MAX_ANGULAR_RATE = Math.PI * 2;

        public static final Translation2d FRONT_LEFT_LOCATION =
                new Translation2d(WHEEL_BASE / 2, TRACK_WIDTH / 2);
        public static final Translation2d FRONT_RIGHT_LOCATION =
                new Translation2d(WHEEL_BASE / 2, -TRACK_WIDTH / 2);
        public static final Translation2d BACK_LEFT_LOCATION =
                new Translation2d(-WHEEL_BASE / 2, TRACK_WIDTH / 2);
        public static final Translation2d BACK_RIGHT_LOCATION =
                new Translation2d(-WHEEL_BASE / 2, -TRACK_WIDTH / 2);

        public static final SwerveDriveKinematics KINEMATICS =
                new SwerveDriveKinematics(
                        FRONT_LEFT_LOCATION,
                        FRONT_RIGHT_LOCATION,
                        BACK_LEFT_LOCATION,
                        BACK_RIGHT_LOCATION
                );
    }
}