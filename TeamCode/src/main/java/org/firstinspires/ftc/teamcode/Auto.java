package org.firstinspires.ftc.teamcode;

/*
 * Created by tripszewczak on 10/10/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
@Autonomous(name = "Auto")
@SuppressWarnings("unused")
public class Auto extends AbstractSuper {
    private int timecount = 0;
    int time = 0;


    @Override
    public void prepare()
    {
    }




    public void loop() {
        if (time > 75) {
            drive(0, 0);
        }else{
            drive(1, 1);

        }
           time ++;












    }





    public void stop() {

    }
}

