package com.ebanx.metadata.annotation;

import java.util.List;
import java.util.ArrayList;

import java.util.Map;
import java.util.HashMap;

public class InMemoryAnnotationStorage implements AnnotationStorage {

	private final Map<String, Map<String, String>> map;

	public InMemoryAnnotationStorage() {
		this.map = new HashMap<String,  Map<String, String>>();
	}

	public void saveAnnotation(String id, String annotationName, String annotationValue) {
		Map<String, String> annotations = this.map.get(id);
		if (annotations == null) {
			annotations = new HashMap<String, String>();
			this.map.put(id, annotations);
		}

		annotations.put(annotationName, annotationValue);
	}

	public String getAnnotation(String id, String annotationName) {
		Map<String, String> annotations = this.map.get(id);
		if (annotations == null) {
			// TODO: Throw not found exceptions
			return null;
		}

		return annotations.get(annotationName);
	}
}
