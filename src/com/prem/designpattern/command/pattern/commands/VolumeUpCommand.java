package com.prem.designpattern.command.pattern.commands;

import com.prem.designpattern.command.pattern.Command;
import com.prem.designpattern.command.pattern.Device;

public class VolumeUpCommand implements Command {

  private Device device;

  public VolumeUpCommand(Device device) {
    this.device=device;
  }

  @Override
  public void execute() {
    device.volumeUp();
  }
}
