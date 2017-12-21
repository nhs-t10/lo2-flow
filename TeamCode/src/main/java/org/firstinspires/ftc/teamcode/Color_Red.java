package org.firstinspires.ftc.teamcode;

/**
 * Created by dvw24 on 10/10/17.
 */




import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.hardware.NormalizedRGBA;
//import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;

//@Autonomous(name = "JewelRed")
public class Color_Red extends OpMode {


    private Servo colorKnocker;
    private ColorSensor color;
    private DcMotor rf, lf, rb, lb;

    private boolean sawBlue = false;
    private boolean sawRed = false;
    private long time = 0;

    @Override
    public synchronized void init() {
        colorKnocker = hardwareMap.servo.get("s4");
        color = hardwareMap.colorSensor.get("color");
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        telemetry.addData("Hi!", "Servos, Motors and Sensors declared! All Systems go!");


        color.enableLed(true);
        colorKnocker.setPosition(1);
    }
    public void loop() {

        //I have no real clue if this will set the arm correctly but if it does no need to fix it

        //In this code we are on the red team.
        //This means we need to knock down the blue ball.
        //The sensor will be on the ?left? of the arm (if left reverse below)
        // If it senses the red ball then it needs to go backwards to knock off the blue ball
        //the reverse if it senses a non red ball (blue)

        if (time == 0) {
            colorKnocker.setPosition(0);
            //sets position down
        }

        if (color.red() > 90 && !sawRed && time == 0){
            time = System.currentTimeMillis();
            sawRed = true;
            lf.setPower(1);
            rf.setPower(-1);
            rb.setPower(-1);
            lb.setPower(1);
        } else if(sawRed && System.currentTimeMillis() >= time + 2000) {
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);
            lb.setPower(0);
            sawRed = false;
            colorKnocker.setPosition(1);
            //sets position up
            //ill save you
        }

        if (color.blue() > 90 && !sawBlue && time == 0){
            time = System.currentTimeMillis();
            sawBlue = true;
            lf.setPower(-1);
            rf.setPower(1);
            rb.setPower(1);
            lb.setPower(-1);
        } else if(sawBlue && System.currentTimeMillis() >= time + 2000) {
            lf.setPower(0);
            rf.setPower(0);
            rb.setPower(0);
            lb.setPower(0);
            sawBlue = false;
            colorKnocker.setPosition(1);
        }
    }
    public void stop() {

    }
}

