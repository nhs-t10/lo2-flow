package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@SuppressWarnings("all")
public abstract class minibotmecsuper extends OpMode {
    public DcMotor lf, lb, rf, rb;



    @Override
    public void init()
    {
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");

        rf.setDirection(DcMotorSimple.Direction.REVERSE);
        rb.setDirection(DcMotorSimple.Direction.REVERSE);

        prepare();
        /**defining motors*/

    }

    public abstract void prepare();

    public void drive(double left, double right)
    {
        lf.setPower(left);
        lb.setPower(left);
        rf.setPower(right);
        rb.setPower(right);

    }
    /**power to wheels*/


    public void side(double side)
    {
        lf.setPower(-side);
        lb.setPower(side);
        rf.setPower(side);
        rb.setPower(-side);
    }
    /**mecanum capabiliy*/
}
