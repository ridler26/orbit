/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package orbit.model;

public class vector_of_part_flight_plan {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected vector_of_part_flight_plan(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(vector_of_part_flight_plan obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        OrbitSimulatorJNI.delete_vector_of_part_flight_plan(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public vector_of_part_flight_plan() {
    this(OrbitSimulatorJNI.new_vector_of_part_flight_plan__SWIG_0(), true);
  }

  public vector_of_part_flight_plan(long n) {
    this(OrbitSimulatorJNI.new_vector_of_part_flight_plan__SWIG_1(n), true);
  }

  public long size() {
    return OrbitSimulatorJNI.vector_of_part_flight_plan_size(swigCPtr, this);
  }

  public long capacity() {
    return OrbitSimulatorJNI.vector_of_part_flight_plan_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    OrbitSimulatorJNI.vector_of_part_flight_plan_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return OrbitSimulatorJNI.vector_of_part_flight_plan_isEmpty(swigCPtr, this);
  }

  public void clear() {
    OrbitSimulatorJNI.vector_of_part_flight_plan_clear(swigCPtr, this);
  }

  public void add(PartOfFlightPlan x) {
    OrbitSimulatorJNI.vector_of_part_flight_plan_add(swigCPtr, this, PartOfFlightPlan.getCPtr(x), x);
  }

  public PartOfFlightPlan get(int i) {
    return new PartOfFlightPlan(OrbitSimulatorJNI.vector_of_part_flight_plan_get(swigCPtr, this, i), false);
  }

  public void set(int i, PartOfFlightPlan val) {
    OrbitSimulatorJNI.vector_of_part_flight_plan_set(swigCPtr, this, i, PartOfFlightPlan.getCPtr(val), val);
  }

}