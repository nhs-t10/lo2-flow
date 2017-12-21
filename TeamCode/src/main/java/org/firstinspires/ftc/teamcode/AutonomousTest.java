package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "CentralPlatformDismount")
@SuppressWarnings("unused")
public class AutonomousTest extends LinearOpMode  {
    private DcMotor lf, lb, rf, rb;
    private Servo l,r;

    private void wheelSet(double lfPower, double lbPower, double rfPower, double rbPower) {
        lf.setPower(lfPower);
        lb.setPower(lbPower);
        rf.setPower(rfPower);
        rb.setPower(rbPower);
    }//overloaded method to make things easier for me
    private void wheelSet(double lfPower, double lbPower, double rfPower, double rbPower, double lPower, double rPower ){
        lf.setPower(lfPower);
        lb.setPower(lbPower);
        rf.setPower(rfPower);
        rb.setPower(rbPower);
        l.setPosition(lPower);
        r.setPosition(rPower);
    }

    private void servoSet(double lPower, double rPower ){
        l.setPosition(lPower);
        r.setPosition(rPower);
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
            waitFor(200);
            wheelSet(0, 0, 0, 0);

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

    private static void waitFor(int durationInMillis) {
        long waitTime = System.currentTimeMillis() + durationInMillis;
        while (System.currentTimeMillis() < waitTime) {
            // do nothing just wait
        }

    }
}
