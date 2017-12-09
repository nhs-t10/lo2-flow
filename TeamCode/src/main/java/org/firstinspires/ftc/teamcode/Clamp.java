package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


/**
 * Created by dvw25 on 11/21/17.
 */
//@TeleOp(name = "Clamp")
public class Clamp extends OpMode {
    private Servo squeeze;

    @Override
    public void init() {
        squeeze = hardwareMap.servo.get("s1");
        squeeze.setPosition(0);

        telemetry.addData("Message 1", "Servos declared! All Systems go!");
    }
    @Override
    public void loop(){
        double extention = gamepad1.right_stick_y;
        extention = Range.clip(extention,-1,1);
        extention = (double)scaleInput(extention);

        if(gamepad1.right_stick_y > 0.25){
            squeeze.setPosition(-extention);
        }
        if(gamepad1.right_stick_y < -0.25){
            squeeze.setPosition(-extention);
        }

    }
    public void stop(){
    }
    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.005, 0.009, 0.01, 0.02, 0.03, 0.07, 0.1,
                0.230, 0.336, 0.443, 0.550, 0.660, 0.772, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        // James Says: This code works just fine, except you could also use "scaleArray.length"
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }
        // return scaled value.
        return dScale;
    }

}
