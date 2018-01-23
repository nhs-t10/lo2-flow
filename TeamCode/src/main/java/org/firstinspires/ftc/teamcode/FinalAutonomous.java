package org.firstinspires.ftc.teamcode;

/*
 Created by Alex K on 1/2/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
@Autonomous(name = "Dismount")
@SuppressWarnings("unused")
public class FinalAutonomous extends AbstractSuper
{
    public void prepare()
    {

    }
    public void loop()
    {
        clamp(1,1);
        arm(1);
        //the next piece of code knocks off the blue ball (must be on red team)
        if (color.blue() > 90){
            driveFor(50);
            arm(0);
            driveFor(450);
        }
        else if (color.red() > 90) {
            driveFor(50,-1,-1)
            arm(0);
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
