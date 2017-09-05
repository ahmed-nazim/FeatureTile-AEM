package org.myproject.sampleaem.core.components;

public class FeatureTile {

		private String title;
		private String image;
		private String description;
		private String linkTitle;
		private String linkUrl;
		private Boolean linkTarget;

		
		public String getLinkTitle() {
			return linkTitle;
		}
		public void setLinkTitle(String linkTitle) {
			this.linkTitle = linkTitle;
		}
		public String getLinkUrl() {
			return linkUrl;
		}
		public void setLinkUrl(String linkUrl) {
			this.linkUrl = linkUrl;
		}
		public Boolean getLinkTarget() {
			return linkTarget;
		}
		public void setLinkTarget(Boolean linkTarget) {
			this.linkTarget = linkTarget;
		}
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}

		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		@Override
		public String toString() {
			return "FeatureTile [ title="
					+ title + ", image=" + image + ", description=" + description + ", linkTitle="
					+ linkTitle + ", linkUrl=" + linkUrl + ", linkTarget="
					+ linkTarget + "]";
		}
		
		
}
