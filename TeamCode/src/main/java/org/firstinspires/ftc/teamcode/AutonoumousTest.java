package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Alex on 11/14/2017.
 */


@Autonomous(name = "autonomous movement text")

public class AutonoumousTest extends LinearOpMode {
    AutonoumousTest hecker = new AutonoumousTest();

    DcMotor lf, lb, rf, rb;



    @Override public synchronized void waitForStart(){
        super.waitForStart();
    }


    private void wheelSet(double a0, double a1, double a2, double a3) {
        lf.setPower(a0);
        lb.setPower(a1);
        rf.setPower(a2);
        rb.setPower(a3);
    }
     public void main(){
        lf = hardwareMap.dcMotor.get("m0");
        lb = hardwareMap.dcMotor.get("m1");
        rf = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        //lf.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        //lb.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        //rf.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        //rb.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
        lf.setDirection(DcMotor.Direction.REVERSE);
        lb.setDirection(DcMotor.Direction.REVERSE);

    }
    hecker.waitForStart();





}