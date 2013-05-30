package hu.bme.mit.inf.mvsd.fieldplayers;

import hu.bme.mit.inf.mvsd.fieldplayers.FieldPlayersMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate FieldPlayersMatcher in a type-safe way.
 * 
 * @see FieldPlayersMatcher
 * @see FieldPlayersMatch
 * 
 */
public final class FieldPlayersMatcherFactory extends BaseGeneratedMatcherFactory<FieldPlayersMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FieldPlayersMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected FieldPlayersMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new FieldPlayersMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.fieldPlayers";
    
  }
  
  private FieldPlayersMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<FieldPlayersMatcherFactory> {
    @Override
    public FieldPlayersMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static FieldPlayersMatcherFactory INSTANCE = make();
    
    public static FieldPlayersMatcherFactory make() {
      try {
      	return new FieldPlayersMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
