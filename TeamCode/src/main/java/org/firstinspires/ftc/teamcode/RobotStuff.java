package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Sasha-SriPlatformDismount")
@SuppressWarnings("unused")
public class RobotStuff extends LinearOpMode  {
    private DcMotor motor0, motor1;
    private void wheelSet(double a0, double a1, double a2, double a3) {
        motor0.setPower(a0);
        motor1.setPower(a1);

    }

    @Override
    public void runOpMode() {
        try {
            motor0 = hardwareMap.dcMotor.get("motor0");
            motor1 = hardwareMap.dcMotor.get("motor1");

            //lf.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
            //lb.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
            //rf.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
            //rb.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);

            motor0.setDirection(DcMotor.Direction.REVERSE);
            motor1.setDirection(DcMotor.Direction.REVERSE);
            waitForStart();
            //long timePass = System.currentTimeMillis();
            //if (time + 2 <= System.currentTimeMillis()){
            //    wheelSet(1,1,1,1);
            //}


            wheelSet(1, 1, 1, 1);
            wait(200);
            wheelSet(1,1,-1,-1);
            wait(100);
            wheelSet(.4,.4,.4,.4);
            wait(100);

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

