package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;
//import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "hecking hecker")
public class Gyro extends OpMode {

    private GyroSensor gyro;
    private DcMotor lf, rf, lb, rb;



    @Override
    public void init() {
        gyro = hardwareMap.gyroSensor.get("Gyro1");
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
    }
    private void wheelSet(double a0, double a1, double a2, double a3){
        lf.setPower(a0);
        lb.setPower(a1);
        rf.setPower(a2);
        rb.setPower(a3);
    }
    private void resetGyro() {
        gyro.calibrate();
    }
    @Override
    public double getRuntime() {
        return super.getRuntime();
    }
    @Override
    public void loop() {
        if (gamepad1.right_trigger > 0) {
            while (gamepad1.right_trigger > .2) {
                int y = gyro.rawY();
                int x = gyro.rawX();
                int z = gyro.rawZ();
                if (y > 0){
                    resetGyro();
                }
                if (y < 0) {
                    if (x > 0) {
                        if (z > 0) {
                            wheelSet(1, 0, 0, 1);
                        } else if (z < 0) {
                            wheelSet(0, -1, -1, 0);
                        } else {
                            wheelSet(-1, 1, -1, 1);
                        }
                    } else if (x < 0) {
                        if (z < 0) {
                            wheelSet(-1, 0, 0, -1);
                        } else if (z > 0) {
                            wheelSet(0, 1, 1, 0);
                        } else {
                            wheelSet(1, -1, -1, 1);
                        }
                    } else if (z < 0) {
                        wheelSet(1, 1, 1, 1);
                    } else if (z > 0) {
                        wheelSet(-1, -1, -1, -1);
                    }
                }
            }
        }
    }
}


