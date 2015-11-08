package com.eagerbeavercrm.web.filter;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by kimberlygrauer on 11/7/15.
 */
@BindingAnnotation @Target({TYPE}) @Retention(RUNTIME)
public  @interface  CrmFilter {
}
