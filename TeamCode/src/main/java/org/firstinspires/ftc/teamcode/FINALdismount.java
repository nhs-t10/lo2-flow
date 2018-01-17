package org.firstinspires.ftc.teamcode;

/*
 Created by Alex K on 1/2/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
@Autonomous(name = "Dismount")
@SuppressWarnings("unused")
public class FINALdismount extends AbstractSuper
{
    public void prepare()
    {

    }
    public void loop()
    {
        clamp(1,1);
        driveFor(500);
        clamp(0,0);
        driveFor(50,-1,-1)
        stop();
    }
    public void stop()
    {

    }
}
