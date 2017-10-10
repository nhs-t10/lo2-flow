package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by tripszewczak on 10/5/17.
 */

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
        if (gamepad1.left_stick_y>0.5){
            l.setPower(1f);
            r.setPower(1f);
        }



        if(gamepad1.left_stick_y<0.5){
            l.setPower(-1f);
            r.setPower(-1f);

        }
        if(gamepad1.left_stick_x>0.5){
            l.setPower(1f);
            r.setPower(-1f);
        }
        if(gamepad1.left_stick_x<0.5){
            l.setPower(-1f);
            r.setPower(1f);
        }
        if (wheelSpeed>0.5 && wheelSpeed<1){
            r.setPower(1);
            l.setPower(1);
        }
        telemetry.addData("Left motor value",gamepad1.left_stick_y);
        telemetry.addData("Right motor value",gamepad1.right_stick_y);


    }

}