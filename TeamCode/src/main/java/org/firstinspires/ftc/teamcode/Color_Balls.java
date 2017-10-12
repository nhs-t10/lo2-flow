//package org.firstinspires.ftc.teamcode;
//
///**
// * Created by dvw24 on 10/10/17.
// */
//
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.ColorSensor;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//
//
//public class Color_Balls extends OpMode {
//
//    private Servo colorKnocker;
//    private ColorSensor jeweler;
//    private DcMotor leftmotor, rightmotor;
//
//    @Override
//    public void init() {
//        colorKnocker = hardwareMap.Servo.get("s1");
//        jeweler = hardwareMap.ColorSensor.get("c1");
//        leftmotor = hardwareMap.dcMotor.get("m1");
//        rightmotor = hardwareMap.dcMotor.get("m2");
//
//        telemetry.addData("Stuff!", "Servos, Motors and Sensors declared! All Systems go!");
//
//        while(true){
//            colorKnocker.setPostion(1);
//
//            if(jeweler= jeweler.blue){
//                rightmotor.setPower(1);
//                leftmotor.setPower(1);
//
//                if(System.currentTimeMillis(4000)){
//                    break;
//                    colorKnocker.setPosition(0);
//                }
//            }
//        }
//
//
//
//    }
//
//
//}
//
//
