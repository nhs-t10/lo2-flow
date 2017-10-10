package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by tripszewczak on 10/5/17.
 */

public class Driving_Stick_4_Motor extends OpMode {
    DcMotor lf, rf, lb, rb;
    double wheelSpeed;


    @Override
    public void init(){
        rf = hardwareMap.dcMotor.get("m2");
        lf = hardwareMap.dcMotor.get("m1");
        rb = hardwareMap.dcMotor.get("m4");
        lb = hardwareMap.dcMotor.get("m3");


        telemetry.addData("Message 1", "Motors and Servos Declared! All Systems go!");



    }

    public void loop(){
        if (gamepad1.left_stick_y>0.5){
            lf.setPower(1f);
            rb.setPower(1f);
        }



        if(gamepad1.left_stick_y<0.5){
            lf.setPower(-1f);
            rb.setPower(-1f);

        }
        if(gamepad1.left_stick_x>0.5){
            lb.setPower(1f);
            rf.setPower(1f);
        }
        if(gamepad1.left_stick_x<0.5){
            lb.setPower(-1f);
            rf.setPower(-1f);
        }
        if (wheelSpeed>0.5 && wheelSpeed<1){
            rf.setPower(1);
            lf.setPower(1);
            rb.setPower(1);
            lb.setPower(1);
        }
        telemetry.addData("Left motor values",gamepad1.left_stick_y);
        telemetry.addData("Right motor values",gamepad1.right_stick_y);


    }

}
