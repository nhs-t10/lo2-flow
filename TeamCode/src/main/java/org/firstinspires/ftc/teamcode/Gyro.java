package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.DcMotor;
/**
 * Created by Alex on 10/17/2017.
 */

public class Gyro extends OpMode {


    private GyroSensor gyro;


    @Override
    public void init() {
        gyro = hardwareMap.gyroSensor.get("???"); //TODO: Find real name!!!


    }

    @Override
    public void loop() {

        int y = gyro.rawY();
        int x = gyro.rawX();
        int z = gyro.rawZ();
        if( y > 0) {
            if ( x > 0) {
                //if Y is changing, then we know platform is moving
            }
            if ( z > 0) {
                //then we need to figure out which direction the robot is moving
                // we will move the opposite of that direction
                // need to figure out how to turn
            }
        }
    }
}
