package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@SuppressWarnings("all")
public abstract class AbstractSuper extends OpMode {
    public DcMotor lf, lb, rf, rb, l0, l1;
    public Servo l, r, colorArm, b2, b1, t1, t2;
    public ColorSensor color;

    @Override
    public void init() {
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        l0 = hardwareMap.dcMotor.get("l0");
        l1 = hardwareMap.dcMotor.get("l1");
        t1 = hardwareMap.servo.get("c0");
        t2 = hardwareMap.servo.get("c1");
        b1 = hardwareMap.servo.get("c2");
        b2 = hardwareMap.servo.get("c3");
        //colorArm = hardwareMap.servo.get("s4");
        //color = hardwareMap.colorSensor.get("color");
        rf.setDirection(DcMotorSimple.Direction.REVERSE);
        rb.setDirection(DcMotorSimple.Direction.REVERSE);
        l1.setDirection(DcMotorSimple.Direction.REVERSE);
        prepare();


    }

    public abstract void prepare();

    @SuppressWarnings("all")

    public void driveFor(long durationInMillis) {
        long timePassed = System.currentTimeMillis();
        while (System.currentTimeMillis() < timePassed + durationInMillis) {
            wheelSet(1, 1, 1, 1);
        }

        wheelSet(0, 0, 0, 0);
    }

    @SuppressWarnings("all")
    public void servoFor(long durationInMillis, double rServo, double lServo) {
        long timePassed = System.currentTimeMillis();
        while (System.currentTimeMillis() < timePassed + durationInMillis) {
            servoSet(lServo, rServo);
        }

        wheelSet(0, 0, 0, 0);
    }

    @SuppressWarnings("all")
    public void driveFor(long durationInMillis, double lPower, double rPower) {
        long timePassed = System.currentTimeMillis();
        while (System.currentTimeMillis() < timePassed + durationInMillis) {

        }


    }

    @SuppressWarnings("all")
    public void wheelSet(double lfPower, double rfPower, double lbPower, double rbPower) {
        lf.setPower(lfPower);
        lb.setPower(lbPower);
        rf.setPower(rfPower);
        rb.setPower(rbPower);
    }

    @SuppressWarnings("all")
    public void drive(double left, double right) {
        lf.setPower(left);
        lb.setPower(left);
        rf.setPower(right);
        rb.setPower(right);

    }

    public void side(double side) {
        lf.setPower(-side);
        lb.setPower(side);
        rf.setPower(side);
        rb.setPower(-side);
    }

    public void lift(double power) {
        l0.setPower(power);
        l1.setPower(power);
    }

    public void clamp(double top, double bottom)
    {
        t1.setPosition(Math.abs(top)); t2.setPosition(top);
        b1.setPosition(Math.abs(bottom)); b2.setPosition(bottom);
    }
    @SuppressWarnings("all")
    public void servoSet(double lMove, double rMove)
    {
        l.setPosition(lMove);
        r.setPosition(rMove);
    }


}
