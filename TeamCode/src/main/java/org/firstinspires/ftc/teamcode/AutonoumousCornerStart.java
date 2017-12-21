package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "test2")
@SuppressWarnings("unused")
public class AutonoumousCornerStart extends LinearOpMode  {
    private DcMotor lf, lb, rf, rb;
    private Servo lc,rc;

    private void wheelSet(double lfPower, double lbPower, double rfPower, double rbPower) {
        lf.setPower(lfPower);
        lb.setPower(lbPower);
        rf.setPower(rfPower);
        rb.setPower(rbPower);
    }
    private void wheelSet(){

    }

    private void servoSet(double b0,double b1){
        lc.setPosition(b0);
        rc.setPosition(b1);
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


            wheelSet(1, 1, 1, 1);
            waitFor(200);
            wheelSet(1,1,-1,-1);
            waitFor(100);
            wheelSet(.4,.4,.4,.4);
            waitFor(100);

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
    private static void waitFor(long durationInMillis){
        long waitTime = System.currentTimeMillis() +durationInMillis;
        while (waitTime > System.currentTimeMillis()){

        }
    }


}

