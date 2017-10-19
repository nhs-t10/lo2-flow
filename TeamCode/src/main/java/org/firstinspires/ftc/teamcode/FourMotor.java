
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by tripszewczak on 10/5/17.
 */
@TeleOp(name = "FourMotor")
public class FourMotor extends OpMode {
    DcMotor lf, rf, lb, rb;


    @Override
    public void init(){
        rf = hardwareMap.dcMotor.get("m2");
        lf = hardwareMap.dcMotor.get("m1");
        rb = hardwareMap.dcMotor.get("m4");
        lb = hardwareMap.dcMotor.get("m3");
        rf.setPower(0);
        lf.setPower(0);
        rb.setPower(0);
        lb.setPower(0);


        telemetry.addData("Message 1", "Motors and Servos Declared! All Systems go!");



    }

    public void loop(){

        if (gamepad1.left_stick_y>0.25){

            lf.setPower(1);
            rf.setPower(1);
            rb.setPower(-1);
            lb.setPower(-1);
        }

        if (gamepad1.left_stick_y<0.25){
            lf.setPower(1);
            rf.setPower(1);
            rb.setPower(-1);
            lb.setPower(-1);

        }

        if (gamepad1.left_stick_x>0.25){
            lb.setPower(-1);
            lf.setPower(1);
            rf.setPower(-1);
            rb.setPower(1);

        }
        if (gamepad1.left_stick_x<0.25){
            lb.setPower(1);
            lf.setPower(-1);
            rf.setPower(1);
            rb.setPower(-1);
        }



        telemetry.addData("Left motor values",gamepad1.left_stick_y);
        telemetry.addData("Right motor values",gamepad1.right_stick_y);


    }

}
