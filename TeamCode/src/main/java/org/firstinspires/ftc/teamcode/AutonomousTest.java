package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "test")
@SuppressWarnings("unused")
public class AutonomousTest extends LinearOpMode  {
    private DcMotor lf, lb, rf, rb;

    private void wheelSet(double a0, double a1, double a2, double a3) {
        lf.setPower(a0);
        lb.setPower(a1);
        rf.setPower(a2);
        rb.setPower(a3);
    }

    @Override
    public void runOpMode() {
        try {
            lf = hardwareMap.dcMotor.get("m0");
            lb = hardwareMap.dcMotor.get("m2");
            rf = hardwareMap.dcMotor.get("m1");
            rb = hardwareMap.dcMotor.get("m3");
            //lf.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
            //lb.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
            //rf.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
            //rb.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);

            lf.setDirection(DcMotor.Direction.REVERSE);
            lb.setDirection(DcMotor.Direction.REVERSE);
            waitForStart();
            //long timePass = System.currentTimeMillis();
            //if (time + 2 <= System.currentTimeMillis()){
            //    wheelSet(1,1,1,1);
            //}


            wheelSet(.5, .5, -.5, -.5);
            wait(200);
            wheelSet(0, 0, 0, 0);
           /* wait(4000);
            wheelSet(1, 1, -1, -1);
            wait(2000);
            wheelSet(0, 0, 0, 0);
           wait(4000);
            wheelSet(1, 1, -1, -1);
            wait(3000);
            wheelSet(0, 0, 0, 0);
            wait(4000);
            wheelSet(1, 1, -1, -1);
            wait(4000);
           wheelSet(0, 0, 0, 0);*/
        }
        catch(Exception e){
            System.err.println("Error handler:");
            e.printStackTrace();
            telemetry.addData("we have an exception","We have a problem " + e.getMessage());
        }
        finally{
            stop();
        }

    }

}
