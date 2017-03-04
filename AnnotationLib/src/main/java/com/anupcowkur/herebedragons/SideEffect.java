package com.anupcowkur.herebedragons;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Annotation to indicate Impure/Side effecting methods. HereBeDragons plugin uses
 * this annotation to show a dragon icon in the IDE gutter.
 */
@Documented
@Target(METHOD)
@Retention(SOURCE)
public @interface SideEffect {
}