package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
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

    public void setGyro(GyroSensor gyro) {
        this.gyro = gyro;
        gyro.calibrate();
    }

    @Override
    public double getRuntime() {
        return super.getRuntime();
    }
//can copy paste
    @Override
    public void loop() {
        if (gamepad1.right_bumper) {
            int y = gyro.rawY();
            int x = gyro.rawX();
            int z = gyro.rawZ();
            if (y < 0) {
                if (x > 0) {
                    if (z > 0) {
                        lf.setPower(1);
                        lb.setPower(0);
                        rf.setPower(0);
                        rb.setPower(1);

                    } else if (z < 0) {
                        lf.setPower(0);
                        lb.setPower(-1);
                        rf.setPower(-1);
                        rb.setPower(0);
                    } else {
                        lf.setPower(-1);
                        lb.setPower(1);
                        rf.setPower(-1);
                        rb.setPower(1);

                    }
                } else if (x < 0) {
                    if (z < 0) {
                        lf.setPower(-1);
                        lb.setPower(0);
                        rf.setPower(0);
                        rb.setPower(-1);
                    } else if (z > 0) {
                        lf.setPower(0);
                        lb.setPower(1);
                        rf.setPower(1);
                        rb.setPower(0);
                    } else {
                        lf.setPower(1);
                        lb.setPower(-1);
                        rf.setPower(1);
                        rb.setPower(-1);
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
}
