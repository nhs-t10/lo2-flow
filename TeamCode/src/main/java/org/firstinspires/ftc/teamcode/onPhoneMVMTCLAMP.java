
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/*
 * Created by tripszewczak on 10/5/17.
 */
@TeleOp(name = "FINALteleOp")
@SuppressWarnings("unused")
public class onPhoneMVMTCLAMP extends OpMode {
    private DcMotor lf, rf, lb, rb;
    private Servo lc, rc, l2, l1;

    @Override
    public void init(){
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        lc = hardwareMap.servo.get("s1");
        rc = hardwareMap.servo.get("s0");
        l2 = hardwareMap.servo.get("s2");
        l1 = hardwareMap.servo.get("s3");

        telemetry.addData("Ready", "Clamp Ready");

        telemetry.addData("Message 1", "Motors and Servos Declared! All Systems go!");
        //declares motors and servos for movement and clamp etc

    }

    @Override
    public void loop() {
        double forward = gamepad1.left_stick_y;
        double turning = gamepad1.left_stick_x;
        double squeeze = gamepad1.right_trigger;
        boolean B = gamepad1.b; /* speed boost **/
        boolean T = gamepad1.left_bumper; /* toggle switch for lifting the clamp */

        //parts of controller responsible for movement and clamp
        squeeze = Range.clip(squeeze, 0, 0.5);
        forward = Range.clip(forward, -1, 1);
        turning = Range.clip(turning, -1, 1);
        //clipping range

        forward = (double) scaleInput(forward);
        turning = (double) scaleInput(turning);
        //refers to set values at the end of the code
        T = !T;

        if (T) {
            l2.setPosition(0.25);
            l1.setPosition(0.25);
        } else {
            l1.setPosition(0);
            l2.setPosition(0);
        /*if (T2) {
            l1.setPosition(0);
            l2.setPosition(0);
        }*/
        }
        if (squeeze >= 0) {
            lc.setPosition(squeeze);
            rc.setPosition(Math.abs(squeeze - 1));
        }
        //setting up the clamp so it uses the values of the trigger pull
        if (forward > 0.25) {

            lf.setPower(-forward);
            rf.setPower(forward + 0.3);
            rb.setPower(forward);
            lb.setPower(-forward);
        }
        if ((forward > 0.25) && (B)) {

            lf.setPower(-1);
            rf.setPower(1 + 0.3);
            rb.setPower(1);
            lb.setPower(-1);
        }
        //forward movement
        if (forward < -0.25) {

            lf.setPower(-forward);
            rf.setPower(forward - 0.3);
            rb.setPower(forward);
            lb.setPower(-forward);

        }
        if ((forward < -0.25) && (B)) {

            lf.setPower(1);
            rf.setPower(-1 - 0.3);
            rb.setPower(-1);
            lb.setPower(1);

        }
        //backwards movement
        if (turning > 0.25) {

            lb.setPower(-turning);
            lf.setPower(-turning);
            rf.setPower(-turning - 0.3);
            rb.setPower(-turning);

        }
        if ((turning > 0.25) && (B)) {

            lb.setPower(-1);
            lf.setPower(-1);
            rf.setPower(-1 -0.3);
            rb.setPower(-1);

        }
        //turning right
        if (turning < -0.25) {

            lb.setPower(-turning);
            lf.setPower(-turning);
            rf.setPower(-turning + 0.3);
            rb.setPower(-turning);
        }
        if ((turning < -0.25) && (B)) {

            lb.setPower(1);
            lf.setPower(1);
            rf.setPower(1 + 0.3);
            rb.setPower(1);
        }
        //turning left
        if ((turning > -0.25 && turning < 0.25) || (forward > -0.25 && forward < 0.25)) {
            lb.setPower(0);
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);
        }
        //making sure the robot stops moving
        telemetry.addData("Left motor values", forward);
        telemetry.addData("Right motor values", turning);


        //printing values the motors are using

    }
    @Override
    public void stop(){

    }

    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.001, 0.005, 0.05, 0.075, 0.1, 0.15, 0.,
                0.2, 0.25, 0.3, 0.35, 0.4, 0.45, 0.5, 0.55, 0.6 };
        /*
        values making sure the robot doesn't go to fast, and is uncontrollable. The values correspond with certain distances
        the stick is pushed or pulled
        */

        int index = (int) (dVal * 16.0);

        if (index < 0) {
            index = -index;
        }
        if (index > 16) {
            index = 16;
        }

        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        return dScale;

    }


}
