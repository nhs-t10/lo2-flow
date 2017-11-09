package org.firstinspires.ftc.teamcode;

/**
 * Created by tripszewczak on 11/9/17.
 */
import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
@TeleOp (name = "colorFinder")
public class ColorValueFinder extends OpMode {

    public static ColorSensor finder;

    public void init() {
        finder = hardwareMap.colorSensor.get("color");
        finder.enableLed(true);

    }
    public void loop() {
        telemetry.addData("Red", finder.red());
        telemetry.addData("Blue", finder.blue());
        telemetry.addData("Green", finder.green());
        telemetry.addData("All", finder.argb());
    }
    public void stop() {

    }

}
