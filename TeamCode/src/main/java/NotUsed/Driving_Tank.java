package NotUsed;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by user on 10/5/17.
 */
public class Driving_Tank extends OpMode{


    private DcMotor leftmotor, rightmotor, leftmotor2, rightmotor2;
    private double wheelSpeed;

    @Override
    public void init() {
        rightmotor = hardwareMap.dcMotor.get("m2");
        leftmotor = hardwareMap.dcMotor.get("m1");
        leftmotor2 = hardwareMap.dcMotor.get("m3");
        rightmotor2 = hardwareMap.dcMotor.get("m4");

        telemetry.addData("Message 1", "Motors and servos declared! All Systems go!");
    }

    @Override
    public void loop(){
        if(gamepad1.left_stick_y > 0.5 && gamepad1.left_stick_y < 0.75)
            leftmotor.setPower(.5);
            leftmotor2.setPower(.5);
        
        if (gamepad1.left_stick_y < -0.5 && gamepad1.left_stick_y > -0.75)
            leftmotor.setPower(-.5);
            leftmotor2.setPower(-.5);

        if(gamepad1.right_stick_y > 0.5 && gamepad1.left_stick_y < 0.75)
            rightmotor.setPower(.5);
            rightmotor2.setPower(.5);
        
        if (gamepad1.right_stick_y < -0.5 && gamepad1.left_stick_y > -0.75)
            rightmotor.setPower(-.5);
            rightmotor2.setPower(-.5);

        if(gamepad1.left_stick_y >= 0.75)
            leftmotor.setPower(1);
            leftmotor2.setPower(1);

        if (gamepad1.left_stick_y <= -0.75)
            leftmotor.setPower(-1);
            leftmotor2.setPower(-1);

        if(gamepad1.right_stick_y >= 0.75)
            rightmotor.setPower(1);
            rightmotor2.setPower(1);

        if (gamepad1.right_stick_y <= -0.75)
            rightmotor.setPower(-1);
            rightmotor2.setPower(-1);

        telemetry.addData("Left motor value",gamepad1.left_stick_y);
        telemetry.addData("Right motor value",gamepad1.right_stick_y);

    }


}

