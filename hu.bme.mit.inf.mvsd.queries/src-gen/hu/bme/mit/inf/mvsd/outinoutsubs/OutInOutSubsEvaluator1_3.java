package hu.bme.mit.inf.mvsd.outinoutsubs;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.outInOutSubs pattern.
 */
public class OutInOutSubsEvaluator1_3 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer outTime2, final Integer inTime) {
    Integer _inTime = inTime;
    Integer _outTime2 = outTime2;
    boolean _lessThan = (_inTime.compareTo(_outTime2) < 0);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int outTime2Position = tupleNameMap.get("outTime2");
    java.lang.Integer outTime2 = (java.lang.Integer) tuple.get(outTime2Position);
    int inTimePosition = tupleNameMap.get("inTime");
    java.lang.Integer inTime = (java.lang.Integer) tuple.get(inTimePosition);
    return evaluateXExpressionGenerated(outTime2, inTime);
  }
}
