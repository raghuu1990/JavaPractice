package com.prem.designpattern.command.pattern;

import com.prem.designpattern.command.pattern.commands.TVOffCommand;
import com.prem.designpattern.command.pattern.commands.TVOnCommand;
import com.prem.designpattern.command.pattern.commands.VolumeDownCommand;
import com.prem.designpattern.command.pattern.commands.VolumeUpCommand;
import com.prem.designpattern.command.pattern.devices.Television;

/**
 * Created by lovebharti on 12/1/17.
 */
public class DeviceClient {

  public static void main(String[] args) {
    Device device= new Television();

    Command command = new TVOnCommand(device);
    command.execute();

    command = new TVOffCommand(device);
    command.execute();

    command = new VolumeUpCommand(device);
    command.execute();

    command = new VolumeDownCommand(device);
    command.execute();

  }

}
