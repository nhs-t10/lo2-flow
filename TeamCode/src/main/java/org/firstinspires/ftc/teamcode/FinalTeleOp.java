package org.firstinspires.ftc.teamcode;

/*
 Created by tripszewczak on 1/12/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
@SuppressWarnings("all")
@TeleOp(name = "FinalTeleOp")
public class FinalTeleOp extends AbstractSuper
{

    public void prepare()
    {
    }
    public void loop() {
        double linear = gamepad1.left_stick_y;
        double rotation = gamepad1.left_stick_x;
        double side = gamepad1.right_stick_x;
        boolean up = gamepad1.right_bumper;
        boolean down = gamepad1.left_bumper;
        double top = gamepad1.right_trigger;
        double bottom = gamepad1.left_trigger;
        boolean B = gamepad1.b;
        lifthold();
        top = Range.clip(top, 0, 0.13);
        bottom = Range.clip(bottom, 0, 0.13);


        if (side == 0) {
            drive(.75*(linear - rotation), .75*(linear + rotation));
        } else {
            side(.75*side);
        }

        if (up)
        {
            lift(0.15);
        }

        if (B)
        {
            lift(0.35);
        }

        if (down) { lift(-0.1); }

        //if ((down == false) && (up == false)) {lift(0);}

        if (top >= 0 || bottom >= 0) {clamp(top, bottom);}

/*for touch sensor, remenber to include if (sensor)
              {
              setPower(0);
*/
    }
     public void stop() {}
}

