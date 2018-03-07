package com.prem.disjointset;

import java.util.HashSet;
import java.util.Set;

public class DSet<T> {

  private int repr;
  private Set<T> dSet= new HashSet<T>();

  public int getRepr() {
    return repr;
  }

  public void setRepr(int repr) {
    this.repr = repr;
  }

  public Set<T> getdSet() {
    return dSet;
  }

  public void setdSet(Set<T> dSet) {
    this.dSet = dSet;
  }
}
