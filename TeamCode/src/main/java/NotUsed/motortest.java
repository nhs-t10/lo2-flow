package NotUsed;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by tripszewczak on 1/9/18.
 */
@TeleOp (name = "ButtonTest")
public class motortest extends OpMode {
    private DcMotor lf, rf, lb, rb;
    public void init (){
        lf = hardwareMap.dcMotor.get("m0");
        rf = hardwareMap.dcMotor.get("m1");
        lb = hardwareMap.dcMotor.get("m2");
        rb = hardwareMap.dcMotor.get("m3");
    }
    public void loop(){
        boolean A = gamepad1.a;
        boolean B = gamepad1.b;
        boolean X = gamepad1.x;
        boolean Y = gamepad1.y;

        if (A){
            lf.setPower(1);
        }
        if (B){
            lb.setPower(1);
        }
        if (X){
            rf.setPower(-1);
        }
        if (Y){
            rb.setPower(-1);
        }
    }
    public void stop(){

    }
}
