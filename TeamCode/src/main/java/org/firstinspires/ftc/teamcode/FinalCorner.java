package org.firstinspires.ftc.teamcode;

/*
 Created by Alex K on 1/2/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Dismount")
@SuppressWarnings("unused")
public class FinalCorner extends AbstractSuper
{
    public void prepare()
    {

    }
    public void loop()
    {
        clamp(0,1);
        arm(1);
        //the next piece of code knocks off the blue ball (must be on red team corner)
        if (color.blue() > 90)
        {
            driveFor(50);
            arm(0);
            driveFor(100);
            SideFor(500,1);
            driveFor(400, 1 ,-1);
            driveFor(600);
        }
        else if (color.red() > 90)
        {
            driveFor(50,-1,-1);
            arm(0);
            driveFor(200);
            SideFor(500,1);
            driveFor(400, 1,-1);
            driveFor(600);
        }
        clamp(0, 0);
        driveFor(50, -1, -1);
        stop();
    }
    public void stop()
    {

    }
}
