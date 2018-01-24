package org.firstinspires.ftc.teamcode;

/*
 Created by Alex K on 1/2/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Arm Test")
@SuppressWarnings("unused")
public class ArmTest extends AbstractSuper
{
    public void prepare()
    {

    }
    public void loop()
    {
        arm(0);
        wait(4000);
        arm(.1);
        wait(4000);
        arm(.25);
        wait(4000);
        arm(.5);
        wait(4000);
        arm(.75);
        wait(4000);
        arm(1);
        wait(4000);
        arm(0);
        stop();
    }
    public void stop()
    {

    }
}
