package com.ebanx.metadata.annotation;

public interface AnnotationStorage {
	public void saveAnnotation(String id, String annotationName, String annotationValue);
	public String getAnnotation(String id, String annotationName);
}
