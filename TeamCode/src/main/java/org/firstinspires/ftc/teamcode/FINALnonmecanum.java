
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by tripszewczak on 10/5/17.
 */
@TeleOp(name = "FINALnonmecanum")
public class FINALnonmecanum extends OpMode {
    DcMotor lf, rf, lb, rb;


    @Override
    public void init(){
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");

        telemetry.addData("Message 1", "Motors and Servos Declared! All Systems go!");
    }

    @Override
    public void loop(){
        double forward = gamepad1.left_stick_y;
        double turning = gamepad1.left_stick_x;

        forward = Range.clip(forward,-1,1);
        turning = Range.clip(turning,-1,1);


        forward = (double)scaleInput(forward);
        turning = (double)scaleInput(turning);

        if (forward>0.25){

            lf.setPower(forward);
            rf.setPower(forward);
            rb.setPower(forward);
            lb.setPower(forward);
        }


        if (forward<-0.25){

            lf.setPower(forward);
            rf.setPower(forward);
            rb.setPower(forward);
            lb.setPower(forward);

        }


        if (turning>0.25){

            lb.setPower(turning);
            lf.setPower(turning);
            rf.setPower(-turning);
            rb.setPower(-turning);

        }

        if (turning<-0.25) {

            lb.setPower(-turning);
            lf.setPower(-turning);
            rf.setPower(turning);
            rb.setPower(turning);
        }


        if ((turning>-0.25 && turning<0.25) || (forward>-0.25 && forward<0.25)) {
            lb.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);
        }



        telemetry.addData("Left motor values",forward);
        telemetry.addData("Right motor values",turning);

    }

    @Override
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
