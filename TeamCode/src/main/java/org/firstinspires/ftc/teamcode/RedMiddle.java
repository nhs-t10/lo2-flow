package org.firstinspires.ftc.teamcode;

/*
 Created by Alex K on 1/2/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Red Middle")
@SuppressWarnings("unused")
public class RedMiddle extends AbstractSuper {
    public void prepare()
    {

    }
    public void loop()
    {
        arm(0.6);
        //the next piece of code knocks off the blue ball (must be on red team middle)
        if (color.blue() > color.red())
        {
            drivefor(1000, forwardA, forwardA);
            arm(0);
            stop();
        }
        else
        {
            if (color.red() < color.blue())
            {
                drivefor(1000, backA, backA);
                arm(0);
                stop();
            }
        }

    }
    public void stop()
    {

    }
}
