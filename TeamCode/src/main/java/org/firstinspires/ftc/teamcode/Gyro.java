package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Alex on 10/17/2017.
 */

public class Gyro extends OpMode {



    private GyroSensor gyro;
    private DcMotor lf, rf, lb, rb;

    @Override
    public void init() {
        gyro = hardwareMap.gyroSensor.get("Gyro1");
        rf = hardwareMap.dcMotor.get("m1");
        lf = hardwareMap.dcMotor.get("m0");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
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
                lf.setPower(1);
                lb.setPower(1);
                rf.setPower(1);
                rb.setPower(1);
            } else if (z > 0) {
                lf.setPower(-1);
                lb.setPower(-1);
                rf.setPower(-1);
                rb.setPower(-1);
            }
        }
    }
}


