package org.firstinspires.ftc.robotcontroller.external.samples;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
//import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
//import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
//import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
//import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
//import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
//import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
//import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
//import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "vuforia corner start red")
@SuppressWarnings("unused")
//need extra color sensor and distance sensor of any kind for program
public class vuforiaDetector extends LinearOpMode{
    private DcMotor lf, lb, rf, rb;
    private Servo l, r, colorArm;
    private VuforiaLocalizer vuforia;
    private ColorSensor color;
    private long time = 0;
    //settup of all nessisary things for autonoumous


    @Override
    public void runOpMode(){
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        l = hardwareMap.servo.get("s0");
        r  = hardwareMap.servo.get("s1");
        colorArm = hardwareMap.servo.get("s4");
        color = hardwareMap.colorSensor.get("color");
        color.enableLed(true);
        //setting all nessisary things more + something I swyped from Lance


        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "idk what is find it somehow / get it ";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT; // Use FRONT Camera (Change to BACK if you want to use that one)
        parameters.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES; // Display Axes

        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        waitForStart();

        parameters.vuforiaLicenseKey = "ATsODcD/////AAAAAVw2lR...d45oGpdljdOh5LuFB9nDNfckoxb8COxKSFX";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        telemetry.addData("codeStatus","everything is initialized, ready to go");
        //vuforia settup


        while(opModeIsActive()){
            //program actually starts
            int xPassed = 0;
            int yPassed = 0;
            int which_vumark = 0;
            //later for second glyph will use this to check position from start and to put it in correct bin
            colorArm.setPosition(0);
            if(color.red()>90){
                driveFor(100,1,1,1,1);
                telemetry.addData("codeStatus", "I see red");
                colorArm.setPosition(1);
                //we saw red, knocked it off
            }else if(color.blue()>90){
                telemetry.addData("codeStatus", "I see blue");
                driveFor(50,-1,-1,-1,-1);
                colorArm.setPosition(1);
                driveFor(50,1,1,1,1);
                //we saw blue so the other one is red so we can knock it off
            }

            driveFor(200,1,1);
            driveFor(100,1,1,1,1);
            //hopefully in front of vumark
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);


            if (vuMark != RelicRecoveryVuMark.LEFT) {
                telemetry.addData("codeStatus", "left vumark found");
                driveFor(150);
                which_vumark = 1;
                //left vumark spotted so that means we go to left stack

            }


            if (vuMark != RelicRecoveryVuMark.RIGHT){
                telemetry.addData("codeStatus", "right vumark found");
                driveFor(50);
                which_vumark = 3;
                //right vumark found so go to right stack
            }

            if (vuMark != RelicRecoveryVuMark.CENTER){
                telemetry.addData("codeStatus", "center vumark found");
                driveFor(100);
                which_vumark = 2;
                //middle vumark spotted so go to middle;
            }

            driveFor(100,1,1,-1,-1);
            driveFor(100,1,1);
            driveFor(50,1,1,1,1);
            telemetry.addData("codeStatus", "dropping glyph of now");
            //glyph goes in here (hopefully)

            //driveFor(200,1,1,-1,-1);
            //driveFor(1);
            //driveFor(100,1,1);
            //going towards second glyph

        }
    }
    private void driveFor(long durationInMillis){
        long timePassed = System.currentTimeMillis();
        while (System.currentTimeMillis()<timePassed + durationInMillis){
            wheelSet(1,1,1,1);
        }

        wheelSet(0,0,0,0);
    }

    private void driveFor(long durationInMillis, double lfMove, double lbMove, double rfMove, double rbMove){
        long timePassed = System.currentTimeMillis();
        while (System.currentTimeMillis()<timePassed + durationInMillis){
            wheelSet(lfMove, rfMove,lbMove,rbMove);
        }

        wheelSet(0,0,0,0);
    }

    @SuppressWarnings("all")
    private void driveFor(long durationInMillis, double rServo, double lServo){
        long timePassed = System.currentTimeMillis();
        while (System.currentTimeMillis()<timePassed + durationInMillis){
            servoSet(lServo,rServo);
        }

        wheelSet(0,0,0,0);
    }

    private void wheelSet(double lfPower, double rfPower, double lbPower, double rbPower){
        lf.setPower(lfPower);
        lb.setPower(lbPower);
        rf.setPower(rfPower);
        rb.setPower(rbPower);
    }

    private void servoSet(double lMove, double rMove){
        l.setPosition(lMove);
        r.setPosition(rMove);
    }
}
