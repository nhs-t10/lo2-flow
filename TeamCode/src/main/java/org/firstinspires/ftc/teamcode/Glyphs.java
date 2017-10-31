package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by dvw25 on 10/24/17.
 */

public class Glyphs extends OpMode {

    private DcMotor lift1,lift2;

    @Override
    public void init() {
        lift1 = hardwareMap.dcMotor.get("gl1");
        lift2 = hardwareMap.dcMotor.get("l2");

        telemetry.addData("Message 1", "Motors and servos declared! All Systems go!");
    }

    @Override
    public void loop(){
        if(gamepad1.right_trigger > 0){
            lift1.setPower(1);
        }
        if(gamepad1.left_trigger > 0){
            lift1.setPower(-1);
        }else{
            lift1.setPower(0);
        }

        if(gamepad1.left_bumper = true){
            lift2.setPower(-1);
        }
        if(gamepad1.right_bumper = true){
            lift2.setPower(1);
        }else{
            lift2.setPower(0);
        }

    }

}
