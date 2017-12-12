package org.firstinspires.ftc.teamcode;

/**
 * Created by tripszewczak on 10/10/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.hardware.NormalizedRGBA;
//import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;

@Autonomous(name = "Dismount")
public class onPhoneDISMOUNT extends OpMode {


    //private Servo colorKnocker;
    private ColorSensor color;
    private DcMotor rf, lf, rb, lb;

    //private boolean sawBlue = false;
    //private boolean sawRed = false;
    private long time = 0;

    @Override
    public synchronized void init() {
        //colorKnocker = hardwareMap.servo.get("s1");
        color = hardwareMap.colorSensor.get("color");
        rf = hardwareMap.dcMotor.get("m1");
        lf = hardwareMap.dcMotor.get("m0");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        telemetry.addData("Hi!", "Servos, Motors and Sensors declared! All Systems go!");


        color.enableLed(true);
        //colorKnocker.setPosition(1);
    }




    public void loop() {

        //I have no real clue if this will set the arm correctly but if it does no need to fix it

        //In this code we are on the blue team.
        //This means we need to knock down the red ball.
        //The sensor will be on the ?right? of the arm (if left reverse below)
        // If it senses the blue ball then it needs to go backwards to knock off the red ball
        //the reverse if it senses a red ball

        //if (time == 0) {
            //colorKnocker.setPosition(0);
            //sets position down
        //}

        if (color.blue() >= 0 && time == 0){
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
            //sawBlue = false;
            //colorKnocker.setPosition(1);
            //sets position up
        }

       // if (color.red() >= 0 && !sawRed && time == 0){
            //time = System.currentTimeMillis();
            //sawRed = true;
        //} else if(sawRed && System.currentTimeMillis() >= time + 2000)
            //sawRed = false;
            //colorKnocker.setPosition(1);
        //}
    }
    public void stop() {

    }
}

