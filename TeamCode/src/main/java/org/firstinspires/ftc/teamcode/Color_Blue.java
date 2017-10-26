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


    public void runOpMode() {
        colorKnocker = hardwareMap.servo.get("s1");
        color = hardwareMap.colorSensor.get("color");
        rf = hardwareMap.dcMotor.get("m1");
        lf = hardwareMap.dcMotor.get("m0");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        telemetry.addData("Hi!", "Servos, Motors and Sensors declared! All Systems go!");

        {

            color.enableLed(true);
            colorKnocker.setPosition(1);
            //I have no real clue if this will set the arm correctly but if it does no need to fix it

            //In this code we are on the blue team.
            //This means we need to knock down the red ball.
            //The sensor will be on the right of the arm
            // If it senses the blue ball then it needs to go backwards to knock off the red ball
            //the reverse if it senses a non blue ball (red)

            if (color.blue() < 255 && color.blue() > 100) {
                //color is not correct and needs to be changed to sense color blue
                rf.setPower(-1);
                lf.setPower(-1);
                rb.setPower(-1);
                lb.setPower(-1);
            } else {
                rf.setPower(1);
                lf.setPower(1);
                rb.setPower(1);
                rf.setPower(1);
            }

            //the problem with this code is that it goes on forever and does not stop
            //once we get it to stop we would need to bring the arm up

        }


    }
}




