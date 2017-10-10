package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by tripszewczak on 10/5/17.
 */

public class Driving_Stick_2_Motor extends OpMode {
    DcMotor leftmotor, rightmotor;
    double wheelSpeed;


    @Override
    public void init(){
        rightmotor = hardwareMap.dcMotor.get("m2");
        leftmotor = hardwareMap.dcMotor.get("m1");


        telemetry.addData("Message 1", "Motors and Servos Declared! All Systems go!");



    }

    public void loop(){
        if (gamepad1.left_stick_y>0.5){
            leftmotor.setPower(1f);
            rightmotor.setPower(1f);
        }



        if(gamepad1.left_stick_y<0.5){
            leftmotor.setPower(-1f);
            rightmotor.setPower(-1f);

        }
        if(gamepad1.left_stick_x>0.5){
            leftmotor.setPower(1f);
            rightmotor.setPower(-1f);
        }
        if(gamepad1.left_stick_x<0.5){
            leftmotor.setPower(-1f);
            rightmotor.setPower(1f);
        }
        if (wheelSpeed>0.5 && wheelSpeed<1){
            rightmotor.setPower(1);
            leftmotor.setPower(1);
        }
        telemetry.addData("Left motor value",gamepad1.left_stick_y);
        telemetry.addData("Right motor value",gamepad1.right_stick_y);


    }

}
