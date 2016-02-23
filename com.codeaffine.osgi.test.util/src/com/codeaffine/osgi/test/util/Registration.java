/**
 * Copyright (c) 2014 - 2016 Frank Appel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Frank Appel - initial API and implementation
 */
package com.codeaffine.osgi.test.util;

import org.osgi.framework.ServiceRegistration;

public class Registration<S> {

  private final ServiceRegistration<S> serviceRegistration;
  private final ServiceRegistrationRule serviceRegistrationRule;

  Registration( ServiceRegistration<S> serviceRegistration, ServiceRegistrationRule serviceRegistrationRule ) {
    this.serviceRegistration = serviceRegistration;
    this.serviceRegistrationRule = serviceRegistrationRule;
  }

  public void unregister() {
    serviceRegistration.unregister();
    serviceRegistrationRule.remove( serviceRegistration );
  }

  public ServiceRegistration<S> getServiceRegistration() {
    return serviceRegistration;
  }
}