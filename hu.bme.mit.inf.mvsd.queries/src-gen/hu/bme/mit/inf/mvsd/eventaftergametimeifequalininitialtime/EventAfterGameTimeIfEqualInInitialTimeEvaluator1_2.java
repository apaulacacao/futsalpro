package hu.bme.mit.inf.mvsd.eventaftergametimeifequalininitialtime;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.EventAfterGameTimeIfEqualInInitialTime pattern.
 */
public class EventAfterGameTimeIfEqualInInitialTimeEvaluator1_2 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer time) {
    boolean _and = false;
    Integer _time = time;
    boolean _greaterThan = ((_time).intValue() > 2400);
    if (!_greaterThan) {
      _and = false;
    } else {
      Integer _time_1 = time;
      boolean _lessEqualsThan = ((_time_1).intValue() <= 3000);
      _and = (_greaterThan && _lessEqualsThan);
    }
    return Boolean.valueOf(_and);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int timePosition = tupleNameMap.get("time");
    java.lang.Integer time = (java.lang.Integer) tuple.get(timePosition);
    return evaluateXExpressionGenerated(time);
  }
}
