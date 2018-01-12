package org.firstinspires.ftc.teamcode;

/*
 Created by tripszewczak on 1/12/18.
 */

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name = "NewTeleOp") @SuppressWarnings("all")
public class NewTeleOp extends AbstractSuper{
    public void init(){

    }
    public void prepare(){

    }
    public void loop(){
        double regular = gamepad1.left_stick_y;
        double inverse = -(gamepad1.left_stick_y);
        double turn = gamepad1.left_stick_x;
        lb.setPower(regular);lb.setPower(turn);
        lf.setPower(regular);lf.setPower(turn);
        rf.setPower(inverse);rf.setPower(turn);
        rb.setPower(inverse);rb.setPower(turn);

        if ((regular < 0.25 && regular > -0.25)|| (inverse > 0.25 && inverse < -0.25) || (turn < 0.25 && turn > -0.25)) {
            lf.setPower(0);
            lb.setPower(0);
            rf.setPower(0);
            rb.setPower(0);
        }

    }
    public void stop(){

    }
}

