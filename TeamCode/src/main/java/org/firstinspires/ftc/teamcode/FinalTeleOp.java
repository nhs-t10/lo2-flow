package org.firstinspires.ftc.teamcode;

/*
 Created by tripszewczak on 1/12/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "FinalTeleOp")
@SuppressWarnings("all")
public class FinalTeleOp extends AbstractSuper
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
        double top = gamepad1.right_trigger;
        double bottom = gamepad1.left_trigger;
        top = Range.clip(top, 0, 0.5);
        bottom = Range.clip(bottom, 0, 0.5);
        lifthold();

        if (side == 0)
        {
            drive(linear - rotation, linear + rotation);
        }
        else
        {
            side(side);
        }



        if (up)
        {
            lift(1);
        }

        if (down)
        {
            lift(-1);
        }
        if (top >= 0 || bottom >= 0)
        {
            clamp(top, bottom);
        }
/*for touch sensor, remenber to include if (sensor)
              {
              setPower(0);
*/

    }







     public void stop()
     {


     }
}

