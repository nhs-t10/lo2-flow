package tests;

/*
 Created by tripszewczak on 1/12/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.AbstractSuper;

@SuppressWarnings("all")
@TeleOp(name = "FinalTeleOp")
public class test extends testsuper
{

    public void prepare()
    {


    }
    public void loop() {
        //double linear = gamepad1.left_stick_y;
        //double rotation = gamepad1.left_stick_x;
        //double side = gamepad1.right_stick_x;
        //boolean extend = gamepad1.right_bumper;
        //boolean down = gamepad1.left_bumper;
        /*double top = gamepad1.left_trigger;
        double bottom = gamepad1.right_trigger;*/

        double in = gamepad1.left_trigger;
        double out = gamepad1.right_trigger;

        boolean leftspin = gamepad1.dpad_left;
        boolean rightspin = gamepad1.dpad_right;
        double ls = 0;
        double rs = 0;
        //boolean B = gamepad1.b;


        if (out > 0)
        {
            extend(out, 0);
        }
        if (in > 0)
        {
            extend(0, in);
        }

        if (leftspin)
        {
            ls = 0.6;
        }
        if (rightspin)
        {
            rs = -0.6;
        }


        /*top = Range.clip(top, 0, 0.13);
        //bottom = Range.clip(bottom, 0, 0.13);

        if (side == 0) {
            drive(.7*(linear - rotation), .7*(linear + rotation));
        } else {
            side(.7*side);
        }

        if (up)
        {
            lift(0.15);
        }

        if (B)
        {
            lift(0.35);
        }

        if (down)
        {
            lift(-0.1);
        }

        //if ((down == false) && (up == false)) {lift(0);}


        if (top >= 0 || bottom >= 0) {clamp(top, bottom);}

/*for touch sensor, remenber to include if (sensor)
              {
              setPower(0);
*/
    }
     public void stop() {}
}

