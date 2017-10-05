package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by user on 10/5/17.
 */

public class Driving_Tank extends OpMode{


    DcMotor leftmotor, rightmotor;
    double wheelSpeed;

    @Override
    public void init() {
        rightmotor = hardwareMap.dcMotor.get("m2");
        leftmotor = hardwareMap.dcMotor.get("m1");

        telemetry.addData("Message 1", "Motors and servos declared! All Systems go!");
    }

    @Override
    public void loop(){
        if(gamepad1.left_stick_y>0.5){
            leftmotor.setPower(1f);

        }
        if(gamepad1.right_stick_y>0.5){
            rightmotor.setPower(1f);
        }
        if (gamepad1.left_stick_y<-0.5){
            leftmotor.setPower(-1f);

        }
        if (gamepad1.right_stick_y<-0.5){
            rightmotor.setPower(-1f);
        }
        telemetry.addData("Left motor value",gamepad1.left_stick_y);
        telemetry.addData("Right motor value",gamepad1.right_stick_y);

    }


}

