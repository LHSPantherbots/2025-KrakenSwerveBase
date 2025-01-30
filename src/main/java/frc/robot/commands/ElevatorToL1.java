package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorToL1 extends Command {
    ElevatorSubsystem elevatorSubsystem;
    boolean shouldEnd;
    
    
        public ElevatorToL1(ElevatorSubsystem elevatorSubsystem) {
            this.elevatorSubsystem = elevatorSubsystem;
            this.shouldEnd = false;
            addRequirements(elevatorSubsystem);
        }

    @Override
    public void initialize() {
        //this.elevatorSubsystem.motionMagicSetPosition(0);
        this.shouldEnd = false;
    }

    @Override
    public void execute() {
        //uses the motion magic method in ElevatorSubsystem to move the motor to 10
        this.elevatorSubsystem.motionMagicSetPosition(10);
        //when the elevator reaches 10 shouldEnd is set to true and the command ends
        if(this.elevatorSubsystem.getPosition() == 10){
            this.shouldEnd = true;
        }
        
    }

    @Override
    public boolean isFinished() {
        return this.shouldEnd;
    }

}