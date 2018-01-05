package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;



public abstract class AbstractSuper extends OpMode{
    public DcMotor lf, lb, rf, rb;
    public Servo l, r, colorArm, ll, lr, l1, l2, tl, tr;
    public ColorSensor color;
    public void init(){
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        ll = hardwareMap.servo.get("s1");
        lr = hardwareMap.servo.get("s0");
        l2 = hardwareMap.servo.get("s2");
        l1 = hardwareMap.servo.get("s3");
        colorArm = hardwareMap.servo.get("s4");
        color = hardwareMap.colorSensor.get("color");
    }
    @SuppressWarnings("all")

    public void driveFor(long durationInMillis){
        long timePassed = System.currentTimeMillis();
        while (System.currentTimeMillis()<timePassed + durationInMillis){
             wheelSet(1,1,1,1);
        }

        wheelSet(0,0,0,0);
    }
    @SuppressWarnings("all")
    public void driveFor(long durationInMillis, double rServo, double lServo){
        long timePassed = System.currentTimeMillis();
        while (System.currentTimeMillis()<timePassed + durationInMillis){
            servoSet(lServo,rServo);
        }

        wheelSet(0,0,0,0);
    }
    @SuppressWarnings("all")
    public void driveFor(long durationInMillis, double lfPower, double rfPower, double lbPower, double rbPower){
        long timePassed = System.currentTimeMillis();
        while (System.currentTimeMillis()<timePassed + durationInMillis){
            wheelSet(lfPower,rfPower,lbPower,rbPower);
        }

        wheelSet(0,0,0,0);
    }
    @SuppressWarnings("all")
    public void wheelSet(double lfPower, double rfPower, double lbPower, double rbPower){
        lf.setPower(lfPower);
        lb.setPower(lbPower);
        rf.setPower(rfPower);
        rb.setPower(rbPower);
    }
    @SuppressWarnings("all")

    public void servoSet(double lMove, double rMove){
        l.setPosition(lMove);
        r.setPosition(rMove);
    }


}
