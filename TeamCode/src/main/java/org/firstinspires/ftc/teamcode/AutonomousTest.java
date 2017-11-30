package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.util.Range;


@Autonomous(name = "autonomous movement test ")

public class AutonomousTest extends LinearOpMode  {
    private AutonomousTest  heck = new AutonomousTest();
    private DcMotor lf, lb, rf, rb;

    private void wheelSet(double a0, double a1, double a2, double a3) {
        lf.setPower(a0);
        lb.setPower(a1);
        rf.setPower(a2);
        rb.setPower(a3);
    }

    @Override public synchronized void waitForStart(){
        super.waitForStart();
    }

     public void runOpMode() throws InterruptedException {
         lf = hardwareMap.dcMotor.get("m0");
         lb = hardwareMap.dcMotor.get("m1");
         rf = hardwareMap.dcMotor.get("m2");
         rb = hardwareMap.dcMotor.get("m3");
         //lf.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
         //lb.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
         //rf.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
         //rb.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
         long timeSpent = System.currentTimeMillis();

         lf.setDirection(DcMotor.Direction.REVERSE);
         lb.setDirection(DcMotor.Direction.REVERSE);
         waitForStart();
         sleep(5000);
         wheelSet(1, 1, -1, -1);
         sleep(1000);
         wheelSet(0, 0, 0, 0);
         sleep(4000);
         wheelSet(1, 1, -1, -1);
         sleep(2000);
         wheelSet(0, 0, 0, 0);
         sleep(4000);
         wheelSet(1, 1, -1, -1);
         sleep(3000);
         wheelSet(0, 0, 0, 0);
         sleep(4000);
         wheelSet(1, 1, -1, -1);
         sleep(4000);
         wheelSet(0, 0, 0, 0);
     }
}
