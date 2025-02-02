package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorToL4 extends Command {
    ElevatorSubsystem elevatorSubsystem;
    boolean shouldEnd;
    
    
        public ElevatorToL4(ElevatorSubsystem elevatorSubsystem) {
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
        this.elevatorSubsystem.motionMagicSetPosition(72);
        if(this.elevatorSubsystem.getPosition() == 72){
            this.shouldEnd = true;
        }
        
    }

    @Override
    public boolean isFinished() {
        return this.shouldEnd;
    }

}


