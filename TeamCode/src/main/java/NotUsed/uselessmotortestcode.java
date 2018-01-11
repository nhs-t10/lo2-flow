package NotUsed;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.AbstractSuper;

/**
 * Created by Alex on 1/9/2018.
 */

public class uselessmotortestcode extends AbstractSuper {
    double joyX= gamepad1.left_stick_x;
    double joyY= gamepad1.left_stick_y;
    double set= .05;
    public void prapare(){
        init();
    }

    @Override
    public void loop() {
         if (joyX>set && joyY>set) {


        }else if (joyX>set && joyY<-set) {

        }else if (joyX<-set && joyY>set) {

        }else if (joyX<-set && joyY<-set) {

        }else if (joyX>set && joyY<set && joyY>-set ) {
            wheelSet(1,1,-1,-1);

        }else if (joyX<-set && joyY<set && joyY>-set) {
            wheelSet(-1,-1,1,1);

        }else if (joyY>set && joyX<set && joyX>-set) {
            wheelSet(1,1,1,1);

        }else if (joyY<-set && joyX<set && joyX>-set) {
            wheelSet(-1,-1,-1,-1);

        }else if (joyX>set && joyY<set && joyY>-set && gamepad1.left_stick_button) {
             wheelSet(1,1,-1,-1);

         }else if (joyX<-set && joyY<set && joyY>-set) {
             wheelSet(-joyY,-j,1,1);

         }
    }
}
