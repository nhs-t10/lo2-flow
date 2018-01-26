package org.firstinspires.ftc.teamcode;

/*
 * Created by tripszewczak on 10/10/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.AbstractSuper;

@Autonomous(name = "Auto")
@SuppressWarnings("unused")
public class Auto extends AbstractSuper {



    @Override
    public void prepare(){

    }



    public void loop() {
        if (System.currentTimeMillis() > 0 && System.currentTimeMillis() < 300) {
            clamp(0, 0.13);
            driveFor(300, -1, -1);

            if (System.currentTimeMillis() > 310) {
                driveFor(0, 0, 0);
                clamp(0, 0);
            }


        }
    }
    public void stop() {

    }
}

