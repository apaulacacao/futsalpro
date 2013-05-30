package hu.bme.mit.inf.mvsd.allplayers;

import hu.bme.mit.inf.mvsd.allplayers.AllPlayersMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate AllPlayersMatcher in a type-safe way.
 * 
 * @see AllPlayersMatcher
 * @see AllPlayersMatch
 * 
 */
public final class AllPlayersMatcherFactory extends BaseGeneratedMatcherFactory<AllPlayersMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static AllPlayersMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected AllPlayersMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new AllPlayersMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.allPlayers";
    
  }
  
  private AllPlayersMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<AllPlayersMatcherFactory> {
    @Override
    public AllPlayersMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static AllPlayersMatcherFactory INSTANCE = make();
    
    public static AllPlayersMatcherFactory make() {
      try {
      	return new AllPlayersMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
