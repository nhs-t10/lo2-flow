package NotUsed;

/*
 Created by Alex K on 1/2/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.AbstractSuper;

//@Autonomous(name = "Red Middle")
@SuppressWarnings("unused")
public class RedMiddle extends AbstractSuper
{
    int time = 0;
    public void prepare()
    {

    }
    public void loop()
    {
        /*arm(0.6);
        //the next piece of code knocks off the blue ball (must be on red team middle)
        if (color.red() > 20)
        {
            driveFor(700, 1, 1);
            arm(0);
            sideFor(100,-1);
            stop();
        }
        else
        {
            driveFor(50,-1,-1);
            arm(0);
            driveFor(200, 0, 0);
            sideFor(100, -1);
            driveFor(400,0, 0);
            stop();
        }*/

        if (time > 85)
        {
            drive(0, 0);
            clamp(0, 0);
            lift(0);
        }
            else
            {
                if (time > 80 && time < 85) {
                    drive(-1, -1);
                    clamp(0,0);
                    lift(0);
                }
                else
                {
                    if (time <5) {clamp(0,0.13);}
                    else
                    {
                        drive(1, 1);
                        clamp(0,0.13);
                        lift(0.15);
                    }
                }
            }


        time ++;

    }
    public void stop()
    {

    }
}
