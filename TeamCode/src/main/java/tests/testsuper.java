package tests;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Timer;


@SuppressWarnings("all")
public abstract class testsuper extends OpMode {
    public DcMotor extend, spin;
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
        spin = hardwareMap.dcMotor.get("m0");
        extend = hardwareMap.dcMotor.get("m1");
        /*l0 = hardwareMap.servo.get("l0");
        t1 = hardwareMap.servo.get("c0");
        t2 = hardwareMap.servo.get("c1");
        b1 = hardwareMap.servo.get("c2");
        b2 = hardwareMap.servo.get("c3");
        a0 = hardwareMap.servo.get("c4");

        color = hardwareMap.colorSensor.get("color");

        b1.setDirection(Servo.Direction.REVERSE);
        b2.setDirection(Servo.Direction.REVERSE);
        t1.setDirection(Servo.Direction.REVERSE);
        t2.setDirection(Servo.Direction.REVERSE);
        a0.setDirection((Servo.Direction.REVERSE));
        l0.setPosition(0);
        a0.setPosition(0);
        color.enableLed(true);*/
        prepare();


    }

    public abstract void prepare();

    /*public void drive(double left, double right) {
        lf.setPower(left);
        lb.setPower(left);
        rf.setPower(right);
        rb.setPower(right);

    }

    private final double setInterval() {
        if (interval <= 1.0)
            timer.cancel();
        return --interval;
        //telemetry.addData("Interval: " , String.valueOf(interval));
    }

*/
    public void extend(double right, double left)
    {
        extend.setPower(right);
        extend.setPower(-left);
    }

    public void spin(double ls, double rs)
    {
        spin.setPower(ls); spin.setPower(rs);
    }

    public void clamp(double top, double bottom)
    {
        t1.setPosition(Math.abs(top - 1));
        t2.setPosition(top);
        b1.setPosition(Math.abs(bottom - 1));
        b2.setPosition(bottom);
    }


    /*public void lift(double positon) {
        l0.setPosition(positon);
    }*/
}
