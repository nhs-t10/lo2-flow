package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by dvw25 on 11/21/17.
 */
@TeleOp(name = "GM")
public class GeniusMachine extends OpMode{
    private DcMotor GM;

    @Override
    public void init() {
        GM = hardwareMap.dcMotor.get("g1");

        telemetry.addData("Message 1", "Servos declared! All Systems go!");
    }
    @Override
    public void loop(){
        if(gamepad1.right_trigger > 0){
            GM.setPower(1);
        }if(gamepad1.left_trigger > 0){
            GM.setPower(-1);
        }else{
            GM.setPower(0);
        }



    }
}
