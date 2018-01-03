package org.firstinspires.ftc.teamcode;

/*
 * Created by tripszewczak on 10/10/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "CurrentDismount")
@SuppressWarnings("unused")
public class onPhoneDISMOUNT extends OpMode {


    private ColorSensor color;
    private DcMotor rf, lf, rb, lb;
    private Servo lc, rc, l2, l1;


    private long time = 0;

    @Override
    public synchronized void init() {
        color = hardwareMap.colorSensor.get("color");
        rf = hardwareMap.dcMotor.get("m1");
        lf = hardwareMap.dcMotor.get("m0");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        lc = hardwareMap.servo.get("s1");
        rc = hardwareMap.servo.get("s0");
        l2 = hardwareMap.servo.get("s2");
        l1 = hardwareMap.servo.get("s3");
        telemetry.addData("Hi!", "Servos, Motors and Sensors declared! All Systems go!");
    //Here we are just simply declaring motors

        color.enableLed(true);

    }


    public void loop() {


        if (color.blue()  >= 0 && time == 0){
            /*color sensor and time are used to intiate movement*/

            time = System.currentTimeMillis();
            lf.setPower(1);
            lb.setPower(1);
            rf.setPower(-1);
            rb.setPower(-1);
            lc.setPosition(1);
            rc.setPosition(Math.abs(0));
            l1.setPosition(0.15);
            l2.setPosition(0.15);


        } else if(System.currentTimeMillis() >= time + 200) {
            lf.setPower(0);
            lb.setPower(0);
            rf.setPower(0);
            rb.setPower(0);
        }
        if (color.blue() >= 0 && time == 220) {
            lb.setPower(1);
            lf.setPower(1);
            rf.setPower(1);
            rb.setPower(1);
        }else if (System.currentTimeMillis() >= time + 40) {
            lf.setPower(0);
            lb.setPower(0);
            rf.setPower(0);
            rb.setPower(0);
            rc.setPosition(1);
            lc.setPosition(0);
        }
        if (color.blue() >= 0 && time == 260) {
            lf.setPower(-1);
            lb.setPower(-1);
            rf.setPower(1);
            rb.setPower(1);
        }else if (System.currentTimeMillis() >= time + 10){
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);
            lb.setPower(0);
        }
            /* this program is very simple it goes and finds the system's
             current time,and then moves forward for .2 seconds.*/

    }
    public void stop() {

    }
}

