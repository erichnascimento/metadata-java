package com.ebanx.metadata.tag;

import java.util.List;

public class TagManagerTest extends BaseTestCase {
	public void testAddTag() {
		InMemoryTagStorage storage = new InMemoryTagStorage();
		TagManager tagManager = new TagManager(storage);

		TaggableImpl target = new TaggableImpl("fooId");
		boolean isRedPersisted = checkIsPersisted(storage, target, TAG_RED);
		assertFalse(isRedPersisted);

		tagManager.addTag(target, TAG_RED);

		isRedPersisted = checkIsPersisted(storage, target, TAG_RED);
		assertTrue(isRedPersisted);

		boolean isBluePersisted = checkIsPersisted(storage, target, TAG_BLUE);
		assertFalse(isBluePersisted);
	}

	public void testHasTag() {
		InMemoryTagStorage storage = new InMemoryTagStorage();
		TagManager tagManager = new TagManager(storage);

		TaggableImpl target = new TaggableImpl("fooId");
		boolean hasRedTag = tagManager.hasTag(target, TAG_RED);
		assertFalse(hasRedTag);

		tagManager.addTag(target, TAG_RED);

		hasRedTag = tagManager.hasTag(target, TAG_RED);
		assertTrue(hasRedTag);
	}

	private static boolean checkIsPersisted(InMemoryTagStorage s, TaggableImpl t, String tag) {
		List<String> savedTags = s.getTags(t.id);

		return savedTags == null
			? false
			: savedTags.contains(tag);
	}

	private static class TaggableImpl implements Taggable {
		public final String id;

		TaggableImpl(String id) {
			this.id = id;
		}

		public String getIdForTagging() {
			return this.id;
		}
	}

	private static final String TAG_RED = "RED";
	private static final String TAG_BLUE = "BLUE";
}
