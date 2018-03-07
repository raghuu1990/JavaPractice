package com.prem.designpattern.command.pattern.devices;

import com.prem.designpattern.command.pattern.Device;

public class Radio implements Device {


  private int volume=0;
  private boolean deviceState;

  @Override
  public void deviceOn() {
    deviceState=true;
    System.out.println("Radio is on now");
  }

  @Override
  public void deviceOff() {
    deviceState=false;
    System.out.println("Radio is off now");
  }

  @Override
  public void volumeUp() {
    volume++;
    System.out.println("Radio now:"+volume);
  }

  @Override
  public void volumeDown() {
    volume--;
    System.out.println("Radio now:"+volume);
  }
}
