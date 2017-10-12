package org.firstinspires.ftc.teamcode;

import com.qualcomm.robot.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robot.hardware.ColorSensor;
/**
 * Created by dvw24 on 10/10/17.
 */
public class Parking extends OpMode {

    private DcMotor rightmotor, leftmotor;
    private ColorSensor zoneSensor;

    @Override
    public void init() {
        rightmotor = hardwareMap.DcMotor.get("m1");
        leftmotor = hardwareMap.DcMotor.get("m2");

        telemetry.addData("Stuff!", "Motors and Sensors ready!");

        while(true){
            rightmotor.setPower(1);
            leftmotor.setPower(1);

            if(zoneSensor = zoneSensor.white){
                break;
            }
        }
    }



