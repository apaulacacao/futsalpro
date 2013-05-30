package hu.bme.mit.inf.mvsd.outinoutsubs;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.outInOutSubs pattern.
 */
public class OutInOutSubsEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer outTime2, final Integer outTime1) {
    Integer _outTime1 = outTime1;
    Integer _outTime2 = outTime2;
    boolean _lessThan = (_outTime1.compareTo(_outTime2) < 0);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int outTime2Position = tupleNameMap.get("outTime2");
    java.lang.Integer outTime2 = (java.lang.Integer) tuple.get(outTime2Position);
    int outTime1Position = tupleNameMap.get("outTime1");
    java.lang.Integer outTime1 = (java.lang.Integer) tuple.get(outTime1Position);
    return evaluateXExpressionGenerated(outTime2, outTime1);
  }
}
