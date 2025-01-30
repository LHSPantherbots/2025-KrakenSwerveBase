package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorToL2 extends Command {
    ElevatorSubsystem elevatorSubsystem;
    boolean shouldEnd;
    
    
        public ElevatorToL2(ElevatorSubsystem elevatorSubsystem) {
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
        this.elevatorSubsystem.motionMagicSetPosition(20);
        if(this.elevatorSubsystem.getPosition() == 20){
            this.shouldEnd = true;
        }
        
    }

    @Override
    public boolean isFinished() {
        return this.shouldEnd;
    }

}