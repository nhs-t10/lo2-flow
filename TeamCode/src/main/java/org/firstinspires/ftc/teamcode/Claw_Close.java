package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by dvw25 on 11/16/17.
 */

@TeleOp(name = "glyph arm claw")
public class Claw_Close  extends OpMode {
    private Servo claw;
    boolean toggle = false;
    @Override
    public void init() {
        claw = hardwareMap.servo.get("c1");
        telemetry.addData("Message 1", "Motors and servos declared! All Systems go!");
    }

    @Override
    public void loop(){

        if(gamepad1.y){
            if(toggle) {
                claw.setPosition(1);
                toggle = true;
            } else {
                claw.setPosition(0);
                toggle = false;
            }
        }
    }
}