package com.darcstarsolutions.common.utils;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidationUtils {
	private static final String CONSTRAINT_VIOLATION_MESSAGE = "Constraint Violation: ";

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ValidationUtils.class);

	private Validator validator;

	public ValidationUtils(Validator validator) {
		this.validator = validator;
	}
	
	public <T> boolean validate(T entity) throws ConstraintViolationException {
		return validate(entity, true, Default.class);
	}

	public <T> boolean validate(T entity, boolean throwException, Class<?> groups)
			throws ConstraintViolationException {
		Set<ConstraintViolation<T>> constraintViolations = validator
				.validate(entity, groups);
		boolean result = constraintViolations.isEmpty();
		if (!result && throwException) {
			logConstraintViolations(constraintViolations);
			throw new ConstraintViolationException(
					new HashSet<ConstraintViolation<?>>(constraintViolations));
		}
		return result;
	}

	/**
	 * @param constraintViolations
	 */
	public <T> void logConstraintViolations(
			Set<ConstraintViolation<T>> constraintViolations) {
		StringBuilder builder = buildConstraintViolationMessage(constraintViolations);
		LOGGER.info(builder.toString());
	}

	/**
	 * @param constraintViolations
	 * @return
	 */
	public <T>StringBuilder buildConstraintViolationMessage(
			Set<ConstraintViolation<T>> constraintViolations) {
		StringBuilder builder = new StringBuilder(CONSTRAINT_VIOLATION_MESSAGE);
		if(constraintViolations.size() >1 ){
			builder.insert(builder.indexOf(":"), "s");
		}
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			builder.append(constraintViolation.getPropertyPath());
			Object object = constraintViolation.getInvalidValue();
			builder.append(" [");
			if(object != null){
				builder.append(constraintViolation.getInvalidValue().toString());
			}
			else {
				builder.append("null");
			}
			builder.append("] ");
			builder.append(constraintViolation.getMessage());
			builder.append(", ");
		}
		builder.delete(builder.length()-2, builder.length());
		return builder;
	}


}
