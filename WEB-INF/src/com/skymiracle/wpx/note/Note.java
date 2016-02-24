package com.skymiracle.wpx.note;

import java.util.UUID;

import com.skymiracle.mdo5.Mdo_X;
import com.skymiracle.wpx.models.WpxMdo;
import com.skymiracle.wpx.models.WpxMdo_X;
import static com.skymiracle.wpx.Singletons.*;
public class Note extends WpxMdo<Note> {
	public Note() {
		super($Note);
	}

	public String uuid = UUID.randomUUID().toString();
	public String owner;

	public String date;

	public String category;

	public String content;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String table() {
		return "tb_note";
	}

	@Override
	public String[] keyNames() {
		return new String[] { "uuid" };
	}

	public static class X extends WpxMdo_X<Note> {

		public X() {
			super(Note.class);
		}
		
	}
}
