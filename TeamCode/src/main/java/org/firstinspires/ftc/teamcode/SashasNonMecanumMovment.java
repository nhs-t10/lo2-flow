package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


@TeleOp(name = "MotorTest")
@SuppressWarnings("unused")
public class SashasNonMecanumMovment extends OpMode {
    public static final double POWER = .25;
    private DcMotor leftMotor, rightMotor;

    @Override
    public void init(){
        leftMotor = hardwareMap.dcMotor.get("motor0");
        rightMotor = hardwareMap.dcMotor.get("motor1");
    }

    @Override
    public void loop(){
        double x = gamepad1.left_stick_x;
        double y = gamepad1.left_stick_y;
        if(x>-.25 && x<.25){
            leftMotor.setPower(y);
            rightMotor.setPower(y);
        }
        if(x>.25){
            leftMotor.setPower(-y);
            rightMotor.setPower(y);
        }
        if(x<-.25){
            leftMotor.setPower(y);
            rightMotor.setPower(-y);
        }

        if(gamepad1.right_trigger>.1){
            leftMotor.setPower(0);
            rightMotor.setPower(0);
        }

    }



}
