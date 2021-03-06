package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@SuppressWarnings("all")
public abstract class minibotsuper extends OpMode {
    public DcMotor lf, lb, rf, rb;



    @Override
    public void init()
    {
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");


        //rf.setDirection(DcMotorSimple.Direction.REVERSE);
        //rb.setDirection(DcMotorSimple.Direction.REVERSE);

        prepare();
        /**defining motors*/

    }

    public abstract void prepare();

    public void drive(double left, double right)
    {
        lf.setPower(left);
        rf.setPower(right);

    }
    /**power to wheels*/
}
