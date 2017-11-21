/**

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by dvw25 on 10/24/17.



@TeleOp(name = "glyph arm")
public class Glyphs extends OpMode {

    private DcMotor lift1,lift2;

    @Override
    public void init() {
        lift1 = hardwareMap.dcMotor.get("l1");
        lift2 = hardwareMap.dcMotor.get("l2");
        lift3 = hardwareMap.dcMotor.get("l3");

        telemetry.addData("Message 1", "Motors and servos declared! All Systems go!");
    }

    @Override
    public void loop(){
        if(gamepad1.right_trigger > 0){
            lift1.setPower(gamepad1.right_trigger);
            lift2.setPower(-gamepad1.right_trigger);
            //up
        }
        if(gamepad1.right_bumper = true){
            lift1.setPower(-1);
            lift2.setPower(1);
            //down
        }else{
            lift1.setPower(0);
            lift2.setPower(0);
            //stop
        }
        //this is for the up and down of the program.
        //If they follow the plan it will have two motors and one needs to be opposite the other
        //They will have a chain connecting the two mototrs to make it go up and down

        if(gamepad1.left_trigger > 0){
            lift3.setPower(gamepad1.right_trigger);
            //forward
        }else{
            lift3.setPower(0);
            //stop
        }
        if(gamepad1.left_bumper = true){
            lift3.setPower(-1);
            //backward
        }
        //this is for the "forward and backward" of the program
        //The button layout is set up so the "forward and backward" is on the right
        //and the up and down on the left.
    }

}
*
*/