package com.ebanx.metadata.annotation;

import java.util.List;
import junit.framework.TestCase;

public class AnnotationManagerTest extends TestCase {
	public void testAnnotate() {
		InMemoryAnnotationStorage storage = new InMemoryAnnotationStorage();
		AnnotationManager manager = new AnnotationManager(storage);

		AnnotableImpl target = new AnnotableImpl("fooId");
		// boolean isRedPersisted = checkIsPersisted(storage, target, TAG_RED);
		// assertFalse(isRedPersisted);
		//
		manager.annotate(target, ANNOTATION_META1, "Value for Meta1");
		//
		// isRedPersisted = checkIsPersisted(storage, target, TAG_RED);
		// assertTrue(isRedPersisted);
		//
		// boolean isBluePersisted = checkIsPersisted(storage, target, TAG_BLUE);
		// assertFalse(isBluePersisted);
	}

	public void testGetAnnotation() {
		// InMemoryTagStorage storage = new InMemoryTagStorage();
		// TagManager tagManager = new TagManager(storage);
		//
		// TaggableImpl target = new TaggableImpl("fooId");
		// boolean hasRedTag = tagManager.hasTag(target, TAG_RED);
		// assertFalse(hasRedTag);
		//
		// tagManager.addTag(target, TAG_RED);
		//
		// hasRedTag = tagManager.hasTag(target, TAG_RED);
		// assertTrue(hasRedTag);
	}

	private static class AnnotableImpl implements Annotable {
		public final String id;

		public AnnotableImpl(String id) {
			this.id = id;
		}

		public String getIdForAnnotation() {
			return this.id;
		}
	}
	//
	private static final String ANNOTATION_META1 = "meta1";
	// private static final String TAG_BLUE = "BLUE";
}
