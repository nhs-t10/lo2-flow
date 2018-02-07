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
            drivefor(50, -1, -1);
            arm(0);
            drivefor(100, 0, 0);
            //sideFor(500,1);
            drivefor(400, 1 ,-1);
            drivefor(600, 1, 1);
        }
        else if (color.blue() > 20)
        {
            drivefor(50,1,1);
            arm(0);
            drivefor(200, 0, 0);
            //sideFor(500,1);
            drivefor(400, 1,-1);
            drivefor(600, 0 , 0);
        }
        clamp(0, 0);
        drivefor(50, -1, -1);
        stop();
    }
    public void stop()
    {

    }
}
