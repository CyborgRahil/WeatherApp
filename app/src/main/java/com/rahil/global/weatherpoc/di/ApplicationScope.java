package com.rahil.global.weatherpoc.di;

import javax.inject.Scope;

/**
 * Dagger-2 scope that indicates that a component or a provider has application level scope.
 * Every component and provider annotated with this scope signifies the injected objects have
 * application scope i.e. they live through out application lifecycle.
 */
@Scope
public @interface ApplicationScope {
}
