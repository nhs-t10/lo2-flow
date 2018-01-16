package org.firstinspires.ftc.teamcode;

/*
 Created by tripszewczak on 1/12/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name = "NewTeleOp")
@SuppressWarnings("all")
public class NewTeleOp extends AbstractSuper
{
    public void prepare()
    {

    }
    public void loop()
    {
        double linear = gamepad1.left_stick_y;
        double rotation = gamepad1.left_stick_x;
        double side = gamepad1.right_stick_x;
        boolean up = gamepad1.right_bumper;
        boolean down = gamepad1.left_bumper;

        if (side == 0)
        {
            drive(linear - rotation, linear + rotation);
        }
        else if (up)
        {
            lift(0.5);
        }
        else if (down)
        {
            lift(-0.5);
        }
        else
        {
            side(side);
        }





    }







     public void stop()
     {


     }
}

