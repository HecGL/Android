
function control()
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
import java.awt.Robot;
import java.awt.event.*;
robot=Robot();

bt = Bluetooth('C3PO', 1);
fopen(bt);

while get(bt).Status == open 
    
    key = fread(bt,35);

    switch key
        case A
            robot.keyPress(keyEvent.VK_A);
        case B
            robot.keyPress(keyEvent.VK_B);
        case C
            robot.keyPress(keyEvent.VK_C);
        case D
            robot.keyPress(keyEvent.VK_D);
        otherwise
       
    end
end 
fclose(bt);
clear('bt');
end

