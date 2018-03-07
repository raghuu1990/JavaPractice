package com.prem.designpattern.command.pattern.commands;

import com.prem.designpattern.command.pattern.Command;
import com.prem.designpattern.command.pattern.Device;

public class VolumeDownCommand implements Command {

  private Device device;

  public VolumeDownCommand(Device device) {
    this.device=device;
  }

  @Override
  public void execute() {
    device.volumeDown();
  }
}
