package com.demo.model;

import java.lang.reflect.Method;

public interface Mergable {

	/**
	 * Merges update object into target object. While merging it ignores all
	 * null values from the update object.
	 * 
	 * @param target
	 * @param update
	 */
	default void merge(Object target, Object update) {
		if (!target.getClass().isAssignableFrom(update.getClass())) {
			return;
		}

		Method[] methods = update.getClass().getMethods();

		for (Method fromMethod : methods) {
			if (fromMethod.getDeclaringClass().equals(target.getClass())
					&& (fromMethod.getName().matches("^get[A-Z].*$") //
							|| fromMethod.getName().matches("^is[A-Z].*$"))) {

				String fromName = fromMethod.getName();
				String toName;
				if (fromName.matches("^get[A-Z].*")) {
					toName = fromName.replace("get", "set");
				} else {
					toName = fromName.replace("is", "set");
				}

				try {
					Method toMetod = target.getClass().getMethod(toName, fromMethod.getReturnType());
					Object value = fromMethod.invoke(update, (Object[]) null);
					if (value != null) {
						toMetod.invoke(target, value);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Merges invoking object into the target object. While merging it ignores
	 * all null values from the update object.
	 * 
	 * @param target
	 * @return true if merged or false if failed
	 */
	default boolean mergeInto(Object target) {

		if (this.equals(target)) {
			return false;
		}

		if (!target.getClass().isAssignableFrom(this.getClass())) {
			return false;
		}

		Method[] methods = target.getClass().getMethods();

		for (Method fromMethod : methods) {
			if (fromMethod.getDeclaringClass().equals(target.getClass())
					&& (fromMethod.getName().matches("^get[A-Z].*$") || fromMethod.getName().matches("^is[A-Z].*$"))) {

				String fromName = fromMethod.getName();
				String toName;
				if (fromName.matches("^get[A-Z].*")) {
					toName = fromName.replace("get", "set");
				} else {
					toName = fromName.replace("is", "set");
				}

				try {
					Method toMetod = target.getClass().getMethod(toName, fromMethod.getReturnType());
					Object value = fromMethod.invoke(this, (Object[]) null);
					if (value != null) {
						toMetod.invoke(target, value);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
}
