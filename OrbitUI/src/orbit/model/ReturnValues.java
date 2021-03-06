/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package orbit.model;

public class ReturnValues {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected ReturnValues(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ReturnValues obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        OrbitSimulatorJNI.delete_ReturnValues(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPosition(vec value) {
    OrbitSimulatorJNI.ReturnValues_position_set(swigCPtr, this, vec.getCPtr(value), value);
  }

  public vec getPosition() {
    long cPtr = OrbitSimulatorJNI.ReturnValues_position_get(swigCPtr, this);
    return (cPtr == 0) ? null : new vec(cPtr, false);
  }

  public void setSpeed(vec value) {
    OrbitSimulatorJNI.ReturnValues_speed_set(swigCPtr, this, vec.getCPtr(value), value);
  }

  public vec getSpeed() {
    long cPtr = OrbitSimulatorJNI.ReturnValues_speed_get(swigCPtr, this);
    return (cPtr == 0) ? null : new vec(cPtr, false);
  }

  public ReturnValues() {
    this(OrbitSimulatorJNI.new_ReturnValues(), true);
  }

}
