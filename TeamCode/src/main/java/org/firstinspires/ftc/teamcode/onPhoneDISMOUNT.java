package org.firstinspires.ftc.teamcode;

/**
 * Created by tripszewczak on 10/10/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous(name = "Dismount")
public class onPhoneDISMOUNT extends OpMode {


    private ColorSensor color;
    private DcMotor rf, lf, rb, lb;


    private long time = 0;

    @Override
    public synchronized void init() {
        color = hardwareMap.colorSensor.get("color");
        rf = hardwareMap.dcMotor.get("m1");
        lf = hardwareMap.dcMotor.get("m0");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        telemetry.addData("Hi!", "Servos, Motors and Sensors declared! All Systems go!");
    //Here we are just simply declaring motors

        color.enableLed(true);

    }




    public void loop() {


        if (color.blue()  >= 0 && time == 0){
            /**color sensor and time are used to intiate movement*/

            time = System.currentTimeMillis();
            lf.setPower(1);
            lb.setPower(1);
            rf.setPower(-1);
            rb.setPower(-1);

        } else if(System.currentTimeMillis() >= time + 200) {
            lf.setPower(0);
            lb.setPower(0);
            rf.setPower(0);
            rb.setPower(0);
        }
            /** this program is very simple it goes and finds the system's
             current time,and then moves forward for .2 seconds.*/

    }
    public void stop() {

    }
}

