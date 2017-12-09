package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
//@TeleOp(name = "Scaling Clamp")
@SuppressWarnings("unused")
public class Scaling_Block_Clamp extends OpMode {

    private Servo lc, rc;
    @Override
    public void init(){
        lc = hardwareMap.servo.get("s1");
        rc = hardwareMap.servo.get("s0");

        telemetry.addData("Ready", "Clamp Ready");
    }
    @Override
    public void loop(){
        double squeeze = gamepad1.right_trigger;

        squeeze = Range.clip(squeeze, 0, 1);

        if (squeeze >= 0 ){
            lc.setPosition(squeeze);
            rc.setPosition(Math.abs(squeeze-1));
        }
    }
    public void stop(){

    }
}
