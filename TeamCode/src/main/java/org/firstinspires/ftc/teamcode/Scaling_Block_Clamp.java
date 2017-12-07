package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
/**
 * Created by tripszewczak on 12/7/17.
 */
@TeleOp(name = "Scaling Clamp")
public class Scaling_Block_Clamp extends OpMode {

    public Servo lc, rc;
    @Override
    public void init(){
        lc = hardwareMap.servo.get("s0");
        rc = hardwareMap.servo.get("s1");

        telemetry.addData("Ready", "Clamp Ready");
    }
    @Override
    public void loop(){
        double squeeze = gamepad1.right_trigger;

        squeeze = Range.clip(squeeze, 0, 1);

        if (squeeze > 0 ){
            lc.setPosition(-squeeze);
            rc.setPosition(squeeze);
        }
        if (squeeze <= 0){
            lc.setPosition(0);
            rc.setPosition(0);
        }
    }
    public void stop(){

    }
}
