package org.jboss.gwt.elemento.sample.common;

import com.google.gwt.core.client.GWT;
import org.jboss.gwt.elemento.sample.gin.client.org_jboss_gwt_elemento_sample_gin_client_ApplicationGinjector_ApplicationGinjectorGinjector;

public class org_jboss_gwt_elemento_sample_gin_client_ApplicationGinjector_ApplicationGinjectorGinjector_fragment {
  public void memberInject_Key$type$org$jboss$gwt$elemento$sample$common$BeanFactory$_annotation$$none$$(org.jboss.gwt.elemento.sample.common.BeanFactory injectee) {
    
  }
  
  public void memberInject_Key$type$org$jboss$gwt$elemento$sample$common$TodoMessages$_annotation$$none$$(org.jboss.gwt.elemento.sample.common.TodoMessages injectee) {
    
  }
  
  
  /**
   * Binding for org.jboss.gwt.elemento.sample.common.BeanFactory declared at:
   *   Implicit GWT.create binding for org.jboss.gwt.elemento.sample.common.BeanFactory
   */
  public org.jboss.gwt.elemento.sample.common.BeanFactory get_Key$type$org$jboss$gwt$elemento$sample$common$BeanFactory$_annotation$$none$$() {
    Object created = GWT.create(org.jboss.gwt.elemento.sample.common.BeanFactory.class);
    assert created instanceof org.jboss.gwt.elemento.sample.common.BeanFactory;
    org.jboss.gwt.elemento.sample.common.BeanFactory result = (org.jboss.gwt.elemento.sample.common.BeanFactory) created;
    
    memberInject_Key$type$org$jboss$gwt$elemento$sample$common$BeanFactory$_annotation$$none$$(result);
    
    return result;
    
  }
  
  
  /**
   * Binding for org.jboss.gwt.elemento.sample.common.TodoMessages declared at:
   *   Implicit GWT.create binding for org.jboss.gwt.elemento.sample.common.TodoMessages
   */
  public org.jboss.gwt.elemento.sample.common.TodoMessages get_Key$type$org$jboss$gwt$elemento$sample$common$TodoMessages$_annotation$$none$$() {
    Object created = GWT.create(org.jboss.gwt.elemento.sample.common.TodoMessages.class);
    assert created instanceof org.jboss.gwt.elemento.sample.common.TodoMessages;
    org.jboss.gwt.elemento.sample.common.TodoMessages result = (org.jboss.gwt.elemento.sample.common.TodoMessages) created;
    
    memberInject_Key$type$org$jboss$gwt$elemento$sample$common$TodoMessages$_annotation$$none$$(result);
    
    return result;
    
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_jboss_gwt_elemento_sample_gin_client_ApplicationGinjector_ApplicationGinjectorGinjector injector;
  public org_jboss_gwt_elemento_sample_gin_client_ApplicationGinjector_ApplicationGinjectorGinjector_fragment(org_jboss_gwt_elemento_sample_gin_client_ApplicationGinjector_ApplicationGinjectorGinjector injector) {
    this.injector = injector;
  }
  
}
