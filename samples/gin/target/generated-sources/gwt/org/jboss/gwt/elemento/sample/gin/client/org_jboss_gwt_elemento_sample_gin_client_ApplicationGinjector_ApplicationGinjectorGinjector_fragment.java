package org.jboss.gwt.elemento.sample.gin.client;

import com.google.gwt.core.client.GWT;
import org.jboss.gwt.elemento.sample.gin.client.org_jboss_gwt_elemento_sample_gin_client_ApplicationGinjector_ApplicationGinjectorGinjector;

public class org_jboss_gwt_elemento_sample_gin_client_ApplicationGinjector_ApplicationGinjectorGinjector_fragment {
  public void memberInject_Key$type$org$jboss$gwt$elemento$sample$gin$client$Templated_ApplicationElement_Provider$_annotation$$none$$(org.jboss.gwt.elemento.sample.gin.client.Templated_ApplicationElement_Provider injectee) {
    
  }
  
  public void memberInject_Key$type$org$jboss$gwt$elemento$sample$gin$client$Templated_TodoItemElement_Provider$_annotation$$none$$(org.jboss.gwt.elemento.sample.gin.client.Templated_TodoItemElement_Provider injectee) {
    
  }
  
  private org.jboss.gwt.elemento.sample.gin.client.ApplicationElement singleton_Key$type$org$jboss$gwt$elemento$sample$gin$client$ApplicationElement$_annotation$$none$$ = null;
  
  public org.jboss.gwt.elemento.sample.gin.client.ApplicationElement get_Key$type$org$jboss$gwt$elemento$sample$gin$client$ApplicationElement$_annotation$$none$$() {
    
    if (singleton_Key$type$org$jboss$gwt$elemento$sample$gin$client$ApplicationElement$_annotation$$none$$ == null) {
    org.jboss.gwt.elemento.sample.gin.client.ApplicationElement result = get_Key$type$org$jboss$gwt$elemento$sample$gin$client$Templated_ApplicationElement_Provider$_annotation$$none$$().get();
        singleton_Key$type$org$jboss$gwt$elemento$sample$gin$client$ApplicationElement$_annotation$$none$$ = result;
    }
    return singleton_Key$type$org$jboss$gwt$elemento$sample$gin$client$ApplicationElement$_annotation$$none$$;
    
  }
  
  
  /**
   * Binding for org.jboss.gwt.elemento.sample.gin.client.TodoItemElement declared at:
   *   org.jboss.gwt.elemento.sample.gin.client.ApplicationModule.configure(ApplicationModule.java:38)
   */
  public org.jboss.gwt.elemento.sample.gin.client.TodoItemElement get_Key$type$org$jboss$gwt$elemento$sample$gin$client$TodoItemElement$_annotation$$none$$() {
    org.jboss.gwt.elemento.sample.gin.client.TodoItemElement result = get_Key$type$org$jboss$gwt$elemento$sample$gin$client$Templated_TodoItemElement_Provider$_annotation$$none$$().get();
    return result;
    
  }
  
  
  /**
   * Binding for org.jboss.gwt.elemento.sample.common.TodoItemRepository declared at:
   *   org.jboss.gwt.elemento.sample.common.TodoItemRepository org.jboss.gwt.elemento.sample.gin.client.ApplicationModule.provideRepository(org.jboss.gwt.elemento.sample.common.BeanFactory)
   */
  public org.jboss.gwt.elemento.sample.common.TodoItemRepository get_Key$type$org$jboss$gwt$elemento$sample$common$TodoItemRepository$_annotation$$none$$() {
    org.jboss.gwt.elemento.sample.common.TodoItemRepository result = org$jboss$gwt$elemento$sample$gin$client$ApplicationModule_provideRepository_methodInjection(new org.jboss.gwt.elemento.sample.gin.client.ApplicationModule(), injector.getFragment_org_jboss_gwt_elemento_sample_common().get_Key$type$org$jboss$gwt$elemento$sample$common$BeanFactory$_annotation$$none$$());
    return result;
    
  }
  
