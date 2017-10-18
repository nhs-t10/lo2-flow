package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.DcMotor;
/**
 * Created by Alex on 10/17/2017.
 */

public class Gyro extends GyroSensor {
    public GyroSensor gyro = new GyroSensor() {


        @Override
        public void calibrate() {

        }
        int y = rawY();
        int x = rawX();
        int z = rawZ();
        if( y > 0){
            if ( x > 0){
//if Y is changing, then we know platform is moving
            }
            if ( z > 0){
//then we need to figure out which direction the robot is moving
 // we will move the opposite of that direction
 // need to figure out how to turn
            }
        }


        @Override
        public boolean isCalibrating() {
            return false;
        }

        @Override
        public int getHeading() {
            return 0;
        }

        @Override
        public double getRotationFraction() {
            return 0;
        }

        @Override
        public int rawX() {
            return 0;
        }

        @Override
        public int rawY() {
            return 0;
        }

        @Override
        public int rawZ() {
            return 0;
        }

        @Override
        public void resetZAxisIntegrator() {

        }

        @Override
        public String status() {
            return null;
        }

        @Override
        public Manufacturer getManufacturer() {
            return null;
        }

        @Override
        public String getDeviceName() {
            return null;
        }

        @Override
        public String getConnectionInfo() {
            return null;
        }

        @Override
        public int getVersion() {
            return 0;
        }

        @Override
        public void resetDeviceConfigurationForOpMode() {

        }

        @Override
        public void close() {

        }
    };
}
