package org.firstinspires.ftc.teamcode;

/*
 * Created by tripszewczak on 10/10/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
@Autonomous(name = "Auto")
@SuppressWarnings("all")
public class Auto extends AbstractSuper {


    @Override
    public void prepare()
    {
    }




    public void loop()
    {
        drivefor(250, forward,back );
    }

    public void stop() {

    }
}

