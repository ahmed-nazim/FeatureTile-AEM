package org.myproject.sampleaem.core.components;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adobe.cq.sightly.WCMUsePojo;



public class FeatureTileComponent extends WCMUsePojo{
	
	public static Logger LOGGER = LoggerFactory.getLogger(FeatureTileComponent.class);
	private List<FeatureTile> featureTiles;
	
	public List<FeatureTile> getFeatureTiles() {
		return featureTiles;
	}
	@Override
	public void activate() throws Exception {

		featureTiles=new ArrayList<FeatureTile>();
		try{
			PropertyIterator propertyIterator=null;
			Resource resource=getResource();
			propertyIterator = resource != null ? resource.adaptTo(Node.class).getProperties("featuredTileMultifield") : null;
			if (propertyIterator != null && propertyIterator.hasNext()) {
				Property prop = propertyIterator.nextProperty();
				if (prop.isMultiple()) {
					LOGGER.debug("IsMultiple");
					String[] multifieldData=getProperties().get("featuredTileMultifield",String[].class);
					for(int i=0;i<multifieldData.length;i++){
						JSONObject eachMultifieldItem=new JSONObject(multifieldData[i]);
						FeatureTile eachTile=new FeatureTile();
						eachTile.setImage(eachMultifieldItem.optString("imagePath"));
						eachTile.setLinkTitle(eachMultifieldItem.optString("CTALinkText"));
						eachTile.setLinkUrl(eachMultifieldItem.optString("CTALink"));
						eachTile.setLinkTarget(eachMultifieldItem.optBoolean("openInNewWindow"));
						eachTile.setTitle(eachMultifieldItem.optString("titleOverride"));
						eachTile.setDescription(eachMultifieldItem.optString("descriptionOverride"));
						featureTiles.add(eachTile);
					}
				} else {
					LOGGER.debug("Not Multiple");
					JSONObject eachMultifieldItem=new JSONObject(getProperties().get("featuredTileMultifield",String.class));
					FeatureTile eachTile=new FeatureTile();
					eachTile.setImage(eachMultifieldItem.optString("imagePath"));
					eachTile.setLinkTitle(eachMultifieldItem.optString("CTALinkText"));
					eachTile.setLinkUrl(eachMultifieldItem.optString("CTALink"));
					eachTile.setLinkTarget(eachMultifieldItem.optBoolean("openInNewWindow"));
					eachTile.setTitle(eachMultifieldItem.optString("titleOverride"));
					eachTile.setDescription(eachMultifieldItem.optString("descriptionOverride"));
					featureTiles.add(eachTile);
				}
			}
		
		}catch(Exception e){
			LOGGER.error("Error in setting feature tile component",e.getMessage());
		}
	}
	
	
	
	@Override
	public String toString() {
		return "FeatureTileComponent [featureTiles=" + featureTiles + "]";
	}
}
