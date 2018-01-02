package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public abstract class AbstractSuper extends OpMode{
    public DcMotor lf, lb, rf, rb;
    public Servo l, r, colorArm;
    public ColorSensor color;
    public void init(){
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        l = hardwareMap.servo.get("s0");
        r = hardwareMap.servo.get("s1");
        colorArm = hardwareMap.servo.get("s4");
        color = hardwareMap.colorSensor.get("color");
    }

    public void driveFor(long durationInMillis){
        long timePassed = System.currentTimeMillis();
        while (System.currentTimeMillis()<timePassed + durationInMillis){
             wheelSet(1,1,1,1);
        }

        wheelSet(0,0,0,0);
    }
    public void driveFor(long durationInMillis, double rServo, double lServo){
        long timePassed = System.currentTimeMillis();
        while (System.currentTimeMillis()<timePassed + durationInMillis){
            servoSet(lServo,rServo);
        }

        wheelSet(0,0,0,0);
    }
    public void driveFor(long durationInMillis, double lfPower, double rfPower, double lbPower, double rbPower){
        long timePassed = System.currentTimeMillis();
        while (System.currentTimeMillis()<timePassed + durationInMillis){
            wheelSet(lfPower,rfPower,lbPower,rbPower);
        }

        wheelSet(0,0,0,0);
    }
    public void wheelSet(double lfPower, double rfPower, double lbPower, double rbPower){
        lf.setPower(lfPower);
        lb.setPower(lbPower);
        rf.setPower(rfPower);
        rb.setPower(rbPower);
    }

    public void servoSet(double lMove, double rMove){
        l.setPosition(lMove);
        r.setPosition(rMove);
    }

}
