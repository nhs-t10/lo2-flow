package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by tripszewczak on 10/5/17.
 */

public class Driving_Stick_4_Motor extends OpMode {
    DcMotor leftfmotor, rightfmotor, leftbmotor, rightbmotor;
    double wheelSpeed;


    @Override
    public void init(){
        rightfmotor = hardwareMap.dcMotor.get("m2");
        leftfmotor = hardwareMap.dcMotor.get("m1");
        rightbmotor = hardwareMap.dcMotor.get("m4");
        leftbmotor = hardwareMap.dcMotor.get("m3");


        telemetry.addData("Message 1", "Motors and Servos Declared! All Systems go!");



    }

    public void loop(){
        if (gamepad1.left_stick_y>0.5){
            leftfmotor.setPower(1f);
            rightbmotor.setPower(1f);
        }



        if(gamepad1.left_stick_y<0.5){
            leftfmotor.setPower(-1f);
            rightbmotor.setPower(-1f);

        }
        if(gamepad1.left_stick_x>0.5){
            leftbmotor.setPower(1f);
            rightfmotor.setPower(-1f);
        }
        if(gamepad1.left_stick_x<0.5){
            leftbmotor.setPower(-1f);
            rightfmotor.setPower(1f);
        }
        if (wheelSpeed>0.5 && wheelSpeed<1){
            rightfmotor.setPower(1);
            leftfmotor.setPower(1);
            rightbmotor.setPower(1);
            leftbmotor.setPower(1);
        }
        telemetry.addData("Left motor values",gamepad1.left_stick_y);
        telemetry.addData("Right motor values",gamepad1.right_stick_y);


    }

}
