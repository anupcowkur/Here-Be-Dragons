package com.anupcowkur.herebedragons;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation to indicate Impure/Side effecting methods. HereBeDragons plugin uses
 * this annotation to show a dragon icon in the gutter.
 */
@Documented
@Target(METHOD)
@Retention(SOURCE)
public @interface SideEffect {
}