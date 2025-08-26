package com.agcoding.s4a.annotations

import jakarta.validation.Constraint
import jakarta.validation.Payload
import jakarta.validation.constraints.Pattern
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [])
@Pattern(
    regexp = "^(?=.*[\\d!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?])(.{9,})$",
    message = "Password must contains of at least 9 character and a special character or a digit.",
)
annotation class Password(
    val message : String = "Password must contains of at least 9 character and a special character or a digit." ,
    val group : Array<KClass<*>> = [] ,
    val payload: Array<KClass<out Payload>> = [] ,

)
