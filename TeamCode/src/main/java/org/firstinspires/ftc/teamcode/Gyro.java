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
    private DcMotor leftmotor, rightmotor, leftmotor2, rightmotor2;

    @Override
    public void init() {
        gyro = hardwareMap.gyroSensor.get("Gyro1");
        rightmotor = hardwareMap.dcMotor.get("m2");
        leftmotor = hardwareMap.dcMotor.get("m1");
        leftmotor2 = hardwareMap.dcMotor.get("m3");
        rightmotor2 = hardwareMap.dcMotor.get("m4");
    }

    @Override
    public void loop() {

        int y = gyro.rawY();
        int x = gyro.rawX();
        int z = gyro.rawZ();
        if (y < 0) {
            if (x > 0) {
                if (z > 0) {

                } else if (z < 0) {

                } else {

                }
            } else if (x < 0) {
                if (z < 0) {


                } else if (z > 0) {

                } else {

                }
            } else if (z < 0) {
                leftmotor.setPower(1);
                leftmotor2.setPower(1);
                rightmotor.setPower(1);
                rightmotor2.setPower(1);
            } else if (z > 0) {
                leftmotor.setPower(-1);
                leftmotor2.setPower(-1);
                rightmotor.setPower(-1);
                rightmotor2.setPower(-1);
            }
        }
    }
}


