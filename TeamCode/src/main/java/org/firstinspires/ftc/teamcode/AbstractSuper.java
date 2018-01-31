package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


@SuppressWarnings("all")
public abstract class AbstractSuper extends OpMode {
    public DcMotor lf, lb, rf, rb;
    public Servo l, r, colorArm, b2, b1, t1, t2, a0, l0;
    public ColorSensor color;

    @Override
    public void init() {
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        l0 = hardwareMap.servo.get("l0");
        t1 = hardwareMap.servo.get("c0");
        t2 = hardwareMap.servo.get("c1");
        b1 = hardwareMap.servo.get("c2");
        b2 = hardwareMap.servo.get("c3");
        a0 = hardwareMap.servo.get("c4");
        color = hardwareMap.colorSensor.get("color");
        rf.setDirection(DcMotorSimple.Direction.REVERSE);
        rb.setDirection(DcMotorSimple.Direction.REVERSE);
        b1.setDirection(Servo.Direction.REVERSE);
        b2.setDirection(Servo.Direction.REVERSE);
        t1.setDirection(Servo.Direction.REVERSE);
        t2.setDirection(Servo.Direction.REVERSE);
        a0.setDirection((Servo.Direction.REVERSE));
        l0.setPosition(0);
        a0.setPosition(0);
        long time = 0;
        color.enableLed(true);
        prepare();



    }

    public abstract void prepare();

    @SuppressWarnings("all")


    public void clampFor(long durationInMillis, double top, double bottom)
    {
        long time = System.currentTimeMillis();
        if (System.currentTimeMillis() < time + durationInMillis)
        {
            b1.setPosition(bottom); b2.setPosition(bottom);
            t1.setPosition(top); t2.setPosition(top);
        }
        if (System.currentTimeMillis() >= time + durationInMillis)
        {
            b1.setPosition(0); b2.setPosition(0);
            t1.setPosition(0); t2.setPosition(0);
        }
    }

    @SuppressWarnings("all")
    public void driveFor(long durationInMillis, double left, double right) {
        time = System.currentTimeMillis();
        if (System.currentTimeMillis() < time + durationInMillis) {
            lf.setPower(-left);
            lb.setPower(-left);
            rf.setPower(-right);
            rb.setPower(-right);
        }
        if (System.currentTimeMillis() >= time + durationInMillis){
            lf.setPower(0);
            lb.setPower(0);
            rf.setPower(0);
            rb.setPower(0);
        }
    }

    @SuppressWarnings("all")


    public void drive(double left, double right)
    {
        lf.setPower(left);
        lb.setPower(left);
        rf.setPower(right);
        rb.setPower(right);

    }

    public void side(double side)
    {
        lf.setPower(-side);
        lb.setPower(side);
        rf.setPower(side);
        rb.setPower(-side);
    }

    public void sideFor(long durationInMillis, double side)
    {
        long time = System.currentTimeMillis();
        if (System.currentTimeMillis() < time + durationInMillis)
        {
            lf.setPower(-side);
            lb.setPower(side);
            rf.setPower(side);
            rb.setPower(-side);
        }
        if (System.currentTimeMillis() >= time + durationInMillis){
            lf.setPower(0);
            lb.setPower(0);
            rf.setPower(0);
            rb.setPower(0);
        }
    }

    public void lift(double positon)
    {
        l0.setPosition(positon);
    }

    public void lifthold()
    {
        l0.setPosition(l0.getPosition());
        a0.setPosition(a0.getPosition());
    }


    public void clamp(double top, double bottom)
    {
        t1.setPosition(Math.abs(top-1));
        t2.setPosition(top);
        b1.setPosition(Math.abs(bottom-1));
        b2.setPosition(bottom);
    }

    @SuppressWarnings("all")

    public void arm(double arm)
    {
        a0.setPosition(arm);
    }

}
