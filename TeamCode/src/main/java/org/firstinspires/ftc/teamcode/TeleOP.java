package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")

public class TeleOP extends LinearOpMode {

    /* Declares variable then sets it to the amount of 
    time that has passed since the program has been run */
    private ElapsedTime runtime = new ElapsedTime();

    // Declares four objects of the DcMotor class
    private DcMotor FrontRight = null;
    private DcMotor FrontLeft = null;
    private DcMotor BackRight = null;
    private DcMotor BackLeft = null;

    @Override
    public void runOpMode() {

	    /* Adds the described data to the telemetry buffer then
	    tells the program that it needs to reread said buffer 
	    and to update what is being displayed */
        telemetry.addData("Status", "Initialized");
        telemetry.update();

	    /* Maps previously declared motor objects to the physical
	     hardware on the robot by the labels that were used on the phones */
        FrontRight  = hardwareMap.get(DcMotor.class, "FrontRight");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");

        FrontLeft.setDirection(DcMotor.Direction.FORWARD);
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.REVERSE);

        /* Waits till user hits start to execute any loc
        after the statement and also sets time variable
        back to zero */
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            double lr = gamepad1.left_stick_x;
            double fb  =  gamepad1.left_stick_y;

            if (lr == 1){
                FrontRight.setPower(-lr);
                FrontLeft.setPower(lr);
                BackRight.setPower(lr);
                BackLeft.setPower(-lr);
            } else if (lr == -1){
                FrontRight.setPower(-lr);
                FrontLeft.setPower(lr);
                BackRight.setPower(lr);
                BackLeft.setPower(-lr);
            } else if (fb == 1){
                FrontRight.setPower(-fb);
                FrontLeft.setPower(-fb);
                BackRight.setPower(-fb);
                BackLeft.setPower(-fb);
            } else if (fb == -1){
                FrontRight.setPower(-fb);
                FrontLeft.setPower(-fb);
                BackRight.setPower(-fb);
                BackLeft.setPower(-fb);
            } else {
                FrontRight.setPower(0);
                FrontLeft.setPower(0);
                BackRight.setPower(0);
                BackLeft.setPower(0);
            }

            // Adds telmetry that shows how long the program has been running
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
