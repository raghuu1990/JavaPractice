package com.prem.designpattern.command.pattern.commands;

import com.prem.designpattern.command.pattern.Command;
import com.prem.designpattern.command.pattern.Device;

public class TVOffCommand implements Command {
  private Device device;

  public TVOffCommand(Device device) {
    this.device=device;
  }

  @Override
  public void execute() {
    device.deviceOff();
  }
}
