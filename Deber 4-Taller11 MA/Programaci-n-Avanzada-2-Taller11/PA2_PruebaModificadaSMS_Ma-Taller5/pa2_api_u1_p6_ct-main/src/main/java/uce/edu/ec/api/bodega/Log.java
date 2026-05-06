package uce.edu.ec.api.bodega;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.interceptor.InterceptorBinding;

@InterceptorBinding
// nomenclatura para anotacion !!!
@Target ({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME) 
public @interface Log {



}
