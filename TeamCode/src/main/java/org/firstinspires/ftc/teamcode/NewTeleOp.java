package org.firstinspires.ftc.teamcode;

/*
 Created by tripszewczak on 1/12/18.
 */
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name = "NewTeleOp")
public class NewTeleOp extends AbstractSuper{
    public void init(){

    }
    public void prepare(){

    }
    public void loop(){
        double right = gamepad1.left_stick_y;
        double left = -(gamepad1.left_stick_y);
    }
    public void stop(){

    }
}