  public org.jboss.gwt.elemento.sample.common.TodoItemRepository org$jboss$gwt$elemento$sample$gin$client$ApplicationModule_provideRepository_methodInjection(org.jboss.gwt.elemento.sample.gin.client.ApplicationModule invokee, org.jboss.gwt.elemento.sample.common.BeanFactory _0) {
    return invokee.provideRepository(_0);
  }
  
  
  /**
   * Binding for com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.TodoItemElement> declared at:
   *   Implicit provider for com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.TodoItemElement>
   */
  public com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.TodoItemElement> get_Key$type$com$google$inject$Provider$org$jboss$gwt$elemento$sample$gin$client$TodoItemElement$$_annotation$$none$$() {
    com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.TodoItemElement> result = new com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.TodoItemElement>() { 
      public org.jboss.gwt.elemento.sample.gin.client.TodoItemElement get() { 
        return get_Key$type$org$jboss$gwt$elemento$sample$gin$client$TodoItemElement$_annotation$$none$$();
      }
    };
    return result;
    
  }
  
  
  /**
   * Binding for org.jboss.gwt.elemento.sample.gin.client.Templated_ApplicationElement_Provider declared at:
   *   Implicit binding for org.jboss.gwt.elemento.sample.gin.client.Templated_ApplicationElement_Provider
   */
  public org.jboss.gwt.elemento.sample.gin.client.Templated_ApplicationElement_Provider get_Key$type$org$jboss$gwt$elemento$sample$gin$client$Templated_ApplicationElement_Provider$_annotation$$none$$() {
    org.jboss.gwt.elemento.sample.gin.client.Templated_ApplicationElement_Provider result = org$jboss$gwt$elemento$sample$gin$client$Templated_ApplicationElement_Provider_org$jboss$gwt$elemento$sample$gin$client$Templated_ApplicationElement_Provider_methodInjection(get_Key$type$org$jboss$gwt$elemento$sample$common$TodoItemRepository$_annotation$$none$$(), injector.getFragment_org_jboss_gwt_elemento_sample_common().get_Key$type$org$jboss$gwt$elemento$sample$common$TodoMessages$_annotation$$none$$(), get_Key$type$com$google$inject$Provider$org$jboss$gwt$elemento$sample$gin$client$TodoItemElement$$_annotation$$none$$());
    memberInject_Key$type$org$jboss$gwt$elemento$sample$gin$client$Templated_ApplicationElement_Provider$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.jboss.gwt.elemento.sample.gin.client.Templated_ApplicationElement_Provider org$jboss$gwt$elemento$sample$gin$client$Templated_ApplicationElement_Provider_org$jboss$gwt$elemento$sample$gin$client$Templated_ApplicationElement_Provider_methodInjection(org.jboss.gwt.elemento.sample.common.TodoItemRepository _0, org.jboss.gwt.elemento.sample.common.TodoMessages _1, com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.TodoItemElement> _2) {
    return new org.jboss.gwt.elemento.sample.gin.client.Templated_ApplicationElement_Provider(_0, _1, _2);
  }
  
  
  /**
   * Binding for com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.ApplicationElement> declared at:
   *   Implicit provider for com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.ApplicationElement>
   */
  public com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.ApplicationElement> get_Key$type$com$google$inject$Provider$org$jboss$gwt$elemento$sample$gin$client$ApplicationElement$$_annotation$$none$$() {
    com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.ApplicationElement> result = new com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.ApplicationElement>() { 
      public org.jboss.gwt.elemento.sample.gin.client.ApplicationElement get() { 
        return get_Key$type$org$jboss$gwt$elemento$sample$gin$client$ApplicationElement$_annotation$$none$$();
      }
    };
    return result;
    
  }
  
  
  /**
   * Binding for org.jboss.gwt.elemento.sample.gin.client.Templated_TodoItemElement_Provider declared at:
   *   Implicit binding for org.jboss.gwt.elemento.sample.gin.client.Templated_TodoItemElement_Provider
   */
  public org.jboss.gwt.elemento.sample.gin.client.Templated_TodoItemElement_Provider get_Key$type$org$jboss$gwt$elemento$sample$gin$client$Templated_TodoItemElement_Provider$_annotation$$none$$() {
    org.jboss.gwt.elemento.sample.gin.client.Templated_TodoItemElement_Provider result = org$jboss$gwt$elemento$sample$gin$client$Templated_TodoItemElement_Provider_org$jboss$gwt$elemento$sample$gin$client$Templated_TodoItemElement_Provider_methodInjection(get_Key$type$com$google$inject$Provider$org$jboss$gwt$elemento$sample$gin$client$ApplicationElement$$_annotation$$none$$(), get_Key$type$org$jboss$gwt$elemento$sample$common$TodoItemRepository$_annotation$$none$$());
    memberInject_Key$type$org$jboss$gwt$elemento$sample$gin$client$Templated_TodoItemElement_Provider$_annotation$$none$$(result);
    
    return result;
    
  }
  
  public org.jboss.gwt.elemento.sample.gin.client.Templated_TodoItemElement_Provider org$jboss$gwt$elemento$sample$gin$client$Templated_TodoItemElement_Provider_org$jboss$gwt$elemento$sample$gin$client$Templated_TodoItemElement_Provider_methodInjection(com.google.inject.Provider<org.jboss.gwt.elemento.sample.gin.client.ApplicationElement> _0, org.jboss.gwt.elemento.sample.common.TodoItemRepository _1) {
    return new org.jboss.gwt.elemento.sample.gin.client.Templated_TodoItemElement_Provider(_0, _1);
  }
  
  
  /**
   * Field for the enclosing injector.
   */
  private final org_jboss_gwt_elemento_sample_gin_client_ApplicationGinjector_ApplicationGinjectorGinjector injector;
  public org_jboss_gwt_elemento_sample_gin_client_ApplicationGinjector_ApplicationGinjectorGinjector_fragment(org_jboss_gwt_elemento_sample_gin_client_ApplicationGinjector_ApplicationGinjectorGinjector injector) {
    this.injector = injector;
  }
  
}
