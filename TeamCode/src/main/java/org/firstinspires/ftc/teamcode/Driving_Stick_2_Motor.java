package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class Driving_Stick_2_Motor extends OpMode {
    DcMotor l, r;
    double wheelSpeed;


    @Override
    public void init(){
        r = hardwareMap.dcMotor.get("m2");
        l = hardwareMap.dcMotor.get("m1");
        // add two more motors and have 2 to side to side and 2 do forward and backward

        telemetry.addData("Message 1", "Motors and Servos Declared! All Systems go!");



    }

    public void loop(){

        if (gamepad1.left_stick_y>0.25) {
            l.setPower(0.5f);
            r.setPower(0.5f);
        }
        if (gamepad1.left_stick_y>0.5){
            l.setPower(1f);
            r.setPower(1f);
        }
        if (gamepad1.left_stick_y>0.75){
            l.setPower(1.5f);
            r.setPower(1.5f);
        }
        if (gamepad1.left_stick_y>0.9){
            l.setPower(2f);
            r.setPower(2f);
        }



        if(gamepad1.left_stick_y<0.5){
            l.setPower(-1f);
            r.setPower(-1f);


        }

        if(gamepad1.left_stick_y<0.75) {
            l.setPower(-1.5f);
            r.setPower(-1.5f);
        }

        if(gamepad1.left_stick_y<0.9) {
            l.setPower(-2f);
            r.setPower(-2f);
        }

        if(gamepad1.left_stick_y<0.25) {
            l.setPower(-0.5f);
            r.setPower(-0.5f);
        }
        if(gamepad1.left_stick_x>0.5){
            l.setPower(1f);
            r.setPower(-1f);
        }
        if(gamepad1.left_stick_x>0.25){
            l.setPower(0.5f);
            r.setPower(-0.5f);
        }
        if(gamepad1.left_stick_x>0.75){
            l.setPower(1.5f);
            r.setPower(-1.5f);
        }
        if(gamepad1.left_stick_x>0.9){
            l.setPower(2f);
            r.setPower(-2f);
        }
        if(gamepad1.left_stick_x<0.5){
            l.setPower(-1f);
            r.setPower(1f);
        }
        if(gamepad1.left_stick_x<0.25){
            l.setPower(-0.5f);
            r.setPower(0.5f);
        }
        if(gamepad1.left_stick_x<0.75){
            l.setPower(-1.5f);
            r.setPower(1.5f);
        }
        if(gamepad1.left_stick_x<0.9){
            l.setPower(-2f);
            r.setPower(2f);
        }
        if (wheelSpeed>3 && wheelSpeed<2){
            r.setPower(3);
            l.setPower(3);
        }
        telemetry.addData("Left motor value",gamepad1.left_stick_y);
        telemetry.addData("Right motor value",gamepad1.right_stick_y);


    }

}
