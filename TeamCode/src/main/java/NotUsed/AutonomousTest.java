package NotUsed;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//@Autonomous(name = "test")
@SuppressWarnings("unused")
public class AutonomousTest extends LinearOpMode  {
    private DcMotor lf, lb, rf, rb;

    private void wheelSet(double a0, double a1, double a2, double a3) {
        lf.setPower(a0);
        lb.setPower(a1);
        rf.setPower(a2);
        rb.setPower(a3);
    }

    @Override
    public void runOpMode() {
        try {
            lf = hardwareMap.dcMotor.get("m0");
            lb = hardwareMap.dcMotor.get("m2");
            rf = hardwareMap.dcMotor.get("m1");
            rb = hardwareMap.dcMotor.get("m3");
            //lf.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
            //lb.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
            //rf.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);
            //rb.setChannelMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODERS);

            lf.setDirection(DcMotor.Direction.REVERSE);
            lb.setDirection(DcMotor.Direction.REVERSE);
            waitForStart();
            //long timePass = System.currentTimeMillis();
            //if (time + 2 <= System.currentTimeMillis()){
            //    wheelSet(1,1,1,1);
            //}


            wheelSet(.5, .5, -.5, -.5);
            wait(200);
            wheelSet(0, 0, 0, 0);
           /* wait(4000);
            wheelSet(1, 1, -1, -1);
            wait(2000);
            wheelSet(0, 0, 0, 0);
           wait(4000);
            wheelSet(1, 1, -1, -1);
            wait(3000);
            wheelSet(0, 0, 0, 0);
            wait(4000);
            wheelSet(1, 1, -1, -1);
            wait(4000);
           wheelSet(0, 0, 0, 0);*/
        }
        catch(Exception e){
            System.err.println("Error handler:");
            e.printStackTrace();
            telemetry.addData("we have an exception","We have a problem " + e.getMessage());
        }
        finally{
            stop();
        }

    }

    //@Autonomous(name = "JewelRed")
    public static class Color_Red extends OpMode {


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
}
