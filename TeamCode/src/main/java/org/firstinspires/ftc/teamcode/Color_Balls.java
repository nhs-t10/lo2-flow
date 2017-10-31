package org.firstinspires.ftc.teamcode;

/**
 * Created by dvw24 on 10/10/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;

@Autonomous(name = "autonomous")
public class Color_Balls extends LinearOpMode {

    private Servo colorKnocker;
    private ColorSensor color;
    private DcMotor leftmotor, rightmotor;

    @Override
    public synchronized void waitForStart() {
        super.waitForStart();
    }


    public void OpMode(){
        colorKnocker = hardwareMap.servo.get("s1");
        color = hardwareMap.colorSensor.get("color");
        leftmotor = hardwareMap.dcMotor.get("m1");
        rightmotor = hardwareMap.dcMotor.get("m2");

        telemetry.addData("Hi!", "Servos, Motors and Sensors declared! All Systems go!");
    }


   public void runOpMode(){

        color.enableLed(true);
        colorKnocker.setPosition(1);

        if (color.red() < 255 && color.red() > 100) {
            rightmotor.setPower(1);
            leftmotor.setPower(1);
        }else{
            rightmotor.setPower(-1);
            leftmotor.setPower(-1);
        }




    }


}




