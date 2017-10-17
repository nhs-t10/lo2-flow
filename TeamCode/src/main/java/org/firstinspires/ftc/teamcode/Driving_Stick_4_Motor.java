
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by tripszewczak on 10/5/17.
 */
@TeleOp(name = "FourMotor")
public class Driving_Stick_4_Motor extends OpMode {
    DcMotor lf, rf, lb, rb;
    double wheelSpeed = 0;


    @Override
    public void init(){
        rf = hardwareMap.dcMotor.get("m2");
        lf = hardwareMap.dcMotor.get("m1");
        rb = hardwareMap.dcMotor.get("m4");
        lb = hardwareMap.dcMotor.get("m3");


        telemetry.addData("Message 1", "Motors and Servos Declared! All Systems go!");



    }

    public void loop(){
        if (gamepad1.left_stick_y>0.1){
            wheelSpeed = 1;
            lf.setPower(wheelSpeed);
            rb.setPower(wheelSpeed);
        }

        if(gamepad1.left_stick_y<0.1){
            wheelSpeed = -1;
            lf.setPower(wheelSpeed);
            rb.setPower(wheelSpeed);

        }
        if(gamepad1.left_stick_x>0.1){
            wheelSpeed = 1;
            lb.setPower(wheelSpeed);
            lf.setPower(wheelSpeed);
        }
        if(gamepad1.left_stick_x>0.1){
            wheelSpeed = -1;
            rf.setPower(wheelSpeed);
            rb.setPower(wheelSpeed);
        }
        if(gamepad1.left_stick_x<0.1){
            wheelSpeed = -1;
            lb.setPower(wheelSpeed;
            lf.setPower(wheelSpeed);
        }
        if (gamepad1.left_stick_x<0.1){
            wheelSpeed = 1;
            rf.setPower(wheelSpeed);
            rb.setPower(wheelSpeed);
        }



        telemetry.addData("Left motor values",gamepad1.left_stick_y);
        telemetry.addData("Right motor values",gamepad1.right_stick_y);


    }

}
