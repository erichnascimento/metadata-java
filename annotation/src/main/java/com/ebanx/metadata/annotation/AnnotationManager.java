package com.ebanx.metadata.annotation;

public class AnnotationManager {
	private final AnnotationStorage storage;

	public AnnotationManager(AnnotationStorage storage) {
		this.storage = storage;
	}

	public void annotate(Annotable annotable, String annotationName, String annotationValue) {
		// TODO Validate
		this.storage.saveAnnotation(annotable.getIdForAnnotation(), annotationName, annotationValue);
	}

	public String getAnnotation(Annotable annotable, String annotationName) {
		return this.storage.getAnnotation(annotable.getIdForAnnotation(), annotationName);
	}
}
