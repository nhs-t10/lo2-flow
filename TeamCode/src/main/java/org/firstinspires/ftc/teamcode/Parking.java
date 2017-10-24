//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//
//
//
///**
// * Created by dvw24 on 10/10/17.
// */
//public class Auto_Move extends OpMode {
//
//    int timer = 0;
//    private DcMotor leftmotor, rightmotor;
//    private double wheelSpeed;
//    int time = 3000;
//
//    @Override
//    public void init() {
//        rightmotor = hardwareMap.dcMotor.get("m2");
//        leftmotor = hardwareMap.dcMotor.get("m1");
//
//        while(timer > 10){
//            rightmotor.setPower(1);
//            leftmotor.setPower(1);
//            wait(time);
//            timer++;
//
//           }
//        }
//
//
//        telemetry.addData("Message 1", "Motors and servos declared! All Systems go!");
//    }
//
//}
