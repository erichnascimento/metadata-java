package com.ebanx.metadata.tag;

public class TagManager {
	private final TagStorage storage;

	public TagManager(TagStorage storage) {
		this.storage = storage;
	}

	public void addTag(Taggable target, String tag) {
		// TODO: Validate arguments
		
		String id = target.getIdForTagging();

		if (this.storage.tagExists(id, tag)) {
			return;
		}

		this.storage.addTag(id, tag);
	}

	public boolean hasTag(Taggable target, String tag) {
		return this.storage.tagExists(target.getIdForTagging(), tag);
	}
}
