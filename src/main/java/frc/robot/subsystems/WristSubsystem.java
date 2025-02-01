package main.java.frc.robot.subsystems;

import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import java.util.Map;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.units.measure.Current;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import main.java.frc.robot.Constants.ModuleConstants.WristConstants;

public class WristSubsystem extends SubsystemBase{
    private final SparkMax m_Wrist; 
    private final SparkMaxConfig c_Wrist;
    AbsoluteEncoder e_WristEncoder = m_Wrist.getAbsoluteEncoder();

    private double lastSetpoint = 0;
    private double setPoint = 2.0;
    private double autoAimTrim = 0;

    private ShuffleboardTab tab = Shuffleboard.getTab("Tuning");  //angles used for shuffleboard; taken from 2024 fulcrum code
    private GenericEntry sbAngle = tab.add("Fulcrum Angle", 1)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withProperties(Map.of("min", 0, "max", 90))
            .getEntry();

    public WristSubsystem() {      
      m_Wrist = new SparkMax(WristConstants.kWrist, MotorType.kBrushless);
 

        Slot0Configs slot0 = cfg.Slot0;
    slot0.kP = 60/12.8;
    slot0.kI = 0;
    slot0.kD = 0.1;
    slot0.kV = 0.12;
    slot0.kS = 0.25; // Approximately 0.25V to get the mechanism moving

    }
    @Override
    public void periodic() {
      SmartDashboard.putBoolean("Wrist is at Set Point", isAtPoint());
      SmartDashboard.putNumber("Wrist Velocity", e_WristEncoder.getVelocity());
      SmartDashboard.putNumber("Wrist Output", m_Wrist.getAppliedOutput());
      SmartDashboard.putNumber("Wrist Setpoint", setPoint);
      SmartDashboard.putNumber("Wrist Pos", e_WristEncoder.getPosition());
    
    }

     public void stop() {
        m_Wrist.set(0.0);
    }

     public double getPosition() {
        return e_WristEncoder.getPosition();
    }

     public double getSetPoint() {
        return setPoint;
    }

    public double getLastSetPoint() {
        return lastSetpoint;
    }

    public void setSetPoint(double point) {
        lastSetpoint = setPoint;
        setPoint = point;
    }

    public double getSbAngle() {  //reference lines 26-30
        return sbAngle.getDouble(1.0);
    }

     public void manualWristMove(double move) {
        m_Wrist.set(move);
    }


 }

