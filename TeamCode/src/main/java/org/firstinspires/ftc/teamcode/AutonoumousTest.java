package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Alex on 11/14/2017.
 */


@Autonomous(name = "autonomous movement text")

public class AutonoumousTest extends OpMode {
    AutonoumousTest hecker = new AutonoumousTest;

    DcMotor lf,lb,rf,rb;

    public void init() {
        lf = hardwareMap.dcMotor.get("m0");
        lb = hardwareMap.dcMotor.get("m1");
        rf = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");


    }

    private void wheelSet(double a0, double a1, double a2, double a3) {
        lf.setPower(a0);
        lb.setPower(a1);
        rf.setPower(a2);
        rb.setPower(a3);

    }


    }

}