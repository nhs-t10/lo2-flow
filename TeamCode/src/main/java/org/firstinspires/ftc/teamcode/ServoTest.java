package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "rvuch")
@SuppressWarnings("unused")
public class ServoTest extends OpMode{
    private Servo spinner,spinner1;
    public void init(){
        spinner = hardwareMap.servo.get("servo0");
        spinner1 = hardwareMap.servo.get("servo1");

        telemetry.addData("update", "we are ready for test");
    }
    @Override
    public void loop(){
        if(gamepad1.right_trigger>.5){
            spinner.setPosition(90);
        }
        if(gamepad1.right_trigger>.1 && gamepad1.right_trigger<.5){
            spinner.setPosition(45);
        }
        if(gamepad1.left_trigger>.5){
            spinner1.setPosition(90);
        }
        if(gamepad1.left_trigger>.1 && gamepad1.left_trigger<.5){
            spinner.setPosition(45);
        }
        if(gamepad1.left_bumper){
            spinner1.setPosition(0);
        }
        if(gamepad1.right_bumper ){
            spinner.setPosition(0);
        }


    }




}
