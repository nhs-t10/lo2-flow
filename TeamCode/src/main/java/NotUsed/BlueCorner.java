package NotUsed;

/*
 Created by Alex K on 1/2/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.AbstractSuper;

@Autonomous(name = "Blue Corner")
@SuppressWarnings("unused")
public class BlueCorner extends AbstractSuper
{
    public void prepare()
    {

    }
    public void loop()
    {
        clamp(0,.13);
        arm(.65);
        //the next piece of code knocks off the red ball (must be on Blue team middle)
        if (color.blue() > 20)
        {
            driveFor(50, -1, -1);
            arm(0);
            driveFor(200,-1,-1);
            driveFor(200,-1,1);
            driveFor(400, 0, 0);
        }
        else if (color.red() > 20)
        {
            driveFor(50,1,1);
            arm(0);
            driveFor(100,-1,-1);
            driveFor(200,-1,1);
            driveFor(400, 0, 0);
        }
        clamp(0, 0);
        driveFor(50, -1, -1);
        stop();
    }
    public void stop()
    {

    }
}
