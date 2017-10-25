
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by tripszewczak on 10/5/17.
 */
@TeleOp(name = "FourMotorMecanum")
public class FourMotorMecanum extends OpMode {
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
        double turning = gamepad1.right_stick_x;
        double side = gamepad1.left_stick_x;

        forward = Range.clip(forward,-1,1);
        turning = Range.clip(turning,-1,1);
        side = Range.clip(side,-1,1);


        forward = (double)scaleInput(forward);
        turning = (double)scaleInput(turning);
        side = (double)scaleInput(side);

        if (forward>0.25 || forward<0.25){

            lf.setPower(forward);
            rf.setPower(-forward);
            rb.setPower(-forward);
            lb.setPower(-forward);
        }
        if (turning>0.25 || turning<-0.25){

            lb.setPower(turning);
            lf.setPower(-turning);
            rf.setPower(-turning);
            rb.setPower(-turning);

        }
        if (side>0.25 || side<-0.25) {
            lb.setPower(side);
            lf.setPower(side);
            rf.setPower(side);
            rb.setPower(side);

        }
        if (side>0.3 && forward>0.3) {
            rf.setPower(-forward);
            lb.setPower(-forward);
        }
        if (side<-0.3 && forward<-0.3) {
            rf.setPower(-forward);
            lb.setPower(-forward);
        }
        if (side>0.3 && forward<-0.3) {
            rf.setPower(-forward);
            lb.setPower(-forward);
        }
        if (side<-0.3 && forward>0.3) {
            rf.setPower(-forward);
            lb.setPower(-forward);
        }



        if ((side>-0.25 && side<0.25) || (forward>-0.25 && forward<0.25 || ((turning>-0.25 && turning<0.25)))) {
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
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

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
