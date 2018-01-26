package NotUsed;

/*
 Created by Alex K on 1/2/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.AbstractSuper;

//@Autonomous(name = "Red Corner")
@SuppressWarnings("unused")
public class RedCorner extends AbstractSuper
{
    public void prepare()
    {

    }
    public void loop()
    {
        clamp(0,.13);
        arm(.65);
        //the next piece of code knocks off the blue ball (must be on red team corner)
        if (color.red() > 20)
        {
            driveFor(50, -1, -1);
            arm(0);
            driveFor(100, 0, 0);
            sideFor(500,1);
            driveFor(400, 1 ,-1);
            driveFor(600, 1, 1);
        }
        else if (color.blue() > 20)
        {
            driveFor(50,1,1);
            arm(0);
            driveFor(200, 0, 0);
            sideFor(500,1);
            driveFor(400, 1,-1);
            driveFor(600, 0 , 0);
        }
        clamp(0, 0);
        driveFor(50, -1, -1);
        stop();
    }
    public void stop()
    {

    }
}
