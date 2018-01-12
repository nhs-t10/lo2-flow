package org.firstinspires.ftc.teamcode;

/*
 Created by tripszewczak on 1/12/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name = "NewTeleOp")
@SuppressWarnings("all")
public class NewTeleOp extends AbstractSuper{
    public void init(){

    }
    public void prepare(){

    }
    public void loop() {
        double linear = gamepad1.left_stick_y;
        double rotation = gamepad1.left_stick_x;
        drive(linear + rotation, linear - rotation);
    }


     public void stop(){



    }
}

