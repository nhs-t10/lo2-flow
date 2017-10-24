package org.firstinspires.ftc.teamcode;

/**
 * Created by dvw24 on 10/10/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;


public class Color_Blue extends LinearOpMode {

    private Servo colorKnocker;
    private ColorSensor color;
    private DcMotor rf, lf, rb, lb;

    @Override
    public synchronized void waitForStart() {
        super.waitForStart();
    }

    @Override
    public void init(){
        colorKnocker = hardwareMap.servo.get("s1");
        color = hardwareMap.colorSensor.get("color");
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");

        telemetry.addData("Hi!", "Servos, Motors and Sensors declared! All Systems go!");
    }


    public void runOpMode() {

        color.enableLed(true);

        if (color.blue() < 255 && color.blue() > 100) {
            rf.setPower(-1);
            lf.setPower(1);
            rb.setPower(-1);
            lb.setPower(-1);
        }else{
            rf.setPower(-1);
            lf.setPower(1);
            rb.setPower(-1);
            rf.setPower(-1);
        }



    }


}




