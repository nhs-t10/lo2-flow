package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
@Autonomous
@SuppressWarnings("unused")
public class SecondGlyphCode extends OpMode {
    private DcMotor lf,lb,rf,rb;
    private Servo sl,sr;
    long timePassed = 0;
    @Override
    public void init(){
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
        sl =  hardwareMap.servo.get("s0");
        sr = hardwareMap.servo.get("s1");
    }
    private static void waitFor(long timeInMillis){

    }
    @Override
    public void loop (){
        timePassed = System.currentTimeMillis();
    }


}
