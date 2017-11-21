package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by dvw25 on 11/21/17.
 */
@TeleOp(name = "Clamp")
public class Clamp extends OpMode {
    private Servo squeeze;
    double x = 0;

    @Override
    public void init() {
        squeeze = hardwareMap.servo.get("s1");
        squeeze.setPosition(x);

        telemetry.addData("Message 1", "Servos declared! All Systems go!");
    }
    @Override
    public void loop(){


        if(gamepad1.right_stick_y > 0){
            x = x + .1;
            squeeze.setPosition(x);
        }
        if(gamepad1.right_stick_y < 0){
            x = x - .1;
            squeeze.setPosition(x);
        }

    }

}
