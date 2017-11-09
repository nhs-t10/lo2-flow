package org.firstinspires.ftc.teamcode;

/**
 * Created by tripszewczak on 11/9/17.
 */
import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
@Autonomous(name = "colorFinder")
public class ColorValueFinder extends OpMode {

    public static ColorSensor color;

    public void init() {
        color = hardwareMap.colorSensor.get("c1");
        color.enableLed(true);

    }
    public void loop() {
        double red = color.red();
        double blue = color.blue();
        double green = color.green();
        double all = color.argb();

        telemetry.addData("Red", red);
        telemetry.addData("Blue", blue);
        telemetry.addData("Green", green);
        telemetry.addData("All", all);
    }
//    public void stop() {
//
//    }

}
