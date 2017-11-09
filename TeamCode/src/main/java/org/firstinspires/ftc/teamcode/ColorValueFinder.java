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
        color = hardwareMap.colorSensor.get("color");
        color.enableLed(true);

    }
    public void loop() {
        color.red();
        color.blue();
        color.green();
        telemetry.addData("Red", color.red());
        telemetry.addData("Blue", color.blue());
        telemetry.addData("Green", color.green());
        telemetry.addData("All", color.argb());
    }
    public void stop() {

    }

}
