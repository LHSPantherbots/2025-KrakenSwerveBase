package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorToCoralStation extends Command {
    ElevatorSubsystem elevatorSubsystem;
    boolean shouldEnd;
    
    
        public ElevatorToCoralStation(ElevatorSubsystem elevatorSubsystem) {
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
        this.elevatorSubsystem.motionMagicSetPosition(37.5);
        if(this.elevatorSubsystem.getPosition() == 37.5){
            this.shouldEnd = true;
        }
        
    }

    @Override
    public boolean isFinished() {
        return this.shouldEnd;
    }

}
