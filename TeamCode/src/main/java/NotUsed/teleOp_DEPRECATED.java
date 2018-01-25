
package NotUsed;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/*
 * Created by tripszewczak on 10/5/17.
 */
//@TeleOp(name = "teleop_DEPRECATED")
@SuppressWarnings("all")
public class teleOp_DEPRECATED extends OpMode {
    private DcMotor lf, rf, lb, rb;
    private Servo ll, lr, l1, l2;
    @Override
    public void init(){
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        ll = hardwareMap.servo.get("s1");
        lr = hardwareMap.servo.get("s0");
        l2 = hardwareMap.servo.get("s2");
        l1 = hardwareMap.servo.get("s3");

        telemetry.addData("Ready", "Clamp Ready");

        telemetry.addData("Message 1", "Motors and Servos Declared! All Systems go!");
        //declares motors and servos for movement and clamp etc

    }

    @Override
    public void loop() {
        double sideways = gamepad1.right_stick_x;
        double forward = gamepad1.left_stick_y;
        double turning = gamepad1.left_stick_x;
        double squeeze = gamepad1.right_trigger;
        //double topsqueeze = gamepad1.left_trigger;
        boolean B = gamepad1.b; /* speed boost **/
        boolean T = gamepad1.left_bumper; /* toggle switch for lifting the clamp */

        //parts of controller responsible for movement and clamp
        squeeze = Range.clip(squeeze, 0, 0.5);
        forward = Range.clip(forward, -1, 1);
        turning = Range.clip(turning, -1, 1);
        //topsqueeze = Range.clip(topsqueeze, -1, 1);
        //clipping range

        //forward = scaleInput(forward);
        //turning = scaleInput(turning);
        //refers to set values at the end of the code

        if (T) {
            l2.setPosition(0.15);
            l1.setPosition(0.15);
        } else {
            l1.setPosition(0);
            l2.setPosition(0);
        }
        /*if (topsqueeze >=0) {
            tl.setPosition(topsqueeze);
            tr.setPosition(Math.abs(topsqueeze - 1));
        }*/
        if (squeeze >= 0) {
            ll.setPosition(squeeze);
            lr.setPosition(Math.abs(squeeze - 1));
        }
        //setting up the clamp so it uses the values of the trigger pull
        if (forward > 0.25) {

            lf.setPower(1);
            rf.setPower(-1);
            rb.setPower(-1);
            lb.setPower(1);
        }
        if (sideways > 0.3) {
            lf.setPower(1);
            rf.setPower(1);
            lb.setPower(-1);
            rb.setPower(-1);
        }
        if (sideways < -0.3) {
            lf.setPower(-1);
            rf.setPower(-1);
            rb.setPower(1);
            lb.setPower(1);
        }
        if ((forward > 0.25) && (B)) {

            lf.setPower(2);
            rf.setPower(-2);
            rb.setPower(-2);
            lb.setPower(2);
        }
        //forward movement
        if (forward < -0.25) {

            lf.setPower(-1);
            rf.setPower(1);
            rb.setPower(1);
            lb.setPower(-1);

        }
        if ((forward < -0.25) && (B)) {

            lf.setPower(-2);
            rf.setPower(2);
            rb.setPower(2);
            lb.setPower(-2);

        }
        //backwards movement

        if (turning > 0.25) {

            lb.setPower(-1);
            lf.setPower(-1);
            rf.setPower(-1);
            rb.setPower(-1);

        }
        //turning right
        /*if (turning < -0.25) {

            lb.setPower(-turning);
            lf.setPower(-turning);
            rf.setPower(-turning + 0.3);
            rb.setPower(-turning);
        }*/
        if (turning < -0.25) {

            lb.setPower(1);
            lf.setPower(1);
            rf.setPower(1);
            rb.setPower(1);
        }
        //turning left
        if ((turning > -0.25 && turning < 0.25) || (forward > -0.25 && forward < 0.25 || (sideways < -0.25 && sideways > 0.25))) {
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

    private double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.001, 0.0035, 0.005, 0.05, 0.075, 0.1, 0.15, 0.2, 0.25, 0.3, 0.35, 0.4, 0.45, 0.5, 0.55, 0.6 };
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

        double dScale;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        return dScale;

    }


}
