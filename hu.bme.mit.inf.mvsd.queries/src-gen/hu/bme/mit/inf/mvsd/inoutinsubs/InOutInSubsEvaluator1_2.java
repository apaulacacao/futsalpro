package hu.bme.mit.inf.mvsd.inoutinsubs;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.inOutInSubs pattern.
 */
public class InOutInSubsEvaluator1_2 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer outTime, final Integer inTime1) {
    Integer _inTime1 = inTime1;
    Integer _outTime = outTime;
    boolean _lessThan = (_inTime1.compareTo(_outTime) < 0);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int outTimePosition = tupleNameMap.get("outTime");
    java.lang.Integer outTime = (java.lang.Integer) tuple.get(outTimePosition);
    int inTime1Position = tupleNameMap.get("inTime1");
    java.lang.Integer inTime1 = (java.lang.Integer) tuple.get(inTime1Position);
    return evaluateXExpressionGenerated(outTime, inTime1);
  }
}
