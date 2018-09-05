package org.firstinspires.ftc.teamcode;

/*
 Created by tripszewczak on 1/12/18
 */

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@SuppressWarnings("all")
@TeleOp(name = "MiniBotMecanum")

public class minibotsmec extends minibotmecsuper {

    public void prepare()
    {
    }
    public void loop()
    {
        double linear = gamepad1.left_stick_y;
        double rotation = gamepad1.left_stick_x;
        double side = gamepad1.right_stick_x;


        if (side == 0) {
            drive(.7*(linear - rotation), .7*(linear + rotation));
        } else {
            side(.7*side);
        }
    }
    public void stop()
    {
    }

}
