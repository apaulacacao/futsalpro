package hu.bme.mit.inf.mvsd.eventafterfullgametime;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.EventAfterFullGameTime pattern.
 */
public class EventAfterFullGameTimeEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer time) {
    Integer _time = time;
    boolean _greaterThan = ((_time).intValue() > 3000);
    return Boolean.valueOf(_greaterThan);
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
