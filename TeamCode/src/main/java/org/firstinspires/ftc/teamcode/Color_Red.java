package org.firstinspires.ftc.teamcode;

/**
 * Created by dvw24 on 10/10/17.
 */




import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.hardware.NormalizedRGBA;
//
//import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;

@Autonomous(name = "JewelRed")
public class Color_Red extends LinearOpMode {


    private Servo colorKnocker;
    private ColorSensor color;
    private DcMotor rf, lf, rb, lb;

    @Override
    public synchronized void waitForStart() {
        super.waitForStart();
    }

    private void setMotor(double a0, double a1, double a2, double a3) {
        lf.setPower(a0);
        lb.setPower(a1);
        rf.setPower(a2);
        rb.setPower(a3);

    }


    public void runOpMode() {
        colorKnocker = hardwareMap.servo.get("s1");
        color = hardwareMap.colorSensor.get("color");
        rf = hardwareMap.dcMotor.get("m1");
        lf = hardwareMap.dcMotor.get("m0");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        telemetry.addData("Hi!", "Servos, Motors and Sensors declared! All Systems go!");


        color.enableLed(true);
        colorKnocker.setPosition(1);
        //I have no real clue if this will set the arm correctly but if it does no need to fix it

        //In this code we are on the blue team.
        //This means we need to knock down the red ball.
        //The sensor will be on the right of the arm
        // If it senses the blue ball then it needs to go backwards to knock off the red ball
        //the reverse if it senses a non blue ball (red)

        if (color.red() > 90 ){
            //color is not correct and needs to be changed to sense color blue
            long t = System.currentTimeMillis();
            long end = t + 2000;
            while (System.currentTimeMillis() < end) {
                setMotor(1, 1, 1, 1);
            }

        } else {
            long t = System.currentTimeMillis();
            long end = t + 2000;
            while (System.currentTimeMillis() < end) {
                setMotor(-1, -1, -1, -1);
            }


        }

        colorKnocker.setPosition(0);
    }
}

