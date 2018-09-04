package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import java.util.Timer;
import java.util.TimerTask;


@SuppressWarnings("all")
public abstract class AbstractSuper extends OpMode {
    public DcMotor lf, lb, rf, rb;
    public Servo l, r, colorArm, b2, b1, t1, t2, a0, l0;
    public ColorSensor color;
    //private long time = System.currentTimeMillis();
    public double forwardA = -1;
    public double backA = 1;
    public double leftA = -1;
    public double rightA = 1;
    private Timer timer;
    private double interval;
    double time = 0;


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
        color.enableLed(true);
        prepare();


    }

    public abstract void prepare();

    public void drive(double left, double right) {
        lf.setPower(left);
        lb.setPower(left);
        rf.setPower(right);
        rb.setPower(right);

    }

    /*public void drivefor(double driveduration, final double left, final double right)
    {
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = driveduration;
        System.out.println(driveduration);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                drive(left, right);

            }
        }, delay, period);

    }*/
    /*public void drivefor(double driveduration, double left, double right)
    {
        if (time >= driveduration)

        {
            drive(0, 0);
        }
        else
        {
            drive(left, right);
            time++;
        }

    }*/


    private final double setInterval() {
        if (interval <= 1.0)
            timer.cancel();
        return --interval;
        //telemetry.addData("Interval: " , String.valueOf(interval));
    }

    public void side(double side)
    {
        lf.setPower(-side);
        lb.setPower(side);
        rf.setPower(side);
        rb.setPower(-side);
    }
    /*public void sidefor(double sideduration, double direction)
    {
        final double sideendtime = time + sideduration;
        while (time <= sideendtime)
        {
            side(direction);
        }
        side(0);

    }*/


    public void clamp(double top, double bottom)
    {
        t1.setPosition(Math.abs(top-1));
        t2.setPosition(top);
        b1.setPosition(Math.abs(bottom-1));
        b2.setPosition(bottom);
    }
    /*public void clampfor(double clampduration)
    {
        final double clampendtime = time + clampduration;
        while (time <= clampendtime)
        {
            clamp(0.13, 0.13);
        }
        clamp(0, 0);
    }
    public void liftfor(double liftduration)
    {
        final double liftendtime = time + liftduration;
        while (time <= liftendtime)
        {
            lift(0.15);
        }
        lift(-0.1);
    }*/


    public void lift(double positon)
    {
        l0.setPosition(positon);
    }

    public void lifthold()
    {
        l0.setPosition(l0.getPosition());
        a0.setPosition(a0.getPosition());
    }




    @SuppressWarnings("all")

    public void arm(double arm)
    {
        a0.setPosition(arm);
    }


}
