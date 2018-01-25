package org.firstinspires.ftc.teamcode;

/*
 Created by Alex K on 1/2/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Arm Test 2")
@SuppressWarnings("unused")
public class ArmTest2 extends AbstractSuper
{
    public void prepare()
    {

    }
    public void loop()
    {
        arm(0);
        WaitFor(4000);
        arm(.1);
        WaitFor(4000);
        arm(.25);
        WaitFor(4000);
        arm(.5);
        WaitFor(4000);
        arm(.75);
        WaitFor(4000);
        arm(1);
        WaitFor(4000);
        arm(0);
        WaitFor(4000);
        arm(-.1);
        WaitFor(4000);
        arm(-.25);
        WaitFor(4000);
        arm(-.5);
        WaitFor(4000);
        arm(0);
        stop();
    }
    public void stop()
    {

    }
}