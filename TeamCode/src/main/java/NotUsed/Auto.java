package NotUsed;

/*
 * Created by tripszewczak on 10/10/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.AbstractSuper;

//@Autonomous(name = "Auto")
@SuppressWarnings("all")
public class Auto extends AbstractSuper {


    @Override
    public void prepare()
    {
    }




    public void loop()
    {
        drivefor(100, forwardA,forwardA );
    }

    public void stop() {

    }
}

